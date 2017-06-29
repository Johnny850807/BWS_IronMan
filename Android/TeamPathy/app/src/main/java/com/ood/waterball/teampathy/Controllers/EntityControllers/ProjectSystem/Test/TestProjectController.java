package com.ood.waterball.teampathy.Controllers.EntityControllers.ProjectSystem.Test;


import com.ood.waterball.teampathy.Controllers.EntityControllers.EntityController;
import com.ood.waterball.teampathy.DomainModels.Domains.Project;

import java.util.ArrayList;
import java.util.List;

public class TestProjectController implements EntityController<Project>{
    public static final String IMAGE_URL_PROJECT = "http://i.imgur.com/fIfxle9.png";
    private List<Project> projectList;
    private Project project = new Project(100,"TeamPathy","軟體專案","行動化團隊合作系統",IMAGE_URL_PROJECT);

    @Override
    public Project create(Project project)throws Exception {
        project.setImageUrl(IMAGE_URL_PROJECT);
        projectList.add(project);
        return project;
    }

    @Override
    public Project read(int id)throws Exception {
        return project;
    }

    @Override
    public List<Project> readList(int id) throws Exception{

        if (projectList != null)
            return projectList;

        projectList = new ArrayList<Project>();
        projectList.add(new Project(1,"TeamPathy","軟體專案","行動化團隊合作系統",IMAGE_URL_PROJECT));
        projectList.add(new Project(2,"TeamPathy","軟體專案","行動化團隊合作系統",IMAGE_URL_PROJECT));
        projectList.add(new Project(3,"TeamPathy","軟體專案","行動化團隊合作系統",IMAGE_URL_PROJECT));
        projectList.add(new Project(4,"TeamPathy","軟體專案","行動化團隊合作系統",IMAGE_URL_PROJECT));
        projectList.add(new Project(5,"TeamPathy","軟體專案","行動化團隊合作系統",IMAGE_URL_PROJECT));
        projectList.add(new Project(6,"TeamPathy","軟體專案","行動化團隊合作系統",IMAGE_URL_PROJECT));
        projectList.add(new Project(7,"TeamPathy","軟體專案","行動化團隊合作系統",IMAGE_URL_PROJECT));
        projectList.add(new Project(8,"TeamPathy","軟體專案","行動化團隊合作系統",IMAGE_URL_PROJECT));
        projectList.add(new Project(9,"TeamPathy","軟體專案","行動化團隊合作系統",IMAGE_URL_PROJECT));
        projectList.add(new Project(10,"TeamPathy","軟體專案","行動化團隊合作系統",IMAGE_URL_PROJECT));
        projectList.add(new Project(11,"TeamPathy","軟體專案","行動化團隊合作系統",IMAGE_URL_PROJECT));
        projectList.add(new Project(12,"TeamPathy","軟體專案","行動化團隊合作系統",IMAGE_URL_PROJECT));
        projectList.add(new Project(13,"TeamPathy","軟體專案","行動化團隊合作系統",IMAGE_URL_PROJECT));
        projectList.add(new Project(14,"TeamPathy","軟體專案","行動化團隊合作系統",IMAGE_URL_PROJECT));
        projectList.add(new Project(15,"TeamPathy","軟體專案","行動化團隊合作系統",IMAGE_URL_PROJECT));
        projectList.add(new Project(16,"TeamPathy","軟體專案","行動化團隊合作系統",IMAGE_URL_PROJECT));
        projectList.add(new Project(17,"TeamPathy","軟體專案","行動化團隊合作系統",IMAGE_URL_PROJECT));
        projectList.add(new Project(18,"TeamPathy","軟體專案","行動化團隊合作系統",IMAGE_URL_PROJECT));
        projectList.add(new Project(19,"TeamPathy","軟體專案","行動化團隊合作系統",IMAGE_URL_PROJECT));
        projectList.add(new Project(20,"TeamPathy","軟體專案","行動化團隊合作系統",IMAGE_URL_PROJECT));
        projectList.add(new Project(21,"TeamPathy","軟體專案","行動化團隊合作系統",IMAGE_URL_PROJECT));
        projectList.add(new Project(22,"TeamPathy","軟體專案","行動化團隊合作系統",IMAGE_URL_PROJECT));
        projectList.add(new Project(23,"TeamPathy","軟體專案","行動化團隊合作系統",IMAGE_URL_PROJECT));
        projectList.add(new Project(24,"TeamPathy","軟體專案","行動化團隊合作系統",IMAGE_URL_PROJECT));
        projectList.add(new Project(25,"TeamPathy","軟體專案","行動化團隊合作系統",IMAGE_URL_PROJECT));
        projectList.add(new Project(26,"TeamPathy","軟體專案","行動化團隊合作系統",IMAGE_URL_PROJECT));
        projectList.add(new Project(27,"TeamPathy","軟體專案","行動化團隊合作系統",IMAGE_URL_PROJECT));
        projectList.add(new Project(28,"TeamPathy","軟體專案","行動化團隊合作系統",IMAGE_URL_PROJECT));
        projectList.add(new Project(29,"TeamPathy","軟體專案","行動化團隊合作系統",IMAGE_URL_PROJECT));
        projectList.add(new Project(30,"TeamPathy","軟體專案","行動化團隊合作系統",IMAGE_URL_PROJECT));
        projectList.add(new Project(31,"TeamPathy","軟體專案","行動化團隊合作系統",IMAGE_URL_PROJECT));
        projectList.add(new Project(32,"TeamPathy","軟體專案","行動化團隊合作系統",IMAGE_URL_PROJECT));
        projectList.add(new Project(33,"TeamPathy","軟體專案","行動化團隊合作系統",IMAGE_URL_PROJECT));
        projectList.add(new Project(34,"TeamPathy","軟體專案","行動化團隊合作系統",IMAGE_URL_PROJECT));
        projectList.add(new Project(35,"TeamPathy","軟體專案","行動化團隊合作系統",IMAGE_URL_PROJECT));
        projectList.add(new Project(36,"TeamPathy","軟體專案","行動化團隊合作系統",IMAGE_URL_PROJECT));
        projectList.add(new Project(37,"TeamPathy","軟體專案","行動化團隊合作系統",IMAGE_URL_PROJECT));
        projectList.add(new Project(38,"TeamPathy","軟體專案","行動化團隊合作系統",IMAGE_URL_PROJECT));

        return projectList;
    }

    @Override
    public Project update(Project project)throws Exception {
        return null;
    }

    @Override
    public Project delete(Project project)throws Exception {
        projectList.remove(project);
        return project;
    }
}
