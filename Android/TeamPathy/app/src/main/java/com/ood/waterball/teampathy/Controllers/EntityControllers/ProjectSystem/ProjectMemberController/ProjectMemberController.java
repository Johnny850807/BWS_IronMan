package com.ood.waterball.teampathy.Controllers.EntityControllers.ProjectSystem.ProjectMemberController;


import com.ood.waterball.teampathy.DomainModels.Domains.Member;
import com.ood.waterball.teampathy.DomainModels.Domains.Project;

public interface ProjectMemberController {
    enum Position{ MEMBER , PM }

    void promote(Member member, Project ofProject, Position position) throws Exception;

}
