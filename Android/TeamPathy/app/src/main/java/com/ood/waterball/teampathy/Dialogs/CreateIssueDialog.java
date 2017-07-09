package com.ood.waterball.teampathy.Dialogs;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.ood.waterball.teampathy.Controllers.EntityControllers.EntityController;
import com.ood.waterball.teampathy.Controllers.Global;
import com.ood.waterball.teampathy.Controllers.MyUtils.AsyncTaskController;
import com.ood.waterball.teampathy.DomainModels.Domains.Issue;
import com.ood.waterball.teampathy.DomainModels.Domains.IssueType;
import com.ood.waterball.teampathy.DomainModels.Domains.Member;
import com.ood.waterball.teampathy.Fragments.ForumFragment;
import com.ood.waterball.teampathy.Fragments.IssueDetailsFragment;
import com.ood.waterball.teampathy.R;

import java.util.List;


public class CreateIssueDialog extends MyConfirmCancelDialog {
    ForumFragment fragment;
    TextInputEditText titleTxt;
    TextInputEditText contentTxt;
    TextView errorTxt;
    Spinner typeOfIssueSpinner;

    public CreateIssueDialog(@NonNull ForumFragment fragment) {
        super(fragment.getContext());
        this.fragment = fragment;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        findViews();
    }

    @Override
    protected int getContentViewId() {
        return R.layout.create_issue_dialog;
    }

    private void findViews() {
        titleTxt = (TextInputEditText) findViewById(R.id.issueTitleED_issue_dialog);
        contentTxt = (TextInputEditText) findViewById(R.id.issueContentED_issue_dialog);
        errorTxt = (TextView) findViewById(R.id.errorTxt_issue_dialog);
        typeOfIssueSpinner = (Spinner) findViewById(R.id.typeSpinner_issue_dialog);
        setupSpinnerAync();
    }

    private void setupSpinnerAync() {
        final ProgressDialog progressDialog = new ProgressDialog(getContext());
        progressDialog.show();

        AsyncTask<Void,Void,List<IssueType>> asyncTask = new AsyncTask<Void, Void, List<IssueType>>() {
            @Override
            protected List<IssueType> doInBackground(Void... voids) {
                try {
                    return Global.getIssuetypeController().readList(fragment.getProjectId());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return null;
            }
            @Override
            protected void onPostExecute(final List<IssueType> issueTypeList) {
                final String[] types = issueTypesToStringArray(issueTypeList);

                ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(getContext(),
                        android.R.layout.simple_list_item_1,types);
                typeOfIssueSpinner.setAdapter(stringArrayAdapter);
                progressDialog.dismiss();
            }

            private String[] issueTypesToStringArray(final List<IssueType> issueTypeList){
                final String[] types = new String[issueTypeList.size()];
                for ( int i = 0 ; i < types.length ; i ++ )
                    types[i] = issueTypeList.get(i).getName();
                return types;
            }
        };

        AsyncTaskController.runAsyncTask(fragment,asyncTask);
    }

    @NonNull
    @Override
    public View.OnClickListener getConfirmListener() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if (checkAvailable())
                    {
                        String title = titleTxt.getText().toString();
                        String content = contentTxt.getText().toString();
                        String issueType = typeOfIssueSpinner.getSelectedItem().toString();
                        Member poster = Global.getMemberController().getActiveMember();
                        addIssueAndNotify(new Issue(poster,title,content,new IssueType(issueType)));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
    }

    private boolean checkAvailable(){
        boolean hasError;
        if ( hasError = titleTxt.getText().toString().isEmpty() )
            titleTxt.setError(getContext().getString(R.string.title_cannot_be_empty));
        if ( hasError |= contentTxt.getText().toString().isEmpty() )
            contentTxt.setError(getContext().getString(R.string.issue_content_cannot_be_empty));
        if ( hasError |= typeOfIssueSpinner.getSelectedItemPosition() == 0 )
        {
            errorTxt.setText(getContext().getString(R.string.please_choose_an_issue_type));
            errorTxt.setVisibility(View.VISIBLE);
        }
        else
            errorTxt.setVisibility(View.GONE);
        return !hasError;
    }

    private void addIssueAndNotify(final Issue issue) throws Exception {
        fragment.CREATE(issue, new EntityController.OnFinishListener() {
            @Override
            public void onFinish() {
                dismiss();
                useSnackBarToNotify(issue);
            }
        });
    }

    private void useSnackBarToNotify(final Issue issue){
        fragment.getLayoutManager().scrollToPosition(0);  //scroll to top

        Snackbar.make(fragment.getView(), R.string.issue_created_completed, Snackbar.LENGTH_LONG)
                .setAction(R.string.enter, new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        fragment.getParentActivity().changePage(IssueDetailsFragment.getInstance(issue));
                    }
                }).show();
    }


    @Override
    protected int getCancelButtonId() {
        return R.id.cancelBTN_issue_dialog;
    }

    @Override
    protected int getConfirmButtonId() {
        return R.id.confirmBTN_issue_dialog;
    }

    @Override
    public void show() {
        setTitle(R.string.CreateIssue);
        super.show();
    }
}
