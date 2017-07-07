package com.ood.waterball.teampathy.DomainModels.WBS;

import org.xml.sax.SAXException;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

public abstract class XmlTranslator {

	public abstract String taskToXml(TaskItem taskItem);

	public abstract TaskItem xmlToTasks(String xml) throws ParserConfigurationException, IOException, SAXException;

}
