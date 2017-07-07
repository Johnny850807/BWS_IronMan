package com.ood.waterball.teampathy.DomainModels.WBS;

public abstract class XmlTranslator {

	public abstract String taskToXml(TaskItem taskItem) throws Exception;

	public abstract TaskItem xmlToTasks(String xml) throws Exception;

}
