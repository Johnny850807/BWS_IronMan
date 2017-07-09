package com.ood.waterball.teampathy.Fragments.ViewAbstractFactory;

import android.content.DialogInterface;
import android.os.AsyncTask;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.ood.waterball.teampathy.Controllers.Global;
import com.ood.waterball.teampathy.Controllers.MyUtils.AsyncTaskController;
import com.ood.waterball.teampathy.Controllers.MyUtils.GlideHelper;
import com.ood.waterball.teampathy.Dialogs.SearchProjectDialog;
import com.ood.waterball.teampathy.DomainModels.Domains.Project;
import com.ood.waterball.teampathy.Fragments.MemberHomePageFragment;
import com.ood.waterball.teampathy.Fragments.TabLayoutPageFragment;
import com.ood.waterball.teampathy.R;

import java.util.List;

import static com.ood.waterball.teampathy.Controllers.MyLog.Log;


public class SearchProjectRecyclerViewFactory extends RecyclerViewAbstractFactory<Project> {
    private static List<Project> userOwnsProject;
    private MemberHomePageFragment fragment;
    private SearchProjectDialog dialog;
    public SearchProjectRecyclerViewFactory(View rootView, List<Project> projects, MemberHomePageFragment fragment , SearchProjectDialog dialog) {
        super(rootView, projects);
        this.fragment = fragment;
        this.dialog = dialog;
        try {
            userOwnsProject = Global.getProjectController().readList(Global.getMemberController().getActiveMember().getId());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected RecyclerView createRecyclerView() {
        return (RecyclerView) rootView.findViewById(R.id.project_recycler_list_searchProjectDialog);
    }

    @Override
    protected RecyclerView.Adapter createRecyclerAdapter(List<Project> projects) {
        return new MyAdapter();
    }

    @Override
    protected RecyclerView.LayoutManager createLayoutManager() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(context);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        return layoutManager;
    }

    private class MyAdapter extends RecyclerView.Adapter<MyViewHolder>{
        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.search_project_item,parent,false));
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            final Project project = entityList.get(position);
            GlideHelper.loadToCircularImage(context,holder.iconImg,project.getImageUrl());
            holder.titleTxt.setText(project.getName());
            holder.descriptionTxt.setText(project.getDescription());
            handleJoinButtonEvent(holder.joinBtn,project);
        }

        @Override
        public int getItemCount() {
            return entityList.size();
        }

        private void handleJoinButtonEvent(Button joinBtn, final Project project) {
            Log(userOwnsProject.toString());
            if (userOwnsProject.contains(project))
            {
                joinBtn.setText(context.getString(R.string.already_in_project));
                joinBtn.setEnabled(false);
            }
            else
            {
                joinBtn.setText(context.getString(R.string.join));
                joinBtn.setEnabled(true);
                joinBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (project.hasPassword())
                            checkPasswordAndJoin(project);
                        else
                            joinProjectAndEnter(project);
                    }
                });
            }
        }

        private void checkPasswordAndJoin(final Project project){
            // setting the layout of input password edittext
            RelativeLayout layout = new RelativeLayout(context);
            final EditText passwordEd = new EditText(context);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams
                    (ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            layoutParams.setMargins(30,30,30,30);
            passwordEd.setLayoutParams(layoutParams);
            layout.addView(passwordEd);

            new AlertDialog.Builder(context)
                    .setTitle(R.string.Inputpassword)
                    .setView(layout)
                    .setPositiveButton(R.string.confirm, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            if (passwordEd.getText().toString().equals(project.getPassword()))
                                joinProjectAndEnter(project);
                            else
                                Toast.makeText(context,context.getString(R.string.password_not_conform),Toast.LENGTH_LONG).show();
                        }
                    }).setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {}
            }).show();
        }

        private void joinProjectAndEnter(final Project project){

            AsyncTask<Void,Void,Void> asyncTask = new AsyncTask<Void, Void, Void>() {
                @Override
                protected Void doInBackground(Void... voids) {
                    try {
                        Global.getProjectController().create(project);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    return null;
                }

                @Override
                protected void onPostExecute(Void aVoid) {
                    super.onPostExecute(aVoid);
                    fragment.getParentActivity().changePage(TabLayoutPageFragment.getInstance(project.getId()));
                    dialog.dismiss();
                }
            };
            AsyncTaskController.runAsyncTask(fragment,asyncTask);
        }
    }



    class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView iconImg;
        TextView titleTxt;
        TextView descriptionTxt;
        Button joinBtn;
        MyViewHolder(View itemView) {
            super(itemView);
            iconImg = (ImageView) itemView.findViewById(R.id.project_icon_searchProject_item);
            titleTxt = (TextView) itemView.findViewById(R.id.project_title_searchProject_item);
            descriptionTxt = (TextView) itemView.findViewById(R.id.project_description_searchProject_item);
            joinBtn = (Button) itemView.findViewById(R.id.joinBTN_searchProject_item);
        }
    }
}
