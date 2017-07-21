package com.ood.waterball.teampathy.Controllers.EntityControllers.MemberSystem;

import com.ood.waterball.teampathy.Controllers.EntityControllers.MemberSystem.Exceptions.AccountDuplicatedException;
import com.ood.waterball.teampathy.Controllers.EntityControllers.MemberSystem.Exceptions.AccountNotFoundException;
import com.ood.waterball.teampathy.Controllers.EntityControllers.MemberSystem.Exceptions.PasswordNotConformException;
import com.ood.waterball.teampathy.DomainModels.Domains.User;


public class TestMemberController extends MemberController {

    private final String TEST_ACCOUNT = "";
    private final String TEST_PASSWORD = "";

    @Override
    public void logIn(String account, String password) throws AccountNotFoundException {

        if (!TEST_ACCOUNT.equals(account) || !TEST_PASSWORD.equals(password))
            throw new AccountNotFoundException();

        activeUser = new User("Mr. Lin",account,password,"http://i.imgur.com/4wXEKrP.png");
        activeUser.setId(545345345);
    }

    @Override
    public void register(User user, String passwordConfirm) throws PasswordNotConformException, AccountDuplicatedException {
        validateRegister(user,passwordConfirm);
        activeUser = user;
    }

    private void validateRegister(User user, String passwordConfirm) throws AccountDuplicatedException, PasswordNotConformException {
        if (user.getAccount().equals(TEST_ACCOUNT))
            throw new AccountDuplicatedException();
        if (!user.getPassword().equals(passwordConfirm))
            throw new PasswordNotConformException();
    }

}
