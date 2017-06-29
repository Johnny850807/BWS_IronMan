package com.ood.waterball.teampathy.Controllers.EntityControllers.ProjectSystem.Test;

import com.ood.waterball.teampathy.Controllers.EntityControllers.EntityController;
import com.ood.waterball.teampathy.DomainModels.Domains.Member;
import com.ood.waterball.teampathy.DomainModels.Domains.Timeline;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class TestTimelineController implements EntityController<Timeline> {
    private  Member zheng = new Member("曾韋傑 Curry0423","","","http://imgur.com/download/c3qnbkg");
    private Timeline timeline = new Timeline(zheng,"文案-專研初審文案提交審核通過1!!",new Date());
    private List<Timeline> timelineList;

    @Override
    public Timeline create(Timeline timeline)throws Exception {
        timelineList.add(0,timeline);
        return timeline;
    }

    @Override
    public Timeline read(int id)throws Exception {
        return timeline;
    }

    @Override
    public List<Timeline> readList(int id) throws Exception{
        if (timelineList != null)
            return timelineList;
        timelineList = new ArrayList<>();
        timelineList.add(new Timeline(zheng,"文案-專研初審文案提交審核通過2!!",new Date()));
        timelineList.add(new Timeline(zheng,"文案-專研初審文案提交審核通過2!!",new Date()));
        timelineList.add(new Timeline(zheng,"文案-專研初審文案提交審核通過3!!",new Date()));
        timelineList.add(new Timeline(zheng,"文案-專研初審文案提交審核通過4!!",new Date()));
        timelineList.add(new Timeline(zheng,"文案-專研初審文案提交審核通過5!!",new Date()));
        timelineList.add(new Timeline(zheng,"文案-專研初審文案提交審核通過6!!",new Date()));
        timelineList.add(new Timeline(zheng,"文案-專研初審文案提交審核通過2!!",new Date()));
        timelineList.add(new Timeline(zheng,"文案-專研初審文案提交審核通過2!!",new Date()));
        timelineList.add(new Timeline(zheng,"文案-專研初審文案提交審核通過3!!",new Date()));
        timelineList.add(new Timeline(zheng,"文案-專研初審文案提交審核通過4!!",new Date()));
        timelineList.add(new Timeline(zheng,"文案-專研初審文案提交審核通過5!!",new Date()));
        timelineList.add(new Timeline(zheng,"文案-專研初審文案提交審核通過6!!",new Date()));
        timelineList.add(new Timeline(zheng,"文案-專研初審文案提交審核通過2!!",new Date()));
        timelineList.add(new Timeline(zheng,"文案-專研初審文案提交審核通過2!!",new Date()));
        timelineList.add(new Timeline(zheng,"文案-專研初審文案提交審核通過3!!",new Date()));
        timelineList.add(new Timeline(zheng,"文案-專研初審文案提交審核通過4!!",new Date()));
        timelineList.add(new Timeline(zheng,"文案-專研初審文案提交審核通過5!!",new Date()));
        timelineList.add(new Timeline(zheng,"文案-專研初審文案提交審核通過6!!",new Date()));
        timelineList.add(new Timeline(zheng,"文案-專研初審文案提交審核通過2!!",new Date()));
        timelineList.add(new Timeline(zheng,"文案-專研初審文案提交審核通過2!!",new Date()));
        timelineList.add(new Timeline(zheng,"文案-專研初審文案提交審核通過3!!",new Date()));
        timelineList.add(new Timeline(zheng,"文案-專研初審文案提交審核通過4!!",new Date()));
        timelineList.add(new Timeline(zheng,"文案-專研初審文案提交審核通過5!!",new Date()));
        timelineList.add(new Timeline(zheng,"文案-專研初審文案提交審核通過6!!",new Date()));
        return timelineList;
    }

    @Override
    public Timeline update(Timeline timeline)throws Exception {
        return null;
    }

    @Override
    public Timeline delete(Timeline timeline) {
        timelineList.remove(timeline);
        return timeline;
    }
}
