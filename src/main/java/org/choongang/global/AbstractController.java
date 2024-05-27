package org.choongang.global;

import org.choongang.global.constants.Menu;
import org.choongang.main.MainRouter;

import java.util.Scanner;

public abstract class AbstractController implements Controller {

    protected Scanner sc;

    public AbstractController() {
        sc= new Scanner(System.in); //메뉴입력 버튼 만듦
    }

    //템플릿 메서드 추가

    /**
     * 상당 공통 출력 부분
     */
    public void common() {
        System.out.println("학생관리 프로그램 Ver1.0");
        System.out.println("------------------------------------");
    }

    /**
     * 입력 항목
     *  -문자 : q, exit, quit -종료
     *  -숫자 :메뉴 항목
     */
    public void prompt() {
        System.out.print("메뉴 선택: ");
        String menu = sc.nextLine();
        if(menu.equals("q") || menu.equals("quit")|| menu.equals("exit")) {
            System.exit(0); // 0: 정상 종료 ,1: 비정상 종료
        }
        try {
            int m = Integer.parseInt(menu);
            change(m);      //메뉴 변경 숫자를 입력하면 메뉴를 변경하도록
        } catch (Exception e) {
            System.out.println("메뉴는 숫자로 입력하세요.");
        }
    }

    /**
     * 템플릿 메서드 패턴: 특정 절차가 고정되어 있는 경우
     */

    @Override
    public final void run() {  //(절차에 의해서 )순서대로 진행할 수 있는 템플릿 메서드 만든다.
                                //바뀌지 않아야 해서 final을 넣었다.
        common();
        show();
        prompt();
    }

    private void change(int menuNo) {
        Menu menu = null;
        switch (menuNo) {
            case 1: menu = Menu.JOIN; break; // 회원가입  메뉴에다가 메뉴.join 이넘상수를 넣고 브레이크로 멈춤
            case 2: menu = Menu.LOGIN; break; //로그인
            default: menu = Menu.MAIN; // 메인메뉴로 초기페이지로 가기
        }

        //메뉴 컨트롤러 변경 처리 -Router  // 싱글톤을 한것임.
        MainRouter.getInstance().change(menu);
    }
}
