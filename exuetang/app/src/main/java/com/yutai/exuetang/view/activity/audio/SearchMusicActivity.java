package com.yutai.exuetang.view.activity.audio;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.yolanda.nohttp.NoHttp;
import com.yolanda.nohttp.RequestMethod;
import com.yolanda.nohttp.error.NetworkError;
import com.yolanda.nohttp.error.NotFoundCacheError;
import com.yolanda.nohttp.error.ServerError;
import com.yolanda.nohttp.error.TimeoutError;
import com.yolanda.nohttp.error.URLError;
import com.yolanda.nohttp.error.UnKnownHostError;
import com.yolanda.nohttp.rest.OnResponseListener;
import com.yolanda.nohttp.rest.Request;
import com.yolanda.nohttp.rest.RequestQueue;
import com.yolanda.nohttp.rest.Response;
import com.yutai.exuetang.R;
import com.yutai.exuetang.model.beans.audio.music.Music;
import com.yutai.exuetang.presenter.dao.audio.AudioTwoStyleDetailPresenter;
import com.yutai.exuetang.presenter.impl.audio.AudioTwoStyleDetailPresenterImpl;
import com.yutai.exuetang.utils.SearchView;
import com.yutai.exuetang.utils.ToastUtils;
import com.yutai.exuetang.utils.nohttp.WaitDialog;
import com.yutai.exuetang.view.adapter.audio.AudioListAdapter;
import com.yutai.exuetang.view.application.MyApplication;
import com.yutai.exuetang.view.iview.audio.IAudioTwoStyleDetailView;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class SearchMusicActivity extends AppCompatActivity implements SearchView.SearchViewListener,IAudioTwoStyleDetailView {
    public static final int GET_ALLMUSIC_LIST_WHAT = 1;
    public static final int UPDATE_AUDITION_NUM = 2;
    /**
     * 默认提示框显示项的个数
     */
    private static int DEFAULT_HINT_SIZE = 4;
    /**
     * 提示框显示项的个数
     */
    private static int hintSize = DEFAULT_HINT_SIZE;
    public String mPath = MyApplication.url + "/audioservlet";
    Request<String> request;
    /**
     * 搜索结果列表view
     */
    private ListView mListView;
    /**
     * 搜索view
     */
    private SearchView mSearchView;
    /**
     * 热搜框列表adapter
     */
    private ArrayAdapter<String> hintAdapter;
    /**
     * 自动补全列表adapter
     */
    private ArrayAdapter<String> autoCompleteAdapter;
    /**
     * 搜索结果列表adapter
     */
    private AudioListAdapter resultAdapter;
    private List<Music> dbData;
    /**
     * 热搜版数据
     */
    private List<String> hintData;
    /**
     * 搜索过程中自动补全数据
     */
    private List<String> autoCompleteData;
    /**
     * 搜索结果的数据
     */
    private List<Music> resultData;
    //网络请求队列
    private RequestQueue requestQueue;
    //自定义一个dialog
    private WaitDialog mDialog;
    private int music_id;
    private AudioTwoStyleDetailPresenter mAudioTwoStyleDetailPresenter;
    public OnResponseListener<String> onResponseListener = new OnResponseListener<String>() {
        @Override
        public void onStart(int what) {
         // 请求开始，这里可以显示一个dialog
            mDialog.show();
        }

        @Override
        public void onSucceed(int what, Response<String> response) {
            String result = response.get();// 响应结果
            switch (what) {
                case GET_ALLMUSIC_LIST_WHAT:
                    //获取音乐
//                    Log.e("music:::::", result);
                    //把JSON格式的字符串改为Student对象
                    Gson gson = new Gson();
                    Type type = new TypeToken<List<Music>>() {
                    }.getType();
                    dbData = gson.fromJson(result, type);
                    Log.e("网络请求mMusicList", dbData.toString());
                    if (dbData.size() == 0) {
                        ToastUtils.showToast(SearchMusicActivity.this, "没有数据了");
                    }
                    break;
                case UPDATE_AUDITION_NUM:
                    if(result.equals("true")){
//                    数据库更新成功
//                        isload=true;
                    }
                    break;
            }
        }

        @Override
        public void onFailed(int what, String url, Object tag, Exception exception, int responseCode, long networkMillis) {
 /*if (exception instanceof ClientError) {// 客户端错误
                ToastUtils.showToast(mActivity, "客户端错误");
            } else */
            if (exception instanceof ServerError) {// 服务器错误
                ToastUtils.showToast(SearchMusicActivity.this, "服务器错误");
            } else if (exception instanceof NetworkError) {// 网络不好
                ToastUtils.showToast(SearchMusicActivity.this, "网络不好");
            } else if (exception instanceof TimeoutError) {// 请求超时
                ToastUtils.showToast(SearchMusicActivity.this, "请求超时");
            } else if (exception instanceof UnKnownHostError) {// 找不到服务器
                ToastUtils.showToast(SearchMusicActivity.this, "找不到服务器");
            } else if (exception instanceof URLError) {// URL是错的
                ToastUtils.showToast(SearchMusicActivity.this, "URL是错的");
            } else if (exception instanceof NotFoundCacheError) {
                ToastUtils.showToast(SearchMusicActivity.this, "没有发现缓存");
                // 这个异常只会在仅仅查找缓存时没有找到缓存时返回
            } else {
                ToastUtils.showToast(SearchMusicActivity.this, "未知错误");
            }
        }

        @Override
        public void onFinish(int what) {
            mDialog.dismiss();
        }
    };

    /**
     * 设置提示框显示项的个数
     *
     * @param hintSize 提示框显示个数
     */
    public static void setHintSize(int hintSize) {
        SearchMusicActivity.hintSize = hintSize;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_music);
//        初始化数据
        initData();
//        初始化控件
        initViews();
//        设置监听
        initListener();
    }

    private void initData() {
        //从数据库获取数据
        getDbData();
        //初始化热搜版数据
        getHotData();
        //初始化自动补全数据
        getAutoCompleteData(null);
        //初始化搜索结果数据
        getResultData(null);
    }

    private void initViews() {
        mSearchView = (SearchView) findViewById(R.id.search_layout);
        mListView = (ListView) findViewById(R.id.main_lv_search_results);
    }

    private void initListener() {
        //设置监听
        mSearchView.setSearchViewListener(this);
        //设置adapter
        mSearchView.setTipsHintAdapter(hintAdapter);
        mSearchView.setAutoCompleteAdapter(autoCompleteAdapter);
//        解决listview中的item单击事件失效的问题??? 布局出现了低级错误！！！
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
//                ToastUtils.showToast(SearchMusicActivity.this, "我是item" + position);
                mAudioTwoStyleDetailPresenter = new AudioTwoStyleDetailPresenterImpl(SearchMusicActivity.this);
                Music music = resultData.get(position);
                music_id=music.getMusic_id();
                mAudioTwoStyleDetailPresenter.onUpdateAudition();
//                Intent intent=new Intent(SearchMusicActivity.this,AudioPlayActivity.class);
                Intent intent = new Intent();
                intent.setClass(SearchMusicActivity.this, AudioPlayActivity.class);
                intent.putExtra("music", music);
                startActivity(intent);
                UpdateRequest(music.getMusic_id());
//                ToastUtils.showToast(SearchMusicActivity.this, music.toString());

            }
        });
    }

    private void UpdateRequest(int music_id) {
        // 创建请求队列, 默认并发3个请求,传入你想要的数字可以改变默认并发数, 例如NoHttp.newRequestQueue(1);
        requestQueue = NoHttp.newRequestQueue();
        // 创建请求对象
        request = NoHttp.createStringRequest(mPath, RequestMethod.POST);
        // 添加请求参数
        request.add("methods", "updateAuditionNum");
        request.add("music_id", music_id);
        requestQueue.add(UPDATE_AUDITION_NUM, request, onResponseListener);
    }

    /**
     * 当搜索框 文本改变时 触发的回调 ,更新自动补全数据
     *
     * @param text
     */
    @Override
    public void onRefreshAutoComplete(String text) {
        //更新数据
        getAutoCompleteData(text);
    }

    /**
     * 点击搜索键时edit text触发的回调
     *
     * @param text
     */

    @Override
    public void onSearch(String text) {
        //更新result数据
        getResultData(text);
        mListView.setVisibility(View.VISIBLE);
        //第一次获取结果 还未配置适配器
        if (mListView.getAdapter() == null) {
            //获取搜索数据 设置适配器
            mListView.setAdapter(resultAdapter);
        } else {
            //更新搜索数据
            resultAdapter.notifyDataSetChanged();
        }
        Toast.makeText(this, "完成搜素", Toast.LENGTH_SHORT).show();
    }

    /**
     * 获取db 数据
     */
    private void getDbData() {
        mDialog = new WaitDialog(this);
        // 创建请求队列, 默认并发3个请求,传入你想要的数字可以改变默认并发数, 例如NoHttp.newRequestQueue(1);
        requestQueue = NoHttp.newRequestQueue();
        // 创建请求对象
        request = NoHttp.createStringRequest(mPath, RequestMethod.POST);
        // 添加请求参数
        request.add("methods", "getallmusic");
        requestQueue.add(GET_ALLMUSIC_LIST_WHAT, request, onResponseListener);
    }

    /**
     * 获取热搜版data 和adapter
     */
    private void getHotData() {
        hintData = new ArrayList<>(hintSize);
        for (int i = 1; i <= hintSize; i++) {
            hintData.add("热搜版" + i + "：经典儿歌");
        }
        hintAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, hintData);
    }

    /**
     * 获取自动补全data 和adapter
     */
    private void getAutoCompleteData(String text) {
        if (autoCompleteData == null) {
            //初始化
            autoCompleteData = new ArrayList<>(hintSize);
        } else {
            // 根据text 获取auto data
            autoCompleteData.clear();
            for (int i = 0, count = 0; i < dbData.size()
                    && count < hintSize; i++) {
                if (dbData.get(i).getMusic_name().contains(text.trim())) {
                    autoCompleteData.add(dbData.get(i).getMusic_name());
                    count++;
                }
            }
        }
        if (autoCompleteAdapter == null) {
            autoCompleteAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, autoCompleteData);
        } else {
            autoCompleteAdapter.notifyDataSetChanged();
        }
    }

    private void getResultData(String text) {
        if (resultData == null) {
            // 初始化
            resultData = new ArrayList<>();
        } else {
            resultData.clear();
            for (int i = 0; i < dbData.size(); i++) {
                if (dbData.get(i).getMusic_name().contains(text.trim())) {
                    resultData.add(dbData.get(i));
                }
            }
        }
        if (resultAdapter == null) {
            resultAdapter = new AudioListAdapter(resultData, SearchMusicActivity.this);
        } else {
            resultAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void intentNextActivity(int music_id) {

    }

    @Override
    public void showToast(String msg) {

    }

    @Override
    public void tabShow() {

    }

    @Override
    public int gettabStyle() {
        return 0;
    }

    @Override
    public int getmusicListCur() {
        return 0;
    }

    @Override
    public String getmusicTYype1() {
        return null;
    }

    @Override
    public String getmusicTYype2() {
        return null;
    }

    @Override
    public Activity getactivity() {
        return this;
    }

    @Override
    public void toActivity(List<Music> musicList) {

    }

    @Override
    public int UpdateAuditionRequest() {
        return music_id;
    }

    @Override
    public void gettypepath(String type_path) {

    }
}
