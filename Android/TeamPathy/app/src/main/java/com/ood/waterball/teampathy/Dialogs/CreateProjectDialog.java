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
    private TextInputEditText descriptionTxt;
    private TextInputEditText passwordTxt;
    private CheckBox passwordChb;
    private String password = "";

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
        descriptionTxt = (TextInputEditText) findViewById(R.id.describeProjectED_createProject_dialog);
        nameTxt = (TextInputEditText) findViewById(R.id.projectTitleED_createProject_dialog);
        typeTxt = (TextInputEditText) findViewById(R.id.projectCategoryED_createProject_dialog);
        passwordTxt = (TextInputEditText) findViewById(R.id.projectPasswordED_createProject_dialog);
        passwordChb = (CheckBox) findViewById(R.id.setProjectPasswordCHK_createProject_dialog);
    }

    private void setPasswordCheckboxListener(){
        //todo password showing or not editagble problem
        passwordChb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean status) {
                if (status)
                {
                    passwordTxt.setInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD);
                    passwordTxt.setText(password);
                }
                else
                {
                    password = passwordTxt.getText().toString();
                    passwordTxt.setText("");
                    passwordTxt.setInputType(InputType.TYPE_NULL);
                }
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
                String description = descriptionTxt.getText().toString();
                if (isAvailable(name,type,description))
                    addProjectAndEnter(new Project(name,type,description,password));
            }
        };
    }

    private boolean isAvailable(String name, String type, String description) {
        boolean error;
        if ( error = name.isEmpty() )
            nameTxt.setError(getContext().getString(R.string.please_input_project_title));
        if ( error |= type.isEmpty() )
            typeTxt.setError(getContext().getString(R.string.please_input_project_type));
        if ( error |= description.isEmpty() )
            descriptionTxt.setError(getContext().getString(R.string.please_input_project_description));
        return !error;
    }

    private void addProjectAndEnter(final Project project) {
        fragment.getProgressDialog().show();
        fragment.CREATE(project, false, new EntityController.OnFinishListener() {
            @Override
            public void onFinish() {
                dismiss();
                fragment.getProgressDialog().dismiss();
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
