package com.ood.waterball.teampathy.Controllers.MyUtils.Dialogs;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;

public class TitleContentPostingDialogBuilder extends PostingDialogBuilder {

    protected int titleTextInputEditTextId;
    protected int contentTextInputEditTextId;
    protected int scrollviewId;
    protected int errorTextViewId;
    protected onFinishListener onFinishListener;
    protected OnDetectListener onDetectListener;

    public TitleContentPostingDialogBuilder(@NonNull Context context) {
        super(context);
    }


    public TitleContentPostingDialogBuilder setTitleTextInputEditTextId(int titleTextInputEditTextId) {
        this.titleTextInputEditTextId = titleTextInputEditTextId;
        return this;
    }


    public TitleContentPostingDialogBuilder setOnDetectListener(OnDetectListener onDetectListener) {
        this.onDetectListener = onDetectListener;
        return this;
    }

    public TitleContentPostingDialogBuilder setScrollviewId(int scrollviewId) {
        this.scrollviewId = scrollviewId;
        return this;
    }

    public TitleContentPostingDialogBuilder setOnFinishListener(TitleContentPostingDialogBuilder.onFinishListener onFinishListener) {
        this.onFinishListener = onFinishListener;
        return this;
    }

    public TitleContentPostingDialogBuilder setContentTextInputEditTextId(int contentTextInputEditTextId) {
        this.contentTextInputEditTextId = contentTextInputEditTextId;
        return this;
    }

    public TitleContentPostingDialogBuilder setErrorTextViewId(int errorTextViewId) {
        this.errorTextViewId = errorTextViewId;
        return this;
    }

    @Override
    protected View.OnClickListener getConfirmBtnListener(final AlertDialog currentDialog) {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView title = (TextView) view.findViewById(titleTextInputEditTextId);
                TextView content = (TextView) view.findViewById(contentTextInputEditTextId);
                ScrollView scrollView = (ScrollView) view.findViewById(scrollviewId);

                final TextView error = (TextView) view.findViewById(errorTextViewId);

                if (error.getVisibility() == View.VISIBLE)
                    error.setVisibility(View.GONE);

                if ( onDetectListener == null )
                    onDetectListener = new OnDetectListener() {
                        @Override
                        public boolean onTextEmptyReport(int errorViewId,TextView errorText) {return true;}
                        @Override
                        public boolean onElseDetect(TextView errorText) {return true;}
                        @Override
                        public boolean onDetectLength(int viewId, int length,TextView errorText) { return true; }
                    };
                boolean titleAvailable = true;
                boolean contentAvailable = true;

                if ( title != null )
                {
                    if ( title.getText().toString().isEmpty() )
                        titleAvailable = onDetectListener.onTextEmptyReport(titleTextInputEditTextId,error)
                                && onDetectListener.onDetectLength(titleTextInputEditTextId,title.getText().length(),error);
                }


                if ( content != null )
                {
                    if ( content.getText().toString().isEmpty() )
                        contentAvailable = onDetectListener.onTextEmptyReport(contentTextInputEditTextId,error)
                                && onDetectListener.onDetectLength(contentTextInputEditTextId,content.getText().length(),error);
                }


                if (  titleAvailable && contentAvailable && onDetectListener.onElseDetect(error)  )
                {
                    onFinishListener.onFinish(title == null ? null : title.getText().toString(),
                            content == null ? null : content.getText().toString());
                    currentDialog.dismiss();
                }
                else if (scrollView != null)
                {
                    error.setVisibility(View.VISIBLE);
                    scrollView.fullScroll(ScrollView.FOCUS_UP);
                }


            }
        };
    }


    public interface OnDetectListener {
        public boolean onTextEmptyReport(int errorViewId,TextView errorText); // if any of texts is empty , it will be pass as a parameter in the function
        public boolean onElseDetect(TextView errorText);  // add additional stuffs here to detect else things and pass a boolean result to decide if an error occurs.
        public boolean onDetectLength(int viewId , int length ,TextView errorText); // to detect whether all views' lengths are correct and return a boolean result to decide if an error occurs.
    }

    public interface onFinishListener{
        public void onFinish(String title,String content);
    }
}
