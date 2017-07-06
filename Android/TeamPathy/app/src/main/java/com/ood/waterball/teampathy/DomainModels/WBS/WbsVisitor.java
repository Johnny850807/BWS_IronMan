package com.ood.waterball.teampathy.DomainModels.WBS;


public interface WbsVisitor {

	public void taskViewOnClick(TaskGroup TaskGoup);

	public void taskViewOnClick(TodoTask task);

	public void taskViewOnLongClick(TaskGroup TaskGoup);

	public void taskViewOnLongClick(TodoTask task);

}
