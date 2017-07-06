package com.ood.waterball.teampathy.DomainModels.WBS;


import com.ood.waterball.teampathy.DomainModels.Domains.TodoTask;

public abstract class WbsVisitor {

	public abstract void taskViewOnClick(TaskGroup TaskGoup);

	public abstract void taskViewOnClick(TodoTask task);

	public abstract void taskViewOnLongClick(TaskGroup TaskGoup);

	public abstract void taskViewOnLongClick(TodoTask task);

}
