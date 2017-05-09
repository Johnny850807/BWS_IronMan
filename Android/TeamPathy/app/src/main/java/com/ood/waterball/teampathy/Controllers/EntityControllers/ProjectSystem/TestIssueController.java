package com.ood.waterball.teampathy.Controllers.EntityControllers.ProjectSystem;


import com.ood.waterball.teampathy.Controllers.EntityControllers.EntityController;
import com.ood.waterball.teampathy.Controllers.Global;
import com.ood.waterball.teampathy.DomainModels.Issue;
import com.ood.waterball.teampathy.DomainModels.Member;
import com.ood.waterball.teampathy.R;

import java.util.ArrayList;
import java.util.List;

public class TestIssueController implements EntityController<Issue>{
    private List<Issue> issueList;
    private Issue issue = new Issue(Global.getMemberController().getActiveMember(),"TeamPathy","我們行不行 ? 絕對沒問題 !!! ","議題");;

    @Override
    public Issue create(Issue issue) throws Exception{
        issueList.add(issue);
        return issue;
    }

    @Override
    public Issue read(String id)throws Exception {
        return issue;
    }

    @Override
    public List<Issue> readList(String id) throws Exception{
        if (issueList != null)
            return issueList;

        Member member = new Member("林宗億-紙箱大王","","","http://i.imgur.com/4wXEKrP.png");

        issueList = new ArrayList<Issue>();
        issueList.add(new Issue(member,"TeamPathy", Global.globalResources.getString(R.string.test_long_string),"議題"));
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
    public Issue update(Issue issue)throws Exception {
        return null;
    }

    @Override
    public Issue delete(Issue issue)throws Exception {
        return null;
    }

    public String[] readIssueTypeList(String id) throws Exception {
        return new String[]{Global.globalResources.getString(R.string.get_all_issue_types),"投票","討論","議題","瞎聊"};
    }
}
