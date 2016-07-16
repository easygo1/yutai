package com.yutai.audio.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.handmark.pulltorefresh.library.ILoadingLayout;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.yutai.audio.R;
import com.yutai.audio.model.beans.music.Music;
import com.yutai.audio.presenters.dao.AudioTwoStyleDetailPresenter;
import com.yutai.audio.presenters.impl.AudioTwoStyleDetailPresenterImpl;
import com.yutai.audio.utils.ToastUtils;
import com.yutai.audio.view.adapter.AudioListAdapter;
import com.yutai.audio.view.application.MyApplication;
import com.yutai.audio.view.iview.AudioTwoStyleDetailView;

import java.util.ArrayList;
import java.util.List;

//二级分类的详情页面
public class AudioTwoStyleDetailActivity extends AppCompatActivity implements View.OnClickListener, AudioTwoStyleDetailView {
    private ImageView mTwostyleTitleBack;
    private TextView mTabNice;
    private TextView mTabNew;
    private TextView mTabPopular;
    private PullToRefreshListView mAudioListview;
    private AudioListAdapter mAudioListAdapter;
    private List<Music> mMusicList;
    public int tabstyle = 1;//默认显示第一个

    private AudioTwoStyleDetailPresenter mAudioTwoStyleDetailPresenter;
    //设置分页
    private int cur = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio_two_style_detail);
        initViews();
        initData();
        //3.设置上拉加载下拉刷新组件和事件监听
        //设置刷新模式为BOTH才可以上拉和下拉都能起作用,必须写在前面
        mAudioListview.setMode(PullToRefreshBase.Mode.BOTH);
        initRefreshListView();
        initListener();
        mAudioTwoStyleDetailPresenter = new AudioTwoStyleDetailPresenterImpl(this);
        getData();
        mTabNice.setTextColor(getResources().getColor(R.color.textDown));
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

    private void initViews() {
        mTwostyleTitleBack = (ImageView) findViewById(R.id.twostyle_title_back);
        mTabNice = (TextView) findViewById(R.id.tab_nice);
        mTabNew = (TextView) findViewById(R.id.tab_new);
        mTabPopular = (TextView) findViewById(R.id.tab_popular);
        mAudioListview = (PullToRefreshListView) findViewById(R.id.audio_listview);
        mTabNice.setTypeface(MyApplication.sTypeface);
        mTabNew.setTypeface(MyApplication.sTypeface);
        mTabPopular.setTypeface(MyApplication.sTypeface);
    }

    private void initData() {
        //初始化数据
        mMusicList = new ArrayList<>();
        mAudioListAdapter = new AudioListAdapter(mMusicList, this);
        mAudioListview.setAdapter(mAudioListAdapter);
    }

    private void getData() {
        mMusicList.clear();
        mMusicList.addAll(mAudioTwoStyleDetailPresenter.onSuccess());
        //通知刷新
        mAudioListAdapter.notifyDataSetChanged();
        //表示刷新完成
        mAudioListview.onRefreshComplete();
    }

    private void initListener() {
        mTwostyleTitleBack.setOnClickListener(this);
        mTabNice.setOnClickListener(this);
        mTabNew.setOnClickListener(this);
        mTabPopular.setOnClickListener(this);
        //设置上拉和下拉时候的监听器
        mAudioListview.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
            //下拉时
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {
                cur = 1;
            }

            //上拉时
            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {
                //页码加一
                cur++;
            }
        });
        mAudioListview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                intentNextActivity();
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.twostyle_title_back:
                finish();
                break;
            case R.id.tab_nice:
                //人气推荐（按照试听量排序）
//                showToast("人气推荐");
                resetColor();
                tabstyle = 1;
                getData();
                mTabNice.setTextColor(getResources().getColor(R.color.textDown));
//                Log.e("人气推荐list", "" + mMusicList.size());
//                Log.e("人气推荐list", "" + mMusicList.toString());
                break;
            case R.id.tab_new:
//                最近更新（按照上传时间排序）
//                showToast("最近更新");
                resetColor();
                tabstyle = 2;
                getData();
                mTabNew.setTextColor(getResources().getColor(R.color.textDown));
//                Log.e("最近更新list", "" + mMusicList.size());
                break;
            case R.id.tab_popular:
//                最受欢迎（按照下载量排序）
//                showToast("最受欢迎");
                tabstyle = 3;
                resetColor();
                getData();
                mTabPopular.setTextColor(getResources().getColor(R.color.textDown));
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

    @Override
    public void intentNextActivity() {
        Intent intent = new Intent();
        intent.setClass(this, TestActivity.class);
        startActivity(intent);
    }

    @Override
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
}
