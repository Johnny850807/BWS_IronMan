package com.ood.waterball.teampathy.Controllers.EntityControllers.ProjectSystem.OfficeController;


import com.ood.waterball.teampathy.DomainModels.Domains.User;

public interface OfficeController {
    enum Position{ MEMBER , PM }

    void modifyPosition(User user, int projectId, Position position) throws Exception;
    void evictMember(User user, int projectId)throws Exception;
    void updateTaskAnalysis(String taskAnalysis,int projectId)throws Exception;
    String getTaskAnalysis(int projectId)throws Exception;
}
