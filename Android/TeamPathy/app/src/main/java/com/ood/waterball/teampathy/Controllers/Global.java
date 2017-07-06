package com.ood.waterball.teampathy.Controllers;


import android.content.res.Resources;

import com.ood.waterball.teampathy.Controllers.EntityControllers.EntityController;
import com.ood.waterball.teampathy.Controllers.EntityControllers.MemberSystem.MemberController;
import com.ood.waterball.teampathy.Controllers.EntityControllers.MemberSystem.TestMemberController;
import com.ood.waterball.teampathy.Controllers.EntityControllers.ProjectSystem.ProjectMemberController.OfficeController;
import com.ood.waterball.teampathy.Controllers.EntityControllers.ProjectSystem.ProjectMemberController.TestOfficeController;
import com.ood.waterball.teampathy.Controllers.EntityControllers.ProjectSystem.ProjectSearcher.ProjectSearcher;
import com.ood.waterball.teampathy.Controllers.EntityControllers.ProjectSystem.Test.TestIssueCommentController;
import com.ood.waterball.teampathy.Controllers.EntityControllers.ProjectSystem.Test.TestIssueController;
import com.ood.waterball.teampathy.Controllers.EntityControllers.ProjectSystem.Test.TestIssueTypeController;
import com.ood.waterball.teampathy.Controllers.EntityControllers.ProjectSystem.Test.TestMemberIdCardController;
import com.ood.waterball.teampathy.Controllers.EntityControllers.ProjectSystem.Test.TestProjectController;
import com.ood.waterball.teampathy.Controllers.EntityControllers.ProjectSystem.Test.TestTimelineController;
import com.ood.waterball.teampathy.Controllers.EntityControllers.ProjectSystem.Test.TestTodoTaskController;
import com.ood.waterball.teampathy.Controllers.EntityControllers.ProjectSystem.ProjectSearcher.TestProjectSearcher;
import com.ood.waterball.teampathy.Controllers.MyUtils.DateConvertStrategy.DateConvertStrategy;
import com.ood.waterball.teampathy.Controllers.MyUtils.DateConvertStrategy.EnglishAbbreviationDateConvert;
import com.ood.waterball.teampathy.DomainModels.Domains.Issue;
import com.ood.waterball.teampathy.DomainModels.Domains.IssueComment;
import com.ood.waterball.teampathy.DomainModels.Domains.IssueType;
import com.ood.waterball.teampathy.DomainModels.Domains.Project;
import com.ood.waterball.teampathy.DomainModels.Domains.Timeline;
import com.ood.waterball.teampathy.DomainModels.WBS.TodoTask;
import com.ood.waterball.teampathy.DomainModels.Models.MemberIdCardModel;

public class Global {
    public static Resources resources;
    public static DateConvertStrategy dateConvertStrategy;

    private static MemberController memberController;
    private static ProjectSearcher projectSearcher;
    private static OfficeController officeController;
    private static EntityController<Project> projectController;
    private static EntityController<IssueType> issuetypeController;
    private static EntityController<Issue> issueController;
    private static EntityController<IssueComment> issueCommentController;
    private static EntityController<Timeline> timelineController;
    private static EntityController<MemberIdCardModel> memberIdCardController;
    private static EntityController<TodoTask> todotaskController;

    public static void init(Resources resources){
        Global.resources = resources;

        dateConvertStrategy = new EnglishAbbreviationDateConvert();

        initiateTestControllers();
    }

    private static void initiateTestControllers() {
        memberController = new TestMemberController();
        projectController = new TestProjectController();
        issueController = new TestIssueController();
        issuetypeController = new TestIssueTypeController();
        issueCommentController = new TestIssueCommentController();
        timelineController = new TestTimelineController();
        memberIdCardController = new TestMemberIdCardController();
        todotaskController = new TestTodoTaskController();
        projectSearcher = new TestProjectSearcher();
        officeController = new TestOfficeController();
    }

    public static OfficeController getOfficeController() {
        return officeController;
    }

    public static ProjectSearcher getProjectSearcher() {
        return projectSearcher;
    }

    public static EntityController<IssueComment> getIssueCommentController() {
        return issueCommentController;
    }

    public static EntityController<Issue> getIssueController() {
        return issueController;
    }

    public static MemberController getMemberController() {
        return memberController;
    }

    public static EntityController<MemberIdCardModel> getMemberIdCardController() {
        return memberIdCardController;
    }

    public static EntityController<Project> getProjectController() {
        return projectController;
    }

    public static EntityController<Timeline> getTimelineController() {
        return timelineController;
    }

    public static EntityController<IssueType> getIssuetypeController() {
        return issuetypeController;
    }

    public static EntityController<TodoTask> getTodotaskController() {
        return todotaskController;
    }
}
