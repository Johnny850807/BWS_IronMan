package com.ood.waterball.teampathy.Controllers.MemberSystem;


import com.ood.waterball.teampathy.Controllers.MemberSystem.Exceptions.AccountDuplicatedException;
import com.ood.waterball.teampathy.Controllers.MemberSystem.Exceptions.AccountNotFoundException;
import com.ood.waterball.teampathy.Controllers.MemberSystem.Exceptions.ModelValidationException;
import com.ood.waterball.teampathy.Domains.Member;

public abstract class MemberController {
    protected Member activeMember;

    public abstract void logIn(String account,String password) throws AccountNotFoundException;
    public abstract void register(Member member ,String passwordConfirm) throws ModelValidationException , AccountDuplicatedException;
}
