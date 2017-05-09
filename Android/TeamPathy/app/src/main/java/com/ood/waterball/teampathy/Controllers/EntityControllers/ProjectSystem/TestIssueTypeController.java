package com.ood.waterball.teampathy.Controllers.EntityControllers.ProjectSystem;

import com.ood.waterball.teampathy.Controllers.EntityControllers.EntityController;
import com.ood.waterball.teampathy.DomainModels.Domains.IssueType;

import java.util.ArrayList;
import java.util.List;


public class TestIssueTypeController implements EntityController<IssueType> {
    private List<IssueType> issueTypeList = new ArrayList<>();
    @Override
    public IssueType create(IssueType issueType) throws Exception {
        issueTypeList.add(issueType);
        return issueType;
    }

    @Override
    public IssueType read(String id) throws Exception {
        return null;
    }

    @Override
    public List<IssueType> readList(String id) throws Exception {
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
