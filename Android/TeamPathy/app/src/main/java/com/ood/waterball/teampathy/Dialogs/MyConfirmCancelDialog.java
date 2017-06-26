package com.ood.waterball.teampathy.Dialogs;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;

import com.ood.waterball.teampathy.R;


public abstract class MyConfirmCancelDialog extends ConfirmCancelDialog {

    public MyConfirmCancelDialog(@NonNull Context context) {
        super(context);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupBasicResId();
    }

    protected void setupBasicResId(){
        iconId(R.drawable.logo);
        cancelDialogContent(R.string.make_sure_to_cancel);
        cancelStrId(R.string.cancel);
        confirmStrId(R.string.confirm);
    }
}
