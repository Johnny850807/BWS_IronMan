package com.ood.waterball.teampathy.Controllers.EntityControllers.ProjectSystem;

import com.ood.waterball.teampathy.Controllers.EntityControllers.EntityController;
import com.ood.waterball.teampathy.Controllers.Global;
import com.ood.waterball.teampathy.DomainModels.Domains.IssueType;
import com.ood.waterball.teampathy.R;

import java.util.ArrayList;
import java.util.List;


public class TestIssueTypeController implements EntityController<IssueType> {
    private List<IssueType> issueTypeList;
    @Override
    public IssueType create(IssueType issueType) throws Exception {
        issueTypeList.add(issueType);
        return issueType;
    }

    @Override
    public IssueType read(int id) throws Exception {
        return null;
    }

    @Override
    public List<IssueType> readList(int id) throws Exception {
        if (issueTypeList != null)
            return issueTypeList;
        issueTypeList = new ArrayList<>();
        issueTypeList.add(new IssueType(Global.resources.getString(R.string.get_all_issue_types)));
        issueTypeList.add(new IssueType("投票"));
        issueTypeList.add(new IssueType("Bug"));
        issueTypeList.add(new IssueType("討論"));
        issueTypeList.add(new IssueType("分享"));
        issueTypeList.add(new IssueType("心得"));
        issueTypeList.add(new IssueType("關鍵!"));
        issueTypeList.add(new IssueType("貢獻"));
        issueTypeList.add(new IssueType("教學"));
        issueTypeList.add(new IssueType("提醒"));
        issueTypeList.add(new IssueType("通知"));
        issueTypeList.add(new IssueType("懲罰"));
        issueTypeList.add(new IssueType("審核"));
        issueTypeList.add(new IssueType("需要更努力"));
        issueTypeList.add(new IssueType("公告"));
        issueTypeList.add(new IssueType("玩笑"));
        return issueTypeList;
    }

    @Override
    public IssueType update(IssueType issueType) throws Exception {
        return null;
    }

    @Override
    public IssueType delete(IssueType issueType) throws Exception {
        return null;
    }
}
