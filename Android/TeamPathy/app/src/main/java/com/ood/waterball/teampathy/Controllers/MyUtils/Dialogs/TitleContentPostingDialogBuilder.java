package com.ood.waterball.teampathy.Controllers.MyUtils.Dialogs;


import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextView;

public class TitleContentPostingDialogBuilder extends PostingDialogBuilder {

    protected int titleTextInputEditTextId;
    protected int contentTextInputEditTextId;
    protected int errorTextView;
    protected String titleHint;
    protected String contentHint;
    protected boolean errorDetect = true;
    protected DetectListener detectListener;

    public TitleContentPostingDialogBuilder(@NonNull Context context) {
        super(context);
    }

    public TitleContentPostingDialogBuilder setTitleHint(String titleHint) {
        this.titleHint = titleHint;
        return this;
    }

    public TitleContentPostingDialogBuilder setTitleTextInputEditTextId(int titleTextInputEditTextId) {
        this.titleTextInputEditTextId = titleTextInputEditTextId;
        return this;
    }

    public TitleContentPostingDialogBuilder setContentHint(String contentHint) {
        this.contentHint = contentHint;
        return this;
    }

    public TitleContentPostingDialogBuilder setDetectListener(DetectListener detectListener) {
        this.detectListener = detectListener;
        return this;
    }

    public TitleContentPostingDialogBuilder setContentTextInputEditTextId(int contentTextInputEditTextId) {
        this.contentTextInputEditTextId = contentTextInputEditTextId;
        return this;
    }

    public TitleContentPostingDialogBuilder setErrorDetect(boolean errorDetect) {
        this.errorDetect = errorDetect;
        return this;
    }

    @Override
    protected View.OnClickListener getConfirmBtnListener() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView title = (TextView) view.findViewById(titleTextInputEditTextId);
                TextView content = (TextView) view.findViewById(contentTextInputEditTextId);
                final TextView error = (TextView) view.findViewById(errorTextView);

                if (error.getVisibility() == View.VISIBLE)
                    error.setVisibility(View.GONE);

                if ( detectListener == null )
                    detectListener = new DetectListener() {
                        @Override
                        public boolean onTextEmptyReport(int errorViewId) {
                            if (errorViewId == titleTextInputEditTextId)
                            {
                                error.setText("Title should not be empty.");
                                error.setVisibility(View.VISIBLE);
                                return false;
                            }

                            else if (errorViewId == contentTextInputEditTextId)
                            {
                                error.setText("Content should not be empty.");
                                error.setVisibility(View.VISIBLE);
                                return false;
                            }

                            return true;
                        }

                        @Override
                        public boolean onElseDetect() {return true;}

                        @Override
                        public boolean onDetectLength(int viewId, int length) { return true; }

                        @Override
                        public void onDetectSuccessfully() {

                        }
                    };

                if ( detectListener.onTextEmptyReport(titleTextInputEditTextId) &&
                detectListener.onTextEmptyReport(contentTextInputEditTextId) &&
                detectListener.onDetectLength(titleTextInputEditTextId,title.getText().length()) &&
                detectListener.onDetectLength(contentTextInputEditTextId,content.getText().length()) &&
                detectListener.onElseDetect() )
                    detectListener.onDetectSuccessfully();
            }
        };
    }


    public interface DetectListener {
        public boolean onTextEmptyReport(int errorViewId); // if any of texts is empty , it will be pass as a parameter in the function
        public boolean onElseDetect();  // add additional stuffs here to detect else things and pass a boolean result to decide if an error occurs.
        public boolean onDetectLength(int viewId , int length); // to detect whether all views' lengths are correct and return a boolean result to decide if an error occurs.
        public void onDetectSuccessfully();
    }
}
