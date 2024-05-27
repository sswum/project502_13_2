package org.choongang.member.controllers;

import org.choongang.global.AbstractController;
import org.choongang.global.constants.Menu;
import org.choongang.template.Templates;

/**
 * 회원 가입 컨트롤러
 */


public class JoinController extends AbstractController { //알트+인서트 눌러서 오버라이딩 show 한 것임
    @Override
    public void show() {

        Templates.getInstance().render(Menu.JOIN);
    }
}
