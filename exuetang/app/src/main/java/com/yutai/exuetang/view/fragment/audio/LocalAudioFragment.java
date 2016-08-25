package com.yutai.exuetang.view.fragment.audio;

import android.content.Intent;
import android.content.IntentSender;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.yanzhenjie.recyclerview.swipe.Closeable;
import com.yanzhenjie.recyclerview.swipe.OnSwipeMenuItemClickListener;
import com.yanzhenjie.recyclerview.swipe.SwipeMenu;
import com.yanzhenjie.recyclerview.swipe.SwipeMenuCreator;
import com.yanzhenjie.recyclerview.swipe.SwipeMenuItem;
import com.yanzhenjie.recyclerview.swipe.SwipeMenuRecyclerView;
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
import com.yolanda.nohttp.rest.Response;
import com.yutai.exuetang.R;
import com.yutai.exuetang.db.MusciTableOperate;
import com.yutai.exuetang.model.beans.audio.music.Music;
import com.yutai.exuetang.utils.FileFindAllMusic;
import com.yutai.exuetang.utils.RequestManager;
import com.yutai.exuetang.utils.ToastUtils;
import com.yutai.exuetang.view.activity.audio.AudioPlayActivity;
import com.yutai.exuetang.view.adapter.audio.OnItemClickListener;
import com.yutai.exuetang.view.adapter.audio.PlayDialogAdapter;
import com.yutai.exuetang.view.application.MyApplication;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/8/16.
 */
public class LocalAudioFragment extends Fragment{
    public static final int WHAT = 1;
    private SwipeMenuRecyclerView localRecyclerView;
    private View mView;
    private PlayDialogAdapter mPlayDialogAdapter;
    private List<Music> mp3Infos;	//存放Mp3Info对象的集合
    //sqlite操作类
    private MusciTableOperate mMusciTableOperate = null;
    //存本地音乐的名称的list
    List<String> musicNameList;
    public String mPath = MyApplication.url + "/audioservlet";
    private OnResponseListener<String> onResponseListener = new OnResponseListener<String>() {
        @SuppressWarnings("unused")
        @Override
        public void onSucceed(int what, Response<String> response) {
            if (what == WHAT) {
                String result = response.get();
                if (result.equals("400")) {
                    ToastUtils.showToast(getActivity(), "服务器异常");
                } else if (result.equals("201")) {
                    ToastUtils.showToast(getActivity(), "本地没有音频文件");
                } else{
                    Log.e("result", result);
                    Gson gson = new Gson();
                    Type type = new TypeToken<List<Music>>() {
                    }.getType();
                    mp3Infos = gson.fromJson(result, type);
                    Log.e("localfragmentmp3",mp3Infos.toString());
                    showRecyclerView();
                }
            }
        }

        @Override
        public void onStart(int what) {

        }

        @Override
        public void onFailed(int what, String url, Object tag, Exception exception, int responseCode, long networkMillis) {
            /*if (exception instanceof ClientError) {// 客户端错误
                Toast.makeText(getActivity(), "客户端发生错误", Toast.LENGTH_SHORT).show();
            } else */if (exception instanceof ServerError) {// 服务器错误
                Toast.makeText(getActivity(), "服务器发生错误", Toast.LENGTH_SHORT).show();
            } else if (exception instanceof NetworkError) {// 网络不好
                Toast.makeText(getActivity(), "请检查网络", Toast.LENGTH_SHORT).show();
            } else if (exception instanceof TimeoutError) {// 请求超时
                Toast.makeText(getActivity(), "请求超时，网络不好或者服务器不稳定", Toast.LENGTH_SHORT).show();
            } else if (exception instanceof UnKnownHostError) {// 找不到服务器
                Toast.makeText(getActivity(), "未发现指定服务器", Toast.LENGTH_SHORT).show();
            } else if (exception instanceof URLError) {// URL是错的
                Toast.makeText(getActivity(), "URL错误", Toast.LENGTH_SHORT).show();
            } else if (exception instanceof NotFoundCacheError) {
                Toast.makeText(getActivity(), "没有发现缓存", Toast.LENGTH_SHORT).show();
                // 这个异常只会在仅仅查找缓存时没有找到缓存时返回
            } else {
                Toast.makeText(getActivity(), "未知错误", Toast.LENGTH_SHORT).show();
            }
        }
        @Override
        public void onFinish(int what) {

        }
    };
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_me_audio_local,null);
        localRecyclerView = (SwipeMenuRecyclerView) mView.findViewById(R.id.local_recycler_view);
        musicNameList = FileFindAllMusic.getAllMusicName();
        mp3Infos = new ArrayList<>();
        mMusciTableOperate = new MusciTableOperate(getActivity());
        getData();
//        mp3Infos = mMusciTableOperate.selectAllMusic();
        return mView;
    }
    public void getData(){
        Gson gson = new Gson();
        String musicNameListStr = gson.toJson(musicNameList);
        // 创建请求对象
        Request<String> request = NoHttp.createStringRequest(mPath, RequestMethod.POST);
        // 添加请求参数
        request.add("methods", "selectMusciByName");
        request.add("musicNameList", musicNameListStr);
        RequestManager.getInstance().add(WHAT, request, onResponseListener);
    }
    public void showRecyclerView(){
        //RecyclerView的设置
        localRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));// 布局管理器。
        localRecyclerView.setHasFixedSize(true);// 如果Item够简单，高度是确定的，打开FixSize将提高性能。
        localRecyclerView.setItemAnimator(new DefaultItemAnimator());// 设置Item默认动画，加也行，不加也行。
        //mPlayDialogRecyclerView.addItemDecoration(new ListViewDecoration());// 添加分割线。
        // 为SwipeRecyclerView的Item创建菜单就两句话，不错就是这么简单：
        // 设置菜单创建器。
        localRecyclerView.setSwipeMenuCreator(swipeMenuCreator);
        // 设置菜单Item点击监听。
        localRecyclerView.setSwipeMenuItemClickListener(menuItemClickListener);

        localRecyclerView.openLeftMenu(1);
        localRecyclerView.openRightMenu(0);
        mPlayDialogAdapter = new PlayDialogAdapter(mp3Infos,getActivity());
        mPlayDialogAdapter.setOnItemClickListener(onItemClickListener);
        localRecyclerView.setAdapter(mPlayDialogAdapter);
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
                        .setBackgroundDrawable(R.drawic_action_addable.selector_green)// 点击的背景。
                        .setImage(R.mipmap.) // 图标。
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
                SwipeMenuItem deleteItem = new SwipeMenuItem(getActivity())
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
            ToastUtils.showToast(getActivity(),"点击了删除第"+adapterPosition+"条");
            mMusciTableOperate.deleteMusicByMusicid(mp3Infos.get(adapterPosition).getMusic_id());
            mp3Infos.remove(adapterPosition);
            mPlayDialogAdapter.notifyDataSetChanged();
        }

    };
    private OnItemClickListener onItemClickListener = new OnItemClickListener() {
        @Override
        public void onItemClick(int position) {
            //ToastUtils.showToast(getActivity(),"这是第"+position+"tiao");
            mMusciTableOperate.deleteMusicByMusicid(mp3Infos.get(position).getMusic_id());
            mMusciTableOperate.insertData(mp3Infos.get(position));
            Intent intent = new Intent();
            intent.setClass(getActivity(), AudioPlayActivity.class);
            //绑定数据
            intent.putExtra("music", mp3Infos.get(position));//也可以绑定数组
            startActivity(intent);
        }
    };


}
