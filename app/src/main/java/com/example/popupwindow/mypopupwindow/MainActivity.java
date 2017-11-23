package com.example.popupwindow.mypopupwindow;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private View rootView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        rootView = LayoutInflater.from(this).inflate(R.layout.activity_main,null);
        setContentView(rootView);
    }

    /**
     * 示例1
     * @param view
     */
    public void click(View view){
        ComfirPopupwindow comfirPopupwindow = new ComfirPopupwindow(this, new ComfirPopupwindow.ICallListener() {
            @Override
            public void callBack() {
                Toast.makeText(getApplicationContext(),"点击确认",Toast.LENGTH_SHORT).show();
            }
        });
        comfirPopupwindow.showAtLocation(rootView, Gravity.CENTER,0,0);
        comfirPopupwindow.setTitle("是否开始下载？");
        comfirPopupwindow.setIcon(R.mipmap.ic);
    }

    /**
     * 示例2
     * @param view
     */
    public void clicktwo(View view){
        ComfirPopupwindow comfirPopupwindow = new ComfirPopupwindow(this, new ComfirPopupwindow.ICallListener() {
            @Override
            public void callBack() {
                Toast.makeText(getApplicationContext(), "点击确认", Toast.LENGTH_SHORT).show();
            }
        }, new ComfirPopupwindow.ICallListener() {
            @Override
            public void callBack() {
                Toast.makeText(getApplicationContext(), "点击取消", Toast.LENGTH_SHORT).show();
            }
        });
        comfirPopupwindow.showAtLocation(rootView, Gravity.CENTER,0,0);
        comfirPopupwindow.setTitle("是否取消该操作");
        comfirPopupwindow.setIcon(R.mipmap.icon_avatar);
    }
}
