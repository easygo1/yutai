package com.yutai.exuetang.view.service;

import android.annotation.SuppressLint;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.os.Handler;
import android.os.IBinder;
import android.os.Parcelable;
import android.util.Log;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;


import com.yutai.exuetang.R;
import com.yutai.exuetang.db.MusciTableOperate;
import com.yutai.exuetang.model.beans.audio.music.LrcContent;
import com.yutai.exuetang.model.beans.audio.music.Music;
import com.yutai.exuetang.utils.AppConstant;
import com.yutai.exuetang.utils.FileVisitorUtils;
import com.yutai.exuetang.utils.LrcProcess;
import com.yutai.exuetang.utils.LrcView;
import com.yutai.exuetang.view.activity.audio.AudioPlayActivity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.ListResourceBundle;

@SuppressLint("NewApi")
public class PlayerService extends Service {
	private MediaPlayer mediaPlayer; // 媒体播放器对象
	private String path; 			// 音乐文件路径
	private int msg;				//播放信息
	private boolean isPause; 		// 暂停状态
	private int current = 0; 		// 记录当前正在播放的音乐
	private List<Music> mp3Infos = null;	//存放Mp3Info对象的集合
	private int status = 2;			//播放状态，默认为全部循环播放
	private MyReceiver myReceiver;	//自定义广播接收器
	private int currentTime;		//当前播放进度
	private int duration;			//播放长度
	private LrcProcess mLrcProcess;	//歌词处理
	private List<LrcContent> lrcList = new ArrayList<>(); //存放歌词列表对象
	private int index = 0;			//歌词检索值
	//sqlite操作类
	private MusciTableOperate mMusciTableOperate = null;
	//接收playActivity传来的music_id
	private int music_id;
	//服务要发送的一些Action
	public static final String UPDATE_ACTION = "com.wwj.action.UPDATE_ACTION";	//更新动作
	public static final String CTL_ACTION = "com.wwj.action.CTL_ACTION";		//控制动作
	public static final String MUSIC_CURRENT = "com.wwj.action.MUSIC_CURRENT";	//当前音乐播放时间更新动作
	public static final String MUSIC_DURATION = "com.wwj.action.MUSIC_DURATION";//新音乐长度更新动作
	public static final String SHOW_LRC = "com.wwj.action.SHOW_LRC";			//通知显示歌词
	public static final String SHOW_LRC1 = "com.wwj.action.SHOW_LRC1";			//通知显示歌词
	public static final String SHOW_LRC2 = "com.wwj.action.SHOW_LRC2";			//通知显示歌词


	/**
	 * handler用来接收消息，来发送广播更新播放时间
	 */
	private Handler handler = new Handler() {
		public void handleMessage(android.os.Message msg) {
			if (msg.what == 1) {
				if(mediaPlayer != null) {
					currentTime = mediaPlayer.getCurrentPosition(); // 获取当前音乐播放的位置
					duration = mediaPlayer.getDuration();
					Intent intent = new Intent();
					intent.setAction(MUSIC_CURRENT);
					intent.putExtra("currentTime", currentTime);
					intent.putExtra("duration", duration);	//通过Intent来传递歌曲的总长度
					sendBroadcast(intent); // 给PlayerActivity发送广播
					handler.sendEmptyMessageDelayed(1, 1000);
				}
			}
		};
	};

