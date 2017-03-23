package com.kuan.mvpdemo.ui.focus;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import com.kuan.mvpdemo.R;

/**
 * Created by Kuan on 2017/3/18.
 */

public class CustomProgressDialog extends AlertDialog {


    private TextView mMessageView;

    public CustomProgressDialog(Context context) {
        this(context,R.style.CustomDialog);
    }

    public CustomProgressDialog(Context context, int theme) {
        super(context, R.style.CustomDialog);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        init(getContext());
    }

    private void init(Context context) {
        //设置不可取消，点击其他区域不能取消，实际中可以抽出去封装供外包设置
        setCanceledOnTouchOutside(false);
        setContentView(R.layout.dialog_progress);
        mMessageView = (TextView)findViewById(R.id.tv_load_dialog);
        mMessageView.setVisibility(View.GONE);
        WindowManager.LayoutParams params = getWindow().getAttributes();
        params.width = WindowManager.LayoutParams.WRAP_CONTENT;
        params.height = WindowManager.LayoutParams.WRAP_CONTENT;
        getWindow().setAttributes(params);
    }

    public void show(String message){
        show();
        mMessageView.setVisibility(View.VISIBLE);
        mMessageView.setText(message);
    }


}
