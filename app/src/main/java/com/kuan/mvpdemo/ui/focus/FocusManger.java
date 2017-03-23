package com.kuan.mvpdemo.ui.focus;

import android.app.Activity;

/**
 * Created by Kuan on 2017/3/19.
 */

public class FocusManger {


    private FocusContract.View mView;

    private FocusContract.Presenter mPresenter;


    public interface OnFocusListener {

        void succeed(int goodsId);

        void failure(int goodsId);
    }


    public FocusManger(Activity activity) {

        mView = new FocusView(activity);

        mPresenter = new FoucsPresenter(mView);

    }


    public void addFoucs(final int goodsId, final OnFocusListener listener) {

        mView.showProgressDialog("添加通知");
        mPresenter.addFocus(goodsId, new FocusContract.Presenter.FocusChangeResultListener() {
            @Override
            public void result(boolean result) {
                mView.hideProgressDialog();
                if (result) {
                    mView.showToast("添加成功");
                    listener.succeed(goodsId);
                } else {
                    mView.showToast("添加失败");
                    listener.failure(goodsId);
                }
            }
        });
    }

    public void removeFocus(final int goodsId, final OnFocusListener listener) {
        mView.showProgressDialog("移除关注");
        mPresenter.removeFocus(goodsId, new FocusContract.Presenter.FocusChangeResultListener() {
            @Override
            public void result(boolean result) {
                mView.hideProgressDialog();
                if (result) {
                    mView.showToast("移除成功");
                    listener.succeed(goodsId);
                } else {
                    mView.showToast("移除失败");
                    listener.failure(goodsId);
                }
            }
        });
    }


}
