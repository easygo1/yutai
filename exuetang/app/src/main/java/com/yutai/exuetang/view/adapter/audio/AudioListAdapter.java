package com.yutai.exuetang.view.adapter.audio;

import android.app.Dialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Environment;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.yolanda.nohttp.Headers;
import com.yolanda.nohttp.NoHttp;
import com.yolanda.nohttp.RequestMethod;
import com.yolanda.nohttp.download.DownloadListener;
import com.yolanda.nohttp.download.DownloadRequest;
import com.yolanda.nohttp.rest.OnResponseListener;
import com.yolanda.nohttp.rest.Request;
import com.yolanda.nohttp.rest.RequestQueue;
import com.yolanda.nohttp.rest.Response;
import com.yutai.exuetang.R;
import com.yutai.exuetang.model.beans.audio.music.Music;
import com.yutai.exuetang.utils.FileUtils;
import com.yutai.exuetang.utils.ToastUtils;
import com.yutai.exuetang.view.application.MyApplication;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ZFG on 2016/7/15.
 */
public class AudioListAdapter extends BaseAdapter {
    public static final int UPDATE_DOWNLOAD_NUM_COINS = 1;
    public static final int GET_USER_COINS = 2;
    private static final String CancelSign = "CancelSign";
    private static boolean isload = false;
    public static double user_coins=0.0;
    int user_id;//用户的id 要从偏好设置中获取
    SharedPreferences mSharedPreferences;
    public static final String USER = "user";
    public String mPath = MyApplication.url + "/audioservlet";
    //    网络请求
    public OnResponseListener<String> onResponseListener = new OnResponseListener<String>() {

        @Override
        public void onStart(int what) {
            // 请求开始
        }

        @Override
        public void onSucceed(int what, Response<String> response) {
            switch (what) {
                case UPDATE_DOWNLOAD_NUM_COINS:
                    String result = response.get();
//                更新音乐的下载量
                    Log.e("更新结果", result);
                    if (result.equals("true")) {
//                    数据库更新成功
                        isload = true;
                    }
                    break;
                case GET_USER_COINS:
                    String result1 = response.get();
//                    得到该用户的学习币
                    Log.e("用户学习币", response.get());
                    user_coins=Double.parseDouble(result1);
//                    Log.e("用户学习币", ""+user_coins);
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
    LayoutInflater mInflater;
    Context mContext;
    List<Music> mMusicList = null;
    DownloadRequest mDownloadRequest1, mDownloadRequest2;//下载请求
    List<DownloadRequest> mDownloadRequests;
    String filepath = Environment
            .getExternalStorageDirectory().toString() + "/yutai/music";//文件的本地保存地址
    Request<String> request;
    private int WHAT = 0;
    //网络请求队列
    private RequestQueue requestQueue;
    //多文件下载的监听
    private DownloadListener downloadListener = new DownloadListener() {
        @Override
        public void onDownloadError(int what, Exception exception) {
            Log.e("多文件下载", "下载异常" + exception.toString());
        }

        @Override
        public void onStart(int what, boolean isResume, long rangeSize, Headers responseHeaders, long allCount) {
            Log.e("多文件下载", "开始下载");
        }

        @Override
        public void onProgress(int what, int progress, long fileCount) {
//            Log.e("多文件下载","正在下载");
        }

        @Override
        public void onFinish(int what, String filePath) {
            Log.e("多文件下载", filePath + "下载完成");
        }

        @Override
        public void onCancel(int what) {
            Log.e("多文件下载", "取消下载");
        }
    };

    public AudioListAdapter(List<Music> musicList, Context context) {
        mMusicList = musicList;
        mContext = context;
        mInflater = LayoutInflater.from(mContext);
        mDownloadRequests = new ArrayList<>();
        mSharedPreferences = mContext.getSharedPreferences(USER, Context.MODE_PRIVATE);
        user_id = mSharedPreferences.getInt("user_id", 0);//整个页面要用
    }

    @Override
    public int getCount() {
        return mMusicList.size();
    }

    @Override
    public Object getItem(int position) {
        return mMusicList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    //检查之前的下载状态
    private boolean check(DownloadRequest mDownloadRequest) {
        // 检查之前的下载状态
        int beforeStatus = mDownloadRequest.checkBeforeStatus();
        boolean flog = false;
        switch (beforeStatus) {
            case DownloadRequest.STATUS_RESTART:
//                viewHolder.itemProgressBar.setProgress(0);
                ToastUtils.showToast(mContext, "开始下载");
                break;
            case DownloadRequest.STATUS_RESUME:
                flog = true;
                ToastUtils.showToast(mContext, "正在下载");
                break;
            case DownloadRequest.STATUS_FINISH:
//                viewHolder.itemProgressBar.setProgress(100);
                flog = true;
                ToastUtils.showToast(mContext, "已经下载");
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
                ToastUtils.showToast(mContext, "下载异常");
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
                requestQueue = NoHttp.newRequestQueue();
                // 创建请求对象
                request = NoHttp.createStringRequest(mPath, RequestMethod.POST);
                // 添加请求参数
                request.add("methods", "updateMusicAndCoins");
                request.add("music_id", music_id);
                request.add("user_id", user_id);
                requestQueue.add(UPDATE_DOWNLOAD_NUM_COINS, request, onResponseListener);
            }

            @Override
            public void onCancel(int what) {
//取消下载
                Log.e("下载文件：", "取消下载");
            }
        });
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.audio_twostyle_list_item, null);
            viewHolder = new ViewHolder();
            //music
            viewHolder.itemMusicPhoto = (ImageView) convertView.findViewById(R.id.item_music_photo);
            viewHolder.itemMusicName = (TextView) convertView.findViewById(R.id.item_music_name);
            viewHolder.itemMusicDescribe = (TextView) convertView.findViewById(R.id.item_music_describe);
            viewHolder.itemMusicAuditionSum = (TextView) convertView.findViewById(R.id.item_music_audition_sum);
            viewHolder.itemMusicDownloadSum = (TextView) convertView.findViewById(R.id.item_music_download_sum);
            viewHolder.itemDownloadImage = (ImageView) convertView.findViewById(R.id.item_download_image);
            viewHolder.itemShareImage = (ImageView) convertView.findViewById(R.id.item_share_image);
//            viewHolder.itemProgressBar= (ProgressBar) convertView.findViewById(R.id.down_progressbar);
            viewHolder.itemMusicName.setTypeface(MyApplication.sTypeface);
            viewHolder.itemMusicDescribe.setTypeface(MyApplication.sTypeface);
            viewHolder.itemMusicAuditionSum.setTypeface(MyApplication.sTypeface);
            viewHolder.itemMusicDownloadSum.setTypeface(MyApplication.sTypeface);
            convertView.setTag(viewHolder);
        } else {
            //说明开始上下滑动，后面的所有行布局采用第一次绘制时的缓存布局
            viewHolder = (ViewHolder) convertView.getTag();
        }
        final ImageView downloadimageView = (ImageView) convertView.findViewById(R.id.item_download_image);
        final ImageView shareimageView = (ImageView) convertView.findViewById(R.id.item_share_image);
        final String itemfilepath=filepath+"/"+mMusicList.get(position).getMusic_type1()+"/";
        downloadimageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(user_id!=0){
                    //FileVisitorUtils.finder.findFiles(".mp3",);
                    boolean adjustload= FileUtils.isExitsFile(mMusicList.get(position).getMusic_name()+".mp3",itemfilepath,".mp3");
                    if(adjustload){
                        ToastUtils.showToast(mContext,"已经下载！");
                    }else{
                        showDialog();
                    }
                }else{
                    ToastUtils.showToast(mContext,"去登录！！");
                }

             }
            private void showDialog() {
                LayoutInflater inflater = LayoutInflater.from(mContext);
                View view = inflater.inflate(R.layout.download_dialog, null);
                final AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
                builder.setView(view);
                final Dialog dialog = builder.show();
                //isUserHavecoins();
                Button canclebutton = (Button) view.findViewById(R.id.download_cancle);
                Button okbutton = (Button) view.findViewById(R.id.download_ok);
                final TextView downloadtextView= (TextView) view.findViewById(R.id.download_textview);
                downloadtextView.setText("您需要花费"+mMusicList.get(position).getMusic_coins()+"学习币下载当前歌曲");
                canclebutton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                        ToastUtils.showToast(mContext,"取消下载！！");
                    }
                });
                okbutton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        isUserHavecoins();
                        if(user_coins>=mMusicList.get(position).getMusic_coins()){
                            // 判断该用户的coins学习币是否能够下载该歌曲
//                            此时说明用户的学习币数量可以下载该歌曲
                            isload = false;
                            //ToastUtils.showToast(mContext, "下载对话框");
                            //下载音乐
                            download(mDownloadRequest1, mMusicList.get(position).getMusic_path_mp3(),
                                    mMusicList.get(position).getMusic_type1(), mMusicList.get(position).getMusic_name() + ".mp3", mMusicList.get(position).getMusic_id());
                        dialog.dismiss();
                        }else{
                            ToastUtils.showToast(mContext,"您的学习币不足请去充值");
                            dialog.dismiss();
                        }
                       }
                });
            }

            private void isUserHavecoins() {
                // 创建请求队列, 默认并发3个请求,传入你想要的数字可以改变默认并发数, 例如NoHttp.newRequestQueue(1);
                requestQueue = NoHttp.newRequestQueue();
                // 创建请求对象
                request = NoHttp.createStringRequest(mPath, RequestMethod.POST);
                // 添加请求参数
                request.add("methods", "selectUserCoins");
                request.add("user_id", user_id);
                requestQueue.add(GET_USER_COINS, request, onResponseListener);
            }
        });
        shareimageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtils.showToast(mContext, "分享对话框");
            }
        });
        final Music music = mMusicList.get(position);
        Glide.with(mContext)
                .load(music.getMusic_photo())
                .into(viewHolder.itemMusicPhoto);
        viewHolder.itemMusicName.setText(music.getMusic_name());
        viewHolder.itemMusicDescribe.setText(music.getMusic_introduct());
        viewHolder.itemMusicAuditionSum.setText("" + music.getMusic_audition_sum_number());
        if (isload) {
            viewHolder.itemMusicDownloadSum.setText("" + music.getMusic_download_sum_number() + 1);
        } else {
            viewHolder.itemMusicDownloadSum.setText("" + music.getMusic_download_sum_number());
        }
        return convertView;
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

    class ViewHolder {
        //item布局控件
        ImageView itemMusicPhoto;
        TextView itemMusicName;
        TextView itemMusicDescribe;
        TextView itemMusicAuditionSum;
        TextView itemMusicDownloadSum;
        ImageView itemDownloadImage;
        ImageView itemShareImage;
//        ProgressBar itemProgressBar;
    }
}