	@Override
	public void onCreate() {
		super.onCreate();
		Log.d("service", "service created");
		mediaPlayer = new MediaPlayer();
		//mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);// 设置媒体流类型
		//mediaPlayer.setOnBufferingUpdateListener(this);
		//mediaPlayer.setOnPreparedListener(this);
		//传来播放列表集合
		mMusciTableOperate = new MusciTableOperate(PlayerService.this);
		mp3Infos = mMusciTableOperate.selectAllMusic();
		Log.e("mp3infos",mp3Infos.toString());
		/**
		 * 设置音乐播放完成时的监听器
		 */
		mediaPlayer.setOnCompletionListener(new OnCompletionListener() {

			@Override
			public void onCompletion(MediaPlayer mp) {
				if (status == 1) { // 单曲循环
					mediaPlayer.start();
				} else if (status == 2) { // 全部循环
					current++;
					if(current > mp3Infos.size() - 1) {	//变为第一首的位置继续播放
						current = 0;
					}
					Intent sendIntent = new Intent(UPDATE_ACTION);
					sendIntent.putExtra("current", current);
					// 发送广播，将被Activity组件中的BroadcastReceiver接收到
					sendBroadcast(sendIntent);
					path = mp3Infos.get(current).getMusic_path_mp3();
					play(0);
				} else if (status == 3) { // 顺序播放
					current++;	//下一首位置
					if (current <= mp3Infos.size() - 1) {
						Intent sendIntent = new Intent(UPDATE_ACTION);
						sendIntent.putExtra("current", current);
						// 发送广播，将被Activity组件中的BroadcastReceiver接收到
						sendBroadcast(sendIntent);
						path = mp3Infos.get(current).getMusic_path_mp3();
						play(0);
					}else {
						mediaPlayer.seekTo(0);
						current = 0;
						Intent sendIntent = new Intent(UPDATE_ACTION);
						sendIntent.putExtra("current", current);
						// 发送广播，将被Activity组件中的BroadcastReceiver接收到
						sendBroadcast(sendIntent);
					}
				} else if(status == 4) {	//随机播放
					System.out.println("mp3infos" + mp3Infos.size());
					current = getRandomIndex(mp3Infos.size() - 1);
					System.out.println("currentIndex ->" + current);
					Intent sendIntent = new Intent(UPDATE_ACTION);
					sendIntent.putExtra("current", current);
					// 发送广播，将被Activity组件中的BroadcastReceiver接收到
					sendBroadcast(sendIntent);
					path = mp3Infos.get(current).getMusic_path_mp3();
					play(0);
				}
			}
		});

		myReceiver = new MyReceiver();
		IntentFilter filter = new IntentFilter();
		filter.addAction(CTL_ACTION);
		filter.addAction(SHOW_LRC);
		registerReceiver(myReceiver, filter);
	}

	/**
	 * 获取随机位置
	 * @param end
	 * @return
	 */
	protected int getRandomIndex(int end) {
		int index = (int) (Math.random() * end);
		return index;
	}

	@Override
	public IBinder onBind(Intent arg0) {
		return null;
	}

	@Override
	public void onStart(Intent intent, int startId) {
		mp3Infos = mMusciTableOperate.selectAllMusic();
		Log.e("serviceonstartmp3",mp3Infos.toString());
			if (path == intent.getStringExtra("url")){
				path = intent.getStringExtra("url");		//歌曲路径
				current = intent.getIntExtra("listPosition", -1);	//当前播放歌曲的在mp3Infos的位置
				msg = intent.getIntExtra("MSG", 0);			//播放信息
				currentTime = mediaPlayer.getCurrentPosition();
				if (msg == AppConstant.PlayerMsg.PLAY_MSG) {	//直接播放音乐
					play(currentTime);
				} else if (msg == AppConstant.PlayerMsg.PAUSE_MSG) {	//暂停
					pause();
				} else if (msg == AppConstant.PlayerMsg.STOP_MSG) {		//停止
					stop();
				} else if (msg == AppConstant.PlayerMsg.CONTINUE_MSG) {	//继续播放
					resume();
				} else if (msg == AppConstant.PlayerMsg.PRIVIOUS_MSG) {	//上一首
					previous();
				} else if (msg == AppConstant.PlayerMsg.NEXT_MSG) {		//下一首
					next();
				} else if (msg == AppConstant.PlayerMsg.PROGRESS_CHANGE) {	//进度更新
					currentTime = intent.getIntExtra("progress", -1);
					play(currentTime);
				} else if (msg == AppConstant.PlayerMsg.PLAYING_MSG) {
					handler.sendEmptyMessage(1);
				}
			}else {
				Log.e("service","service has onstart");
				path = intent.getStringExtra("url");		//歌曲路径
				current = intent.getIntExtra("listPosition", -1);	//当前播放歌曲的在mp3Infos的位置
				msg = intent.getIntExtra("MSG", 0);			//播放信息
				Log.e("path+msg",path+"+"+msg);
				if (msg == AppConstant.PlayerMsg.PLAY_MSG) {	//直接播放音乐
					play(0);
				} else if (msg == AppConstant.PlayerMsg.PAUSE_MSG) {	//暂停
					pause();
				} else if (msg == AppConstant.PlayerMsg.STOP_MSG) {		//停止
					stop();
				} else if (msg == AppConstant.PlayerMsg.CONTINUE_MSG) {	//继续播放
					resume();
				} else if (msg == AppConstant.PlayerMsg.PRIVIOUS_MSG) {	//上一首
					previous();
				} else if (msg == AppConstant.PlayerMsg.NEXT_MSG) {		//下一首
					next();
				} else if (msg == AppConstant.PlayerMsg.PROGRESS_CHANGE) {	//进度更新
					currentTime = intent.getIntExtra("progress", -1);
					play(currentTime);
				} else if (msg == AppConstant.PlayerMsg.PLAYING_MSG) {
					handler.sendEmptyMessage(1);
				}else if (msg == AppConstant.PlayerMsg.DELETE_ONE){
					music_id = intent.getIntExtra("music_id",0);
					for (int i = 0; i < mp3Infos.size(); i++) {
						if (music_id == mp3Infos.get(i).getMusic_id()){
							mp3Infos.remove(i);
							mMusciTableOperate.deleteMusicByMusicid(music_id);
						}
					}
				}else if (msg == AppConstant.PlayerMsg.DELETE_ALL){
					mp3Infos.clear();
					mMusciTableOperate.deleteAllMusic();
				}
			}
		super.onStart(intent, startId);
	}

