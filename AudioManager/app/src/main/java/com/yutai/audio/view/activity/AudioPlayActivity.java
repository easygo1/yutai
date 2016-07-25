package com.yutai.audio.view.activity;

import android.content.Intent;
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
import com.yutai.audio.utils.PathToBitmapUtils;
import com.yutai.audio.utils.PhotoBlurUtils;
import com.yutai.audio.utils.ToastUtils;
import com.yutai.audio.view.custom.Player;
import com.yutai.audio.view.iview.IAudioPlayView;

import java.util.List;

/**
 * 音乐播放页面
 * 参考网址：http://blog.csdn.net/wwj_748/article/details/20933055
 */
public class AudioPlayActivity extends AppCompatActivity implements IAudioPlayView, View.OnClickListener {
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
    private ImageView mAudioPlaystyleImage;//播放类型（单曲循环，顺序播放，随机播放）
    private ImageView mAudioPlaypreviousImage;//上一曲
    private ImageView mAudioPlaynowImage;//播放或者暂停
    private ImageView mAudioPlaynextImage;//下一首
    private ImageView mAudioPlaylistImage;//播放列表（在最下右方）
    private ProgressBar mProgressBar;

    private LinearLayout mLinearLayout;

    private Player player; // 播放器
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
                    if (mAudioPlaySeekbar.getProgress() == mAudioPlaySeekbar.getMax()) { // 下载完成
                        showToast("下载成功");
                    }
                    break;
                case FAILURE: // 下载失败
                    showToast("下载失败");
                    break;
            }
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio_play);
        //获得意图
        Intent intent = getIntent();
        //读取数据
        music_id = intent.getIntExtra("music_id", 0);
        mAudioPlayPresenter = new AudioPlayPresenterImpl(this);
        initViews();
        initListeners();
        getData();
        setTextViews();
        new Thread() {
            public void run() {
                new AnotherTask().execute("JSON");
            }
        }.start();
//        new Thread(downloadRun).start();
    }

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

    private void initViews() {
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

    private void getData() {
        //得到数据
        mMusic = mAudioPlayPresenter.onSucess();
    }

    private void setTextViews() {
        //赋值
        mAudioName.setText(mMusic.getMusic_name());
        Glide.with(this).load(mMusic.getMusic_photo()).into(mAudioPhotoImage);
        /*Resources res = getResources();
        Bitmap bitmap = BitmapFactory.decodeResource(res, R.drawable.u24);*/
        Log.e("photo_path", mMusic.getMusic_photo());
        Log.e("music_mp3", mMusic.getMusic_path_mp3());
    }

    @Override
    public void showToast(String msg) {
        ToastUtils.showToast(this, msg);
    }

    @Override
    public int getMusicID() {
        return music_id;
    }

    @Override
    public void onClick(View v) {
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
                player = new Player(mAudioPlaySeekbar);
                player.playUrl(mMusic.getMusic_path_mp3());
                //player.onPrepared(player.mediaPlayer);
                player.play();
                break;
            case R.id.audio_playnext_image:
                //下一首
                showToast("下一首");
                break;
            case R.id.audio_playlist_image:
                //播放列表
                showToast("播放列表");
                break;
        }
    }

    //进度条改变时的事件监听
    private class SeekBarChangeEvent implements SeekBar.OnSeekBarChangeListener {
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {

        }
    }
}

