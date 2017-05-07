package com.ood.waterball.teampathy.Domains;


public enum ProjectSection {
    TIMELINE("動態牆"),FORUM("討論區"),TODOLIST("代辦清單"),OFFICE("辦公室");

    private String name;

    private ProjectSection(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
