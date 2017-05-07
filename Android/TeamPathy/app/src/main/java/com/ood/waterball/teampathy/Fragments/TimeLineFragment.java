package com.ood.waterball.teampathy.Fragments;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.ood.waterball.teampathy.Controllers.Global;
import com.ood.waterball.teampathy.Controllers.MyUtils.GlideHelper;
import com.ood.waterball.teampathy.Domains.Member;
import com.ood.waterball.teampathy.Domains.Timeline;
import com.ood.waterball.teampathy.R;

import java.util.Date;
import java.util.List;
import java.util.Random;

import static com.ood.waterball.teampathy.Controllers.MyLog.Log;


public class TimeLineFragment extends EntityAsyncCRUDFragment {
    private List<Timeline> timelineList;
    private String projectId;

    private CardView inputCardView;
    private ImageView inputPostHeaderImg;
    private EditText inputContentED;
    private TextView posternameTXT;

    private RecyclerView timelineRecyclerView;
    private LinearLayoutManager layoutManager;
    private TimeLineFragment.MyRecyclerAdapter recyclerAdapter;
    private String issueType; //點選新增文章時會出現分類Spinner，將其選擇的選項字串儲存至issueType中

    public static TimeLineFragment getInstance(String projectId){
        TimeLineFragment fragment = new TimeLineFragment();
        Bundle args = new Bundle();
        args.putString("projectId",projectId);
        fragment.setArguments(args);
        return fragment;
    }


    public TimeLineFragment() {
        // Required empty public constructor
    }
    @Override
    protected void onFetchData(@Nullable Bundle savedInstanceState, @Nullable Bundle arguBundle) {
        try {
            projectId = (String) arguBundle.get("projectId");
            timelineList = Global.getTeamPathyFacade().getTimelineListByProjectId(projectId);
            Log("動態數量:" + timelineList.size());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_timeline_page;
    }

    @Override
    protected void onFindViews(View parentView) {
        timelineRecyclerView = (RecyclerView) parentView.findViewById(R.id.timeline_recyclerview_timeline);
        inputCardView = (CardView) parentView.findViewById(R.id.workline_input_cardview_timeline);
        inputPostHeaderImg = (ImageView) parentView.findViewById(R.id.workline_input_poster_header_timeline);
        inputContentED = (EditText) parentView.findViewById(R.id.workline_input_content_ed_timeline);
        posternameTXT = (TextView) parentView.findViewById(R.id.poster_name_timeline);
    }


    @Override
    protected void onControlViews() {
        Member currentUser = Global.getMemberController().getActiveMember();
        posternameTXT.setText(currentUser.getName());
        GlideHelper.loadToCircularImage(getContext(),inputPostHeaderImg,
                currentUser.getImageUrl());
        initiateRecyclerView();
        setListeners();
    }

    private void setListeners(){
        //todo 改善輸入區 點選card就能夠觸發到edit focus
        /**讓輸入欄位能夠按下Enter送出**/
        inputContentED.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if ((event.getKeyCode() == KeyEvent.KEYCODE_ENTER) && (event.getAction() == KeyEvent.ACTION_DOWN ))
                    try {
                        Member poster = Global.getMemberController().getActiveMember();
                        Timeline timeline = new Timeline(poster,inputContentED.getText().toString(),new Date());
                        addTimeline(timeline);
                        clearInputEdittextStatus();
                        return true;
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                return false;
            }
        });
    }

    private void clearInputEdittextStatus() {
        /**讓鍵盤卸下**/
        inputContentED.setText("");
        InputMethodManager imm = (InputMethodManager)getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(inputContentED.getWindowToken(), 0);
    }

    private void addTimeline(Timeline timeline) throws Exception {
        Global.getTeamPathyFacade().addTimeline(timeline);
        recyclerAdapter.notifyDataSetChanged();
        snackberNotify(timeline);
    }

    private void snackberNotify(final Timeline timeline){
        /**工作小語新增完畢通知，設置UNDO供使用者移除工作心情小語，移除後又可以UNDO，造成遞迴**/
        Snackbar.make(inputCardView,getString(R.string.timeline_created_completed),Snackbar.LENGTH_LONG)
                .setAction("UNDO", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        try {
                            Global.getTeamPathyFacade().removeTimeline(timeline);
                            recyclerAdapter.notifyDataSetChanged();
                            Snackbar.make(inputCardView,getString(R.string.timeline_removed_completed),Snackbar.LENGTH_LONG)
                                    .setAction("UNDO", new View.OnClickListener() {
                                        @Override
                                        public void onClick(View view) {
                                            try {
                                                addTimeline(timeline);
                                            } catch (Exception e) {
                                                e.printStackTrace();
                                            }
                                        }
                                    }).show();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }).show();
    }

    private void initiateRecyclerView(){
        recyclerAdapter = new MyRecyclerAdapter();
        timelineRecyclerView.setAdapter(recyclerAdapter);
        layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        timelineRecyclerView.setLayoutManager(layoutManager);
    }


    class MyRecyclerAdapter extends RecyclerView.Adapter<MyRecyclerAdapter.MyViewHolder>{

        @Override
        public MyRecyclerAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.workline_input_item, parent, false);
            return  new MyViewHolder(v);
        }

        @Override
        public void onBindViewHolder(TimeLineFragment.MyRecyclerAdapter.MyViewHolder holder, int position) {
            Timeline timeline = timelineList.get(position);
            GlideHelper.loadToCircularImage(getContext(),holder.posterPictureImg,
                    timeline.getPoster().getImageUrl());
            holder.contentTxt.setText(timeline.getContent());
            holder.dateTxt.setText(timeline.getDateString());
            holder.authorTxt.setText(timeline.getPoster().getName());
            holder.cardview.setCardBackgroundColor(getRandomColor());
        }

        private int getRandomColor(){
            Random random = new Random();
            Resources resources = getResources();
            switch(random.nextInt(6))
            {
                case 0:
                    return resources.getColor(R.color.timeline_colors_yellow);
                case 1:
                    return resources.getColor(R.color.timeline_colors_blue);
                case 2:
                    return resources.getColor(R.color.timeline_colors_red);
                case 3:
                    return resources.getColor(R.color.timeline_colors_green);
                case 4:
                    return resources.getColor(R.color.timeline_colors_purple);
                default:
                    return resources.getColor(R.color.timeline_colors_orange);
            }
        }

        @Override
        public int getItemCount() {
            return timelineList.size();
        }

        class MyViewHolder extends  RecyclerView.ViewHolder{
            TextView dateTxt;
            ImageView posterPictureImg;
            TextView contentTxt;
            TextView authorTxt;
            CardView cardview;

            public MyViewHolder(View itemView) {
                super(itemView);
                cardview = (CardView) itemView.findViewById(R.id.card_workline_item);
                posterPictureImg = (ImageView) itemView.findViewById(R.id.poster_header_workline_item);
                contentTxt = (TextView) itemView.findViewById(R.id.content_workline_item);
                dateTxt = (TextView) itemView.findViewById(R.id.datetxt_workline_item);
                authorTxt = (TextView) itemView.findViewById(R.id.poster_nametxt_workline_item);

                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        //todo 點選工作心情小語 動畫放大顯示全文
                    }
                });
            }
        }
    }
}
