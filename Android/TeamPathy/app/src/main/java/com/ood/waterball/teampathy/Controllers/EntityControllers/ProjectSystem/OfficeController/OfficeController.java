package com.ood.waterball.teampathy.Controllers.EntityControllers.ProjectSystem.OfficeController;


import com.ood.waterball.teampathy.DomainModels.Domains.Member;

public interface OfficeController {
    enum Position{ MEMBER , PM }

    void modifyPosition(Member member,int projectId, Position position) throws Exception;
    void evictMember(Member member,int projectId)throws Exception;
    void updateTaskAnalysis(String taskAnalysis,int projectId)throws Exception;
    String getTaskAnalysis(int projectId)throws Exception;
}
