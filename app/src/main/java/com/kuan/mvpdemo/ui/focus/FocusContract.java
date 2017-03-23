package com.kuan.mvpdemo.ui.focus;

/**
 * Created by Kuan on 2017/3/18.
 */

public interface FocusContract {


    interface  View  {


        void showProgressDialog(String message);

        void showProgressDialog();

        void hideProgressDialog();

        void showToast(String message);

        void showToast(int resId);


    }


    interface Presenter  {


        interface  FocusChangeResultListener{
            void result(boolean result);
        }


        void addFocus(int goodsId, FocusChangeResultListener listener);

        void removeFocus(int goodsId, FocusChangeResultListener listener);
    }
}
