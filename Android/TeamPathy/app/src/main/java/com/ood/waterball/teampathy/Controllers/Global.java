package com.ood.waterball.teampathy.Controllers;


import android.content.res.Resources;

import com.ood.waterball.teampathy.Controllers.Facades.ITeamPathyController;
import com.ood.waterball.teampathy.Controllers.Facades.TestTeamPathyController;
import com.ood.waterball.teampathy.Controllers.MemberSystem.MemberController;
import com.ood.waterball.teampathy.Controllers.MemberSystem.TestMemberController;

public class Global {
    public static Resources globalResources;
    private static MemberController memberController;

    private static ITeamPathyController teamPathyFacade;

    public static void init(Resources resources){
        Global.globalResources = resources;

        teamPathyFacade = new TestTeamPathyController();
        memberController = new TestMemberController();
    }

    public static MemberController getMemberController() {
        return memberController;
    }

    public static ITeamPathyController getTeamPathyFacade() {
        return teamPathyFacade;
    }
}
