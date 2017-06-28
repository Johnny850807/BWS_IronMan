package com.ood.waterball.teampathy.Dialogs;


import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.annotation.DrawableRes;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Button;

import com.ood.waterball.teampathy.R;

public abstract class ConfirmCancelDialog extends Dialog{
    private Button cancelBtn;
    private Button confirmBtn;
    private @Nullable String cancelDialogContent;
    private @DrawableRes int iconId;
    private @Nullable String confirmStr;
    private @Nullable String cancelStr;
    private View.OnClickListener confirmListener;

    public ConfirmCancelDialog(@NonNull Context context) {
        super(context);
        setContentView(getContentViewId());
        setupButtons();
        this.confirmListener = getConfirmListener();
    }

    @LayoutRes
    protected abstract int getContentViewId();

    @NonNull
    public abstract View.OnClickListener getConfirmListener();

    private void setupButtons(){
        cancelBtn = (Button) findViewById(getCancelButtonId());
        confirmBtn = (Button) findViewById(getConfirmButtonId());
    }

    @IdRes
    protected abstract int getCancelButtonId();
    @IdRes
    protected abstract int getConfirmButtonId();

    public ConfirmCancelDialog iconId(@DrawableRes int iconId) {
        this.iconId = iconId;
        return this;
    }

    public ConfirmCancelDialog cancelDialogContent(@StringRes int cancelDialogContentId) {
        this.cancelDialogContent = getContext().getResources().getString(cancelDialogContentId);
        return this;
    }

    public ConfirmCancelDialog cancelStrId(@StringRes int cancelStrId) {
        this.cancelStr = getContext().getResources().getString(cancelStrId);
        return this;
    }

    public ConfirmCancelDialog confirmStrId(@StringRes int confirmStrId) {
        this.confirmStr = getContext().getResources().getString(confirmStrId);
        return this;
    }

    @Override
    public void show() throws IllegalStateException{
        if (confirmListener == null )
            throw new IllegalStateException("ConfirmListener (View.OnclickListener) should be set.");
        confirmBtn.setOnClickListener(confirmListener);
        setCancelBtnListener();
        super.show();
    }


    private void setCancelBtnListener(){
        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                if ( iconId != 0 )
                    builder.setIcon(iconId);
                if ( cancelDialogContent != null )
                    builder.setTitle(cancelDialogContent);
                else
                    builder.setTitle("Are you sure to close?");
                String confirm = confirmStr == null ? "Finish" : confirmStr;
                String cancel = cancelStr == null ? "Cancel" : cancelStr;

                builder.setPositiveButton( confirm, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        ConfirmCancelDialog.this.dismiss();
                    }
                });

                builder.setNegativeButton( cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {}
                }).show();
            }
        });
    }


}
