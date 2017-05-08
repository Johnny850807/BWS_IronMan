package com.ood.waterball.teampathy.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.CardView;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.ood.waterball.teampathy.Controllers.EntityControllers.EntityController;
import com.ood.waterball.teampathy.Controllers.Global;
import com.ood.waterball.teampathy.Controllers.MyUtils.GlideHelper;
import com.ood.waterball.teampathy.Domains.Member;
import com.ood.waterball.teampathy.Domains.Timeline;
import com.ood.waterball.teampathy.Fragments.Architecture.AsyncQueryRecyclerFragment;
import com.ood.waterball.teampathy.Fragments.ViewAbstractFactory.RecyclerViewAbstractFactory;
import com.ood.waterball.teampathy.Fragments.ViewAbstractFactory.TimeLineRecyclerViewFactory;
import com.ood.waterball.teampathy.R;

import java.util.Date;
import java.util.List;


public class TimeLineFragment extends AsyncQueryRecyclerFragment<Timeline> {
    private CardView inputCardView;
    private ImageView inputPostHeaderImg;
    private EditText inputContentED;
    private TextView posternameTXT;

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
    protected int getLayoutResource() {
        return R.layout.fragment_timeline_page;
    }


    @Override
    protected RecyclerViewAbstractFactory<Timeline> createRecyclerFactory(View parentView,List<Timeline> entityList) {
        return new TimeLineRecyclerViewFactory(parentView,entityList);
    }

    @Override
    protected List<Timeline> createEntityList() {
        try {
            String projectId = (String) getArguments().get("projectId");
            return Global.getTimelineController().readList(projectId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onFindUseCaseViews(View parentView) {
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

    private void addTimeline(final Timeline timeline) throws Exception {
        CREATE(timeline, new EntityController.OnFinishListener() {
            @Override
            public void onFinish() {
                snackberNotify(timeline);
            }
        });
    }

    private void snackberNotify(final Timeline timeline){
        /**工作小語新增完畢通知，設置UNDO供使用者移除工作心情小語，移除後又可以UNDO，造成遞迴**/
        Snackbar.make(inputCardView,getString(R.string.timeline_created_completed),Snackbar.LENGTH_LONG)
                .setAction("UNDO", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        DELETE(timeline, new EntityController.OnFinishListener() {
                            @Override
                            public void onFinish() {
                                removeTimeline(timeline);
                            }
                        });
                    }
                }).show();
    }

    public void removeTimeline(final Timeline timeline){
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
    }



    @Override
    protected EntityController<Timeline> createEntityController() {
        return Global.getTimelineController();
    }

}
