package com.ood.waterball.teampathy.Controllers.EntityControllers.ProjectSystem.ProjectMemberController;


import com.ood.waterball.teampathy.DomainModels.Domains.Member;
import com.ood.waterball.teampathy.DomainModels.Domains.Project;

public interface OfficeController {
    enum Position{ MEMBER , PM }

    void modifyPosition(Member member, Project ofProject, Position position) throws Exception;
    void evictMember(Member member)throws Exception;
    void updateTaskAnalysis(String taskAnalysis)throws Exception;
    String getTaskAnalysis()throws Exception;
}
