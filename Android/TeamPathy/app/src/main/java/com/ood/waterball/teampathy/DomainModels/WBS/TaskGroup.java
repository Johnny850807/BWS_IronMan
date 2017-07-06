package com.ood.waterball.teampathy.DomainModels.WBS;

import com.ood.waterball.teampathy.DomainModels.Domains.TaskEntity;
import com.ood.waterball.teampathy.DomainModels.Domains.TodoTask;

import org.w3c.dom.Node;

import java.util.Date;
import java.util.List;


public class TaskGroup extends TaskEntity implements TaskItem {
	protected List<TodoTask> tasks;

	public TaskGroup(int id, String name, String ofGroupName) {
		super(id, name, ofGroupName);
	}

	public TaskGroup(String name, String ofGroupName) {
		super(name,ofGroupName);
	}

	@Override
	public Date getEndDate() {
		//todo set the end date which the latest end date of child tasks
		return null;
	}

	@Override
	public void setEndDate(Date endDate) {
		throw new RuntimeException();
	}

	@Override
	public Date getStartDate() {
		//todo set the start date which the earliest start date of child tasks
		return null;
	}

	@Override
	public void setStartDate(Date startDate) {
		throw new RuntimeException();
	}

	public String getDescription() {
		return name;
	}

	public void setDescription(String description) {
		throw new RuntimeException();
	}

	@Override
	public int getContributePoint() {
		int sum = 0;
		for (TaskItem taskItem : tasks)
			sum += taskItem.getContributePoint();
		return sum;
	}

	@Override
	public void setContributePoint(int contributePoint) {
		throw new RuntimeException();
	}

	public Node toXmlNode() {  //todo to xml node
		return null;
	}

	public boolean hasChild() {
		return true;
	}

	public void addChild(WbsVisitor visitor) {
		visitor.taskViewOnClick(this);
	}

	public void edit(WbsVisitor visitor) {
		visitor.taskViewOnLongClick(this);
	}

}
