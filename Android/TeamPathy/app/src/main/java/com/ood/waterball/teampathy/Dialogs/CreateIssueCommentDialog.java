package com.ood.waterball.teampathy.Dialogs;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.view.View;
import android.widget.ScrollView;

import com.ood.waterball.teampathy.Controllers.EntityControllers.EntityController;
import com.ood.waterball.teampathy.Controllers.Global;
import com.ood.waterball.teampathy.DomainModels.Domains.IssueComment;
import com.ood.waterball.teampathy.DomainModels.Domains.Member;
import com.ood.waterball.teampathy.Fragments.IssueDetailsFragment;
import com.ood.waterball.teampathy.R;

import java.util.Date;

public class CreateIssueCommentDialog  extends MyConfirmCancelDialog{
    private IssueDetailsFragment fragment;
    private TextInputEditText contentTxt;

    public CreateIssueCommentDialog(@NonNull IssueDetailsFragment fragment) {
        super(fragment.getContext());
        this.fragment = fragment;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        findViews();
    }

    private void findViews() {
        contentTxt = (TextInputEditText) findViewById(R.id.commentContentED_issue_comment_dialog);
    }

    @Override
    protected int getContentViewId() {
        return R.layout.create_issue_comment_dialog;
    }

    @NonNull
    @Override
    public View.OnClickListener getConfirmListener() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkAvailable())
                {
                    try {
                        String content = contentTxt.getText().toString();
                        Member poster = Global.getMemberController().getActiveMember();
                        addNewIssueCommentAndRefresh(new IssueComment(poster,content,new Date()));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        };
    }

    private boolean checkAvailable(){
        if (contentTxt.getText().toString().isEmpty())
        {
            contentTxt.setError(getContext().getString(R.string.issue_content_cannot_be_empty));
            return false;
        }
        return true;
    }

    private void addNewIssueCommentAndRefresh(final IssueComment issueComment) throws Exception {
        fragment.CREATE(issueComment, new EntityController.OnFinishListener() {
            @Override
            public void onFinish() {
                dismiss();
                snackbarNotify(issueComment);
            }
        });
    }

    private void snackbarNotify(IssueComment issueComment){
        /**通知並且設定點擊觀看則scroll到新留言所在position**/
        Snackbar.make(fragment.getScrollView(),R.string.comment_created_completed,Snackbar.LENGTH_SHORT).setAction(getContext().getString(R.string.watch), new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragment.getScrollView().fullScroll(ScrollView.FOCUS_DOWN);
            }
        }).show();
    }


    @Override
    protected int getCancelButtonId() {
        return R.id.cancelBTN_issue_comment_dialog;
    }

    @Override
    protected int getConfirmButtonId() {
        return R.id.confirmBTN_issue_comment_dialog;
    }
}
