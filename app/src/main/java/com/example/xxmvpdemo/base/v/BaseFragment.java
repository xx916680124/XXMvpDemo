package com.example.xxmvpdemo.base.v;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.annotation.IdRes;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.appcompat.widget.ContentFrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.xxmvpdemo.R;
import com.trello.rxlifecycle4.components.support.RxFragment;


/**
 * author : xx
 * time : 2020/8/8 11:40
 * describe :
 **/
public abstract class BaseFragment extends RxFragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(getLayoutId(), container, false);
        String viewclassname = view.getClass().getName();
        if (viewclassname.equals(RelativeLayout.class.getName())
        ||viewclassname.equals(ConstraintLayout.class.getName())
        ||viewclassname.equals(FrameLayout.class.getName())
        ||viewclassname.equals(ContentFrameLayout.class.getName())
        ){
            return view;
        }else {
            FrameLayout frameLayout = new FrameLayout(getContext());
            frameLayout.addView(view);
            return frameLayout;
        }
    }

    protected abstract int getLayoutId();

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
    }
    protected abstract void initView();
    public <T extends View> T findViewById(@IdRes int id) {
        return getView().findViewById(id);
    }
    protected void showToast(String content){
        Toast.makeText(getContext(), content, Toast.LENGTH_SHORT).show();
    }
    protected void showToast(@StringRes int id){
        Toast.makeText(getContext(), id, Toast.LENGTH_SHORT).show();
    }

    public int  getEnterAnimation(){
        return R.anim.common_page_right_in;
    }

    public int  getExitAnimation(){
        return R.anim.common_page_left_out;
    }
    public int  getPopEnterAnimation(){
        return R.anim.common_page_left_in;
    }
    public int  getPopExitAnimation(){
        return R.anim.common_page_right_out;
    }
    public boolean isNeedAddToBackStack(){
        return true;
    }

    public Action getActionFroPreFragment(){
        return Action.HIDE;
    }

    /**
     * 对上一个fragment 如何进行处理
     */
    public enum Action{
        NONE,HIDE,DETACH,REMOVE
    }
}
