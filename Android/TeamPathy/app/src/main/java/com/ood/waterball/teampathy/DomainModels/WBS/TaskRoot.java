package com.ood.waterball.teampathy.DomainModels.WBS;

public class TaskRoot extends TaskGroup {

	public TaskRoot(int id, String name, String ofGroupName) {
		super(id, name, ofGroupName);
	}

	public TaskRoot(String name, String ofGroupName) {
		super(name, ofGroupName);
	}

	@Override
	public String getOfGroupName() {
		return "--";
	}
}