	/**
	 * 初始化歌词配置
	 */
	public void initLrc(){
		/*new Thread(){
			@Override
			public void run() {
				mLrcProcess = new LrcProcess();
				Log.e("initlrc",mp3Infos.get(current).getMusic_path_lrc());
				//读取歌词文件
				mLrcProcess.readLRC(mp3Infos.get(current).getMusic_path_lrc(), FileVisitorUtils.LocalFilePath+"ck.lrc");
				//传回处理后的歌词文件
				lrcList = mLrcProcess.getLrcList();
			}
		}.start();*/
		mLrcProcess = new LrcProcess();
		//Log.e("initlrc",mp3Infos.get(current).getMusic_path_lrc());
		//读取歌词文件
		//mLrcProcess.readLRC(mp3Infos.get(current).getMusic_path_lrc(), FileVisitorUtils.LocalFilePath+mp3Infos.get(current).getMusic_name()+".lrc");
		mLrcProcess.readLRC(FileVisitorUtils.LocalFilePath+mp3Infos.get(current).getMusic_type1()+"/"+mp3Infos.get(current).getMusic_name()+".lrc");
		Log.e("lrcPath",FileVisitorUtils.LocalFilePath+mp3Infos.get(current).getMusic_type1()+"/"+mp3Infos.get(current).getMusic_name()+".lrc");
		//传回处理后的歌词文件
		lrcList = mLrcProcess.getLrcList();
		//Log.e("lrcList",lrcList.toString());
		/*AudioPlayActivity.lrcView.setmLrcList(lrcList);
		//切换带动画显示歌词
		AudioPlayActivity.lrcView.setAnimation(AnimationUtils.loadAnimation(PlayerService.this, R.anim.alpha_z));
		handler.post(mRunnable);*/
		Intent sendIntent = new Intent();
		sendIntent.setAction(SHOW_LRC1);
		sendIntent.putExtra("lrcList", (Serializable) lrcList);
		// 发送广播，将被Activity组件中的BroadcastReceiver接收到
		sendBroadcast(sendIntent);
		handler.post(mRunnable);
	}
	Runnable mRunnable = new Runnable() {

		@Override
		public void run() {
			/*AudioPlayActivity.lrcView.setIndex(lrcIndex());
			AudioPlayActivity.lrcView.invalidate();*/
			int lrcIndex = lrcIndex();
			Intent sendIntent = new Intent();
			sendIntent.setAction(SHOW_LRC2);
			sendIntent.putExtra("lrcIndex",lrcIndex);
			// 发送广播，将被Activity组件中的BroadcastReceiver接收到
			sendBroadcast(sendIntent);
			handler.postDelayed(mRunnable, 100);
		}
	};
	
