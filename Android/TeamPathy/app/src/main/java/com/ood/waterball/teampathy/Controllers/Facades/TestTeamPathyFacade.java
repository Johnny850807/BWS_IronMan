package com.ood.waterball.teampathy.Controllers.Facades;


import com.ood.waterball.teampathy.Controllers.Global;
import com.ood.waterball.teampathy.Controllers.MyUtils.DateConvertStrategy.DateConvertStrategy;
import com.ood.waterball.teampathy.Domains.Issue;
import com.ood.waterball.teampathy.Domains.Member;
import com.ood.waterball.teampathy.Domains.Project;
import com.ood.waterball.teampathy.R;

import java.util.ArrayList;
import java.util.List;
//todo 把每個crud 非同步化
public class TestTeamPathyFacade extends TeamPathyFacade {
    private static final String IMAGE_URL_PROJECT = "http://i.imgur.com/5s7vtxN.jpg";
    private List<Project> projectList;
    private Project project = new Project("TeamPathy","軟體專案","行動化團隊合作系統",IMAGE_URL_PROJECT);
    private List<Issue> issueList;
    private Issue issue;

    public TestTeamPathyFacade(DateConvertStrategy dateConvertStrategy) {
        super(dateConvertStrategy);
    }

    @Override
    public List<Project> getProjectListByUserId(String userId) throws Exception {

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
    public Project getProjectById(String projectId) throws Exception {
        return project;
    }

    @Override
    public List<Issue> getIssueListByProjectId(String projectId) throws Exception {
        if (issueList != null)
            return issueList;

        Member member = new Member();
        member.setName("林宗億-紙箱大王");

        issueList = new ArrayList<Issue>();
        issueList.add(new Issue(member,"TeamPathy","我們行不行 ? 絕對沒問題 !!! ","議題"));
        issueList.add(new Issue(member,"TeamPathy","我們行不行 ? 絕對沒問題 !!! ","議題"));
        issueList.add(new Issue(member,"TeamPathy","我們行不行 ? 絕對沒問題 !!! ","議題"));
        issueList.add(new Issue(member,"TeamPathy","我們行不行 ? 絕對沒問題 !!! ","議題"));
        issueList.add(new Issue(member,"TeamPathy","我們行不行 ? 絕對沒問題 !!! ","議題"));
        issueList.add(new Issue(member,"TeamPathy","我們行不行 ? 絕對沒問題 !!! ","議題"));
        issueList.add(new Issue(member,"TeamPathy","我們行不行 ? 絕對沒問題 !!! ","議題"));
        issueList.add(new Issue(member,"TeamPathy","我們行不行 ? 絕對沒問題 !!! ","議題"));
        issueList.add(new Issue(member,"TeamPathy","我們行不行 ? 絕對沒問題 !!! ","議題"));
        issueList.add(new Issue(member,"TeamPathy","我們行不行 ? 絕對沒問題 !!! ","議題"));
        issueList.add(new Issue(member,"TeamPathy","我們行不行 ? 絕對沒問題 !!! ","議題"));
        issueList.add(new Issue(member,"TeamPathy","我們行不行 ? 絕對沒問題 !!! ","議題"));
        issueList.add(new Issue(member,"TeamPathy","我們行不行 ? 絕對沒問題 !!! ","議題"));
        issueList.add(new Issue(member,"TeamPathy","我們行不行 ? 絕對沒問題 !!! ","議題"));
        issueList.add(new Issue(member,"TeamPathy","我們行不行 ? 絕對沒問題 !!! ","議題"));
        issueList.add(new Issue(member,"TeamPathy","我們行不行 ? 絕對沒問題 !!! ","議題"));
        issueList.add(new Issue(member,"TeamPathy","我們行不行 ? 絕對沒問題 !!! ","議題"));
        issueList.add(new Issue(member,"TeamPathy","我們行不行 ? 絕對沒問題 !!! ","議題"));
        issueList.add(new Issue(member,"TeamPathy","我們行不行 ? 絕對沒問題 !!! ","議題"));
        issueList.add(new Issue(member,"TeamPathy","我們行不行 ? 絕對沒問題 !!! ","議題"));
        issueList.add(new Issue(member,"TeamPathy","我們行不行 ? 絕對沒問題 !!! ","議題"));
        issueList.add(new Issue(member,"TeamPathy","我們行不行 ? 絕對沒問題 !!! ","議題"));
        issueList.add(new Issue(member,"TeamPathy","我們行不行 ? 絕對沒問題 !!! ","議題"));
        issueList.add(new Issue(member,"TeamPathy","我們行不行 ? 絕對沒問題 !!! ","議題"));
        issueList.add(new Issue(member,"TeamPathy","我們行不行 ? 絕對沒問題 !!! ","議題"));
        issueList.add(new Issue(member,"TeamPathy","我們行不行 ? 絕對沒問題 !!! ","議題"));
        issueList.add(new Issue(member,"TeamPathy","我們行不行 ? 絕對沒問題 !!! ","議題"));
        issueList.add(new Issue(member,"TeamPathy","我們行不行 ? 絕對沒問題 !!! ","議題"));
        issueList.add(new Issue(member,"TeamPathy","我們行不行 ? 絕對沒問題 !!! ","議題"));
        issueList.add(new Issue(member,"TeamPathy","我們行不行 ? 絕對沒問題 !!! ","議題"));
        issueList.add(new Issue(member,"TeamPathy","我們行不行 ? 絕對沒問題 !!! ","議題"));
        issueList.add(new Issue(member,"TeamPathy","我們行不行 ? 絕對沒問題 !!! ","議題"));
        issueList.add(new Issue(member,"TeamPathy","我們行不行 ? 絕對沒問題 !!! ","議題"));
        issueList.add(new Issue(member,"TeamPathy","我們行不行 ? 絕對沒問題 !!! ","議題"));
        issueList.add(new Issue(member,"TeamPathy","我們行不行 ? 絕對沒問題 !!! ","議題"));
        issueList.add(new Issue(member,"TeamPathy","我們行不行 ? 絕對沒問題 !!! ","議題"));
        issueList.add(new Issue(member,"TeamPathy","我們行不行 ? 絕對沒問題 !!! ","議題"));
        issueList.add(new Issue(member,"TeamPathy","我們行不行 ? 絕對沒問題 !!! ","議題"));
        issueList.add(new Issue(member,"TeamPathy","我們行不行 ? 絕對沒問題 !!! ","議題"));
        issueList.add(new Issue(member,"TeamPathy","我們行不行 ? 絕對沒問題 !!! ","議題"));
        issueList.add(new Issue(member,"TeamPathy","我們行不行 ? 絕對沒問題 !!! ","議題"));
        issueList.add(new Issue(member,"TeamPathy","我們行不行 ? 絕對沒問題 !!! ","議題"));
        issueList.add(new Issue(member,"TeamPathy","我們行不行 ? 絕對沒問題 !!! ","議題"));
        issueList.add(new Issue(member,"TeamPathy","我們行不行 ? 絕對沒問題 !!! ","議題"));
        issueList.add(new Issue(member,"TeamPathy","我們行不行 ? 絕對沒問題 !!! ","議題"));
        issueList.add(new Issue(member,"TeamPathy","我們行不行 ? 絕對沒問題 !!! ","議題"));
        issueList.add(new Issue(member,"TeamPathy","我們行不行 ? 絕對沒問題 !!! ","議題"));
        issueList.add(new Issue(member,"TeamPathy","我們行不行 ? 絕對沒問題 !!! ","議題"));


        return issueList;
    }

    @Override
    public Issue getIssueById(String issueId) throws Exception {
        if (issue == null)
            issue = new Issue(Global.getMemberController().getActiveMember(),"TeamPathy","我們行不行 ? 絕對沒問題 !!! ","議題");
        return issue;
    }

    @Override
    public Issue addIssue(Issue issue) throws Exception {
        issueList.add(issue);
        return issue;
    }

    @Override
    public Issue removeIssue(Issue issue) throws Exception {
        issueList.remove(issue);
        return issue;
    }

    @Override
    public Issue editIssue(Issue issue) throws Exception {
        for (int i = 0 ; i < issueList.size() ; i ++ )
            issueList.set(i,issue.getClone());
        return issue;
    }

    @Override
    public String[] getIssueTypeListByProjectId(String projectId) throws Exception {
        return new String[]{Global.globalResources.getString(R.string.get_all_issue_types),"投票","討論","議題","瞎聊"};
    }


}
