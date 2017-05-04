package com.ood.waterball.teampathy.Controllers.Facades;


import com.ood.waterball.teampathy.Domains.Issue;
import com.ood.waterball.teampathy.Domains.Project;

import java.util.List;

public interface ITeamPathyFacade {

    public List<Project> getAllProjectsByUserId(String userId) throws Exception;

    public Project getProjectById(String projectId) throws Exception;
    public List<Issue> getAllIssuesByProjectId(String projectId) throws Exception;
}
