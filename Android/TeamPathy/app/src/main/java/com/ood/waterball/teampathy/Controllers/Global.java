package com.ood.waterball.teampathy.Controllers;


import android.content.res.Resources;

import com.ood.waterball.teampathy.Controllers.Facades.ITeamPathyFacade;
import com.ood.waterball.teampathy.Controllers.Facades.TestTeamPathyFacade;
import com.ood.waterball.teampathy.Controllers.MemberSystem.MemberController;
import com.ood.waterball.teampathy.Controllers.MemberSystem.TestMemberController;

public class Global {
    public static Resources globalResources;
    private static MemberController memberController;

    private static ITeamPathyFacade teamPathyFacade;

    public static void init(Resources resources){
        Global.globalResources = resources;

        teamPathyFacade = new TestTeamPathyFacade();
        memberController = new TestMemberController();
    }

    public static MemberController getMemberController() {
        return memberController;
    }

    public static ITeamPathyFacade getTeamPathyFacade() {
        return teamPathyFacade;
    }
}
