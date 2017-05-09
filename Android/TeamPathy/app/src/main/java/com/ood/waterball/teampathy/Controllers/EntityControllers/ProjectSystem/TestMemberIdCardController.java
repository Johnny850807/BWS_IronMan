package com.ood.waterball.teampathy.Controllers.EntityControllers.ProjectSystem;

import com.ood.waterball.teampathy.Controllers.EntityControllers.EntityController;
import com.ood.waterball.teampathy.Controllers.Global;
import com.ood.waterball.teampathy.DomainModels.Domains.Member;
import com.ood.waterball.teampathy.DomainModels.Domains.TodoTask;
import com.ood.waterball.teampathy.DomainModels.Models.MemberIdCardModel;
import com.ood.waterball.teampathy.R;

import java.util.ArrayList;
import java.util.List;


public class TestMemberIdCardController implements EntityController<MemberIdCardModel> {
    private List<MemberIdCardModel> memberIdCardModelList;
    @Override
    public MemberIdCardModel create(MemberIdCardModel memberIdCardModel) throws Exception {
        return null;
    }

    @Override
    public MemberIdCardModel read(String id) throws Exception {
        return null;
    }

    @Override
    public List<MemberIdCardModel> readList(String id) throws Exception {
        if (memberIdCardModelList != null)
            return memberIdCardModelList;
        Member zong = new Member("林宗億","","","http://i.imgur.com/4wXEKrP.png");
        zong.setPosition(Global.resources.getString(R.string.pm));
        Member wb = new Member("水球潘","","","http://i.imgur.com/NCCXqIj.jpg");
        wb.setPosition(Global.resources.getString(R.string.leader));
        Member zheng = new Member("曾韋傑","","","http://i.imgur.com/c3qnbkg.png");
        zheng.setPosition(Global.resources.getString(R.string.member));
        Member chia = new Member("花柳齋","","","http://i.imgur.com/DuhZSwy.png");
        chia.setPosition(Global.resources.getString(R.string.member));
        TodoTask todoTask1 = new TodoTask("設計","ER圖設計");
        TodoTask todoTask4 = new TodoTask("實作","Android架構");
        TodoTask todoTask2 = new TodoTask("實作","API 學習");
        TodoTask todoTask3 = new TodoTask("文案","初審文案整理");
        memberIdCardModelList = new ArrayList<>();
        memberIdCardModelList.add(new MemberIdCardModel(zong,todoTask2));
        memberIdCardModelList.add(new MemberIdCardModel(wb,todoTask4));
        memberIdCardModelList.add(new MemberIdCardModel(zheng,todoTask3));
        memberIdCardModelList.add(new MemberIdCardModel(chia,todoTask1));
        return memberIdCardModelList;
    }

    @Override
    public MemberIdCardModel update(MemberIdCardModel memberIdCardModel) throws Exception {
        return null;
    }

    @Override
    public MemberIdCardModel delete(MemberIdCardModel memberIdCardModel) throws Exception {
        return null;
    }
}
