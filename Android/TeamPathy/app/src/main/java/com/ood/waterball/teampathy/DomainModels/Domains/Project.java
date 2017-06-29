package com.ood.waterball.teampathy.DomainModels.Domains;


import com.ood.waterball.teampathy.DomainModels.Entity;

public class Project extends Entity {
    public final static String NO_PASSWORD = "";
    private String name;
    private String description;
    private String type;
    private String imageUrl;
    private String password = NO_PASSWORD;

    public Project(int id ,String name,String type,String description,String imageUrl){
        this.id = id;
        this.name = name;
        this.type = type;
        this.description = description;
        this.imageUrl = imageUrl;
    }

    public Project(String name,String type,String description,String imageUrl){
        this.name = name;
        this.type = type;
        this.description = description;
        this.imageUrl = imageUrl;
    }

    public Project(int id ,String name,String type,String description,String imageUrl,String password){
        this(id,name,type,description,imageUrl);
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean hasPassword(){
        return !password.equals(NO_PASSWORD);
    }

    @Override
    public String toString() {
        return String.format("Project name : %s , description : %s" , name , description);
    }
}
