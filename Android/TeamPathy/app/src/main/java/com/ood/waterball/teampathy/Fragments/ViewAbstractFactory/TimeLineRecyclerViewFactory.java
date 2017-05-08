package com.ood.waterball.teampathy.Fragments.ViewAbstractFactory;


import android.content.res.Resources;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ood.waterball.teampathy.Controllers.MyUtils.GlideHelper;
import com.ood.waterball.teampathy.Domains.Timeline;
import com.ood.waterball.teampathy.R;

import java.util.List;
import java.util.Random;

public class TimeLineRecyclerViewFactory extends RecyclerViewAbstractFactory<Timeline>{

    public TimeLineRecyclerViewFactory(View rootView,List<Timeline>timelineList) {
        super(rootView,timelineList);
    }

    @Override
    protected RecyclerView createRecyclerView() {
        return  (RecyclerView) rootView.findViewById(R.id.timeline_recyclerview_timeline);
    }

    @Override
    protected RecyclerView.Adapter createRecyclerAdapter(List<Timeline> timelines) {
        return new MyRecyclerAdapter();
    }

    @Override
    protected RecyclerView.LayoutManager createLayoutManager() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(context);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        return layoutManager;
    }


    class MyRecyclerAdapter extends RecyclerView.Adapter<MyRecyclerAdapter.MyViewHolder>{

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.workline_input_item, parent, false);
            return  new MyViewHolder(v);
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            Timeline timeline = entityList.get(position);
            GlideHelper.loadToCircularImage(context,holder.posterPictureImg,
                    timeline.getPoster().getImageUrl());
            holder.contentTxt.setText(timeline.getContent());
            holder.dateTxt.setText(timeline.getDateString());
            holder.authorTxt.setText(timeline.getPoster().getName());
            holder.cardview.setCardBackgroundColor(getRandomColor());
        }

        private int getRandomColor(){
            Random random = new Random();
            Resources resources = context.getResources();
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
            return entityList.size();
        }

        class MyViewHolder extends  RecyclerView.ViewHolder{
            TextView dateTxt;
            ImageView posterPictureImg;
            TextView contentTxt;
            TextView authorTxt;
            CardView cardview;

            MyViewHolder(View itemView) {
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
