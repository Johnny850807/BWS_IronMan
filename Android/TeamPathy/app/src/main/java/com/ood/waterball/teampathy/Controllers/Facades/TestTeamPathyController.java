package com.ood.waterball.teampathy.Controllers.Facades;


import com.ood.waterball.teampathy.Domains.Issue;
import com.ood.waterball.teampathy.Domains.Member;
import com.ood.waterball.teampathy.Domains.Project;

import java.util.ArrayList;
import java.util.List;

public class TestTeamPathyController implements ITeamPathyController {
    private static final String IMAGE_URL_PROJECT = "http://grinews.com/news/wp-content/uploads/2016/08/%E9%A3%9F%E7%89%A9006.jpg";
    private List<Project> projectList;
    private List<Issue> issueList;

    @Override
    public List<Project> getAllProjectsByUserId(String userId) throws Exception {

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
    public List<Issue> getAllIssuesByProjectId(String projecyId) throws Exception {
        if (issueList != null)
            return issueList;

        Member member = new Member();
        member.setName("林宗億-紙箱大王");

        issueList = new ArrayList<Issue>();
        issueList.add(new Issue(member,"TeamPathy","我們行不行 ? 絕對沒問題 !!! "));
        issueList.add(new Issue(member,"TeamPathy","我們行不行 ? 絕對沒問題 !!! "));
        issueList.add(new Issue(member,"TeamPathy","我們行不行 ? 絕對沒問題 !!! "));
        issueList.add(new Issue(member,"TeamPathy","我們行不行 ? 絕對沒問題 !!! "));
        issueList.add(new Issue(member,"TeamPathy","我們行不行 ? 絕對沒問題 !!! "));
        issueList.add(new Issue(member,"TeamPathy","我們行不行 ? 絕對沒問題 !!! "));
        issueList.add(new Issue(member,"TeamPathy","我們行不行 ? 絕對沒問題 !!! "));
        issueList.add(new Issue(member,"TeamPathy","我們行不行 ? 絕對沒問題 !!! "));
        issueList.add(new Issue(member,"TeamPathy","我們行不行 ? 絕對沒問題 !!! "));
        issueList.add(new Issue(member,"TeamPathy","我們行不行 ? 絕對沒問題 !!! "));
        issueList.add(new Issue(member,"TeamPathy","我們行不行 ? 絕對沒問題 !!! "));
        issueList.add(new Issue(member,"TeamPathy","我們行不行 ? 絕對沒問題 !!! "));
        issueList.add(new Issue(member,"TeamPathy","我們行不行 ? 絕對沒問題 !!! "));
        issueList.add(new Issue(member,"TeamPathy","我們行不行 ? 絕對沒問題 !!! "));


        return issueList;
    }

}
