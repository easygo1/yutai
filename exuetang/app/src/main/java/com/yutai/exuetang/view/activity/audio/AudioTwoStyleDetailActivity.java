package com.yutai.exuetang.view.activity.audio;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.handmark.pulltorefresh.library.ILoadingLayout;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.yolanda.nohttp.Headers;
import com.yolanda.nohttp.NoHttp;
import com.yolanda.nohttp.RequestMethod;
import com.yolanda.nohttp.download.DownloadListener;
import com.yolanda.nohttp.download.DownloadRequest;
import com.yutai.exuetang.R;
import com.yutai.exuetang.db.MusciTableOperate;
import com.yutai.exuetang.model.beans.audio.music.Music;
import com.yutai.exuetang.presenter.dao.audio.AudioTwoStyleDetailPresenter;
import com.yutai.exuetang.presenter.impl.audio.AudioTwoStyleDetailPresenterImpl;
import com.yutai.exuetang.utils.FileUtils;
import com.yutai.exuetang.utils.ToastUtils;
import com.yutai.exuetang.view.adapter.audio.AudioListAdapter;
import com.yutai.exuetang.view.application.MyApplication;
import com.yutai.exuetang.view.iview.audio.IAudioTwoStyleDetailView;

import java.util.ArrayList;
import java.util.List;

public class AudioTwoStyleDetailActivity extends AppCompatActivity implements View.OnClickListener, IAudioTwoStyleDetailView {
    private ImageView mAudioTwostyleImage;
    private ImageView mAudioTwostyleBackImage;
    private TextView mAudioTwostyleTitleTextview;

    private TextView mTabNice;//选项卡
    private TextView mTabNew;
    private TextView mTabPopular;
    private PullToRefreshListView mAudioListview;
    private AudioTwoStyleDetailPresenter mAudioTwoStyleDetailPresenter;
    //设置分页
    private  static int cur = 1;//分页显示初始值是第一页

