package com.ood.waterball.teampathy.Dialogs;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import com.ood.waterball.teampathy.Fragments.MemberHomePageFragment;
import com.ood.waterball.teampathy.R;

public class CreateProjectDialog extends ConfirmCancelDialog{
    private MemberHomePageFragment fragment;
    private TextView nameTxt;
    private TextView typeTxt;
    private TextView passwordTxt;
    private CheckBox passwordChb;

    public CreateProjectDialog(@NonNull MemberHomePageFragment fragment) {
        super(fragment.getContext());
        this.fragment = fragment;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        findViews();
    }

    private void findViews() {
        //nameTxt = findViewById(R.id.projectDialog_chk_password)
    }

    @Override
    protected int getContentViewId() {
        return R.layout.create_project_dialog;
    }

    @NonNull
    @Override
    public View.OnClickListener getConfirmListener() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        };
    }

    @Override
    protected int getCancelButtonId() {
        return R.id.cancelBTN_project_dialog;
    }

    @Override
    protected int getConfirmButtonId() {
        return R.id.confirmBTN_project_dialog;
    }
}
