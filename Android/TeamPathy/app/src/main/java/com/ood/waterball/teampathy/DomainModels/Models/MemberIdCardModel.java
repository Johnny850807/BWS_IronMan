package com.ood.waterball.teampathy.DomainModels.Models;


import com.ood.waterball.teampathy.DomainModels.Domains.User;
import com.ood.waterball.teampathy.DomainModels.WBS.TodoTask;

public class MemberIdCardModel{
    private User user;
    private TodoTask todoTask;

    public MemberIdCardModel(){}

    public MemberIdCardModel(User user, TodoTask todoTask){
        this.user = user;
        this.todoTask = todoTask;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public TodoTask getTodoTask() {
        return todoTask;
    }

    public void setTodoTask(TodoTask todoTask) {
        this.todoTask = todoTask;
    }
}
