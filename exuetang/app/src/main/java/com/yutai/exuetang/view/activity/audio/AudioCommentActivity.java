package com.yutai.exuetang.view.activity.audio;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.handmark.pulltorefresh.library.ILoadingLayout;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.yolanda.nohttp.NoHttp;
import com.yolanda.nohttp.RequestMethod;
import com.yolanda.nohttp.rest.OnResponseListener;
import com.yolanda.nohttp.rest.Request;
import com.yolanda.nohttp.rest.Response;
import com.yutai.exuetang.R;
import com.yutai.exuetang.model.beans.audio.music.GsonMusicCommentBean;
import com.yutai.exuetang.model.beans.audio.music.Music;
import com.yutai.exuetang.utils.RequestManager;
import com.yutai.exuetang.utils.ToastUtils;
import com.yutai.exuetang.view.adapter.audio.AudioCommentListAdapter;
import com.yutai.exuetang.view.application.MyApplication;

import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AudioCommentActivity extends AppCompatActivity implements View.OnClickListener {
    public static final int GET_MUSICCOMMENTS_LIST_WHAT = 1;
    public static final int ADD_MUSICCOMMENTS_WHAT = 2;
    private ImageView mCommentBackImage;
    private TextView mCommentTitleTextview;
    private ImageView mItemMusicPhoto;
    private TextView mItemMusicName;
    private TextView mItemMusicDescribe;
    private TextView mItemMusicNum;
    private TextView mItemMusicAuditionSum;
    private TextView mItemMusicDownloadSum;
    private ImageView mItemDownloadImage;
    private ImageView mItemShareImage;
    private TextView mNewComment;
    private PullToRefreshListView mCommentListview;
    private TextView mEmptyText;
    private EditText mSendCommentEdittext;
    private TextView mSendCommentTextview;

    private List<GsonMusicCommentBean> mMusicCommentBeanList;
    private AudioCommentListAdapter mCommentListAdapter;

    private int cur = 1;//显示分页，得到第几页
    Music music;
    private int music_id;
    private int user_id;//偏好设置中取
    SharedPreferences mSharedPreferences;
    public static final String USER = "user";

    //服务端的URL
    public String mPath = MyApplication.url + "/audioservlet";
    private boolean isSucess = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio_comment);
        getintentdata();
        initViews();
        initWordStyle();
        //设置上拉加载下拉刷新组件和事件监听
        //设置刷新模式为BOTH才可以上拉和下拉都能起作用,必须写在前面
        mCommentListview.setMode(PullToRefreshBase.Mode.PULL_FROM_END);
        initRefreshListView();
        initData();//初始化数据
        initListener();
        getData();
    }

    private void getintentdata() {
        mSharedPreferences = this.getSharedPreferences(USER, Context.MODE_PRIVATE);
        user_id = mSharedPreferences.getInt("user_id", 0);//整个页面要用
        Intent intent=getIntent();
        music= (Music) intent.getSerializableExtra("music");
        music_id=music.getMusic_id();
    }

    private void initViews() {
        mCommentBackImage = (ImageView) findViewById(R.id.comment_back_image);
        mCommentTitleTextview = (TextView) findViewById(R.id.comment_title_textview);
        mItemMusicPhoto = (ImageView) findViewById(R.id.item_music_photo);
        mItemMusicName = (TextView) findViewById(R.id.item_music_name);
        mItemMusicDescribe = (TextView) findViewById(R.id.item_music_describe);
        mItemMusicNum = (TextView) findViewById(R.id.item_music_num);
        mItemMusicAuditionSum = (TextView) findViewById(R.id.item_music_audition_sum);
        mItemMusicDownloadSum = (TextView) findViewById(R.id.item_music_download_sum);
        mItemDownloadImage = (ImageView) findViewById(R.id.item_download_image);
        mItemShareImage = (ImageView) findViewById(R.id.item_share_image);
        mNewComment = (TextView) findViewById(R.id.new_comment);
        mCommentListview = (PullToRefreshListView) findViewById(R.id.comment_listview);
        mSendCommentEdittext = (EditText) findViewById(R.id.send_comment_edittext);
        mSendCommentTextview = (TextView) findViewById(R.id.send_comment_textview);
        mEmptyText = (TextView) findViewById(R.id.emptyText);

    }

    private void initWordStyle() {
        //mCommentTitleTextview.setTypeface(MyApplication.sTypeface);
        mItemMusicName.setTypeface(MyApplication.sTypeface);
        mItemMusicDescribe.setTypeface(MyApplication.sTypeface);
        mItemMusicNum.setTypeface(MyApplication.sTypeface);
        mItemMusicAuditionSum.setTypeface(MyApplication.sTypeface);
        mItemMusicDownloadSum.setTypeface(MyApplication.sTypeface);
        mNewComment.setTypeface(MyApplication.sTypeface);
        mEmptyText.setTypeface(MyApplication.sTypeface);
        // mSendCommentTextview.setTypeface(MyApplication.sTypeface);
    }

    private void initRefreshListView() {
        ILoadingLayout startLabels = mCommentListview.getLoadingLayoutProxy(true, false);
        startLabels.setPullLabel("下拉刷新");
        startLabels.setRefreshingLabel("正在刷新");
        startLabels.setReleaseLabel("放开刷新");
        ILoadingLayout endLabels = mCommentListview.getLoadingLayoutProxy(false, true);
        endLabels.setPullLabel("上拉加载");
        endLabels.setRefreshingLabel("正在载入...");
        endLabels.setReleaseLabel("放开加载...");
    }

    private void initListener() {
        mCommentBackImage.setOnClickListener(this);
        mItemDownloadImage.setOnClickListener(this);
        mItemShareImage.setOnClickListener(this);
        mSendCommentTextview.setOnClickListener(this);
        mCommentListview.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener<ListView>() {
            @Override
            public void onRefresh(PullToRefreshBase<ListView> refreshView) {
                cur++;
                getData();
            }
        });
        mCommentListview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });
    }

    private void getData() {
        Request<String> request = NoHttp.createStringRequest(mPath, RequestMethod.GET);
        // 添加请求参数
        request.add("methods", "getMusicComments");
        request.add("music_id", music_id);
        request.add("cur", cur);
        RequestManager.getInstance().add(GET_MUSICCOMMENTS_LIST_WHAT, request, onResponseListener);
    }

    private void initData() {
       Glide.with(this).load(music.getMusic_photo()).into(mItemMusicPhoto);
        mItemMusicName.setText(music.getMusic_name());
        mItemMusicDescribe.setText(music.getMusic_introduct());
//      mItemMusicNum.setText(music.get);
        mItemMusicAuditionSum.setText(""+music.getMusic_audition_sum_number());
        mItemMusicDownloadSum.setText(""+music.getMusic_download_sum_number());
        //初始化数据
        mMusicCommentBeanList = new ArrayList<>();
        mCommentListAdapter = new AudioCommentListAdapter(this, mMusicCommentBeanList);
        mCommentListview.setAdapter(mCommentListAdapter);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.comment_back_image:
                finish();
                break;
            case R.id.item_download_image:
                ToastUtils.showToast(this, "下载歌曲");
                break;
            case R.id.item_share_image:
                ToastUtils.showToast(this, "分享该歌曲");
                break;
            case R.id.send_comment_textview:
                ToastUtils.showToast(this, "发表评论");
                addMusicComments();
                break;
        }
    }

    private void addMusicComments() {
        Log.e("评论", mSendCommentEdittext.getText().toString());
        Log.e("评论", "" + mSendCommentEdittext.getText().length());
        if (mSendCommentEdittext.getText().length() > 0) {
            if (mSendCommentEdittext.getText().length() < 100) {
                String comment_content = mSendCommentEdittext.getText().toString();
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy年MM月dd日    HH:mm:ss     ");
                Date curDate = new Date(System.currentTimeMillis());//获取当前时间
                String comment_time =formatter.format(curDate);
                Request < String > request = NoHttp.createStringRequest(mPath, RequestMethod.GET);
                // 添加请求参数
                request.add("methods", "addMusiccomment");
                request.add("music_id", music_id);
                request.add("user_id", user_id);
                request.add("comment_content", comment_content);
                request.add("comment_time", comment_time);
                RequestManager.getInstance().add(ADD_MUSICCOMMENTS_WHAT, request, onResponseListener);

            } else {
                ToastUtils.showToast(this, "评论内容在100字以内");
            }
        } else {
            ToastUtils.showToast(this, "评论内容不能为空");
        }
    }

    //    网络请求的结果的处理
    public OnResponseListener<String> onResponseListener = new OnResponseListener<String>() {

        @Override
        public void onStart(int what) {

        }

        @Override
        public void onSucceed(int what, Response<String> response) {
            String result = response.get();// 响应结果
            switch (what) {
                case GET_MUSICCOMMENTS_LIST_WHAT:
                    List<GsonMusicCommentBean> commentBeanlist = new ArrayList<>();
//获取音乐
                    // Log.e("music::", result2);//list
                    if (result.equals("400")) {
                        isSucess=false;
                        ToastUtils.showToast(AudioCommentActivity.this, "获取数据异常");
                    } else if (result.equals("201")) {
                        ToastUtils.showToast(AudioCommentActivity.this, "没有数据了");
                        isSucess = true;
                    } else {
                        isSucess = true;
                        Log.e("result", result);
                        //此时的判断是 有时会出现图片请求的结果 不明白为啥 这样写也不能解决
                        Gson gson = new Gson();
                        Type type = new TypeToken<List<GsonMusicCommentBean>>() {
                        }.getType();
                        commentBeanlist = gson.fromJson(result, type);
                        int commentssize=commentBeanlist.get(0).getCommentssize();
                        mCommentTitleTextview.setText("评论("+commentssize+")");
                    }
                    if (isSucess) {

//                       得到数据
                        mMusicCommentBeanList.addAll(commentBeanlist);
                        //通知刷新
                        mCommentListAdapter.notifyDataSetChanged();
                        //表示刷新完成
                        mCommentListview.onRefreshComplete();
                    }
                    break;
                case ADD_MUSICCOMMENTS_WHAT:
//                    修改头像
                    if (result.equals("200")) {
                        ToastUtils.showToast(AudioCommentActivity.this, "评论成功");
//                        mMyInfoNicknameTv.setText(contenttext.getText().toString());
                    } else if (result.equals("222")) {
                        ToastUtils.showToast(AudioCommentActivity.this, "评论失败");
                    }
                    break;
            }
        }

        @Override
        public void onFailed(int what, String url, Object tag, Exception exception, int responseCode, long networkMillis) {

        }

        @Override
        public void onFinish(int what) {

        }
    };
}
