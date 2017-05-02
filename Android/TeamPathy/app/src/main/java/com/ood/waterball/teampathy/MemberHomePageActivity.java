package com.ood.waterball.teampathy;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
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

import java.util.List;

import static com.ood.waterball.teampathy.MyLog.Log;

public class MemberHomePageActivity extends AppCompatActivity {
    private List<Project> projectList;

    private GridView projectGridView;
    private ProjectGridAdapter projectGridAdapter;
    private FloatingActionButton fab;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member_home_page);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        try {
            findViews();
            setListeners();
            initProjectList();
            initProjectGridView();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void findViews(){
        projectGridView = (GridView) findViewById(R.id.projectGridMemberHomePage);
        fab = (FloatingActionButton) findViewById(R.id.fab);
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

    private void initProjectList() throws Exception {
        String userId = Global.getMemberController().getActiveMember().getId();
        projectList = Global.getTeamPathyFacade().getAllProjectsByUserId(userId);
        Log(String.valueOf(projectList.size()));
    }

    private void initProjectGridView(){
        projectGridAdapter = new ProjectGridAdapter();
        projectGridView.setAdapter(projectGridAdapter);
    }

    public class ProjectGridAdapter extends ArrayAdapter<Project>{

        public ProjectGridAdapter() {
            super(MemberHomePageActivity.this, R.layout.project_item , projectList);
        }

        @NonNull
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder viewHolder;
            if ( convertView == null )
            {
                convertView = LayoutInflater.from(MemberHomePageActivity.this).inflate(R.layout.project_item,parent,false);
                viewHolder = new ViewHolder();
                viewHolder.image = (ImageView) convertView.findViewById(R.id.img_projectItem);
                viewHolder.text = (TextView) convertView.findViewById(R.id.name_projectItem);
                convertView.setTag(viewHolder);
            }
            else
                viewHolder = (ViewHolder) convertView.getTag();

            Project project = getItem(position);


            Glide.with(MemberHomePageActivity.this)
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
