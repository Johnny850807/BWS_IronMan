package com.ood.waterball.teampathy.Controllers.EntityControllers.ProjectSystem.Test;

import com.ood.waterball.teampathy.Controllers.EntityControllers.EntityController;
import com.ood.waterball.teampathy.DomainModels.Domains.TodoTask;

import java.util.ArrayList;
import java.util.List;


public class TestTodoTaskController implements EntityController<TodoTask> {
    private List<TodoTask> todoTaskList;
    @Override
    public TodoTask create(TodoTask todoTask) throws Exception {
        return null;
    }

    @Override
    public TodoTask read(int id) throws Exception {
        return null;
    }

    @Override
    public List<TodoTask> readList(int id) throws Exception {
        if (todoTaskList != null)
            return todoTaskList;

        todoTaskList = new ArrayList<>();
        todoTaskList.add(new TodoTask(1,"實作","API學習",""));
        todoTaskList.add(new TodoTask(2,"實作","Android介面",""));
        todoTaskList.add(new TodoTask(3,"設計","ER圖設計",""));
        todoTaskList.add(new TodoTask(4,"設計","後端API設計",""));
        todoTaskList.add(new TodoTask(5,"設計","GUI及UX設計",""));
        todoTaskList.add(new TodoTask(6,"設計","系統類別設計",""));
        todoTaskList.add(new TodoTask(7,"設計","報告設計",""));
        todoTaskList.add(new TodoTask(8,"文案","專研初審",""));
        todoTaskList.add(new TodoTask(9,"文案","總審簡報",""));
        todoTaskList.add(new TodoTask(10,"文案","初審文獻審稿",""));
        todoTaskList.add(new TodoTask(11,"實作","API學習",""));
        todoTaskList.add(new TodoTask(12,"實作","Android介面",""));
        todoTaskList.add(new TodoTask(13,"設計","ER圖設計",""));
        todoTaskList.add(new TodoTask(14,"設計","後端API設計",""));
        todoTaskList.add(new TodoTask(15,"設計","GUI及UX設計",""));
        todoTaskList.add(new TodoTask(16,"設計","系統類別設計",""));
        todoTaskList.add(new TodoTask(17,"設計","報告設計",""));
        todoTaskList.add(new TodoTask(18,"文案","專研初審",""));
        todoTaskList.add(new TodoTask(19,"文案","總審簡報",""));
        todoTaskList.add(new TodoTask(20,"文案","初審文獻審稿",""));

        return todoTaskList;
    }

    @Override
    public TodoTask update(TodoTask todoTask) throws Exception {
        return null;
    }

    @Override
    public TodoTask delete(TodoTask todoTask) throws Exception {
        return null;
    }
}
