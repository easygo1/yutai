package com.yutai.audio.view.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.yutai.audio.R;
import com.yutai.audio.model.beans.music.Music;
import com.yutai.audio.presenters.dao.AudioPlayPresenter;
import com.yutai.audio.presenters.impl.AudioPlayPresenterImpl;
import com.yutai.audio.utils.AppConstant;
import com.yutai.audio.utils.LrcView;
import com.yutai.audio.utils.MediaUtil;
import com.yutai.audio.utils.PathToBitmapUtils;
import com.yutai.audio.utils.PhotoBlurUtils;
import com.yutai.audio.utils.ToastUtils;
import com.yutai.audio.view.custom.Player;
import com.yutai.audio.view.iview.IAudioPlayView;

import java.util.List;

/**
 * 音乐播放页面
 * 参考网址：http://blog.csdn.net/wwj_748/article/details/20933055
 * 从主界面传递过来歌曲的Id、歌曲名、歌手、歌曲路径、播放状态
 */
public class AudioPlayActivity2 extends AppCompatActivity implements IAudioPlayView, View.OnClickListener {
    private static final int PROCESSING = 1;
    private static final int FAILURE = -1;

    private ImageView mAudioPlayTitleBack;//返回键
    private TextView mAudioName;//音乐名称
    private ImageView mAudioTimerImage;//计时功能
    private ImageView mAudioPhotoImage;//音乐图片
    private TextView mAudioLrcTextview;//歌词
    private ImageView mAudioLoveImage;//喜欢
    private ImageView mAudioLoadImage;//下载
    private ImageView mAudioCommentImage;//评论
    private ImageView mAudioShareImage;//分享
    private SeekBar mAudioPlaySeekbar;//进度条
    private TextView mAudioPlayThistime;//当前时间
    private TextView mAudioPlaySumtime;//总时间
    private ImageView mAudioPlaystyleImage;//播放类型（单曲循环，顺序播放，随机播放）
    private ImageView mAudioPlaypreviousImage;//上一曲
    private ImageView mAudioPlaynowImage;//播放或者暂停
    private ImageView mAudioPlaynextImage;//下一首
    private ImageView mAudioPlaylistImage;//播放列表（在最下右方）
    private ProgressBar mProgressBar;

    private String title; // 歌曲标题
    private String artist; // 歌曲艺术家
    private String url; // 歌曲路径
    private int listPosition; // 播放歌曲在mp3Infos的位置
    private int currentTime; // 当前歌曲播放时间
    private int duration; // 歌曲长度
    private int flag; // 播放标识
    private final int isCurrentRepeat = 1; // 单曲循环
    private final int isAllRepeat = 2; // 全部循环
    private final int isNoneRepeat = 3; // 无重复播放
    private LinearLayout mLinearLayout;
    private boolean isPlaying; // 正在播放
    private boolean isPause; // 暂停
    private boolean isNoneShuffle; // 顺序播放
    private boolean isShuffle; // 随机播放

    private List<Music> mp3Infos;
    public static LrcView lrcView; // 自定义歌词视图

    private PlayerReceiver playerReceiver;
    public static final String UPDATE_ACTION = "com.wwj.action.UPDATE_ACTION"; // 更新动作
    public static final String CTL_ACTION = "com.wwj.action.CTL_ACTION"; // 控制动作
    public static final String MUSIC_CURRENT = "com.wwj.action.MUSIC_CURRENT"; // 音乐当前时间改变动作
    public static final String MUSIC_DURATION = "com.wwj.action.MUSIC_DURATION";// 音乐播放长度改变动作
    public static final String MUSIC_PLAYING = "com.wwj.action.MUSIC_PLAYING"; // 音乐正在播放动作
    public static final String REPEAT_ACTION = "com.wwj.action.REPEAT_ACTION"; // 音乐重复播放动作
    public static final String SHUFFLE_ACTION = "com.wwj.action.SHUFFLE_ACTION";// 音乐随机播放动作
    public static final String SHOW_LRC = "com.wwj.action.SHOW_LRC"; // 通知显示歌词

