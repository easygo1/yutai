package com.yutai.exuetang.view.fragment.audio;

import android.content.Intent;
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

import com.yanzhenjie.recyclerview.swipe.Closeable;
import com.yanzhenjie.recyclerview.swipe.OnSwipeMenuItemClickListener;
import com.yanzhenjie.recyclerview.swipe.SwipeMenu;
import com.yanzhenjie.recyclerview.swipe.SwipeMenuCreator;
import com.yanzhenjie.recyclerview.swipe.SwipeMenuItem;
import com.yanzhenjie.recyclerview.swipe.SwipeMenuRecyclerView;
import com.yutai.exuetang.R;
import com.yutai.exuetang.db.MusciTableOperate;
import com.yutai.exuetang.model.beans.audio.music.Music;
import com.yutai.exuetang.utils.AppConstant;
import com.yutai.exuetang.utils.ToastUtils;
import com.yutai.exuetang.view.activity.audio.AudioPlayActivity;
import com.yutai.exuetang.view.adapter.audio.OnItemClickListener;
import com.yutai.exuetang.view.adapter.audio.PlayDialogAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/8/16.
 */
public class RecentlyAudioFragment extends Fragment{
    private SwipeMenuRecyclerView recentlyRecyclerView;
    private View mView;
    private PlayDialogAdapter mPlayDialogAdapter;
    private List<Music> mp3Infos;	//存放Mp3Info对象的集合
    //sqlite操作类
    private MusciTableOperate mMusciTableOperate = null;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_me_audio_recently,null);
        recentlyRecyclerView = (SwipeMenuRecyclerView) mView.findViewById(R.id.recently_recycler_view);
        mp3Infos = new ArrayList<>();
        mMusciTableOperate = new MusciTableOperate(getActivity());
        mp3Infos = mMusciTableOperate.selectAllMusic();
        Log.e("fragmentmp3",mp3Infos.toString());
        showRecyclerView();
        return mView;
    }
    public void showRecyclerView(){
        //RecyclerView的设置
        recentlyRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));// 布局管理器。
        recentlyRecyclerView.setHasFixedSize(true);// 如果Item够简单，高度是确定的，打开FixSize将提高性能。
        recentlyRecyclerView.setItemAnimator(new DefaultItemAnimator());// 设置Item默认动画，加也行，不加也行。
        //mPlayDialogRecyclerView.addItemDecoration(new ListViewDecoration());// 添加分割线。
        // 为SwipeRecyclerView的Item创建菜单就两句话，不错就是这么简单：
        // 设置菜单创建器。
        recentlyRecyclerView.setSwipeMenuCreator(swipeMenuCreator);
        // 设置菜单Item点击监听。
        recentlyRecyclerView.setSwipeMenuItemClickListener(menuItemClickListener);

        recentlyRecyclerView.openLeftMenu(1);
        recentlyRecyclerView.openRightMenu(0);
        mPlayDialogAdapter = new PlayDialogAdapter(mp3Infos,getActivity());
        mPlayDialogAdapter.setOnItemClickListener(onItemClickListener);
        recentlyRecyclerView.setAdapter(mPlayDialogAdapter);
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
