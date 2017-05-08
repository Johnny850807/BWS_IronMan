package com.ood.waterball.teampathy.Controllers.EntityControllers;

import java.util.List;

public interface EntityController<T> {
    public T create(T t) throws Exception;
    public T read(String id)throws Exception;
    public List<T> readList(String id)throws Exception;
    public T update(T t)throws Exception;
    public T delete(T t)throws Exception;

    public interface OnFinishListener{
        public void onFinish();
    }
}
