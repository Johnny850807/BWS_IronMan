package com.ood.waterball.teampathy.Controllers;


import android.content.res.Resources;

import com.ood.waterball.teampathy.Controllers.Facades.TeamPathyFacade;
import com.ood.waterball.teampathy.Controllers.Facades.TestTeamPathyFacade;
import com.ood.waterball.teampathy.Controllers.MemberSystem.MemberController;
import com.ood.waterball.teampathy.Controllers.MemberSystem.TestMemberController;
import com.ood.waterball.teampathy.Controllers.MyUtils.DateConvertStrategy.EnglishAbbreviationDateConvert;

public class Global {
    public static Resources globalResources;
    private static MemberController memberController;

    private static TeamPathyFacade teamPathyFacade;

    public static void init(Resources resources){
        Global.globalResources = resources;

        teamPathyFacade = new TestTeamPathyFacade(new EnglishAbbreviationDateConvert());
        memberController = new TestMemberController();
    }

    public static MemberController getMemberController() {
        return memberController;
    }

    public static TeamPathyFacade getTeamPathyFacade() {
        return teamPathyFacade;
    }
}
