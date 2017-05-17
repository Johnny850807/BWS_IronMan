package com.ood.waterball.teampathy.Controllers.EntityControllers.ProjectSystem;


import com.ood.waterball.teampathy.Controllers.EntityControllers.EntityController;
import com.ood.waterball.teampathy.Controllers.Global;
import com.ood.waterball.teampathy.DomainModels.Domains.Issue;
import com.ood.waterball.teampathy.DomainModels.Domains.IssueType;
import com.ood.waterball.teampathy.DomainModels.Domains.Member;
import com.ood.waterball.teampathy.R;

import java.util.ArrayList;
import java.util.List;

public class TestIssueController implements EntityController<Issue>{
    private List<Issue> issueList;
    private Issue issue = new Issue(Global.getMemberController().getActiveMember(),"TeamPathy","我們行不行 ? 絕對沒問題 !!! ",new IssueType("議題"));

    @Override
    public Issue create(Issue issue) throws Exception{
        issueList.add(issue);
        return issue;
    }

    @Override
    public Issue read(int id)throws Exception {
        return issue;
    }

    @Override
    public List<Issue> readList(int id) throws Exception{
        if (issueList != null)
            return issueList;

        Member member = new Member("林宗億-紙箱大王","","","http://i.imgur.com/4wXEKrP.png");

        issueList = new ArrayList<Issue>();
        issueList.add(new Issue(member,"WooTalk很爛", Global.resources.getString(R.string.test_long_string),new IssueType("議題")));
        issueList.add(new Issue(member,"班會有學分嗎?","如題，班會有學分??",new IssueType("討論")));
        issueList.add(new Issue(member,"TeamPathy","我們行不行 ? 絕對沒問題 !!! ",new IssueType("議題")));
        issueList.add(new Issue(member,"TeamPathy","我們行不行 ? 絕對沒問題 !!! ",new IssueType("議題")));
        issueList.add(new Issue(member,"TeamPathy","我們行不行 ? 絕對沒問題 !!! ",new IssueType("議題")));
        issueList.add(new Issue(member,"TeamPathy","我們行不行 ? 絕對沒問題 !!! ",new IssueType("議題")));
        issueList.add(new Issue(member,"TeamPathy","我們行不行 ? 絕對沒問題 !!! ",new IssueType("議題")));
        issueList.add(new Issue(member,"TeamPathy","我們行不行 ? 絕對沒問題 !!! ",new IssueType("議題")));
        issueList.add(new Issue(member,"TeamPathy","我們行不行 ? 絕對沒問題 !!! ",new IssueType("議題")));
        issueList.add(new Issue(member,"TeamPathy","我們行不行 ? 絕對沒問題 !!! ",new IssueType("議題")));
        issueList.add(new Issue(member,"TeamPathy","我們行不行 ? 絕對沒問題 !!! ",new IssueType("議題")));
        issueList.add(new Issue(member,"TeamPathy","我們行不行 ? 絕對沒問題 !!! ",new IssueType("議題")));
        issueList.add(new Issue(member,"TeamPathy","我們行不行 ? 絕對沒問題 !!! ",new IssueType("議題")));
        issueList.add(new Issue(member,"TeamPathy","我們行不行 ? 絕對沒問題 !!! ",new IssueType("議題")));
        issueList.add(new Issue(member,"TeamPathy","我們行不行 ? 絕對沒問題 !!! ",new IssueType("議題")));
        issueList.add(new Issue(member,"TeamPathy","我們行不行 ? 絕對沒問題 !!! ",new IssueType("議題")));
        issueList.add(new Issue(member,"TeamPathy","我們行不行 ? 絕對沒問題 !!! ",new IssueType("議題")));
        issueList.add(new Issue(member,"TeamPathy","我們行不行 ? 絕對沒問題 !!! ",new IssueType("議題")));
        issueList.add(new Issue(member,"TeamPathy","我們行不行 ? 絕對沒問題 !!! ",new IssueType("議題")));
        issueList.add(new Issue(member,"TeamPathy","我們行不行 ? 絕對沒問題 !!! ",new IssueType("議題")));
        issueList.add(new Issue(member,"TeamPathy","我們行不行 ? 絕對沒問題 !!! ",new IssueType("議題")));
        issueList.add(new Issue(member,"TeamPathy","我們行不行 ? 絕對沒問題 !!! ",new IssueType("議題")));
        issueList.add(new Issue(member,"TeamPathy","我們行不行 ? 絕對沒問題 !!! ",new IssueType("議題")));
        issueList.add(new Issue(member,"TeamPathy","我們行不行 ? 絕對沒問題 !!! ",new IssueType("議題")));
        issueList.add(new Issue(member,"TeamPathy","我們行不行 ? 絕對沒問題 !!! ",new IssueType("議題")));
        issueList.add(new Issue(member,"TeamPathy","我們行不行 ? 絕對沒問題 !!! ",new IssueType("議題")));
        issueList.add(new Issue(member,"TeamPathy","我們行不行 ? 絕對沒問題 !!! ",new IssueType("議題")));
        issueList.add(new Issue(member,"TeamPathy","我們行不行 ? 絕對沒問題 !!! ",new IssueType("議題")));
        issueList.add(new Issue(member,"TeamPathy","我們行不行 ? 絕對沒問題 !!! ",new IssueType("議題")));
        issueList.add(new Issue(member,"TeamPathy","我們行不行 ? 絕對沒問題 !!! ",new IssueType("議題")));
        issueList.add(new Issue(member,"TeamPathy","我們行不行 ? 絕對沒問題 !!! ",new IssueType("議題")));
        issueList.add(new Issue(member,"TeamPathy","我們行不行 ? 絕對沒問題 !!! ",new IssueType("議題")));
        issueList.add(new Issue(member,"TeamPathy","我們行不行 ? 絕對沒問題 !!! ",new IssueType("議題")));
        issueList.add(new Issue(member,"TeamPathy","我們行不行 ? 絕對沒問題 !!! ",new IssueType("議題")));
        issueList.add(new Issue(member,"TeamPathy","我們行不行 ? 絕對沒問題 !!! ",new IssueType("議題")));
        issueList.add(new Issue(member,"TeamPathy","我們行不行 ? 絕對沒問題 !!! ",new IssueType("議題")));
        issueList.add(new Issue(member,"TeamPathy","我們行不行 ? 絕對沒問題 !!! ",new IssueType("議題")));
        issueList.add(new Issue(member,"TeamPathy","我們行不行 ? 絕對沒問題 !!! ",new IssueType("議題")));

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
        return new String[]{Global.resources.getString(R.string.get_all_issue_types),"投票","討論","議題","瞎聊"};
    }
}
