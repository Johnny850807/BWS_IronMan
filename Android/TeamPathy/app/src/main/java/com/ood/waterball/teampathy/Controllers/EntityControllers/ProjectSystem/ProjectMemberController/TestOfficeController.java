package com.ood.waterball.teampathy.Controllers.EntityControllers.ProjectSystem.ProjectMemberController;


import com.ood.waterball.teampathy.DomainModels.Domains.Member;
import com.ood.waterball.teampathy.DomainModels.Domains.Project;

import static com.ood.waterball.teampathy.Controllers.MyLog.Log;

public class TestOfficeController implements OfficeController {
    private String taskAnalysis = "";
    @Override
    public void modifyPosition(Member member, Project ofProject, Position position) {
        Log("Test, " + member.getName() + " is modified to " + position);
    }

    @Override
    public void evictMember(Member member) throws Exception {

    }

    @Override
    public void updateTaskAnalysis(String taskAnalysis) throws Exception {

    }

    @Override
    public String getTaskAnalysis() throws Exception {
        return taskAnalysis;
    }


}
