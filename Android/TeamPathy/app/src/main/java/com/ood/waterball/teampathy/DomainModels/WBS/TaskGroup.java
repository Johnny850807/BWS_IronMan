package com.ood.waterball.teampathy.DomainModels.WBS;

import com.ood.waterball.teampathy.DomainModels.Domains.TaskEntity;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class TaskGroup extends TaskEntity implements TaskItem {
	protected List<TaskItem> taskList = new ArrayList<>();

	public TaskGroup(int id,String ofGroupName,String name) {
		super(id, ofGroupName,name );
	}

	public TaskGroup(String ofGroupName ,String name ) {
		super(ofGroupName,name);
	}

	@Override
	public List<TaskItem> toList() {
		List<TaskItem> list = new ArrayList<>();
        list.add(this);
        for ( TaskItem taskItem : taskList )
			list.addAll(taskItem.toList());
		return list;
	}

	@Override
	public void addTaskChild(TaskItem taskItem) {
		taskItem.setDegree(getDegree() + 1);
		taskList.add(taskItem);
	}

	@Override
	public void setDegree(int degree) {
		this.degree = degree;
		for (TaskItem taskItem : taskList)
			taskItem.setDegree(taskItem.getDegree() + degree);
	}

	@Override
	public Date getEndDate() {
		//todo set the end date which the latest end date of child taskList
		return null;
	}

	@Override
	public void setEndDate(Date endDate) {
		throw new RuntimeException("Not Supported.");
	}

	@Override
	public Date getStartDate() {
		//todo set the start date which the earliest start date of child taskList
		return null;
	}

	@Override
	public void setStartDate(Date startDate) {
		throw new RuntimeException("Not Supported.");
	}

	public String getDescription() {
		return name;
	}

	public void setDescription(String description) {
		throw new RuntimeException("Not Supported.");
	}

	@Override
	public int getContributePoint() {
		int sum = 0;
		for (TaskItem taskItem : taskList)
			sum += taskItem.getContributePoint();
		return sum;
	}

	@Override
	public void setContributePoint(int contributePoint) {
		throw new RuntimeException();
	}

	public Node toXmlNode(Document document) {
        Element element = document.createElement(XmlTranslatorImp.TASK_GROUP_NAME);
        element.setAttribute(XmlTranslatorImp.NAME_ATT,name);
        for (TaskItem taskItem : taskList)
            element.appendChild(taskItem.toXmlNode(document));
		return element;
	}

	public boolean hasChild() {
		return true;
	}

	public void onClick(WbsVisitor visitor) {
		visitor.taskViewOnClick(this);
	}

	public void onLongClick(WbsVisitor visitor) {
		visitor.taskViewOnLongClick(this);
	}

}
