package com.ood.waterball.teampathy.Controllers.EntityControllers.ProjectSystem.ProjectMemberController;


import com.ood.waterball.teampathy.DomainModels.Domains.Member;
import com.ood.waterball.teampathy.DomainModels.Domains.Project;

import static com.ood.waterball.teampathy.Controllers.MyLog.Log;

public class TestProjectMemberController implements ProjectMemberController {

    @Override
    public void promote(Member member, Project ofProject, Position position) {
        Log("Test, " + member.getName() + " is promoted onto " + position);
    }


}
