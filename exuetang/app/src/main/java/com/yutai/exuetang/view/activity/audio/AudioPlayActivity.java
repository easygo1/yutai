package com.yutai.exuetang.view.activity.audio;

import android.annotation.TargetApi;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.yanzhenjie.recyclerview.swipe.Closeable;
import com.yanzhenjie.recyclerview.swipe.OnSwipeMenuItemClickListener;
import com.yanzhenjie.recyclerview.swipe.SwipeMenu;
import com.yanzhenjie.recyclerview.swipe.SwipeMenuCreator;
import com.yanzhenjie.recyclerview.swipe.SwipeMenuItem;
import com.yanzhenjie.recyclerview.swipe.SwipeMenuRecyclerView;
import com.yutai.exuetang.R;
import com.yutai.exuetang.db.MusciTableOperate;
import com.yutai.exuetang.model.beans.audio.music.LrcContent;
import com.yutai.exuetang.model.beans.audio.music.Music;
import com.yutai.exuetang.utils.AppConstant;
import com.yutai.exuetang.utils.LrcView;
import com.yutai.exuetang.utils.MediaUtil;
import com.yutai.exuetang.utils.PathToBitmapUtils;
import com.yutai.exuetang.utils.PhotoBlurUtils;
import com.yutai.exuetang.utils.ToastUtils;
import com.yutai.exuetang.view.adapter.audio.OnItemClickListener;
import com.yutai.exuetang.view.adapter.audio.PlayDialogAdapter;

import java.util.ArrayList;
import java.util.List;

public class AudioPlayActivity extends AppCompatActivity implements View.OnClickListener{
    private ImageView mAudioPlayBackImage;//返回键
    private TextView mAudioMusicName;//音乐名称
    private ImageView mAudioTimerImage;//计时功能按钮
    private ImageView mAudioMusicphotoImage;//音乐图片
    //public static LrcView mAudioMusiclrcTextview;//歌词
    private ImageView mAudioPlayLoveImage;//喜欢
    private ImageView mAudioPlayLoadImage;//下载
    private ImageView mAudioPlayCommentImage;//评论
    private ImageView mAudioPlayShareImage;//分享
    private TextView mAudioPlayStarttimeTextview;//当前时间
    private SeekBar mAudioPlaySeekbar;//进度条
    private TextView mAudioPlayEndtimeTextview;//总时间
    private ImageView mAudioPlayStyleImage;//播放类型（单曲循环，顺序循环，随机播放）
    private ImageView mAudioPlayPreviousImage;//上一首
    private ImageView mAudioPlayNowImage;//播放或暂停
    private ImageView mAudioPlayNextImage;//下一首
    private ImageView mAudioPlayListImage;//播放列表
    private Bitmap bitmap = null;
    private Drawable mDrawable;

    Music music;
    private String title; // 歌曲标题
    private String artist; // 歌曲艺术家
    private String url; // 歌曲路径
    private int listPosition = 0; // 播放歌曲在mp3Infos的位置
    private int currentTime; // 当前歌曲播放时间
    private int duration; // 歌曲长度
    private int flag; // 播放标识
    private int repeatState = 2;
    private final int isCurrentRepeat = 1; // 单曲循环
    private final int isAllRepeat = 2; // 全部循环
    private final int isNoneRepeat = 4; // 无重复播放(随机播放)
    private LinearLayout mLinearLayout;
    private boolean isPlaying; // 正在播放
    private boolean isPause; // 暂停
    private boolean isNoneShuffle; // 顺序播放
    private boolean isShuffle; // 随机播放
    private List<Music> mp3Infos;
    public static LrcView lrcView; // 自定义歌词视图
    private List<LrcContent> lrcList = new ArrayList<>(); //存放歌词列表对象
    private Dialog dialog;
    private PlayerReceiver playerReceiver;
    public static final String UPDATE_ACTION = "com.wwj.action.UPDATE_ACTION"; // 更新动作
    public static final String CTL_ACTION = "com.wwj.action.CTL_ACTION"; // 控制动作
    public static final String MUSIC_CURRENT = "com.wwj.action.MUSIC_CURRENT"; // 音乐当前时间改变动作
    public static final String MUSIC_DURATION = "com.wwj.action.MUSIC_DURATION";// 音乐播放长度改变动作
    public static final String MUSIC_PLAYING = "com.wwj.action.MUSIC_PLAYING"; // 音乐正在播放动作
    public static final String REPEAT_ACTION = "com.wwj.action.REPEAT_ACTION"; // 音乐重复播放动作
    public static final String SHUFFLE_ACTION = "com.wwj.action.SHUFFLE_ACTION";// 音乐随机播放动作
    public static final String SHOW_LRC = "com.wwj.action.SHOW_LRC"; // 通知显示歌词
    public static final String SHOW_LRC1 = "com.wwj.action.SHOW_LRC1"; // 通知显示歌词
    public static final String SHOW_LRC2 = "com.wwj.action.SHOW_LRC2"; // 通知显示歌词

