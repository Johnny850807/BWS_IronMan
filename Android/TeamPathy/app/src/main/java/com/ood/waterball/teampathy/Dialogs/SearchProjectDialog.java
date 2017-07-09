package com.ood.waterball.teampathy.Dialogs;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputEditText;
import android.view.View;
import android.widget.ImageButton;

import com.ood.waterball.teampathy.Controllers.Global;
import com.ood.waterball.teampathy.Controllers.MyUtils.AsyncTaskController;
import com.ood.waterball.teampathy.DomainModels.Domains.Project;
import com.ood.waterball.teampathy.Fragments.MemberHomePageFragment;
import com.ood.waterball.teampathy.Fragments.ViewAbstractFactory.SearchProjectRecyclerViewFactory;
import com.ood.waterball.teampathy.R;

import java.util.ArrayList;
import java.util.List;

public class SearchProjectDialog extends Dialog {
    private MemberHomePageFragment fragment;
    private List<Project> resultProjectList = new ArrayList<>();
    private TextInputEditText keywordTxt;
    private ImageButton searchBtn;
    private SearchProjectRecyclerViewFactory recyclerFactory;

    public SearchProjectDialog(@NonNull MemberHomePageFragment fragment) {
        super(fragment.getContext());
        this.fragment = fragment;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_project_dialog);
        findViews();
        initRecyclerView();
    }

    private void findViews() {
        searchBtn = (ImageButton) findViewById(R.id.searchBTN_searchProject_dialog);
        keywordTxt = (TextInputEditText) findViewById(R.id.projectTitleED_searchProject_dialog);
        searchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    search(keywordTxt.getText().toString());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private void initRecyclerView() {
        View rootview = findViewById(R.id.rootView_searchDialog);
        recyclerFactory = new SearchProjectRecyclerViewFactory(rootview, resultProjectList , fragment,this);
    }

    private void search(final String keyword) throws Exception {
        final ProgressDialog dialog = new ProgressDialog(getContext());
        dialog.setMessage(getContext().getString(R.string.searching_project));

        dialog.show();
        AsyncTaskController.runAsyncTask(fragment,new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
                try {
                    resultProjectList = Global.getProjectSearcher().searchProject(keyword);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                recyclerFactory.setEntityList(resultProjectList);
                dialog.dismiss();
            }
        });


    }
}
