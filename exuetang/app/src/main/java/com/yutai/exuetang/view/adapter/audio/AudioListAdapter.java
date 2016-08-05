package com.yutai.exuetang.view.adapter.audio;

import android.content.Context;
import android.os.Environment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
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
import com.yutai.exuetang.utils.ToastUtils;
import com.yutai.exuetang.view.application.MyApplication;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ZFG on 2016/7/15.
 */
public class AudioListAdapter extends BaseAdapter {
    public static final int UPDATE_DOWNLOAD_NUM = 1;
    private static final String CancelSign = "CancelSign";
    private static boolean isload = false;
    LayoutInflater mInflater;
    Context mContext;
    List<Music> mMusicList = null;
    DownloadRequest mDownloadRequest1, mDownloadRequest2;//下载请求
    List<DownloadRequest> mDownloadRequests;
    String filepath = Environment.getExternalStorageDirectory().getPath() + "/yutai/music";//文件的本地保存地址
    private int WHAT = 0;

    public String mPath = MyApplication.url + "/audioservlet";
    //网络请求队列
    private RequestQueue requestQueue;
    Request<String> request;
//    网络请求
    public OnResponseListener<String> onResponseListener = new OnResponseListener<String>() {
    @Override
    public void onStart(int what) {
        // 请求开始
    }

    @Override
    public void onSucceed(int what, Response<String> response) {
        String result=response.get();
        switch (what){
            case UPDATE_DOWNLOAD_NUM:
//                更新音乐的下载量
                Log.e("更新结果",result);
                if(result.equals("true")){
//                    数据库更新成功
                    isload=true;
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
        boolean flog=false;
        switch (beforeStatus) {
            case DownloadRequest.STATUS_RESTART:
//                viewHolder.itemProgressBar.setProgress(0);
                ToastUtils.showToast(mContext, "开始下载");
                break;
            case DownloadRequest.STATUS_RESUME:
                flog=true;
                ToastUtils.showToast(mContext, "正在下载");
                break;
            case DownloadRequest.STATUS_FINISH:
//                viewHolder.itemProgressBar.setProgress(100);
                flog=true;
                ToastUtils.showToast(mContext, "已经下载");
                break;
        }
        Log.e("下载ok",""+flog);
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
                Log.e("更新数据库","zzzz");
                // 创建请求队列, 默认并发3个请求,传入你想要的数字可以改变默认并发数, 例如NoHttp.newRequestQueue(1);
                requestQueue = NoHttp.newRequestQueue();
                // 创建请求对象
                request = NoHttp.createStringRequest(mPath, RequestMethod.POST);
                // 添加请求参数
                request.add("methods", "updateDownloadNum");
                request.add("music_id", music_id);
                requestQueue.add(UPDATE_DOWNLOAD_NUM, request, onResponseListener);
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
            viewHolder.itemMusicDescribe= (TextView) convertView.findViewById(R.id.item_music_describe);
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

        downloadimageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isload = false;
//                ToastUtils.showToast(mContext, "下载对话框");
                //下载音乐
                download(mDownloadRequest1, mMusicList.get(position).getMusic_path_mp3(),
                        mMusicList.get(position).getMusic_type1(), mMusicList.get(position).getMusic_name() + ".mp3",mMusicList.get(position).getMusic_id());
/*//               下载歌词
                download(mDownloadRequest2, mMusicList.get(position).getMusic_path_lrc(),
                        mMusicList.get(position).getMusic_type1(), mMusicList.get(position).getMusic_name() + ".lrc");*/

               /* mDownloadRequests.add(mDownloadRequest1);
                mDownloadRequests.add(mDownloadRequest2);
                String[] urls={mMusicList.get(position).getMusic_path_mp3(),mMusicList.get(position).getMusic_path_lrc()};
                String[] filenames={mMusicList.get(position).getMusic_name()+".mp3",mMusicList.get(position).getMusic_name()+".lrc"};
                NohttpHelper.downloadList(urls,filepath+"/"+mMusicList.get(position).getMusic_type1(),filenames,true,true,mDownloadRequests,downloadListener);
               *//* if((mDownloadRequest1.checkBeforeStatus()==DownloadRequest.STATUS_FINISH)&&(mDownloadRequest2.checkBeforeStatus()==DownloadRequest.STATUS_FINISH)){
                    ToastUtils.showToast(mContext,"下载完成");
                }*/
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
        if(isload){
            viewHolder.itemMusicDownloadSum.setText("" + music.getMusic_download_sum_number()+1);
        }else{
            viewHolder.itemMusicDownloadSum.setText("" + music.getMusic_download_sum_number());
        }
        return convertView;
    }

    //单个文件下载
    private void download(DownloadRequest downloadRequest, String url, String type1, String filename,int music_id) {
        downloadRequest = NoHttp.createDownloadRequest(url, filepath + "/" + type1
                ,
                filename,
                true,
                false);
        if(!check(downloadRequest)){
            //此时说明还没有下载，去下载
            reques(downloadRequest,music_id);
        }else{
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