	/**
	 * 根据时间获取歌词显示的索引值
	 * @return
	 */
	public int lrcIndex() {
		if(mediaPlayer.isPlaying()) {
			currentTime = mediaPlayer.getCurrentPosition();
			duration = mediaPlayer.getDuration();
		}
		if(currentTime < duration) {
			for (int i = 0; i < lrcList.size(); i++) {
				if (i < lrcList.size() - 1) {
					if (currentTime < lrcList.get(i).getLrcTime() && i == 0) {
						index = i;
					}
					if (currentTime > lrcList.get(i).getLrcTime()
							&& currentTime < lrcList.get(i + 1).getLrcTime()) {
						index = i;
					}
				}
				if (i == lrcList.size() - 1
						&& currentTime > lrcList.get(i).getLrcTime()) {
					index = i;
				}
			}
		}
		return index;
	}
	/**
	 * 播放音乐
	 * 
	 * @param
	 */
	private void play(int currentTime) {
		try {
			initLrc();
			Log.e("进来play","++++");
			mediaPlayer.reset();// 把各项参数恢复到初始状态
			mediaPlayer.setDataSource(path);
			mediaPlayer.prepare(); // 进行缓冲
			mediaPlayer.setOnPreparedListener(new PreparedListener(currentTime));// 注册一个监听器
			handler.sendEmptyMessage(1);
			//Log.e("play","playa");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 暂停音乐
	 */
	private void pause() {
		if (mediaPlayer != null && mediaPlayer.isPlaying()) {
			mediaPlayer.pause();
			isPause = true;
		}
	}

	private void resume() {
		if (isPause) {
			mediaPlayer.start();
			isPause = false;
		}
	}

	/**
	 * 上一首
	 */
	private void previous() {
		Intent sendIntent = new Intent(UPDATE_ACTION);
		sendIntent.putExtra("current", current);
		// 发送广播，将被Activity组件中的BroadcastReceiver接收到
		sendBroadcast(sendIntent);
		play(0);
	}

	/**
	 * 下一首
	 */
	private void next() {
		Intent sendIntent = new Intent(UPDATE_ACTION);
		sendIntent.putExtra("current", current);
		// 发送广播，将被Activity组件中的BroadcastReceiver接收到
		sendBroadcast(sendIntent);
		play(0);
	}

	/**
	 * 停止音乐
	 */
	private void stop() {
		if (mediaPlayer != null) {
			mediaPlayer.stop();
			try {
				mediaPlayer.prepare(); // 在调用stop后如果需要再次通过start进行播放,需要之前调用prepare函数
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void onDestroy() {
		if (mediaPlayer != null) {
			mediaPlayer.stop();
			mediaPlayer.release();
			mediaPlayer = null;
		}
		handler.removeCallbacks(mRunnable);
	}

	/**
	 * 
	 * 实现一个OnPrepareLister接口,当音乐准备好的时候开始播放
	 * 
	 */
	private final class PreparedListener implements OnPreparedListener {
		private int currentTime;

		public PreparedListener(int currentTime) {
			this.currentTime = currentTime;
		}

		@Override
		public void onPrepared(MediaPlayer mp) {
			mediaPlayer.start(); // 开始播放
			if (currentTime > 0) { // 如果音乐不是从头播放
				mediaPlayer.seekTo(currentTime);
			}
			Intent intent = new Intent();
			intent.setAction(MUSIC_DURATION);
			duration = mediaPlayer.getDuration();
			intent.putExtra("duration", duration);	//通过Intent来传递歌曲的总长度
			sendBroadcast(intent);
		}
	}

	public class MyReceiver extends BroadcastReceiver {

		@Override
		public void onReceive(Context context, Intent intent) {
			int control = intent.getIntExtra("control", -1);
			switch (control) {
			case 1:
				status = 1; // 将播放状态置为1表示：单曲循环
				break;
			case 2:
				status = 2;	//将播放状态置为2表示：全部循环
				break;
			/*case 3:
				status = 3;	//将播放状态置为3表示：顺序播放
				break;*/
			case 4:
				status = 4;	//将播放状态置为4表示：随机播放
				break;
			}
			
			String action = intent.getAction();
			if(action.equals(SHOW_LRC)){
				current = intent.getIntExtra("listPosition", -1);
				initLrc();
			}
		}
	}

}
