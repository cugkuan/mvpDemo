package com.kuan.mvpdemo.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ListView;

import com.kuan.mvpdemo.R;
import com.kuan.mvpdemo.ui.focus.FocusManger;

public class Test2Activity extends Activity {


    private ListView mListView;

    private Test1Activity.Adapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test2ctivity);

        mListView = (ListView)findViewById(R.id.listView);
        mAdapter = new Test1Activity.Adapter(this);
        mListView.setAdapter(mAdapter);
    }

    static  class  Adapter extends BaseAdapter {


        private FocusManger manger;

        public Adapter(Activity activity){
            manger = new FocusManger(activity);
        }

        @Override
        public int getCount() {
            return 6;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {

            ViewHolder viewHolder =null;
            if ( view == null ){
                view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_layout_pageinfo2,null);
                viewHolder = new ViewHolder();
                view.setTag(viewHolder);
            }else {
                viewHolder = (ViewHolder)view.getTag();
            }
            viewHolder.checkBox = (CheckBox) view.findViewById(R.id.cb_depreciate);
            viewHolder.checkBox.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    CheckBox checkBox = (CheckBox)view;

                    if (!checkBox.isChecked()){
                        manger.removeFocus(1, new FocusManger.OnFocusListener() {
                            @Override
                            public void succeed(int goodsId) {

                            }

                            @Override
                            public void failure(int goodsId) {

                            }
                        });
                    }else {
                        manger.addFoucs(1, new FocusManger.OnFocusListener() {
                            @Override
                            public void succeed(int goodsId) {

                            }

                            @Override
                            public void failure(int goodsId) {

                            }
                        });
                    }

                }
            });


            return view;
        }

        class ViewHolder{

            CheckBox checkBox;
        }
    }
}
