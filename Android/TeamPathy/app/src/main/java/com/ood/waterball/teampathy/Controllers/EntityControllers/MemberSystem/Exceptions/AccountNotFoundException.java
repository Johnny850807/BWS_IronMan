package com.ood.waterball.teampathy.Controllers.EntityControllers.MemberSystem.Exceptions;

import com.ood.waterball.teampathy.R;

import static com.ood.waterball.teampathy.Controllers.Global.resources;


public class AccountNotFoundException extends Exception {

    public AccountNotFoundException(){
        super(resources.getString(R.string.accountNotFound));
    }

}