    private MusciTableOperate mMusciTableOperate = null;
    //dialog有关的
    private PlayDialogAdapter mPlayDialogAdapter;
    private TextView mPlayDialogCleanall;
    private TextView mPlayDialogListtile;
    private TextView mPlayDialogLoveall;
    private SwipeMenuRecyclerView mPlayDialogRecyclerView;
    private Button mPlayDialogOff;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio_play);
        initViews();
        addListeners();
        getDataFromBundle();
        mMusciTableOperate = new MusciTableOperate(AudioPlayActivity.this);
        mp3Infos = mMusciTableOperate.selectAllMusic();
        registerReceiver();
        initPlay();
        Log.e("oncreate", "playactivity has onCreate");
    }
    private void showPhoto(final Music music){
        //设置音乐图片
        Glide.with(this).load(music.getMusic_photo()).into(mAudioMusicphotoImage);
        //先把背景图变为bitmap,在模糊化
        new Thread(){
            @Override
            public void run() {
                super.run();
                bitmap = PathToBitmapUtils.returnBitMap(music.getMusic_photo());
            }
        }.start();
        new Thread() {
            public void run() {
                while (true){
                    if(bitmap != null){
                        new AnotherTask().execute("JSON");
                        return;
                    }else {
                        try {
                            sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }

            }
        }.start();
    }
    //执行背景模糊化
    private class AnotherTask extends AsyncTask<String, Void, String> {
        @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
        @Override
        protected void onPostExecute(String result) {
            //对UI组件的更新操作
            mLinearLayout.setBackground(mDrawable);
        }

        @Override
        protected String doInBackground(String... params) {
            //耗时的操作
            Log.e("bitmap","进来了"+music.getMusic_photo());
            //bitmap = PathToBitmapUtils.returnBitMap(music.getMusic_photo());
            Log.e("activitybitmap","with"+bitmap.getWidth()+"hight"+bitmap.getHeight());
            mDrawable = PhotoBlurUtils.BoxBlurFilter(bitmap);
            return params[0];
        }
    }
    private void initViews() {
        isPlaying = true;
        isPause = false;
        mAudioPlayBackImage = (ImageView) findViewById(R.id.audio_play_back_image);
        mAudioMusicName = (TextView) findViewById(R.id.audio_music_name);
        mAudioTimerImage = (ImageView) findViewById(R.id.audio_timer_image);
        mAudioMusicphotoImage = (ImageView) findViewById(R.id.audio_musicphoto_image);
        lrcView = (LrcView) findViewById(R.id.audio_musiclrc_textview);
        mAudioPlayLoveImage = (ImageView) findViewById(R.id.audio_play_love_image);
        mAudioPlayLoadImage = (ImageView) findViewById(R.id.audio_play_load_image);
        mAudioPlayCommentImage = (ImageView) findViewById(R.id.audio_play_comment_image);
        mAudioPlayShareImage = (ImageView) findViewById(R.id.audio_play_share_image);
        mAudioPlayStarttimeTextview = (TextView) findViewById(R.id.audio_play_starttime_textview);
        mAudioPlaySeekbar = (SeekBar) findViewById(R.id.audio_play_seekbar);
        mAudioPlayEndtimeTextview = (TextView) findViewById(R.id.audio_play_endtime_textview);
        mAudioPlayStyleImage = (ImageView) findViewById(R.id.audio_play_style_image);
        mAudioPlayPreviousImage = (ImageView) findViewById(R.id.audio_play_previous_image);
        mAudioPlayNowImage = (ImageView) findViewById(R.id.audio_play_now_image);
        mAudioPlayNextImage = (ImageView) findViewById(R.id.audio_play_next_image);
        mAudioPlayListImage = (ImageView) findViewById(R.id.audio_play_list_image);
        mLinearLayout = (LinearLayout) findViewById(R.id.audio_play_layout);
    }
    private void addListeners() {
        mAudioPlayBackImage.setOnClickListener(this);
        mAudioTimerImage.setOnClickListener(this);
        mAudioPlayLoveImage.setOnClickListener(this);
        mAudioPlayLoadImage.setOnClickListener(this);
        mAudioPlayCommentImage.setOnClickListener(this);
        mAudioPlayShareImage.setOnClickListener(this);
        mAudioPlaySeekbar.setOnSeekBarChangeListener(new SeekBarChangeEvent());
        mAudioPlayStyleImage.setOnClickListener(this);
        mAudioPlayPreviousImage.setOnClickListener(this);
        mAudioPlayNowImage.setOnClickListener(this);
        mAudioPlayNextImage.setOnClickListener(this);
        mAudioPlayListImage.setOnClickListener(this);
    }
    private void registerReceiver() {
        //定义和注册广播接收器
        playerReceiver = new PlayerReceiver();
        IntentFilter filter = new IntentFilter();
        filter.addAction(UPDATE_ACTION);
        filter.addAction(MUSIC_CURRENT);
        filter.addAction(MUSIC_DURATION);
        filter.addAction(SHOW_LRC1);
        filter.addAction(SHOW_LRC2);
        registerReceiver(playerReceiver, filter);
    }
    private void initPlay(){
        //mAudioMusicphotoImage.setImageDrawable(getResources().getDrawable(music.getMusic_photo()));
        switch (repeatState) {
            case isCurrentRepeat: // 单曲循环
                mAudioPlayStyleImage.setImageDrawable(getResources().getDrawable(R.mipmap.single_cycle));
                //mAudioPlayStyleImage.setBackgroundResource(R.mipmap.single_cycle);
                break;
            case isAllRepeat: // 全部循环
                mAudioPlayStyleImage.setImageDrawable(getResources().getDrawable(R.mipmap.circulation));
                //mAudioPlayStyleImage.setBackgroundResource(R.mipmap.circulation);
                break;
            case isNoneRepeat: // 无重复
                mAudioPlayStyleImage.setImageDrawable(getResources().getDrawable(R.mipmap.random_broadcast));
                //mAudioPlayStyleImage.setBackgroundResource(R.mipmap.random_broadcast);
                break;
        }
        play();
        /*if (flag == AppConstant.PlayerMsg.PLAYING_MSG) { // 如果播放信息是正在播放
            Intent intent = new Intent();
            intent.setAction(SHOW_LRC);
            intent.putExtra("listPosition", listPosition);
            sendBroadcast(intent);
        } else if (flag == AppConstant.PlayerMsg.PLAY_MSG) { // 如果是点击列表播放歌曲的话
            play();
        } else if (flag == AppConstant.PlayerMsg.CONTINUE_MSG) {
            Intent intent = new Intent(AudioPlayActivity.this, PlayerService.class);
            intent.setAction("com.wwj.media.MUSIC_SERVICE");
            intent.putExtra("MSG", AppConstant.PlayerMsg.CONTINUE_MSG);	//继续播放音乐
            startService(intent);
        }*/
    }
    /**
     * 用来接收从service传回来的广播的内部类
     */
    public class PlayerReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (action.equals(MUSIC_CURRENT)) {
                currentTime = intent.getIntExtra("currentTime", -1);
                mAudioPlayStarttimeTextview.setText(MediaUtil.formatTime(currentTime));
                mAudioPlaySeekbar.setProgress(currentTime);
                duration = intent.getIntExtra("duration", -1);
                mAudioPlaySeekbar.setMax(duration);
                mAudioPlayEndtimeTextview.setText(MediaUtil.formatTime(duration));
            } else if (action.equals(MUSIC_DURATION)) {
                duration = intent.getIntExtra("duration", -1);
                mAudioPlaySeekbar.setMax(duration);
                mAudioPlayEndtimeTextview.setText(MediaUtil.formatTime(duration));
            } else if (action.equals(UPDATE_ACTION)) {
                // 获取Intent中的current消息，current代表当前正在播放的歌曲
                listPosition = intent.getIntExtra("current", -1);
                url = mp3Infos.get(listPosition).getMusic_path_mp3();
                if (listPosition >= 0) {
                    // musicTitle.setText(mp3Infos.get(listPosition).getTitle());
                    // musicArtist.setText(mp3Infos.get(listPosition).getArtist());
                    mAudioMusicName.setText(mp3Infos.get(listPosition).getMusic_name());
                    showPhoto(mp3Infos.get(listPosition));
                }
                /*if (listPosition == 0) {
                    mAudioMusicName.setTypeface(MyApplication.sTypeface);
                    *//*mAudioPlaySumtime.setText(MediaUtil.formatTime(mp3Infos.get(
                            listPosition).getDuration()));*//*
                    //playBtn.setBackgroundResource(R.drawable.pause_selector);
                    mAudioPlayEndtimeTextview.setText("00:00");
                    mAudioPlayNowImage.setImageDrawable(getResources().getDrawable(R.mipmap.play));
                    isPause = true;
                }*/
            }else if (action.equals(SHOW_LRC1)) {
                lrcList = (List<LrcContent>) intent.getSerializableExtra("lrcList");
               // Log.e("activityLrcList",lrcList.toString());
                lrcView.setmLrcList(lrcList);
                lrcView.setAnimation(AnimationUtils.loadAnimation(AudioPlayActivity.this, R.anim.alpha_z));
            }else if (action.equals(SHOW_LRC2)){
                int lrcIndex = intent.getIntExtra("lrcIndex",0);
                lrcView.setIndex(lrcIndex);
                lrcView.invalidate();
            }
        }
    }
    /**
     * 从Bundle中获取来自HomeActivity中传过来的数据
     */
    private void getDataFromBundle() {

        Intent intent = getIntent();
        /*Bundle bundle = intent.getExtras();
        music = (Music) bundle.getSerializable("music");*/
        music = (Music) intent.getSerializableExtra("music");
        //flag = bundle.getInt("MSG");
        url = music.getMusic_path_mp3();
        title = music.getMusic_name();
        //Log.e("music",music.toString()+""+"flag"+flag);
        //Log.e("musicphoto",music.getMusic_photo()+""+"flag"+flag);
        mAudioMusicName.setText(title);
        showPhoto(music);
        /*Bundle bundle = intent.getExtras();
        *//*title = bundle.getString("title");
        artist = bundle.getString("artist");*//*
        url = bundle.getString("url");
        //listPosition = bundle.getInt("listPosition");
        //repeatState = bundle.getInt("repeatState");
        //isShuffle = bundle.getBoolean("shuffleState");
        flag = bundle.getInt("MSG");
        //currentTime = bundle.getInt("currentTime");
        // duration = bundle.getInt("duration");*/
    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.e("onStart","PlayerActivity has onStart");
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
     * 单曲循环
     */
    public void repeat_one() {
        Intent intent = new Intent(CTL_ACTION);
        intent.putExtra("control", 1);
        sendBroadcast(intent);
    }
    /**
     * 顺序循环播放
     */
    public void repeat_none() {
        Intent intent = new Intent(CTL_ACTION);
        intent.putExtra("control", 2);
        sendBroadcast(intent);
    }
    /**
     * 随机播放
     */
    public void shuffleMusic() {
        Intent intent = new Intent(CTL_ACTION);
        intent.putExtra("control", 4);
        sendBroadcast(intent);
    }
    /**
     * 播放音乐
     */
    public void play() {
        // 开始播放的时候为顺序循环播放
        repeat_none();
        Intent intent = new Intent();
        intent.setAction("com.wwj.media.MUSIC_SERVICE");
        intent.setPackage("com.yutai.exuetang");
        intent.putExtra("url", url);
        intent.putExtra("listPosition", listPosition);
        intent.putExtra("MSG", AppConstant.PlayerMsg.PLAY_MSG);
        startService(intent);
    }
    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        switch (v.getId()) {
            case R.id.audio_play_back_image:
                finish();
                break;
            case R.id.audio_timer_image:
                //计时功能
                ToastUtils.showToast(this,"计时功能");
                break;
            case R.id.audio_play_love_image:
                //喜欢
                ToastUtils.showToast(this,"喜欢");
                break;
            case R.id.audio_play_load_image:
                //下载音乐
                ToastUtils.showToast(this,"下载音乐");
                break;
            case R.id.audio_play_comment_image:
                //评论
                ToastUtils.showToast(this,"评论");
//                传递music对象
                intent.setClass(AudioPlayActivity.this, AudioCommentActivity.class);
                /*Bundle mBundle = new Bundle();
                mBundle.putSerializable("music",music);// 或者 mBundle.putParcelable("设置标记的key",对象Bean);
                intent.putExtras(mBundle);*/
                //绑定数据
                intent.putExtra("music", music);//也可以绑定数组
                startActivity(intent);
                break;
            case R.id.audio_play_share_image:
                //分享
                ToastUtils.showToast(this,"分享");
                break;
            case R.id.audio_play_style_image:
                //播放类型
                ToastUtils.showToast(this,"播放类型");
                if (repeatState == isAllRepeat){
                    repeat_one();
                    mAudioPlayStyleImage.setImageDrawable(getResources().getDrawable(R.mipmap.single_cycle));
                    repeatState = isCurrentRepeat;
                }else if (repeatState == isCurrentRepeat){
                    shuffleMusic();
                    mAudioPlayStyleImage.setImageDrawable(getResources().getDrawable(R.mipmap.random_broadcast));
                    repeatState = isNoneRepeat;
                }else if (repeatState == isNoneRepeat){
                    repeat_none();
                    mAudioPlayStyleImage.setImageDrawable(getResources().getDrawable(R.mipmap.circulation));
                    repeatState = isAllRepeat;
                }
                break;
            case R.id.audio_play_previous_image:
                //上一首
                ToastUtils.showToast(this,"上一首");
                previous_music();
                break;
            case R.id.audio_play_now_image:
                //当前音乐是播放还是暂停
                //判断是否在播放
                if (isPlaying) {
                    //playBtn.setBackgroundResource(R.drawable.pause_selector);
                    intent.setAction("com.wwj.media.MUSIC_SERVICE");
                    intent.setPackage("com.yutai.exuetang");
                    intent.putExtra("MSG", AppConstant.PlayerMsg.PAUSE_MSG);
                    startService(intent);
                    mAudioPlayNowImage.setImageDrawable(getResources().getDrawable(R.mipmap.play));
                    isPlaying = false;
                    isPause = true;
                    ToastUtils.showToast(this,"已暂停");
                } else if (isPause) {
                    //playBtn.setBackgroundResource(R.drawable.play_selector);
                    intent.setAction("com.wwj.media.MUSIC_SERVICE");
                    intent.setPackage("com.yutai.exuetang");
                    intent.putExtra("MSG", AppConstant.PlayerMsg.CONTINUE_MSG);
                    startService(intent);
                    mAudioPlayNowImage.setImageDrawable(getResources().getDrawable(R.mipmap.stop));
                    isPause = false;
                    isPlaying = true;
                    ToastUtils.showToast(this,"开始播放");
                }
                break;
            case R.id.audio_play_next_image:
                //下一首
                ToastUtils.showToast(this,"下一首");
                /*isPlaying = true;
                isPause = false;*/
                next();
                break;
            case R.id.audio_play_list_image:
                //播放列表
                ToastUtils.showToast(this,"播放列表");
                showPlayListDialog();
                break;
        }
    }
    /**
     * 上一首
     */
    public void previous_music() {
        listPosition = listPosition - 1;
        if (listPosition >= 0) {
            Music music = mp3Infos.get(listPosition); // 上一首MP3
            title = music.getMusic_name();
            mAudioMusicName.setText(title);
            showPhoto(music);
            url = music.getMusic_path_mp3();
            Intent intent = new Intent();
            intent.setAction("com.wwj.media.MUSIC_SERVICE");
            intent.setPackage("com.yutai.exuetang");
            intent.putExtra("listPosition", listPosition);
            intent.putExtra("url", url);
            intent.putExtra("MSG", AppConstant.PlayerMsg.PRIVIOUS_MSG);
            startService(intent);
        } else {
            listPosition = 0;
            ToastUtils.showToast(AudioPlayActivity.this,"没有上一首了");
        }
    }

    /**
     * 下一首歌曲
     */
    public void next() {
        listPosition = listPosition + 1;
        //Log.e("activitylistposition",listPosition+"mp3infos.size"+mp3Infos.size());
        if (listPosition <= mp3Infos.size() - 1) {
            //Log.e("audioplayActivity",mp3Infos.toString());
            Music music = mp3Infos.get(listPosition);
           // Log.e("playactivitymusic",music.toString());
            title = music.getMusic_name();
            mAudioMusicName.setText(title);
            showPhoto(music);
            url = music.getMusic_path_mp3();
            Intent intent = new Intent();
            intent.setAction("com.wwj.media.MUSIC_SERVICE");
            intent.setPackage("com.yutai.exuetang");
            intent.putExtra("listPosition", listPosition);
            intent.putExtra("url", url);
            intent.putExtra("MSG", AppConstant.PlayerMsg.NEXT_MSG);
            startService(intent);
        } else {
            listPosition = mp3Infos.size() - 1;
            ToastUtils.showToast(AudioPlayActivity.this,"没有下一首了");
        }
    }
    /**
     * 播放进度改变
     * @param progress
     */
    public void audioTrackChange(int progress) {
        Intent intent = new Intent();
        intent.setAction("com.wwj.media.MUSIC_SERVICE");
        intent.setPackage("com.yutai.exuetang");
        intent.putExtra("url", url);
        intent.putExtra("listPosition", listPosition);
        intent.putExtra("MSG", AppConstant.PlayerMsg.PROGRESS_CHANGE);
        intent.putExtra("progress", progress);
        startService(intent);
    }
    //进度条改变时的事件监听
    public class SeekBarChangeEvent implements SeekBar.OnSeekBarChangeListener {
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            // 该方法拖动进度条开始拖动的时候开始调用
            if (fromUser) {
                audioTrackChange(progress); // 用户控制进度的改变
                mAudioPlayNowImage.setImageDrawable(getResources().getDrawable(R.mipmap.stop));
                isPause = false;
                isPlaying = true;
            }
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {
            //该方法拖动进度条停止拖动的时候开始调用
        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {
            //该方法拖动进度条进度改变的时候调用
        }
    }
    public void showPlayListDialog(){
        LayoutInflater mInflater = LayoutInflater.from(this);
        final View mView = mInflater.inflate(R.layout.play_dialog,null);
        mPlayDialogCleanall = (TextView) mView.findViewById(R.id.play_dialog_cleanall);
        mPlayDialogListtile = (TextView) mView.findViewById(R.id.play_dialog_listtile);
        mPlayDialogLoveall = (TextView) mView.findViewById(R.id.play_dialog_loveall);
        mPlayDialogRecyclerView = (SwipeMenuRecyclerView) mView.findViewById(R.id.play_dialog_recycler_view);
        mPlayDialogOff = (Button) mView.findViewById(R.id.play_dialog_off);
        mPlayDialogCleanall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtils.showToast(AudioPlayActivity.this,"点击了清除全部");
                mp3Infos.clear();
                Intent intent = new Intent();
                intent.setAction("com.wwj.media.MUSIC_SERVICE");
                intent.setPackage("com.yutai.exuetang");
                //intent.putExtra("music_id", mp3Infos.get(adapterPosition).getMusic_id());
                intent.putExtra("MSG", AppConstant.PlayerMsg.DELETE_ALL);
                startService(intent);
            }
        });
        mPlayDialogLoveall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtils.showToast(AudioPlayActivity.this,"点击了收藏全部");
            }
        });
        mPlayDialogListtile.setText("播放列表（"+mp3Infos.size()+")");

        //RecyclerView的设置
        mPlayDialogRecyclerView.setLayoutManager(new LinearLayoutManager(this));// 布局管理器。
        mPlayDialogRecyclerView.setHasFixedSize(true);// 如果Item够简单，高度是确定的，打开FixSize将提高性能。
        mPlayDialogRecyclerView.setItemAnimator(new DefaultItemAnimator());// 设置Item默认动画，加也行，不加也行。
        //mPlayDialogRecyclerView.addItemDecoration(new ListViewDecoration());// 添加分割线。
        // 为SwipeRecyclerView的Item创建菜单就两句话，不错就是这么简单：
        // 设置菜单创建器。
        mPlayDialogRecyclerView.setSwipeMenuCreator(swipeMenuCreator);
        // 设置菜单Item点击监听。
        mPlayDialogRecyclerView.setSwipeMenuItemClickListener(menuItemClickListener);

        mPlayDialogRecyclerView.openLeftMenu(1);
        mPlayDialogRecyclerView.openRightMenu(0);
        mPlayDialogAdapter = new PlayDialogAdapter(mp3Infos,this);
        mPlayDialogAdapter.setOnItemClickListener(onItemClickListener);
        mPlayDialogRecyclerView.setAdapter(mPlayDialogAdapter);
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setView(mView);
        dialog = builder.show();
        mPlayDialogOff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtils.showToast(AudioPlayActivity.this,"点击了关闭");
                dialog.dismiss();
            }
        });
    }
    /**
     * 菜单创建器。在Item要创建菜单的时候调用。
     */
    private SwipeMenuCreator swipeMenuCreator = new SwipeMenuCreator() {
        @Override
        public void onCreateMenu(SwipeMenu swipeLeftMenu, SwipeMenu swipeRightMenu, int viewType) {
            int size = 200;

            // 添加左侧的，如果不添加，则左侧不会出现菜单。
            /*{
                SwipeMenuItem addItem = new SwipeMenuItem(mContext)
                        .setBackgroundDrawable(R.drawable.selector_green)// 点击的背景。
                        .setImage(R.mipmap.ic_action_add) // 图标。
                        .setWidth(size) // 宽度。
                        .setHeight(size); // 高度。
                swipeLeftMenu.addMenuItem(addItem); // 添加一个按钮到左侧菜单。

                SwipeMenuItem closeItem = new SwipeMenuItem(mContext)
                        .setBackgroundDrawable(R.drawable.selector_red)
                        .setImage(R.mipmap.ic_action_close)
                        .setWidth(size)
                        .setHeight(size);

                swipeLeftMenu.addMenuItem(closeItem); // 添加一个按钮到左侧菜单。
            }*/

            // 添加右侧的，如果不添加，则右侧不会出现菜单。
            {
                SwipeMenuItem deleteItem = new SwipeMenuItem(AudioPlayActivity.this)
                        .setBackgroundDrawable(R.color.delete_red)
                        .setText("删除") // 文字，还可以设置文字颜色，大小等。。
                        .setTextColor(Color.WHITE)
                        .setWidth(size)
                        .setHeight(size);
                swipeRightMenu.addMenuItem(deleteItem);// 添加一个按钮到右侧侧菜单。

               /* SwipeMenuItem closeItem = new SwipeMenuItem(mContext)
                        .setBackgroundDrawable(R.drawable.selector_purple)
                        .setImage(R.mipmap.ic_action_close)
                        .setWidth(size)
                        .setHeight(size);
                swipeRightMenu.addMenuItem(closeItem); // 添加一个按钮到右侧菜单。

                SwipeMenuItem addItem = new SwipeMenuItem(mContext)
                        .setBackgroundDrawable(R.drawable.selector_green)
                        .setText("添加")
                        .setTextColor(Color.WHITE)
                        .setWidth(size)
                        .setHeight(size);
                swipeRightMenu.addMenuItem(addItem); // 添加一个按钮到右侧菜单。*/
            }
        }
    };
    /**
     * 菜单点击监听。
     */
    private OnSwipeMenuItemClickListener menuItemClickListener = new OnSwipeMenuItemClickListener() {
        /**
         * Item的菜单被点击的时候调用。
         * @param closeable       closeable. 用来关闭菜单。
         * @param adapterPosition adapterPosition. 这个菜单所在的item在Adapter中position。
         * @param menuPosition    menuPosition. 这个菜单的position。比如你为某个Item创建了2个MenuItem，那么这个position可能是是 0、1，
         * @param direction       如果是左侧菜单，值是：SwipeMenuRecyclerView#LEFT_DIRECTION，如果是右侧菜单，值是：SwipeMenuRecyclerView#RIGHT_DIRECTION.
         */
        @Override
        public void onItemClick(Closeable closeable, int adapterPosition, int menuPosition, int direction) {
            closeable.smoothCloseMenu();// 关闭被点击的菜单。

            /*if (direction == SwipeMenuRecyclerView.RIGHT_DIRECTION) {
                Toast.makeText(mContext, "list第" + adapterPosition + "; 右侧菜单第" + menuPosition, Toast.LENGTH_SHORT).show();
            } else if (direction == SwipeMenuRecyclerView.LEFT_DIRECTION) {
                Toast.makeText(mContext, "list第" + adapterPosition + "; 左侧菜单第" + menuPosition, Toast.LENGTH_SHORT).show();
            }*/
            ToastUtils.showToast(AudioPlayActivity.this,"删除攻略");
            ToastUtils.showToast(AudioPlayActivity.this,"点击了删除第"+adapterPosition+"条");
            Intent intent = new Intent();
            intent.setAction("com.wwj.media.MUSIC_SERVICE");
            intent.setPackage("com.yutai.exuetang");
            intent.putExtra("music_id", mp3Infos.get(adapterPosition).getMusic_id());
            intent.putExtra("MSG", AppConstant.PlayerMsg.DELETE_ONE);
            startService(intent);
            for (int i = 0; i < mp3Infos.size(); i++) {
                if (mp3Infos.get(adapterPosition).getMusic_id() == mp3Infos.get(i).getMusic_id()){
                    mp3Infos.remove(i);
                    // mMusciTableOperate.deleteMusicByMusicid(mp3Infos.get(adapterPosition).getMusic_id());
                }
            }
            //dialog.dismiss();
            mPlayDialogAdapter.notifyDataSetChanged();
        }
    };
    private OnItemClickListener onItemClickListener = new OnItemClickListener() {
        @Override
        public void onItemClick(int position) {
            ToastUtils.showToast(AudioPlayActivity.this,"这是第"+position+"tiao");
            mMusciTableOperate.deleteMusicByMusicid(mp3Infos.get(position).getMusic_id());
            mMusciTableOperate.insertData(mp3Infos.get(position));
            /*Intent intent = new Intent();
            intent.setClass(AudioPlayActivity.this, AudioPlayActivity.class);
            //绑定数据
            intent.putExtra("music", mp3Infos.get(position));//也可以绑定数组
            startActivity(intent);*/
            mp3Infos = mMusciTableOperate.selectAllMusic();
            music = mp3Infos.get(0);
            url = mp3Infos.get(0).getMusic_path_mp3();
            listPosition = 0;
            title = music.getMusic_name();
            //Log.e("music",music.toString()+""+"flag"+flag);
            //Log.e("musicphoto",music.getMusic_photo()+""+"flag"+flag);
            mAudioMusicName.setText(title);
            showPhoto(music);
            Intent intent = new Intent();
            intent.setAction("com.wwj.media.MUSIC_SERVICE");
            intent.setPackage("com.yutai.exuetang");
            intent.putExtra("url", url);
            intent.putExtra("listPosition", listPosition);
            intent.putExtra("MSG", AppConstant.PlayerMsg.PLAY_MSG);
            startService(intent);
            dialog.dismiss();
        }
    };
}
