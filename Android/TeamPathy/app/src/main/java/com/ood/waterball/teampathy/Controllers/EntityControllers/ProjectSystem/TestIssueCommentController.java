package com.ood.waterball.teampathy.Controllers.EntityControllers.ProjectSystem;

import com.ood.waterball.teampathy.Controllers.EntityControllers.EntityController;
import com.ood.waterball.teampathy.DomainModels.Domains.IssueComment;
import com.ood.waterball.teampathy.DomainModels.Domains.Member;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class TestIssueCommentController implements EntityController<IssueComment> {
    private List<IssueComment> issueCommentList;
    @Override
    public IssueComment create(IssueComment issueComment) throws Exception{
        issueCommentList.add(issueComment);
        return issueComment;
    }

    @Override
    public IssueComment read(int id)throws Exception {
        return null;
    }

    @Override
    public List<IssueComment> readList(int id)throws Exception {
        Date now = new Date();
        if ( issueCommentList != null )
            return issueCommentList;
        issueCommentList = new ArrayList<>();
        issueCommentList.add( new IssueComment(new Member("曾韋傑","","",""),"阿是有多閒拉",now));
        issueCommentList.add( new IssueComment(new Member("黃嘉偉","","",""),"白癡 用GoodNight阿",now));
        issueCommentList.add( new IssueComment(new Member("Wang Ning","","",""),"聽說好像可以用url做女搜",now));
        issueCommentList.add( new IssueComment(new Member("黃嘉偉","","",""),"老大 你都用機場附贈杯對吧?",now));
        issueCommentList.add( new IssueComment(new Member("黃嘉偉","","",""),"樓上老大",now));
        issueCommentList.add( new IssueComment(new Member("Wang Ning","","",""),"請問怎麼刪自己的留言?",now));
        issueCommentList.add( new IssueComment(new Member("曾韋傑","","",""),"幹 ",now));
        issueCommentList.add( new IssueComment(new Member("林宗億","","",""),"......被盜抱歉",now));

        return issueCommentList;
    }

    @Override
    public IssueComment update(IssueComment issueComment)throws Exception {
        return null;
    }

    @Override
    public IssueComment delete(IssueComment issueComment)throws Exception {
        return null;
    }
}
