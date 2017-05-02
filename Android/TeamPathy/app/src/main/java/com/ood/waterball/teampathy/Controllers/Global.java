package com.ood.waterball.teampathy.Controllers;


import android.content.res.Resources;

import com.ood.waterball.teampathy.Controllers.MemberSystem.MemberController;
import com.ood.waterball.teampathy.Controllers.MemberSystem.TestMemberController;

public class Global {
    public static Resources globalResources;
    private static MemberController memberController;

    public static void init(Resources resources){
        Global.globalResources = resources;

        memberController = new TestMemberController();
    }

    public static MemberController getMemberController() {
        return memberController;
    }


}
