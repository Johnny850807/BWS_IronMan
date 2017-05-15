package com.ood.waterball.teampathy.Controllers.EntityControllers.ProjectSystem;

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
    public TodoTask read(String id) throws Exception {
        return null;
    }

    @Override
    public List<TodoTask> readList(String id) throws Exception {
        if (todoTaskList != null)
            return todoTaskList;

        todoTaskList = new ArrayList<>();
        todoTaskList.add(new TodoTask("實作","API學習",""));
        todoTaskList.add(new TodoTask("實作","Android介面",""));
        todoTaskList.add(new TodoTask("設計","ER圖設計",""));
        todoTaskList.add(new TodoTask("設計","後端API設計",""));
        todoTaskList.add(new TodoTask("設計","GUI及UX設計",""));
        todoTaskList.add(new TodoTask("設計","系統類別設計",""));
        todoTaskList.add(new TodoTask("設計","報告設計",""));
        todoTaskList.add(new TodoTask("文案","專研初審",""));
        todoTaskList.add(new TodoTask("文案","總審簡報",""));
        todoTaskList.add(new TodoTask("文案","初審文獻審稿",""));
        todoTaskList.add(new TodoTask("實作","API學習",""));
        todoTaskList.add(new TodoTask("實作","Android介面",""));
        todoTaskList.add(new TodoTask("設計","ER圖設計",""));
        todoTaskList.add(new TodoTask("設計","後端API設計",""));
        todoTaskList.add(new TodoTask("設計","GUI及UX設計",""));
        todoTaskList.add(new TodoTask("設計","系統類別設計",""));
        todoTaskList.add(new TodoTask("設計","報告設計",""));
        todoTaskList.add(new TodoTask("文案","專研初審",""));
        todoTaskList.add(new TodoTask("文案","總審簡報",""));
        todoTaskList.add(new TodoTask("文案","初審文獻審稿",""));

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
