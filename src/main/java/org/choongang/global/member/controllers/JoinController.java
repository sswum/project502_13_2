package org.choongang.global.member.controllers;

import org.choongang.global.AbstractController;

/**
 * 회원 가입 컨트롤러
 */


public class JoinController extends AbstractController { //알트+인서트 눌러서 오버라이딩 show 한 것임
    @Override
    public void show() {
        System.out.println("회원가입!");
    }
}
