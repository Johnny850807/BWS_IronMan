package com.ood.waterball.teampathy.Controllers.EntityControllers.MemberSystem.Exceptions;

import com.ood.waterball.teampathy.R;

import static com.ood.waterball.teampathy.Controllers.Global.globalResources;
public class AccountDuplicatedException extends Exception {

    public AccountDuplicatedException(){
        super(globalResources.getString(R.string.accountDuplicated));
    }

}
