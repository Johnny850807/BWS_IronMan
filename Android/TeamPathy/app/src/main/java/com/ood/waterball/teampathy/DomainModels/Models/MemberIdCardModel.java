package com.ood.waterball.teampathy.DomainModels.Models;


import com.ood.waterball.teampathy.DomainModels.Domains.Member;
import com.ood.waterball.teampathy.DomainModels.Domains.TodoList;

public class MemberIdCardModel {
    private Member member;
    private TodoList todoList;

    public MemberIdCardModel(){}

    public MemberIdCardModel(Member member,TodoList todoList){
        this.member = member;
        this.todoList = todoList;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public TodoList getTodoList() {
        return todoList;
    }

    public void setTodoList(TodoList todoList) {
        this.todoList = todoList;
    }
}
