package org.choongang.member.controllers;

import org.choongang.global.AbstractController;
import org.choongang.global.constants.Menu;
import org.choongang.main.MainRouter;
import org.choongang.template.Templates;

import java.util.function.Predicate;

/**
 * 회원 가입 컨트롤러
 */


public class JoinController extends AbstractController { //알트+인서트 눌러서 오버라이딩 show 한 것임


    @Override
    public void show() {

        Templates.getInstance().render(Menu.JOIN);
    }

    @Override
    public void prompt() {  //prompt를 재정의해서 아이디내용을 바꿀 수 있다.
        String userId = promptWithValidation("아이디(6자리 이상): " ,
                s -> s.length()>=6);
        String userPw = promptWithValidation("비밀번호(8자리 이상): ",
                s-> s.length()>=8);

        String confirmPw =promptWithValidation("비밀번호 확인: ", s->
        {
            boolean match = s.equals(userPw);
            if (!match) {
                System.err.println("\n비밀번호가 일치하지 않습니다.");
            }
            return match;
        });

        String userNm = promptWithValidation("회원명 : ", s -> !s.isBlank());

        RequestJoin form = RequestJoin.builder()
                .userId(userId)
                .userPw(userPw)
                .confirmPw(confirmPw)
                .userNm(userNm)
                .build();

        //회원 가입 처리...
        System.out.println(form);

        //회원 가입 성공 시 -> 로그인 화면 이동

        MainRouter.getInstance().change(Menu.LOGIN);



    }

}
