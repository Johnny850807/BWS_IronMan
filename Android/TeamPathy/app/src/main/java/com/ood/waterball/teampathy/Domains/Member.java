package com.ood.waterball.teampathy.Domains;


import com.ood.waterball.teampathy.Controllers.Global;

public class Member extends Entity{
    private String name;
    private String account;
    private String password;
    private String imageUrl;

    public Member(){}

    public Member(String name,String account,String password,String imageUrl){
        this.name = name;
        this.account = account;
        this.password = password;
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }


}