    private AudioListAdapter mAudioListAdapter;
    private List<Music> mMusicList;
    private int music_id;
    private int tabstyle = 1;//默认显示第一个<试听量排序>
    private String type1 = "";
    private String type2 = "";
    private String type_path;
    private boolean isFirst=true;
    //sqlite有关声明
    private MusciTableOperate mMusciTableOperate = null;
    //保存歌词地址
    String filepath = Environment
            .getExternalStorageDirectory().toString() + "/yutai/music";//文件的本地保存地址
    private int WHAT = 0;
    DownloadRequest mDownloadRequest1;
    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
//            更新UI操作
            switch (msg.what) {
                case 1:
                    mAudioListview.setAdapter(mAudioListAdapter);
                    //表示刷新完成
                    mAudioListview.onRefreshComplete();
                    //通知刷新
                    mAudioListAdapter.notifyDataSetChanged();
                    break;
                case 2:
                    Log.e("图片地址",type_path);
                    Glide.with(AudioTwoStyleDetailActivity.this)
                            .load(type_path)
                            .placeholder(R.mipmap.twostyle_defult)
                            .error(R.mipmap.twostyle_defult)
                            .into(mAudioTwostyleImage);
                    break;
                case 3:
                    mAudioListview.onRefreshComplete();//刷新完成
//                    mAudioListAdapter.notifyDataSetChanged();
                    break;
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio_two_style);
        Intent intent = getIntent();
        type1 = intent.getStringExtra("type1");
        type2 = intent.getStringExtra("type2");
//        Log.e("传过来的值", type1 + ":::" + type2);
        //根据type1 type2 网络请求数据
        //初始化控件
        initViews();
        initData();//初始化数据
        mMusciTableOperate = new MusciTableOperate(AudioTwoStyleDetailActivity.this);
        initWordStyleType();
        //设置上拉加载下拉刷新组件和事件监听
        //设置刷新模式为BOTH才可以上拉和下拉都能起作用,必须写在前面
        mAudioListview.setMode(PullToRefreshBase.Mode.BOTH);
        initRefreshListView();
        initListener();
        settypeImage();
        getData1();
        mTabNice.setTextColor(getResources().getColor(R.color.titlecolor));
    }

    private void initViews() {
        mAudioTwostyleImage = (ImageView) findViewById(R.id.audio_twostyle_image);
        mAudioTwostyleBackImage = (ImageView) findViewById(R.id.audio_twostyle_back_image);
        mAudioTwostyleTitleTextview = (TextView) findViewById(R.id.audio_twostyle_title_textview);

        mTabNice = (TextView) findViewById(R.id.tab_nice);
        mTabNew = (TextView) findViewById(R.id.tab_new);
        mTabPopular = (TextView) findViewById(R.id.tab_popular);
        mAudioListview = (PullToRefreshListView) findViewById(R.id.audio_listview);
        mAudioListview.setEmptyView(findViewById(R.id.empty));
//        mAudioListview.setScrollContainer(true);
        mAudioTwostyleTitleTextview.setText(type2);
    }

    private void initData() {
        //初始化数据
        mMusicList = new ArrayList<>();
//        mAudioListAdapter = new AudioListAdapter(mMusicList, this);
//        mAudioListview.setAdapter(mAudioListAdapter);
//        mAudioTwoStyleDetailPresenter = new AudioTwoStyleDetailPresenterImpl(this);
    }

    private void initWordStyleType() {
        mTabNice.setTypeface(MyApplication.sTypeface);
        mTabNew.setTypeface(MyApplication.sTypeface);
        mTabPopular.setTypeface(MyApplication.sTypeface);
    }

    private void initRefreshListView() {
        ILoadingLayout startLabels = mAudioListview.getLoadingLayoutProxy(true, false);
        startLabels.setPullLabel("下拉刷新");
        startLabels.setRefreshingLabel("正在刷新");
        startLabels.setReleaseLabel("放开刷新");
        ILoadingLayout endLabels = mAudioListview.getLoadingLayoutProxy(false, true);
        endLabels.setPullLabel("上拉加载");
        endLabels.setRefreshingLabel("正在载入...");
        endLabels.setReleaseLabel("放开加载...");
    }

    private void initListener() {
        mAudioTwostyleBackImage.setOnClickListener(this);
        mTabNice.setOnClickListener(this);
        mTabNew.setOnClickListener(this);
        mTabPopular.setOnClickListener(this);
        //设置上拉和下拉时候的监听器
        mAudioListview.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
            //下拉时
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {
                cur = 1;
//                Log.e("cur", "" + cur);
                mMusicList.clear();
                getData();
            }

            //上拉时
            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {
                //页码加一
                cur++;
//                Log.e("cur", "" + cur);
                getData();
            }
        });
        mAudioListview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //向sqlite中加入这条music信息,删除之前这条music信息
                mMusciTableOperate.deleteMusicByMusicid(mMusicList.get(position - 1).getMusic_id());
                mMusciTableOperate.insertData(mMusicList.get(position - 1));
                //判断手机里是否有这个歌词文件，来下载这个歌词
                downLoadLrc(mMusicList.get(position - 1));
                //跳转到play页面
                intentNextActivity(mMusicList.get(position - 1));
                music_id=mMusicList.get(position - 1).getMusic_id();
