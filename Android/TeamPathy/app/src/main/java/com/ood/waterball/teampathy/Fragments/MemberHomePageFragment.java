package com.ood.waterball.teampathy.Fragments;


import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;

import com.ood.waterball.teampathy.Controllers.EntityControllers.EntityController;
import com.ood.waterball.teampathy.Controllers.Global;
import com.ood.waterball.teampathy.DomainModels.Project;
import com.ood.waterball.teampathy.Fragments.Architecture.AsyncQueryRecyclerFragment;
import com.ood.waterball.teampathy.Fragments.ViewAbstractFactory.MemberHomePageRecyclerViewFactory;
import com.ood.waterball.teampathy.Fragments.ViewAbstractFactory.RecyclerViewAbstractFactory;
import com.ood.waterball.teampathy.R;

import java.util.List;

public class MemberHomePageFragment extends AsyncQueryRecyclerFragment<Project> {
    private FloatingActionButton fab;
    public MemberHomePageFragment() {}
    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_member_home_page;
    }

    @Override
    protected List<Project> createEntityList() {
        try {
            String userId = Global.getMemberController().getActiveMember().getId();
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
        fab = (FloatingActionButton) parentView.findViewById(R.id.fab);
    }
    @Override
    protected void onControlViews() {
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
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
