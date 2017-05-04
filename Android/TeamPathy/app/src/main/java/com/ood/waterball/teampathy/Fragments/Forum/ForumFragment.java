package com.ood.waterball.teampathy.Fragments.Forum;


import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;

import com.ood.waterball.teampathy.Controllers.Global;
import com.ood.waterball.teampathy.Domains.Issue;
import com.ood.waterball.teampathy.Domains.Member;
import com.ood.waterball.teampathy.Fragments.ActivityBaseFragment;
import com.ood.waterball.teampathy.R;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static com.ood.waterball.teampathy.Controllers.MyLog.Log;

public class ForumFragment extends ActivityBaseFragment {
    private String projectId;
    private List<Issue> issueList;
    private FloatingActionButton fab;

    private RecyclerView issueRecyclerView;
    private LinearLayoutManager layoutManager;
    private MyRecyclerAdapter recyclerAdapter;
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
    protected void onFetchData(@Nullable Bundle savedInstanceState, @Nullable Bundle arguBundle) {
        try {
            projectId = (String) arguBundle.get("projectId");
            issueList = Global.getTeamPathyFacade().getIssueListByProjectId(projectId);
            Log("文章數量:" + issueList.size());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_forum_page;
    }

    @Override
    protected void onFindViews(View parentView) {
        issueRecyclerView = (RecyclerView) parentView.findViewById(R.id.issues_recyclerview_forum);
        fab = (FloatingActionButton) parentView.findViewById(R.id.fab_forum);
    }

    @Override
    protected void onControlViews() {
        initiateRecyclerView();
        setListeners();
    }

    private void initiateRecyclerView(){
        recyclerAdapter = new MyRecyclerAdapter();
        issueRecyclerView.setAdapter(recyclerAdapter);
        layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        issueRecyclerView.setLayoutManager(layoutManager);
    }

    private void setListeners(){
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                final View dialogView = LayoutInflater.from(getContext()).inflate(R.layout.create_issue_dialog,null);
                setDialogSpinnerListener(dialogView);

                AlertDialog alertDialog = new AlertDialog.Builder(getContext())
                        .setIcon(R.drawable.logo)
                        .setView(dialogView)
                        .setTitle(R.string.CreateIssue)
                        .show();

                setDialogButtonListener(dialogView,alertDialog);
            }
        });
    }


    private void setDialogSpinnerListener(View dialogView){

        try {
            Spinner typeSpinner = (Spinner) dialogView.findViewById(R.id.typeSpinner_issue_dialog);
            final String[] typeList = Global.getTeamPathyFacade().getIssueTypeListByProjectId(projectId);
            ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(getContext(),android.R.layout.simple_list_item_1,typeList);
            typeSpinner.setAdapter(stringArrayAdapter);
            typeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                    issueType = typeList[position];
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {}
            });
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void setDialogButtonListener(final View dialogView, final AlertDialog alertDialog){
        final ScrollView scrollView = (ScrollView) dialogView.findViewById(R.id.scrollView_issue_dialog);
        Button confirmBTN = ((Button)dialogView.findViewById(R.id.confirmBTN_issue_dialog));
        Button cancleBTN = (Button) dialogView.findViewById(R.id.cancelBTN_issue_dialog);

        confirmBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if ( createIssueAndCheckAvailable(dialogView) )
                    {
                        alertDialog.dismiss();
                        Snackbar.make(fab, R.string.issue_created_completed, Snackbar.LENGTH_LONG)
                                .setAction("Action", null).show();
                    }
                    else
                        scrollView.fullScroll(ScrollView.FOCUS_UP);  //偵測到錯誤之後，將對話窗回到頂端，才能看到錯誤訊息

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        cancleBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new AlertDialog.Builder(getContext())
                        .setIcon(R.drawable.logo)
                        .setTitle(R.string.make_sure_to_cancel)
                        .setPositiveButton(getString(R.string.confirm), new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                alertDialog.dismiss();
                            }
                        })
                        .setNegativeButton(getString(R.string.cancel), new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {}
                        }).show();
            }
        });
    }


    private boolean createIssueAndCheckAvailable(View dialogView) throws Exception {
        TextInputLayout titleEd = (TextInputLayout)dialogView.findViewById(R.id.issueTitleED_issue_dialog);
        TextView errorTxt = (TextView) dialogView.findViewById(R.id.errorTxt_issue_dialog);
        String title = titleEd.getEditText().getText().toString();
        String content = ((EditText)dialogView.findViewById(R.id.issueContentED_issue_dialog)).getText().toString();
        Member poster = Global.getMemberController().getActiveMember();
        if (title.isEmpty())
        {
            errorTxt.setText(getString(R.string.title_cannot_be_empty));
            errorTxt.setVisibility(View.VISIBLE);
            return false;
        }
        else if ( issueType.equals(getString(R.string.get_all_issue_types)) )
        {
            errorTxt.setText(getString(R.string.please_choose_an_issue_type));
            errorTxt.setVisibility(View.VISIBLE);
            return false;
        }
        else if ( content.isEmpty() )
        {
            errorTxt.setText(getString(R.string.issue_content_cannot_be_empty));
            errorTxt.setVisibility(View.VISIBLE);
            return false;
        }

        Global.getTeamPathyFacade().addIssue(new Issue(poster,title,content,issueType));
        recyclerAdapter.notifyDataSetChanged();
        layoutManager.scrollToPosition(0);

        return true;
    }


    class MyRecyclerAdapter extends RecyclerView.Adapter<MyRecyclerAdapter.MyViewHolder>{

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.issue_item, parent, false);
            return  new MyViewHolder(v);
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            holder.titleTxt.setText(issueList.get(position).getTitle());
            holder.typeTxt.setText(issueList.get(position).getType());
            holder.dateTxt.setText(convertDateToString(issueList.get(position).getDatetime()));
            holder.authorTxt.setText(issueList.get(position).getPoster().getName());
        }

        private String convertDateToString(Date datetime){
            String[] monthNames = getResources().getStringArray(R.array.month_names);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(datetime);
            String date = String.valueOf(calendar.get(Calendar.DATE));
            String month = monthNames[(calendar.get(Calendar.MONTH))];
            String year = String.valueOf(calendar.get(Calendar.YEAR));
            return year + " " + date + " " + month;
        }

        @Override
        public int getItemCount() {
            return issueList.size();
        }

        class MyViewHolder extends  RecyclerView.ViewHolder{
            TextView titleTxt;
            TextView typeTxt;
            TextView dateTxt;
            TextView authorTxt;

            public MyViewHolder(View itemView) {
                super(itemView);
                titleTxt = (TextView) itemView.findViewById(R.id.title_text_issue_item);
                typeTxt = (TextView) itemView.findViewById(R.id.type_text_issue_item);
                dateTxt = (TextView) itemView.findViewById(R.id.datetime_text_issue_item);
                authorTxt = (TextView) itemView.findViewById(R.id.author_text_issue_item);
            }
        }
    }

}
