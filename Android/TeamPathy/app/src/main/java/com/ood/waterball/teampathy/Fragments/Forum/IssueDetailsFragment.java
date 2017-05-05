package com.ood.waterball.teampathy.Fragments.Forum;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ood.waterball.teampathy.Fragments.ActivityBaseFragment;
import com.ood.waterball.teampathy.R;


public class IssueDetailsFragment extends ActivityBaseFragment {
    private ImageView posterHeadImg;
    private TextView issueContextTxt;
    private TextView dateTxt;
    private RecyclerView commentsRecyclerView;
    private LinearLayoutManager layoutManager;

    @Override
    protected void onFetchData(@Nullable Bundle savedInstanceState, @Nullable Bundle arguBundle) {

    }

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_issue_details_page;
    }

    @Override
    protected void onFindViews(View parentView) {

    }

    @Override
    protected void onControlViews() {

    }


    class MyRecyclerAdapter extends RecyclerView.Adapter<MyRecyclerAdapter.ViewHolder>{

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return null;
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {

        }

        @Override
        public int getItemCount() {
            return 0;
        }

        class ViewHolder extends RecyclerView.ViewHolder{
            private TextView commentTxt;
            private TextView authorTxt;
            private TextView dateTxt;

            public ViewHolder(View itemView) {
                super(itemView);
            }
        }
    }
}
