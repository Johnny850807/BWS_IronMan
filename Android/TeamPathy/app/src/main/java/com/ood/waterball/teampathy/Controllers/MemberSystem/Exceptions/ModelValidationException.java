package com.ood.waterball.teampathy.Controllers.MemberSystem.Exceptions;

import com.ood.waterball.teampathy.R;

import static com.ood.waterball.teampathy.Controllers.Global.globalResources;

public class ModelValidationException extends Exception {

    public ModelValidationException(){
        super(globalResources.getString(R.string.accountNotFound));
    }

    public ModelValidationException(String errorMessage){
        super(errorMessage);
    }

}
