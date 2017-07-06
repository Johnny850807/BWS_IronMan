package com.ood.waterball.teampathy.DomainModels.WBS;

public class TaskRoot extends TaskGroup {

	public TaskRoot(int id, String name) {
		super(id, "--", name);
        degree = 0;
	}

	public TaskRoot(String name) {
		super("--", name);
        degree = 0;
	}

	@Override
	public String getOfGroupName() {
		return "--";
	}

    @Override
    public int getDegree() {
        return 0;
    }
}
