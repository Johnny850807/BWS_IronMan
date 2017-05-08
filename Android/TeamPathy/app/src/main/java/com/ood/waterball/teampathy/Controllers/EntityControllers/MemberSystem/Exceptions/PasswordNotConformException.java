package com.ood.waterball.teampathy.Controllers.EntityControllers.MemberSystem.Exceptions;

import com.ood.waterball.teampathy.Controllers.Global;
import com.ood.waterball.teampathy.R;

public class PasswordNotConformException extends Exception {

    public PasswordNotConformException(){
        super(Global.globalResources.getString(R.string.password_not_conform));
    }

}
