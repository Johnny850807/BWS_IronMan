package com.ood.waterball.teampathy;

import com.ood.waterball.teampathy.Controllers.Global;
import com.ood.waterball.teampathy.Controllers.MemberSystem.MemberController;
import com.ood.waterball.teampathy.Controllers.MemberSystem.TestMemberController;
import com.ood.waterball.teampathy.Domains.Member;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception{
        Global.init(null);
        Member member = new Member("Waterball","123456","12345");
        MemberController memberController = new TestMemberController();
        memberController.register(member , "12345");

        assertNotNull(memberController.getActiveMember());

        memberController.logIn("12345","12345");

        assertEquals("Waterball",memberController.getActiveMember().getName());
    }
}