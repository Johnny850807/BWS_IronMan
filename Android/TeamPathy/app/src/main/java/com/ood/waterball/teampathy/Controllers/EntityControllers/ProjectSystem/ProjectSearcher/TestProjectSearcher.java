package com.ood.waterball.teampathy.Controllers.EntityControllers.ProjectSystem.ProjectSearcher;


import com.ood.waterball.teampathy.Controllers.Global;
import com.ood.waterball.teampathy.DomainModels.Domains.Project;

import java.util.ArrayList;
import java.util.List;

import static com.ood.waterball.teampathy.Controllers.EntityControllers.ProjectSystem.Test.TestProjectController.IMAGE_URL_PROJECT;
import static com.ood.waterball.teampathy.Controllers.MyLog.Log;

public class TestProjectSearcher implements ProjectSearcher{
    private List<Project> globalProjectList;


    @Override
    public List<Project> searchProject(String keyword) throws Exception {
        if (globalProjectList == null)
        {
            globalProjectList = new ArrayList<>();
            globalProjectList.add(new Project(50,"哈哈","123","乾你什麼事情",IMAGE_URL_PROJECT));
            globalProjectList.add(new Project(51,"測試","123","測試用",IMAGE_URL_PROJECT));
            globalProjectList.add(new Project(52,"TeamPathy","123","專研吧",IMAGE_URL_PROJECT));
            globalProjectList.add(new Project(53,"專研","報告","報告告",IMAGE_URL_PROJECT));
            globalProjectList.add(new Project(54,"專研集合唷","工作","工作用",IMAGE_URL_PROJECT));
            globalProjectList.add(new Project(55,"專123研","..","哈",IMAGE_URL_PROJECT));
            globalProjectList.add(new Project(56,"團康大活動銘傳105","團康","快進來一群小孩子",IMAGE_URL_PROJECT));
            globalProjectList.add(new Project(57,"世界文明通是報告","報告","報告你分配",IMAGE_URL_PROJECT));
            globalProjectList.add(new Project(59,"這個有密碼","密碼測試","密碼是123",IMAGE_URL_PROJECT,"123"));
        }

        List<Project> resultList = new ArrayList<>();
        List<Project> testProjectList = Global.getProjectController().readList(0);

        for ( Project project : testProjectList )
            if (isMatchKeyword(project,keyword))
                resultList.add(project);

        for ( Project project : globalProjectList )
            if (isMatchKeyword(project,keyword))
                resultList.add(project);

        Log("搜尋結果: " + resultList);
        return resultList;
    }

    private boolean isMatchKeyword(Project project , String keyword ){
        return project.getName().contains(keyword);
    }
}
