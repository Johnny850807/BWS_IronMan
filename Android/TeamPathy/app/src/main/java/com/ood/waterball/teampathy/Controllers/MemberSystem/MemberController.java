package com.ood.waterball.teampathy.Controllers.MemberSystem;


import com.ood.waterball.teampathy.Domains.Member;

public abstract class MemberController {
    public abstract void logIn(String account,String password);
    public abstract void register(Member member);
}
