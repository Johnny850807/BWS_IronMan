package com.ood.waterball.teampathy.DomainModels.Models;


import com.ood.waterball.teampathy.DomainModels.Domains.Member;
import com.ood.waterball.teampathy.DomainModels.Domains.TodoTask;

public class MemberIdCardModel{
    private Member member;
    private TodoTask todoTask;

    public MemberIdCardModel(){}

    public MemberIdCardModel(Member member,TodoTask todoTask){
        this.member = member;
        this.todoTask = todoTask;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public TodoTask getTodoTask() {
        return todoTask;
    }

    public void setTodoTask(TodoTask todoTask) {
        this.todoTask = todoTask;
    }
}