//                Log.e("position", "" + position);
            }
        });
    }
    private void getData1() {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        mAudioTwoStyleDetailPresenter = new AudioTwoStyleDetailPresenterImpl(this);
        mAudioTwoStyleDetailPresenter.onSuccess();
    }
    private void getData() {
        mAudioTwoStyleDetailPresenter = new AudioTwoStyleDetailPresenterImpl(AudioTwoStyleDetailActivity.this);
        mAudioTwoStyleDetailPresenter.onSuccess();
    }

    private void settypeImage() {
        mAudioTwoStyleDetailPresenter = new AudioTwoStyleDetailPresenterImpl(this);
        mAudioTwoStyleDetailPresenter.onGetTypePhoto();
    }

    public void intentNextActivity(Music music) {
        showToast("跳转到播放页面");
        mAudioTwoStyleDetailPresenter.onUpdateAudition();
        Intent intent = new Intent();
        intent.setClass(this, AudioPlayActivity.class);
        //绑定数据
        intent.putExtra("music", music);//也可以绑定数组
        startActivity(intent);
    }

    public void showToast(String msg) {
        ToastUtils.showToast(this, msg);
    }

    @Override
    public void tabShow() {

    }

    @Override
    public int gettabStyle() {
        return tabstyle;

    }

    @Override
    public int getmusicListCur() {
        return cur;
    }

    @Override
    public String getmusicTYype1() {
        return type1;
    }

    @Override
    public String getmusicTYype2() {
        return type2;
    }

    @Override
    public Activity getactivity() {
        return this;
    }

    @Override
    public void toActivity(List<Music> musicList) {
        Log.e("toActivity", mMusicList.toString());
        if(cur==1&&(!isFirst)&&mMusicList.size()!=0&&musicList!=null){
            mMusicList.clear();}
        if(musicList!=null){
            mMusicList.addAll(musicList);
            mAudioListAdapter = new AudioListAdapter(mMusicList, this);
            // 通知UI刷新页面
            Message message = new Message();
            message.what = 1;
            mHandler.sendMessage(message);
        }
//        Log.e("传过来的数据", "wqwq"+musicList.toString());
        if(musicList==null){
            Message message1 = new Message();
            message1.what = 3;
            mHandler.sendMessage(message1);}
        else if(musicList.size()==0){
            Message message2 = new Message();
            // 通知UI刷新页面
            message2.what = 3;
            mHandler.sendMessage(message2);
        }
    }

    @Override
    public int UpdateAuditionRequest() {
        return music_id;
    }

    @Override
    public void gettypepath(String type_path1) {
       type_path=type_path1;
//        Log.e("activity得到数据", type_path);
        //        通知UI刷新页面
        Message message = new Message();
        message.what = 2;
        mHandler.sendMessage(message);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.audio_twostyle_back_image:
                finish();
                break;
            case R.id.tab_nice:
                //人气推荐（按照试听量排序）
//                showToast("人气推荐");
                resetColor();
                cur = 1;
                tabstyle = 1;
                mMusicList.clear();
                isFirst=false;
                getData();
                mTabNice.setTextColor(getResources().getColor(R.color.titlecolor));
//                Log.e("人气推荐list", "" + mMusicList.size());
//                Log.e("人气推荐list", "" + mMusicList.toString());
                break;
            case R.id.tab_new:
//                最近更新（按照上传时间排序）
//                showToast("最近更新");
                resetColor();
                cur = 1;
                tabstyle = 2;
                mMusicList.clear();
                Log.e("clear","clear");
                isFirst=false;
                getData();
                mTabNew.setTextColor(getResources().getColor(R.color.titlecolor));
//                Log.e("最近更新list", "" + mMusicList.size());
                break;
            case R.id.tab_popular:
//                最受欢迎（按照下载量排序）
//                showToast("最受欢迎");
                cur = 1;
                tabstyle = 3;
                resetColor();
                mMusicList.clear();
                isFirst=false;
                getData();
                mTabPopular.setTextColor(getResources().getColor(R.color.titlecolor));
//                Log.e("最受欢迎list", "" + mMusicList.size());
                break;
        }
    }

    private void resetColor() {
        //        重置颜色
        mTabNice.setTextColor(getResources().getColor(R.color.gray));
        mTabNew.setTextColor(getResources().getColor(R.color.gray));
        mTabPopular.setTextColor(getResources().getColor(R.color.gray));
    }
    //根据music对象来下载歌词
    private void downLoadLrc(Music music){
        String itemfilepath=filepath+"/"+music.getMusic_type1()+"/";
        boolean adjustload= FileUtils.isExitsFile(music.getMusic_name()+".lrc",itemfilepath,".lrc");
        if(adjustload){
            //说明已经下载了歌词
        }else{
            //下载音乐歌词
            download(mDownloadRequest1, music.getMusic_path_lrc(),
                    music.getMusic_type1(), music.getMusic_name() + ".lrc", music.getMusic_id());
        }
    }
    //单个文件下载
    private void download(DownloadRequest downloadRequest, String url, String type1, String filename, int music_id) {
        downloadRequest = NoHttp.createDownloadRequest(url, filepath + "/" + type1
                ,
                filename,
                true,
                false);
        if (!check(downloadRequest)) {
            //此时说明还没有下载，去下载
            reques(downloadRequest, music_id);
        } else {
//            下载过了
        }

    }
    //检查之前的下载状态
    private boolean check(DownloadRequest mDownloadRequest) {
        // 检查之前的下载状态
        int beforeStatus = mDownloadRequest.checkBeforeStatus();
        boolean flog = false;
        switch (beforeStatus) {
            case DownloadRequest.STATUS_RESTART:
//                viewHolder.itemProgressBar.setProgress(0);
                //ToastUtils.showToast(mContext, "开始下载");
                break;
            case DownloadRequest.STATUS_RESUME:
                flog = true;
                //ToastUtils.showToast(mContext, "正在下载");
                break;
            case DownloadRequest.STATUS_FINISH:
//                viewHolder.itemProgressBar.setProgress(100);
                flog = true;
                //ToastUtils.showToast(mContext, "已经下载");
                break;
        }
        Log.e("下载ok", "" + flog);
        return flog;
    }
    private void reques(final DownloadRequest mDownloadRequest, final int music_id) {
        MyApplication.downloadQueue.add(WHAT, mDownloadRequest, new DownloadListener() {
            @Override
            public void onDownloadError(int what, Exception exception) {
                //下载异常
                Log.e("下载异常：", exception.toString());
                //ToastUtils.showToast(mContext, "下载异常");
            }

            @Override
            public void onStart(int what, boolean isResume, long rangeSize, Headers responseHeaders, long allCount) {
                //开始下载
                //what
                //isResume 是否重新下载
                //rangeSize 已下载文件大小
                //responseHeaders
                //allCount 文件总大小
                int progress = (int) (rangeSize * 100 / allCount); //下载进度
                Log.e("下载文件：", "文件大小" + rangeSize + "下载进度" + progress);
//                ToastUtils.showToast(mContext,"开始下载，文件大小"+rangeSize);
            }

            @Override
            public void onProgress(int what, int progress, long fileCount) {
                //下载进度
                //progress 进度
                //fileCount 文件大小
                Log.e("下载文件：", "文件大小" + fileCount + "下载进度" + progress);
            }

            @Override
            public void onFinish(int what, String filePath) {
//下载完成
                Log.e("下载文件：", "下载完成");
//                ToastUtils.showToast(mContext,"下载完成");
                Log.e("更新数据库", "zzzz");
                // 创建请求队列, 默认并发3个请求,传入你想要的数字可以改变默认并发数, 例如NoHttp.newRequestQueue(1);
                /*requestQueue = NoHttp.newRequestQueue();
                // 创建请求对象
                request = NoHttp.createStringRequest(mPath, RequestMethod.POST);
                // 添加请求参数
                request.add("methods", "updateMusicAndCoins");
                request.add("music_id", music_id);
                request.add("user_id", user_id);
                requestQueue.add(UPDATE_DOWNLOAD_NUM_COINS, request, onResponseListener);*/
            }

            @Override
            public void onCancel(int what) {
//取消下载
                Log.e("下载文件：", "取消下载");
            }
        });
    }
}
