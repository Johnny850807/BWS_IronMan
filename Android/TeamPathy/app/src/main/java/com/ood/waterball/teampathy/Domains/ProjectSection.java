package com.ood.waterball.teampathy.Domains;


public enum ProjectSection {
    FORUM("討論區"),TODOLIST("代辦清單"),WORK_ANALYSIS("工作分析"),OFFICE("辦公室");

    private String name;

    private ProjectSection(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
