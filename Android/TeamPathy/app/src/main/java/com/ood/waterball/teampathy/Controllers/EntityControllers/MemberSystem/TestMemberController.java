package com.ood.waterball.teampathy.Controllers.EntityControllers.MemberSystem;

import com.ood.waterball.teampathy.Controllers.EntityControllers.MemberSystem.Exceptions.AccountDuplicatedException;
import com.ood.waterball.teampathy.Controllers.EntityControllers.MemberSystem.Exceptions.AccountNotFoundException;
import com.ood.waterball.teampathy.Controllers.EntityControllers.MemberSystem.Exceptions.PasswordNotConformException;
import com.ood.waterball.teampathy.DomainModels.Domains.Member;


public class TestMemberController extends MemberController {

    private final String TEST_ACCOUNT = "";
    private final String TEST_PASSWORD = "";

    @Override
    public void logIn(String account, String password) throws AccountNotFoundException {

        if (!TEST_ACCOUNT.equals(account) || !TEST_PASSWORD.equals(password))
            throw new AccountNotFoundException();

        activeMember = new Member("Mr. Lin",account,password,"http://i.imgur.com/4wXEKrP.png");
        activeMember.setId(545345345);
    }

    @Override
    public void register(Member member,String passwordConfirm) throws PasswordNotConformException, AccountDuplicatedException {
        validateRegister(member,passwordConfirm);
        activeMember = member;
    }

    private void validateRegister(Member member,String passwordConfirm) throws AccountDuplicatedException, PasswordNotConformException {
        if (member.getAccount().equals(TEST_ACCOUNT))
            throw new AccountDuplicatedException();
        if (!member.getPassword().equals(passwordConfirm))
            throw new PasswordNotConformException();
    }

}
