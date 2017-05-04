package com.ood.waterball.teampathy.Controllers.Facades;


import com.ood.waterball.teampathy.Domains.Issue;
import com.ood.waterball.teampathy.Domains.Project;

import java.util.List;

public interface ITeamPathyFacade {

    public List<Project> getProjectListByUserId(String userId) throws Exception;

    public Project getProjectById(String projectId) throws Exception;
    public List<Issue> getIssueListByProjectId(String projectId) throws Exception;
    public Issue getIssueById(String issueId)throws Exception;
    public Issue addIssue(Issue issue)throws Exception;
    public Issue removeIssue(Issue issue)throws Exception;
    public Issue editIssue(Issue issue)throws Exception;
    public String[] getIssueTypeListByProjectId(String projectId) throws Exception;
}
