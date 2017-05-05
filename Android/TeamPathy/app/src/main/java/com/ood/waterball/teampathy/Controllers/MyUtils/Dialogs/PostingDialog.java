package com.ood.waterball.teampathy.Controllers.MyUtils.Dialogs;

import android.content.Context;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Button;


public class PostingDialog extends AlertDialog.Builder {
    private Context context;
    private int confirmBTNid;
    private int cancelBTNid;
    private int confirmStrid;
    private int cancelStrid;
    private View view;
    private AlertDialog dialog;
    private int cancelDialogContentStringId;
    private int iconId;
    private View.OnClickListener confirmBtnListener;
    private View.OnClickListener cancelBtnListener;

    public PostingDialog(@NonNull Context context) {
        super(context);
        this.context = context;
    }

    public AlertDialog.Builder setConfirmButtonId(int confirmBTNid) {
        this.confirmBTNid = confirmBTNid;
        return this;
    }

    public AlertDialog.Builder setCancelButtonId(int cancelBTNid) {
        this.cancelBTNid = cancelBTNid;
        return this;
    }

    public AlertDialog.Builder setCancelDialogContentStringId(int cancelDialogContentStringId) {
        this.cancelDialogContentStringId = cancelDialogContentStringId;
        return this;
    }

    public AlertDialog.Builder setConfirmStringId(int confirmStrid) {
        this.confirmStrid = confirmStrid;
        return this;
    }

    public AlertDialog.Builder setCancelStringId(int cancelStrid) {
        this.cancelStrid = cancelStrid;
        return this;
    }

    public AlertDialog.Builder setIcon(int iconId) {
        this.iconId = iconId;
        return super.setIcon(iconId);
    }

    @Override
    public AlertDialog.Builder setView(View view) {
        this.view = view;
        return super.setView(view);
    }

    @Override
    public AlertDialog create() {
        dialog = super.create();
        setButtonsListener();
        return dialog;
    }

    protected void setButtonsListener(){
        Button confirmButton = (Button) view.findViewById(confirmBTNid);
        Button cancelButton = (Button) view.findViewById(cancelBTNid);
        if (confirmBtnListener == null)
            confirmButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    dialog.dismiss();
                }
            });
        if ( cancelBtnListener == null )
            cancelButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(context);
                    if ( iconId != 0 )
                        builder.setIcon(iconId);
                    if ( cancelDialogContentStringId != 0 )
                        builder.setTitle(cancelDialogContentStringId);
                    if ( confirmStrid != 0 )
                        builder.setPositiveButton(context.getString(confirmStrid), new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialog.dismiss();
                            }
                        });
                    if ( cancelStrid != 0 )
                        builder.setNegativeButton(context.getString(cancelStrid), new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {}
                        }).show();
                }
            });
    }

    protected void setConfirmButtonListener(View.OnClickListener listener){
        this.confirmBtnListener = listener;
    }

    protected void setCancelButtonListener(View.OnClickListener listener){
        this.cancelBtnListener = listener;
    }


}
