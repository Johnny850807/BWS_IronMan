package com.ood.waterball.teampathy.Controllers.EntityControllers.ProjectSystem.ProjectMemberController;


import com.ood.waterball.teampathy.DomainModels.Domains.Member;

public class TestOfficeController implements OfficeController {
    private String taskAnalysis = "";


    @Override
    public void modifyPosition(Member member, int projectId, Position position) throws Exception {

    }

    @Override
    public void evictMember(Member member, int projectId) throws Exception {

    }

    @Override
    public void updateTaskAnalysis(String taskAnalysis, int projectId) throws Exception {

    }

    @Override
    public String getTaskAnalysis(int projectId) throws Exception {
        return taskAnalysis;
    }
}
