package com.ood.waterball.teampathy.Controllers.EntityControllers.MemberSystem;


import com.ood.waterball.teampathy.Controllers.EntityControllers.MemberSystem.Exceptions.AccountDuplicatedException;
import com.ood.waterball.teampathy.Controllers.EntityControllers.MemberSystem.Exceptions.AccountNotFoundException;
import com.ood.waterball.teampathy.Controllers.EntityControllers.MemberSystem.Exceptions.PasswordNotConformException;
import com.ood.waterball.teampathy.DomainModels.Member;

public abstract class MemberController {
    protected Member activeMember;

    public Member getActiveMember(){
        return activeMember;
    }

    public abstract void register(Member member ,String passwordConfirm) throws PasswordNotConformException, AccountDuplicatedException;

    public abstract void logIn(String account,String password) throws AccountNotFoundException;



}
