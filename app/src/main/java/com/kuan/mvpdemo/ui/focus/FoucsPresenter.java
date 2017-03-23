package com.kuan.mvpdemo.ui.focus;

import android.os.Handler;
import android.support.annotation.NonNull;

/**
 * Created by Kuan on 2017/3/18.
 */

public class FoucsPresenter implements FocusContract.Presenter {


    private FocusContract.View mView;


    private Handler mHandler = new Handler();

    public FoucsPresenter( FocusContract.View view) {

        mView = view;
    }

    @Override
    public void addFocus(final int goodsId, @NonNull final  FocusChangeResultListener listener) {

        //模拟业务过程
        mView.showProgressDialog("正在添加关注");
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                listener.result(true);
                mView.hideProgressDialog();
                mView.showToast("添加成功");
            }
        },5000);


    }

    @Override
    public void removeFocus(final int goodsId,@NonNull final FocusChangeResultListener listener) {

        mView.showProgressDialog("正在移除关注");
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                listener.result(true);
                mView.hideProgressDialog();
                mView.showToast("移除成功");
            }
        },5000);
    }
}
