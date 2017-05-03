package com.ood.waterball.teampathy.Fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.ood.waterball.teampathy.Controllers.Global;
import com.ood.waterball.teampathy.Domains.Project;
import com.ood.waterball.teampathy.R;

import java.util.List;

import static com.ood.waterball.teampathy.Controllers.MyLog.Log;

public class MemberHomePageFragment extends Fragment {
    private List<Project> projectList;

    private GridView projectGridView;
    private ProjectGridAdapter projectGridAdapter;
    private FloatingActionButton fab;

    public MemberHomePageFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        try {
            fetchProjectList();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void fetchProjectList() throws Exception {
        String userId = Global.getMemberController().getActiveMember().getId();
        projectList = Global.getTeamPathyFacade().getAllProjectsByUserId(userId);
        Log(String.valueOf(projectList.size()));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_member_home_page, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        projectGridView = (GridView) view.findViewById(R.id.projectGridMemberHomePage);
        fab = (FloatingActionButton) view.findViewById(R.id.fab);

        initProjectGridView();
        setListeners();
    }


    private void setListeners(){
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }


    private void initProjectGridView(){
        projectGridAdapter = new ProjectGridAdapter(getContext());
        projectGridView.setAdapter(projectGridAdapter);
    }



    public class ProjectGridAdapter extends ArrayAdapter<Project> {

        public ProjectGridAdapter(Context context) {
            super( context , R.layout.project_item , projectList);
        }

        @NonNull
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder viewHolder;
            if ( convertView == null )
            {
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.project_item,parent,false);
                viewHolder = new ViewHolder();
                viewHolder.image = (ImageView) convertView.findViewById(R.id.img_projectItem);
                viewHolder.text = (TextView) convertView.findViewById(R.id.name_projectItem);
                convertView.setTag(viewHolder);
                convertView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        //todo 進入專案
                    }
                });
            }
            else
                viewHolder = (ViewHolder) convertView.getTag();

            Project project = getItem(position);

            //todo Glide 載入 網路圖片問題
            Glide.with(getContext())
                    .load(R.drawable.testimg)
                    .into(viewHolder.image);


            viewHolder.text.setText(project.getName());

            return convertView;
        }

        class ViewHolder{
            ImageView image;
            TextView text;
        }

    }

}
