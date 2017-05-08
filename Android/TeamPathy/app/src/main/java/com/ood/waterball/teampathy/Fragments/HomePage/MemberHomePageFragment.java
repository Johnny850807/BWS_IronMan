package com.ood.waterball.teampathy.Fragments.HomePage;


import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;

import com.ood.waterball.teampathy.Controllers.EntityControllers.EntityController;
import com.ood.waterball.teampathy.Controllers.Global;
import com.ood.waterball.teampathy.Domains.Project;
import com.ood.waterball.teampathy.Fragments.AsyncQueryRecyclerFragment;
import com.ood.waterball.teampathy.Fragments.ViewAbstractFactory.ProjectGridRecyclerViewFactory;
import com.ood.waterball.teampathy.Fragments.ViewAbstractFactory.RecyclerViewAbstractFactory;
import com.ood.waterball.teampathy.R;

public class MemberHomePageFragment extends AsyncQueryRecyclerFragment<Project> {
    private FloatingActionButton fab;

    public MemberHomePageFragment() {
        // Required empty public constructor
    }


    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_member_home_page;
    }

    @Override
    protected RecyclerViewAbstractFactory<Project> createRecyclerFactory(View parentView) {
        String userId = Global.getMemberController().getActiveMember().getId();
        return new ProjectGridRecyclerViewFactory(parentView,userId);
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
    protected EntityController createEntityController() {
        return Global.getProjectController();
    }

}
