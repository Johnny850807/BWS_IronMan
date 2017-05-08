package com.ood.waterball.teampathy.Controllers.EntityControllers.ProjectSystem;


import com.ood.waterball.teampathy.Controllers.EntityControllers.EntityController;
import com.ood.waterball.teampathy.Domains.Project;

import java.util.ArrayList;
import java.util.List;

public class TestProjectController implements EntityController<Project>{
    private static final String IMAGE_URL_PROJECT = "http://i.imgur.com/fIfxle9.png";
    private List<Project> projectList;
    private Project project = new Project("TeamPathy","軟體專案","行動化團隊合作系統",IMAGE_URL_PROJECT);

    @Override
    public Project create(Project project)throws Exception {
        return null;
    }

    @Override
    public Project read(String id)throws Exception {
        return project;
    }

    @Override
    public List<Project> readList(String id) throws Exception{

        if (projectList != null)
            return projectList;

        projectList = new ArrayList<Project>();
        projectList.add(new Project("TeamPathy","軟體專案","行動化團隊合作系統",IMAGE_URL_PROJECT));
        projectList.add(new Project("TeamPathy","軟體專案","行動化團隊合作系統",IMAGE_URL_PROJECT));
        projectList.add(new Project("TeamPathy","軟體專案","行動化團隊合作系統",IMAGE_URL_PROJECT));
        projectList.add(new Project("TeamPathy","軟體專案","行動化團隊合作系統",IMAGE_URL_PROJECT));
        projectList.add(new Project("TeamPathy","軟體專案","行動化團隊合作系統",IMAGE_URL_PROJECT));
        projectList.add(new Project("TeamPathy","軟體專案","行動化團隊合作系統",IMAGE_URL_PROJECT));
        projectList.add(new Project("TeamPathy","軟體專案","行動化團隊合作系統",IMAGE_URL_PROJECT));
        projectList.add(new Project("TeamPathy","軟體專案","行動化團隊合作系統",IMAGE_URL_PROJECT));
        projectList.add(new Project("TeamPathy","軟體專案","行動化團隊合作系統",IMAGE_URL_PROJECT));
        projectList.add(new Project("TeamPathy","軟體專案","行動化團隊合作系統",IMAGE_URL_PROJECT));
        projectList.add(new Project("TeamPathy","軟體專案","行動化團隊合作系統",IMAGE_URL_PROJECT));

        return projectList;
    }

    @Override
    public Project update(Project project)throws Exception {
        return null;
    }

    @Override
    public Project delete(Project project)throws Exception {
        return null;
    }
}
