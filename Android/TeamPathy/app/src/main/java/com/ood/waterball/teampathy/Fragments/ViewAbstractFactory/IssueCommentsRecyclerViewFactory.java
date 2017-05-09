package com.ood.waterball.teampathy.Fragments.ViewAbstractFactory;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ood.waterball.teampathy.Controllers.Global;
import com.ood.waterball.teampathy.DomainModels.Domains.IssueComment;
import com.ood.waterball.teampathy.R;

import java.util.List;


public class IssueCommentsRecyclerViewFactory extends RecyclerViewAbstractFactory<IssueComment> {

    public IssueCommentsRecyclerViewFactory(View rootView,List<IssueComment> issueCommentList) {
        super(rootView,issueCommentList);
    }

    @Override
    protected RecyclerView createRecyclerView() {
        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.recycler_issue_details);
        recyclerView.setNestedScrollingEnabled(false);  //改善 scrollview 滑動慢的問題 see : http://stackoverflow.com/questions/33143485/recyclerview-inside-scrollview-not-scrolling-smoothly
        return recyclerView;
    }


    @Override
    protected RecyclerView.Adapter createRecyclerAdapter(List<IssueComment> issueComments) {
        return  new MyRecyclerAdapter();
    }

    @Override
    protected RecyclerView.LayoutManager createLayoutManager() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(context);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        return layoutManager;
    }


    class MyRecyclerAdapter extends RecyclerView.Adapter<MyRecyclerAdapter.ViewHolder>{

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.issue_details_item,parent,false));
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            IssueComment issueComment = entityList.get(position);
            holder.authorTxt.setText(issueComment.getPoster().getName());
            holder.commentTxt.setText(issueComment.getContent());
            holder.dateTxt.setText(Global.dateConvertStrategy.
                    dateToTime(issueComment.getPostDate()));
        }

        @Override
        public int getItemCount() {
            return entityList.size();
        }

        class ViewHolder extends RecyclerView.ViewHolder{
            private TextView commentTxt;
            private TextView authorTxt;
            private TextView dateTxt;

            public ViewHolder(View itemView) {
                super(itemView);
                commentTxt = (TextView) itemView.findViewById(R.id.comment_text_issue_details_item);
                authorTxt = (TextView) itemView.findViewById(R.id.author_text_issue_details_item);
                dateTxt = (TextView) itemView.findViewById(R.id.datetime_text_issue_details_item);
            }
        }
    }

}
