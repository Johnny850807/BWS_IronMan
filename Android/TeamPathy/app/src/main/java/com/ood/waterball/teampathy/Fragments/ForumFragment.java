package com.ood.waterball.teampathy.Fragments;


import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.ood.waterball.teampathy.Controllers.EntityControllers.EntityController;
import com.ood.waterball.teampathy.Controllers.Global;
import com.ood.waterball.teampathy.Controllers.MyUtils.AsyncTaskController;
import com.ood.waterball.teampathy.Controllers.MyUtils.Dialogs.TitleContentPostingDialogBuilder;
import com.ood.waterball.teampathy.DomainModels.Issue;
import com.ood.waterball.teampathy.DomainModels.Member;
import com.ood.waterball.teampathy.Fragments.Architecture.AsyncQueryRecyclerFragment;
import com.ood.waterball.teampathy.Fragments.ViewAbstractFactory.IssuesRecyclerViewFactory;
import com.ood.waterball.teampathy.Fragments.ViewAbstractFactory.RecyclerViewAbstractFactory;
import com.ood.waterball.teampathy.R;

import java.util.List;

public class ForumFragment extends AsyncQueryRecyclerFragment<Issue> {
    private String projectId;
    private FloatingActionButton fab;

    private String issueType; //點選新增文章時會出現分類Spinner，將其選擇的選項字串儲存至issueType中

    public static ForumFragment getInstance(String projectId){
        ForumFragment fragment = new ForumFragment();
        Bundle args = new Bundle();
        args.putString("projectId",projectId);
        fragment.setArguments(args);
        return fragment;
    }


    public ForumFragment() {
        // Required empty public constructor
    }


    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_forum_page;
    }


    @Override
    protected void onFindUseCaseViews(View parentView) {
        fab = (FloatingActionButton) parentView.findViewById(R.id.fab_forum);
    }

    @Override
    protected List<Issue> createEntityList() {
        try {
            projectId = (String) getArguments().get("projectId");
            return Global.getIssueController().readList(projectId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected RecyclerViewAbstractFactory<Issue> createRecyclerFactory(View parentView, List<Issue> entityList) {
        return new IssuesRecyclerViewFactory(parentView,entityList);
    }

    @Override
    protected void onControlViews() {
        setListeners();
    }

    private void setListeners(){
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                final View dialogView = LayoutInflater.from(getContext()).inflate(R.layout.create_issue_dialog,null);
                setDialogSpinnerListener(dialogView);

                TitleContentPostingDialogBuilder builder = new TitleContentPostingDialogBuilder(getContext());
                builder.setContentTextInputEditTextId(R.id.issueContentED_issue_dialog)
                        .setTitleTextInputEditTextId(R.id.issueTitleED_issue_dialog)
                        .setErrorTextViewId(R.id.errorTxt_issue_dialog)
                        .setOnFinishListener(new TitleContentPostingDialogBuilder.onFinishListener() {
                            @Override
                            public void onFinish(String title, String content) {
                                try {
                                    Member poster = Global.getMemberController().getActiveMember();
                                    addIssueAndNotify(new Issue(poster,title,content,issueType));
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                        )
                        .setOnDetectListener(new TitleContentPostingDialogBuilder.OnDetectListener() {
                            @Override
                            public boolean onTextEmptyReport(int errorViewId,TextView errorText) {
                                if (errorViewId == R.id.issueTitleED_issue_dialog)
                                {
                                    errorText.setText(getString(R.string.title_cannot_be_empty));
                                    return false;
                                }
                                if (errorViewId == R.id.issueContentED_issue_dialog)
                                {
                                    errorText.setText(getString(R.string.issue_content_cannot_be_empty));
                                    return false;
                                }
                                return true;
                            }

                            @Override
                            public boolean onElseDetect(TextView errorText) {
                                if ( issueType.equals(getString(R.string.get_all_issue_types)) )
                                {
                                    errorText.setText(getString(R.string.please_choose_an_issue_type));
                                    errorText.setVisibility(View.VISIBLE);
                                    return false;
                                }
                                return true;
                            }

                            @Override
                            public boolean onDetectLength(int viewId, int length,TextView errorText) {
                                if ( viewId == R.id.issueTitleED_issue_dialog && length > 12 )
                                {
                                    errorText.setText(R.string.title_cannt_be_exceeding_12_words);
                                    return false;
                                }
                                return true;
                            }
                        })
                        .setScrollviewId(R.id.scrollView_issue_dialog)
                        .setCancelDialogContentString(getString(R.string.make_sure_to_cancel))
                        .setConfirmString(getString(R.string.confirm))
                        .setCancelString(getString(R.string.cancel))
                        .setConfirmButtonId(R.id.confirmBTN_issue_dialog)
                        .setCancelButtonId(R.id.cancelBTN_issue_dialog)
                        .setIcon(R.drawable.logo)
                        .setView(dialogView)
                        .setTitle(getString(R.string.CreateIssue))
                        .show();
            }
        });
    }


    private void setDialogSpinnerListener(final View dialogView){

        AsyncTask<Void,Void,String[]> asyncTask = new AsyncTask<Void, Void, String[]>() {
            @Override
            protected String[] doInBackground(Void... voids) {
                try {
                    return Global.getIssueController().readIssueTypeList(projectId);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return null;
            }
            @Override
            protected void onPostExecute(final String[] issueTypeList) {
                Spinner typeSpinner = (Spinner) dialogView.findViewById(R.id.typeSpinner_issue_dialog);
                ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(getContext(),android.R.layout.simple_list_item_1,issueTypeList);
                typeSpinner.setAdapter(stringArrayAdapter);
                typeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                        issueType = issueTypeList[position];
                    }
                    @Override
                    public void onNothingSelected(AdapterView<?> adapterView) {}
                });
            }
        };

        AsyncTaskController.runAsyncTask(asyncTask);
    }


    private void addIssueAndNotify(final Issue issue) throws Exception {
        CREATE(issue, new EntityController.OnFinishListener() {
            @Override
            public void onFinish() {
                useSnackBarToNotify(issue);
            }
        });
    }

    private void useSnackBarToNotify(final Issue issue){
        layoutManager.scrollToPosition(0);
        Snackbar.make(fab, R.string.issue_created_completed, Snackbar.LENGTH_LONG)
                .setAction(R.string.enter, new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        getParentActivity().changePage(IssueDetailsFragment.getInstance(issue));
                    }
                }).show();
    }

    @Override
    protected EntityController<Issue> createEntityController() {
        return Global.getIssueController();
    }

}
