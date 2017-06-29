package com.ood.waterball.teampathy.Controllers.EntityControllers.ProjectSystem;


import com.ood.waterball.teampathy.Controllers.EntityControllers.ProjectSearcher;
import com.ood.waterball.teampathy.Controllers.Global;
import com.ood.waterball.teampathy.DomainModels.Domains.Project;

import java.util.ArrayList;
import java.util.List;

import static com.ood.waterball.teampathy.Controllers.EntityControllers.ProjectSystem.Test.TestProjectController.IMAGE_URL_PROJECT;

public class TestProjectSearcher implements ProjectSearcher{
    private List<Project> globalProjectList;


    @Override
    public List<Project> searchProject(String keyword) throws Exception {
        if (globalProjectList == null)
        {
            globalProjectList = new ArrayList<>();
            globalProjectList.add(new Project("哈哈","123","乾你什麼事情",IMAGE_URL_PROJECT));
            globalProjectList.add(new Project("測試","123","測試用",IMAGE_URL_PROJECT));
            globalProjectList.add(new Project("TeamPathy","123","專研吧",IMAGE_URL_PROJECT));
            globalProjectList.add(new Project("專研","報告","報告告",IMAGE_URL_PROJECT));
            globalProjectList.add(new Project("專研集合唷","工作","工作用",IMAGE_URL_PROJECT));
            globalProjectList.add(new Project("專123研","..","哈",IMAGE_URL_PROJECT));
            globalProjectList.add(new Project("團康大活動銘傳105","團康","快進來一群小孩子",IMAGE_URL_PROJECT));
            globalProjectList.add(new Project("世界文明通是報告","報告","報告你分配",IMAGE_URL_PROJECT));
        }

        List<Project> resultList = new ArrayList<>();
        List<Project> testProjectList = Global.getProjectController().readList(0);

        for ( Project project : testProjectList )
            if (isMatchKeyword(project,keyword))
                resultList.add(project);

        for ( Project project : globalProjectList )
            if (isMatchKeyword(project,keyword))
                resultList.add(project);

        return resultList;
    }

    private boolean isMatchKeyword(Project project , String keyword ){
        return project.getName().contains(keyword);
    }
}
