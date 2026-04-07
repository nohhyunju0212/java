package kr.co.javaex.sec23.controller;

public class MainController {

    public void mainview() {
        System.out.println("======================================================");
        System.out.println("                    H주얼리 웹사이트                    ");
        System.out.println("======================================================");
        System.out.println(" 전체 | 카테고리 | 로그인 | 회원가입 | 종료 ");
    }

    public void userview() {
        System.out.println("======================================================");
        System.out.println("                    H주얼리 웹사이트                    ");
        System.out.println("======================================================");
        System.out.println(" 전체 | 카테고리 | 장바구니 | 회원관리 | 로그아웃 | 종료 ");
    }

    public void adminview() {
        System.out.println("======================================================");
        System.out.println("                    H주얼리 웹사이트                    ");
        System.out.println("======================================================");
        System.out.println(" 전체 | 카테고리 | 관리 | 회원관리 | 로그아웃 | 종료 ");
    }

    public void allview() {
        System.out.println("======================================================");
        System.out.println("                    H주얼리 전체상품                    ");
        System.out.println("======================================================");
        System.out.println(" 가격순 | 검색 | 뒤로가기 | 상품번호입력 ");
    }

    public void cartview() {
        System.out.println("======================================================");
        System.out.println("                        장바구니                        ");
        System.out.println("======================================================");
        System.out.println(" 삭제 | 수량변경 | 개별주문 | 전체주문 | 뒤로가기 ");
    }

    public void adminmenu() {
        System.out.println("======================================================");
        System.out.println("                       관리자 기능                       ");
        System.out.println("======================================================");
        System.out.println(" 상품관리 | 카테고리관리 | 뒤로가기 ");
    }

    public void productmenu() {
        System.out.println("======================================================");
        System.out.println("                        상품 관리                        ");
        System.out.println("======================================================");
        System.out.println(" 등록 | 수정 | 삭제 | 뒤로가기 ");
    }

    public void catemenu() {
        System.out.println("======================================================");
        System.out.println("                      카테고리 관리                      ");
        System.out.println("======================================================");
        System.out.println(" 등록 | 수정 | 삭제 | 뒤로가기 ");
    }

    public void usermenu() {
        System.out.println("======================================================");
        System.out.println("                        회원 관리                        ");
        System.out.println("======================================================");
        System.out.println(" 수정 | 탈퇴 | 뒤로가기 ");
    }

    public void useredit() {
        System.out.println("======================================================");
        System.out.println("                      회원정보 수정                      ");
        System.out.println("======================================================");
        System.out.println(" 이름 | 비밀번호 | 전화번호 | 이메일 | 뒤로가기 ");
    }

    public void cateview() {
        System.out.println("======================================================");
        System.out.println("                      카테고리 페이지                     ");
        System.out.println("======================================================");
        System.out.println(" 카테고리번호입력 | 뒤로가기 ");
    }
}