package com.kuan.mvpdemo.ui.focus;

import android.app.Activity;
import android.widget.Toast;

/**
 * Created by Kuan on 2017/3/19.
 */

public class FocusView implements FocusContract.View {



    private CustomProgressDialog mProgressDiaog;

    private Toast mToast;

    private Activity mActivity;

    public FocusView(Activity activity){

        mProgressDiaog = new CustomProgressDialog(activity);
        mActivity = activity;
    }

    public void showToast(String message){
        if (mToast != null){
            mToast.cancel();
        }
        mToast = Toast.makeText(mActivity,message,
                Toast.LENGTH_SHORT);
        mToast.show();
    }

    public void showToast(int resId){
        if (mToast != null ){
            mToast.cancel();
        }
        mToast = Toast.makeText(mActivity,resId,
                Toast.LENGTH_SHORT);
        mToast.show();
    }

    @Override
    public void showProgressDialog(String message) {
        if (!mProgressDiaog.isShowing()) {
            mProgressDiaog.show(message);
        }
    }

    @Override
    public void showProgressDialog() {
        mProgressDiaog.show();
    }

    @Override
    public void hideProgressDialog() {
        mProgressDiaog.dismiss();
    }
}