    /*private Player player; // 播放器
    private List<Integer> mTimeList;
    private Music mMusic;
    private Bitmap bitmap;
    private Drawable mDrawable;

    private Boolean flag = false;//标记当前是否在播放
    private int music_id = 0;//上个页面传过来的music_id

    private AudioPlayPresenter mAudioPlayPresenter;

    private Handler handler = new UIHandler();

    private final class UIHandler extends Handler {
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case PROCESSING: // 更新进度
                    mAudioPlaySeekbar.setProgress(msg.getData().getInt("size"));
                    float num = (float) mAudioPlaySeekbar.getProgress()
                            / (float) mAudioPlaySeekbar.getMax();
                    int result = (int) (num * 100); // 计算进度
//                    resultView.setText(result + "%");
                    mAudioPlaySumtime.setText(result + ":");
                    if (mAudioPlaySeekbar.getProgress() == mAudioPlaySeekbar.getMax()) { // 下载完成
                        showToast("下载成功");
                    }
                    break;
                case FAILURE: // 下载失败
                    showToast("下载失败");
                    break;
            }
        }
    }*/


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio_play);
        initViews();
        initListeners();
        getDataFromBundle();

        registerReceiver();
        play();
        /*//获得意图
        Intent intent = getIntent();
        //读取数据
        music_id = intent.getIntExtra("music_id", 0);
        mAudioPlayPresenter = new AudioPlayPresenterImpl(this);
        initViews();
        initListeners();
        getData();
        setTextViews();
        player = new Player(mAudioPlaySeekbar,mAudioPlaySumtime,mAudioPlayThistime);
        player.playUrl(mMusic.getMusic_path_mp3());
        //player.onPrepared(player.mediaPlayer);
        player.play();
        new Thread() {
            public void run() {
                new AnotherTask().execute("JSON");
            }
        }.start();
//        new Thread(downloadRun).start();*/
    }

