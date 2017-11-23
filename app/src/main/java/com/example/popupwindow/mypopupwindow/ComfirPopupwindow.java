package com.example.popupwindow.mypopupwindow;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;

/**
 * 确认通用Popupwindow
 */

public class ComfirPopupwindow extends PopupWindow{
    private TextView tvTitle,tvSure,tvCancel;
    private ImageView ivIcon;

    public ComfirPopupwindow(Context context, ICallListener confirmListener){
        init(context);
        setListener(confirmListener);
    }

    public ComfirPopupwindow(Context context, ICallListener confirmListener, ICallListener cancelListener){
        init(context);
        setListener(confirmListener,cancelListener);
    }

    public void init(Context context){
        View view = LayoutInflater.from(context).inflate(R.layout.dialog_upload_file,null);
        setFocusable(true);
        setOutsideTouchable(true);
        setBackgroundDrawable(new BitmapDrawable());
        setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        setContentView(view);
        
        tvTitle = (TextView) view.findViewById(R.id.tv_dialog_title);
        ivIcon = (ImageView) view.findViewById(R.id.tv_content);
        tvSure = (TextView) view.findViewById(R.id.tv_sureadd);
        tvCancel = (TextView) view.findViewById(R.id.tv_canceladd);
    }

    /**
     * 仅带确认回调
     * @param listener
     */
    private void setListener(final ICallListener listener){
        tvSure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
                listener.callBack();
            }
        });
        tvCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
    }

    /**
     * 同时带有确认和取消回调
     * @param listener
     * @param listener2
     */
    private void setListener(final ICallListener listener,final ICallListener listener2){
        tvSure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
                listener.callBack();
            }
        });
        tvCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
                listener2.callBack();
            }
        });
    }

    public void setTitle(String title){
        tvTitle.setText(title);
    }

    public void setIcon(int resId){
        ivIcon.setImageResource(resId);
    }

    public interface ICallListener {
        void callBack();
    }

}
