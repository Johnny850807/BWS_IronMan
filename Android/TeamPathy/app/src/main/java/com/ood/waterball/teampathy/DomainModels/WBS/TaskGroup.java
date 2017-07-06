package com.ood.waterball.teampathy.DomainModels.WBS;

import com.ood.waterball.teampathy.DomainModels.Domains.TaskEntity;

import org.w3c.dom.Node;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
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

	public Node toXmlNode() {  //todo to xml node
		return null;
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

	@Override
	public Iterator<TaskItem> iterator() {
		return new MyIterator();
	}

	private class MyIterator implements Iterator<TaskItem>{
		boolean visited = false;
		int index = 0;
		List<Iterator<TaskItem>> iteratorList = new ArrayList<>();

		@Override
		public boolean hasNext() {
			return !visited || index < taskList.size() - 1;  // if index less than the size means still have child tasks not visited.
		}

		@Override
		public TaskItem next() {
			if (!visited){
				visited = true;  //return self node if not visited
				return TaskGroup.this;
			}

			Iterator<TaskItem> iterator = findCurrentIterator();
			if (!iterator.hasNext())
			{
				index ++;
				iterator = findCurrentIterator();
			}
			return iterator.next();
		}

		private Iterator<TaskItem> findCurrentIterator(){
			Iterator<TaskItem> iterator;
			if (index == iteratorList.size())
			{
				iterator = taskList.get(index).iterator();
				iteratorList.add(iterator);
			}
			else
				iterator = iteratorList.get(index);
			return iterator;

		}
	}

}