/*
    private class AnotherTask extends AsyncTask<String, Void, String> {
        @Override
        protected void onPostExecute(String result) {
            //对UI组件的更新操作
            mLinearLayout.setBackground(mDrawable);
        }

        @Override
        protected String doInBackground(String... params) {
            //耗时的操作
            bitmap = PathToBitmapUtils.returnBitMap(mMusic.getMusic_photo());
            mDrawable = PhotoBlurUtils.BoxBlurFilter(bitmap);
            return params[0];
        }
    }
*/
    private void registerReceiver() {
        //定义和注册广播接收器
        playerReceiver = new PlayerReceiver();
        IntentFilter filter = new IntentFilter();
        filter.addAction(UPDATE_ACTION);
        filter.addAction(MUSIC_CURRENT);
        filter.addAction(MUSIC_DURATION);
        registerReceiver(playerReceiver, filter);
    }
    private void initViews() {
        isPlaying = true;
        isPause = false;
        mAudioPlayTitleBack = (ImageView) findViewById(R.id.audio_play_title_back);
        mAudioName = (TextView) findViewById(R.id.audio_name);
        mAudioTimerImage = (ImageView) findViewById(R.id.audio_timer_image);
        mAudioPhotoImage = (ImageView) findViewById(R.id.audio_photo_image);
        mAudioLrcTextview = (TextView) findViewById(R.id.audio_lrc_textview);
        mAudioLoveImage = (ImageView) findViewById(R.id.audio_love_image);
        mAudioLoadImage = (ImageView) findViewById(R.id.audio_load_image);
        mAudioCommentImage = (ImageView) findViewById(R.id.audio_comment_image);
        mAudioShareImage = (ImageView) findViewById(R.id.audio_share_image);
        mAudioPlaySeekbar = (SeekBar) findViewById(R.id.audio_play_seekbar);
        mAudioPlayThistime = (TextView) findViewById(R.id.audio_play_thistime);
        mAudioPlaySumtime = (TextView) findViewById(R.id.audio_play_sumtime);
        mAudioPlaystyleImage = (ImageView) findViewById(R.id.audio_playstyle_image);
        mAudioPlaypreviousImage = (ImageView) findViewById(R.id.audio_playprevious_image);
        mAudioPlaynowImage = (ImageView) findViewById(R.id.audio_playnow_image);
        mAudioPlaynextImage = (ImageView) findViewById(R.id.audio_playnext_image);
        mAudioPlaylistImage = (ImageView) findViewById(R.id.audio_playlist_image);
        mLinearLayout = (LinearLayout) findViewById(R.id.play_layout_liner);
        mProgressBar = (ProgressBar) findViewById(R.id.play_progressBar);
    }

    private void initListeners() {
        mAudioPlayTitleBack.setOnClickListener(this);
        mAudioTimerImage.setOnClickListener(this);
        mAudioLoveImage.setOnClickListener(this);
        mAudioLoadImage.setOnClickListener(this);
        mAudioCommentImage.setOnClickListener(this);
        mAudioShareImage.setOnClickListener(this);
        mAudioPlaySeekbar.setOnSeekBarChangeListener(new SeekBarChangeEvent());
        mAudioPlaystyleImage.setOnClickListener(this);
        mAudioPlaypreviousImage.setOnClickListener(this);
        mAudioPlaynowImage.setOnClickListener(this);
        mAudioPlaynextImage.setOnClickListener(this);
        mAudioPlaylistImage.setOnClickListener(this);
    }
    /**
     * 用来接收从service传回来的广播的内部类
     *
     * @author wwj
     *
     */
    public class PlayerReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (action.equals(MUSIC_CURRENT)) {
                currentTime = intent.getIntExtra("currentTime", -1);
                mAudioPlayThistime.setText(MediaUtil.formatTime(currentTime));
                mAudioPlaySeekbar.setProgress(currentTime);
            } else if (action.equals(MUSIC_DURATION)) {
                int duration = intent.getIntExtra("duration", -1);
                mAudioPlaySeekbar.setMax(duration);
                mAudioPlaySumtime.setText(MediaUtil.formatTime(duration));
            } else if (action.equals(UPDATE_ACTION)) {
                // 获取Intent中的current消息，current代表当前正在播放的歌曲
                listPosition = intent.getIntExtra("current", -1);
                url = mp3Infos.get(listPosition).getMusic_path_mp3();
                if (listPosition >= 0) {
                   // musicTitle.setText(mp3Infos.get(listPosition).getTitle());
                   // musicArtist.setText(mp3Infos.get(listPosition).getArtist());
                }
                if (listPosition == 0) {
                    /*mAudioPlaySumtime.setText(MediaUtil.formatTime(mp3Infos.get(
                            listPosition).getDuration()));*/
                    //playBtn.setBackgroundResource(R.drawable.pause_selector);
                    isPause = true;
                }
            }
        }
    }
    /**
     * 从Bundle中获取来自HomeActivity中传过来的数据
     */
    private void getDataFromBundle() {
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        /*title = bundle.getString("title");
        artist = bundle.getString("artist");*/
        url = bundle.getString("url");
        //listPosition = bundle.getInt("listPosition");
        //repeatState = bundle.getInt("repeatState");
        //isShuffle = bundle.getBoolean("shuffleState");
        flag = bundle.getInt("MSG");
        //currentTime = bundle.getInt("currentTime");
       // duration = bundle.getInt("duration");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e("onStart","PlayerActivity has onStart");
        Log.e("cuikaitest","playerActivity start");
    }

    @Override
    protected void onResume() {
        super.onResume();
        registerReceiver();
        Log.e("onResume","PlayerActivity has onResume");
    }
    //反注册广播

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(playerReceiver);
        Log.e("onStop","PlayerActivity has onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("onDestroy","PlayerActivity has onDestroy");
    }
    /**
     * 顺序播放
     */
    public void repeat_none() {
        Intent intent = new Intent(CTL_ACTION);
        intent.putExtra("control", 3);
        sendBroadcast(intent);
    }
    /**
     * 播放音乐
     */
    public void play() {
        // 开始播放的时候为顺序播放
        repeat_none();
        Intent intent = new Intent();
        intent.setAction("com.wwj.media.MUSIC_SERVICE");
        intent.setPackage("com.yutai.audio");
        intent.putExtra("url", url);
        //intent.putExtra("listPosition", listPosition);
        intent.putExtra("MSG", flag);
        startService(intent);
    }
    /*private void getData() {
        //得到数据
        mMusic = mAudioPlayPresenter.onSucess();
    }

    private void setTextViews() {
        //赋值
        mAudioName.setText(mMusic.getMusic_name());
        Glide.with(this).load(mMusic.getMusic_photo()).into(mAudioPhotoImage);
        *//*Resources res = getResources();
        Bitmap bitmap = BitmapFactory.decodeResource(res, R.drawable.u24);*//*
        Log.e("photo_path", mMusic.getMusic_photo());
        Log.e("music_mp3", mMusic.getMusic_path_mp3());
       *//* int sumtime = player.getSumtime();
        mAudioPlayThistime.setText(":");
        mAudioPlaySumtime.setText(":"+sumtime);*//*
    }*/

    @Override
    public void showToast(String msg) {
        ToastUtils.showToast(this, msg);
    }

    @Override
    public int getMusicID() {
        return 0;
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        switch (v.getId()) {
            case R.id.audio_play_title_back:
                finish();
                break;
            case R.id.audio_timer_image:
                //计时功能
                showToast("计时功能");
                break;
            case R.id.audio_love_image:
                //喜欢
                showToast("喜欢");
                break;
            case R.id.audio_load_image:
                //下载音乐
                showToast("下载音乐");
                break;
            case R.id.audio_comment_image:
                //评论
                showToast("评论");
                break;
            case R.id.audio_share_image:
                //分享
                showToast("分享");
                break;
            case R.id.audio_playstyle_image:
                //播放类型
                showToast("播放类型");
                break;
            case R.id.audio_playprevious_image:
                //上一首
                showToast("上一首");
                break;
            case R.id.audio_playnow_image:
                //当前音乐是播放还是暂停
                showToast("播放还是暂停");
                if (isPlaying) {
                   // playBtn.setBackgroundResource(R.drawable.pause_selector);
                    intent.setAction("com.wwj.media.MUSIC_SERVICE");
                    intent.setPackage("com.yutai.audio");
                    intent.putExtra("MSG", AppConstant.PlayerMsg.PAUSE_MSG);
                    startService(intent);
                    isPlaying = false;
                    isPause = true;
                } else if (isPause) {
                    //playBtn.setBackgroundResource(R.drawable.play_selector);
                    intent.setAction("com.wwj.media.MUSIC_SERVICE");
                    intent.setPackage("com.yutai.audio");
                    intent.putExtra("MSG", AppConstant.PlayerMsg.CONTINUE_MSG);
                    startService(intent);
                    isPause = false;
                    isPlaying = true;
                }
                break;
            case R.id.audio_playnext_image:
                //下一首
                showToast("下一首");
                //player.nextMusic("地址");
                break;
            case R.id.audio_playlist_image:
                //播放列表
                showToast("播放列表");
                break;
        }
    }
    /**
     * 下一首
     */
    public void next_music() {
        //playBtn.setBackgroundResource(R.drawable.play_selector);
        listPosition = listPosition + 1;
        if (listPosition <= mp3Infos.size() - 1) {
            Music mp3Info = mp3Infos.get(listPosition);
            //showArtwork(mp3Info);	//显示专辑封面
            url = mp3Info.getMusic_path_mp3();
            //musicTitle.setText(mp3Info.getTitle());
            //musicArtist.setText(mp3Info.getArtist());
            Intent intent = new Intent();
            intent.setAction("com.wwj.media.MUSIC_SERVICE");
            intent.setPackage("com.yutai.audio");
            intent.putExtra("url", mp3Info.getMusic_path_mp3());
            intent.putExtra("listPosition", listPosition);
            intent.putExtra("MSG", AppConstant.PlayerMsg.NEXT_MSG);
            startService(intent);

        } else {
            listPosition = mp3Infos.size() - 1;
            ToastUtils.showToast(this,"没有下一首了啊");
        }
    }
    /**
     * 播放进度改变
     * @param progress
     */
    public void audioTrackChange(int progress) {
        Intent intent = new Intent();
        intent.setAction("com.wwj.media.MUSIC_SERVICE");
        intent.setPackage("com.yutai.audio");
        intent.putExtra("url", url);
        intent.putExtra("listPosition", listPosition);
        intent.putExtra("MSG", AppConstant.PlayerMsg.PROGRESS_CHANGE);
        intent.putExtra("progress", progress);
        startService(intent);
    }
    //进度条改变时的事件监听
    public class SeekBarChangeEvent implements SeekBar.OnSeekBarChangeListener {
        int progress;
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            // 该方法拖动进度条开始拖动的时候开始调用
            /*this.progress = progress * player.mediaPlayer.getDuration()
                    / seekBar.getMax();*/
            if (fromUser) {
                audioTrackChange(progress); // 用户控制进度的改变
            }
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {
            //该方法拖动进度条停止拖动的时候开始调用
        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {
            //该方法拖动进度条进度改变的时候调用
            //mediaPlayer.seekTo(seekBar.getProgress());
            // seekTo()的参数是相对与影片时间的数字，而不是与seekBar.getMax()相对的数字
            //player.mediaPlayer.seekTo(progress);
        }
    }

}

