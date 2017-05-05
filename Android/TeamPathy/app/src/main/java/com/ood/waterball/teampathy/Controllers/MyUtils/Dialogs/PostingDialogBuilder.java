package com.ood.waterball.teampathy.Controllers.MyUtils.Dialogs;

import android.content.Context;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Button;


public class PostingDialogBuilder extends AlertDialog.Builder {
    protected Context context;
    protected int confirmBTNid;
    protected int cancelBTNid;
    protected String confirmStr;
    protected String cancelStr;
    protected String cancelDialogContentString;
    protected View view;
    protected AlertDialog dialog;
    protected int iconId;
    protected View.OnClickListener confirmBtnListener;
    protected View.OnClickListener cancelBtnListener;

    public PostingDialogBuilder(@NonNull Context context) {
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

    public AlertDialog.Builder setCancelDialogContentStringId(String cancelDialogContentString) {
        this.cancelDialogContentString = cancelDialogContentString;
        return this;
    }

    public AlertDialog.Builder setConfirmStringId(String confirmStr) {
        this.confirmStr = confirmStr;
        return this;
    }

    public AlertDialog.Builder setCancelStringId(String cancelStr) {
        this.cancelStr = cancelStr;
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

    protected void setConfirmButtonListener(View.OnClickListener listener){
        this.confirmBtnListener = listener;
    }

    protected void setCancelButtonListener(View.OnClickListener listener){
        this.cancelBtnListener = listener;
    }

    private void setButtonsListener(){
        Button confirmButton = (Button) view.findViewById(confirmBTNid);
        Button cancelButton = (Button) view.findViewById(cancelBTNid);

        if (confirmBtnListener == null)  // it won't always be null , because users can set listener before creating.
            confirmBtnListener = getConfirmBtnListener(); // if it hasn't been set , get it from subclass method.
        if ( cancelBtnListener == null) // it won't always be null , because users can set listener before creating.
            cancelBtnListener = getCancelBtnListener();  // if it hasn't been set , use default.

        if ( confirmBtnListener == null)  // it there is no subclass overriding getConfirmBtnListener() method , use default
            confirmButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    dialog.dismiss();
                }
            });
        else
            confirmButton.setOnClickListener(confirmBtnListener);

        if ( cancelBtnListener == null )
            cancelButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    dialog.dismiss();
                }
            });
        else
            cancelButton.setOnClickListener(cancelBtnListener);
    }

    protected View.OnClickListener getConfirmBtnListener(){
        return null;
    }

    protected View.OnClickListener getCancelBtnListener(){
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                if ( iconId != 0 )
                    builder.setIcon(iconId);
                if ( !cancelDialogContentString.isEmpty() )
                    builder.setTitle(cancelDialogContentString);
                if ( !confirmStr.isEmpty() )
                    builder.setPositiveButton( confirmStr, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialog.dismiss();
                        }
                    });
                if ( !cancelStr.isEmpty()  )
                    builder.setNegativeButton( cancelStr, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {}
                    }).show();
            }
        };
    }



}
