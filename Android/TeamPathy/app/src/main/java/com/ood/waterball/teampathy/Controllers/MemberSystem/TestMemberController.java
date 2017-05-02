package com.ood.waterball.teampathy.Controllers.MemberSystem;

import com.ood.waterball.teampathy.Controllers.MemberSystem.Exceptions.AccountDuplicatedException;
import com.ood.waterball.teampathy.Controllers.MemberSystem.Exceptions.AccountNotFoundException;
import com.ood.waterball.teampathy.Controllers.MemberSystem.Exceptions.ModelValidationException;
import com.ood.waterball.teampathy.Domains.Member;


public class TestMemberController extends MemberController {

    private final String TEST_ACCOUNT = "12345";
    private final String TEST_PASSWORD = "12345";

    @Override
    public void logIn(String account, String password) throws AccountNotFoundException {

        if (!TEST_ACCOUNT.equals(account) || !TEST_PASSWORD.equals(password))
            throw new AccountNotFoundException();

        activeMember = new Member("Waterball",account,password);
        activeMember.setId("sada564a56sd4as6d4a5s6d465as");
    }

    @Override
    public void register(Member member,String passwordConfirm) throws ModelValidationException, AccountDuplicatedException {

        if (member.getAccount().equals(TEST_ACCOUNT))
            throw new AccountDuplicatedException();
        if (!checkModelAvailable(member,passwordConfirm))
            throw new ModelValidationException();

        activeMember = member;
    }

    public boolean checkModelAvailable(Member member,String passwordConfirm){
        if (member.getAccount().length() < 5)
            return false;
        if (member.getPassword().length() < 5)
            return false;
        if (!member.getPassword().equals(passwordConfirm))
            return false;
        if (member.getName().length() < 5)
            return false;
        return true;
    }

}
