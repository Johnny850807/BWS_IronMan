package com.ood.waterball.teampathy.Controllers.EntityControllers.MemberSystem;


import com.ood.waterball.teampathy.Controllers.EntityControllers.MemberSystem.Exceptions.AccountDuplicatedException;
import com.ood.waterball.teampathy.Controllers.EntityControllers.MemberSystem.Exceptions.AccountNotFoundException;
import com.ood.waterball.teampathy.Controllers.EntityControllers.MemberSystem.Exceptions.PasswordNotConformException;
import com.ood.waterball.teampathy.DomainModels.Domains.User;

public abstract class MemberController {
    protected User activeUser;

    public User getActiveUser(){
        return activeUser;
    }

    public abstract void register(User user, String passwordConfirm) throws PasswordNotConformException, AccountDuplicatedException;

    public abstract void logIn(String account,String password) throws AccountNotFoundException;



}
