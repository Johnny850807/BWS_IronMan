package com.ood.waterball.teampathy.Fragments;


import android.content.DialogInterface;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.ArrayAdapter;

import com.ood.waterball.teampathy.Controllers.EntityControllers.EntityController;
import com.ood.waterball.teampathy.Controllers.Global;
import com.ood.waterball.teampathy.Dialogs.CreateProjectDialog;
import com.ood.waterball.teampathy.Dialogs.SearchProjectDialog;
import com.ood.waterball.teampathy.DomainModels.Domains.Project;
import com.ood.waterball.teampathy.Fragments.Architecture.AsyncQueryRecyclerFragment;
import com.ood.waterball.teampathy.Fragments.ViewAbstractFactory.MemberHomePageRecyclerViewFactory;
import com.ood.waterball.teampathy.Fragments.ViewAbstractFactory.RecyclerViewAbstractFactory;
import com.ood.waterball.teampathy.R;

import java.util.List;

public class MemberHomePageFragment extends AsyncQueryRecyclerFragment<Project> {
    private final int CREATE_PROJECT_ACTION = 0;
    private final int ATTEND_PROJECT_ACTION = 1;
    private String[] projectActions;

    private FloatingActionButton fab;
    public MemberHomePageFragment() {}
    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_member_home_page;
    }

    @Override
    protected List<Project> createEntityList() {
        try {
            int userId = Global.getMemberController().getActiveUser().getId();
            return Global.getProjectController().readList(userId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    @Override
    protected RecyclerViewAbstractFactory<Project> createRecyclerFactory(View parentView, List<Project> entityList) {
        return new MemberHomePageRecyclerViewFactory(parentView,entityList);
    }
    @Override
    protected void onFindUseCaseViews(View parentView) {
        projectActions = new String[]{getString(R.string.create_a_new_project), getString(R.string.participate_to_exists_project)};
        fab = (FloatingActionButton) parentView.findViewById(R.id.fab);
    }
    @Override
    protected void onControlViews() {
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialogForCreatingProject();
            }
        });
    }

    private void showDialogForCreatingProject(){
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(),android.R.layout.simple_list_item_1, projectActions);
        new AlertDialog.Builder(getContext())
                .setAdapter(adapter, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int position) {
                        switch (position){
                            case CREATE_PROJECT_ACTION:
                                createNewProject();
                                break;
                            case ATTEND_PROJECT_ACTION:
                                attendToExistsProject();
                        }
                    }
                })
                .show();
    }

    private void createNewProject(){
        new CreateProjectDialog(this)
                .show();
    }

    private void attendToExistsProject(){
        new SearchProjectDialog(this).show();
    }

    @Override
    protected EntityController<Project> createEntityController() {
        return Global.getProjectController();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        //回收時把主Activity也回收，不然會留下空區塊
        getParentActivity().finish();
    }
}
