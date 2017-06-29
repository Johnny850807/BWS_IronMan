package com.ood.waterball.teampathy.Dialogs;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputEditText;
import android.text.InputType;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import com.ood.waterball.teampathy.BaseActivity;
import com.ood.waterball.teampathy.Controllers.EntityControllers.EntityController;
import com.ood.waterball.teampathy.DomainModels.Domains.Project;
import com.ood.waterball.teampathy.Fragments.MemberHomePageFragment;
import com.ood.waterball.teampathy.Fragments.TabLayoutPageFragment;
import com.ood.waterball.teampathy.R;

public class CreateProjectDialog extends MyConfirmCancelDialog{
    private MemberHomePageFragment fragment;
    private TextInputEditText nameTxt;
    private TextInputEditText typeTxt;
    private TextInputEditText passwordTxt;
    private CheckBox passwordChb;

    public CreateProjectDialog(@NonNull MemberHomePageFragment fragment) {
        super(fragment.getContext());
        this.fragment = fragment;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        findViews();
        setPasswordCheckboxListener();
    }

    private void findViews() {
        nameTxt = (TextInputEditText) findViewById(R.id.projectTitleED_createProject_dialog);
        typeTxt = (TextInputEditText) findViewById(R.id.projectCategoryED_createProject_dialog);
        passwordTxt = (TextInputEditText) findViewById(R.id.projectPasswordED_createProject_dialog);
        passwordChb = (CheckBox) findViewById(R.id.setProjectPasswordCHK_createProject_dialog);
    }

    private void setPasswordCheckboxListener(){
        passwordChb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean status) {
                if (status)
                    passwordTxt.setInputType(InputType.TYPE_NULL);
                else
                    passwordTxt.setInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD);
            }
        });
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
                String name = nameTxt.getText().toString();
                String type = typeTxt.getText().toString();
                boolean hasPassword = passwordChb.isChecked();
                String password = hasPassword ? passwordTxt.getText().toString() : Project.NO_PASSWORD;
                String description = "";  // todo 專案敘述
                addProjectAndEnter(new Project(name,type,description,password));

            }
        };
    }

    private void addProjectAndEnter(final Project project) {
        fragment.CREATE(project, new EntityController.OnFinishListener() {
            @Override
            public void onFinish() {
                dismiss();
                ((BaseActivity)fragment.getContext()).changePage( TabLayoutPageFragment.getInstance(project.getId()) );
            }
        });
    }

    @Override
    protected int getCancelButtonId() {
        return R.id.cancelBTN_createProject_dialog;
    }

    @Override
    protected int getConfirmButtonId() {
        return R.id.confirmBTN_createProject_dialog;
    }
}
