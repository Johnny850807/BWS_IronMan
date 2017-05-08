package com.ood.waterball.teampathy.Controllers;


import android.content.res.Resources;

import com.ood.waterball.teampathy.Controllers.EntityControllers.MemberSystem.MemberController;
import com.ood.waterball.teampathy.Controllers.EntityControllers.MemberSystem.TestMemberController;
import com.ood.waterball.teampathy.Controllers.EntityControllers.ProjectSystem.TestIssueCommentController;
import com.ood.waterball.teampathy.Controllers.EntityControllers.ProjectSystem.TestIssueController;
import com.ood.waterball.teampathy.Controllers.EntityControllers.ProjectSystem.TestProjectController;
import com.ood.waterball.teampathy.Controllers.EntityControllers.ProjectSystem.TestTimelineController;
import com.ood.waterball.teampathy.Controllers.MyUtils.DateConvertStrategy.DateConvertStrategy;
import com.ood.waterball.teampathy.Controllers.MyUtils.DateConvertStrategy.EnglishAbbreviationDateConvert;

public class Global {
    public static Resources globalResources;
    public static DateConvertStrategy dateConvertStrategy;

    private static MemberController memberController;
    private static TestProjectController projectController;
    private static TestIssueController issueController;
    private static TestIssueCommentController issueCommentController;
    private static TestTimelineController timelineController;

    public static void init(Resources resources){
        Global.globalResources = resources;

        dateConvertStrategy = new EnglishAbbreviationDateConvert();

        memberController = new TestMemberController();
        projectController = new TestProjectController();
        issueController = new TestIssueController();
        issueCommentController = new TestIssueCommentController();
        timelineController = new TestTimelineController();
    }

    public static MemberController getMemberController() {
        return memberController;
    }

    public static TestIssueCommentController getIssueCommentController() {
        return issueCommentController;
    }

    public static TestIssueController getIssueController() {
        return issueController;
    }

    public static TestProjectController getProjectController() {
        return projectController;
    }

    public static TestTimelineController getTimelineController() {
        return timelineController;
    }
}
