package com.ood.waterball.teampathy.DomainModels.WBS;

public abstract class XmlTranslator {

	public abstract String taskToXml(TaskRoot taskRoot);

	public abstract TaskRoot xmlToTasks();

}
