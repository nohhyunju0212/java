package kr.co.javaex.sec23;

import kr.co.javaex.sec23.controller.MainController;
import kr.co.javaex.sec23.domain.Product;
import kr.co.javaex.sec23.service.CartService;
import kr.co.javaex.sec23.service.MakeAccount;
import kr.co.javaex.sec23.service.ProductOfficial;
import kr.co.javaex.sec23.service.ProductPage;
import kr.co.javaex.sec23.service.Categoriesoffical;
import kr.co.javaex.sec23.util.ReadCart;
import kr.co.javaex.sec23.util.ReadIt;
import kr.co.javaex.sec23.util.ReadUser;

import java.io.UnsupportedEncodingException;
import java.util.Scanner;

public class Ecommerce {

    static Scanner s = new Scanner(System.in);
    static MainController m = new MainController();
    static ProductPage pp = new ProductPage();
    static CartService cs = new CartService();
    static ProductOfficial po = new ProductOfficial();
    static Categoriesoffical co = new Categoriesoffical();

    static void allloop() {
        while (true) {
            m.allview();
            pp.showall();

            System.out.print(": ");
            String ans = s.next();

            if (ans.equals("가격순")) {
                pp.priceshow();

            } else if (ans.equals("검색")) {
                System.out.print("검색어 입력 : ");
                String keyword = s.next();
                pp.showsearch(keyword);

            } else if (ans.equals("뒤로가기")) {
                return;

            } else if (ans.matches("\\d+")) {
                int pID = Integer.parseInt(ans);
                Product p = pp.findById(pID);

                if (p == null) {
                    System.out.println("해당 상품이 없습니다.");
                    continue;
                }

                while (true) {
                    pp.showdeep(p.getName());
                    System.out.println("담기 | 뒤로가기");
                    System.out.print(": ");
                    String cmd = s.next();

                    if (cmd.equals("담기")) {
                        if (!MakeAccount.Ami()) {
                            System.out.println("로그인 후 이용 가능합니다.");
                        } else {
                            cs.addCart(MakeAccount.myid(), p, 1);
                        }

                    } else if (cmd.equals("뒤로가기")) {
                        break;

                    } else {
                        System.out.println("잘못된 입력");
                    }
                }

            } else {
                System.out.println("잘못된 입력");
            }
        }
    }

    static void cartloop() {
        if (!MakeAccount.Ami()) {
            System.out.println("로그인 후 이용 가능합니다.");
            return;
        }

        while (true) {
            m.cartview();
            cs.showCart(MakeAccount.myid());

            System.out.print(": ");
            String ans = s.next();

            if (ans.equals("삭제")) {
                System.out.print("상품번호 : ");
                int pID = s.nextInt();
                cs.deleteItem(MakeAccount.myid(), pID);

            } else if (ans.equals("수량변경")) {
                System.out.print("상품번호 : ");
                int pID = s.nextInt();
                System.out.print("수량 : ");
                int qty = s.nextInt();
                cs.updateQty(MakeAccount.myid(), pID, qty);

            } else if (ans.equals("전체주문")) {
                cs.orderAll(MakeAccount.myid());

            } else if (ans.equals("개별주문")) {
                System.out.print("상품번호 : ");
                int pID = s.nextInt();
                cs.orderOne(MakeAccount.myid(), pID);

            } else if (ans.equals("뒤로가기")) {
                return;

            } else {
                System.out.println("잘못된 입력");
            }
        }
    }

    static void usereditloop() {
        if (!MakeAccount.Ami()) {
            System.out.println("로그인 후 이용 가능합니다.");
            return;
        }

        MakeAccount ma = new MakeAccount();

        while (true) {
            m.useredit();
            System.out.print(": ");
            String ans = s.next();

            if (ans.equals("이름")) {
                ma.rename();

            } else if (ans.equals("비밀번호")) {
                ma.newpassword();

            } else if (ans.equals("전화번호")) {
                ma.rephone();

            } else if (ans.equals("이메일")) {
                ma.reemail();

            } else if (ans.equals("뒤로가기")) {
                return;

            } else {
                System.out.println("잘못된 입력");
            }
        }
    }

    static void userloop() {
        if (!MakeAccount.Ami()) {
            System.out.println("로그인 후 이용 가능합니다.");
            return;
        }

        MakeAccount ma = new MakeAccount();

        while (true) {
            m.usermenu();
            System.out.print(": ");
            String ans = s.next();

            if (ans.equals("수정")) {
                usereditloop();

            } else if (ans.equals("탈퇴")) {
                ma.deleteme();
                return;

            } else if (ans.equals("뒤로가기")) {
                return;

            } else {
                System.out.println("잘못된 입력");
            }
        }
    }

    static void productloop() {
        if (!MakeAccount.Ami() || !MakeAccount.isOfficial()) {
            System.out.println("관리자만 이용 가능합니다.");
            return;
        }

        while (true) {
            m.productmenu();
            System.out.print(": ");
            String ans = s.next();

            if (ans.equals("등록")) {
                po.ceP();

            } else if (ans.equals("수정")) {
                po.edP();

            } else if (ans.equals("삭제")) {
                System.out.println("상품 삭제 기능은 아직 안 만들었습니다.");

            } else if (ans.equals("뒤로가기")) {
                return;

            } else {
                System.out.println("잘못된 입력");
            }
        }
    }
    static void cateloop() {
        if (!MakeAccount.Ami() || !MakeAccount.isOfficial()) {
            System.out.println("관리자만 이용 가능합니다.");
            return;
        }

        while (true) {
            m.catemenu();
            System.out.print(": ");
            String ans = s.next();

            if (ans.equals("등록")) {
                co.newcate();

            } else if (ans.equals("수정")) {
                co.upcate();

            } else if (ans.equals("삭제")) {
                co.delcate();

            } else if (ans.equals("뒤로가기")) {
                return;

            } else {
                System.out.println("잘못된 입력");
            }
        }
    }

    static void adminloop() {
        if (!MakeAccount.Ami() || !MakeAccount.isOfficial()) {
            System.out.println("관리자만 이용 가능합니다.");
            return;
        }

        while (true) {
            m.adminmenu();
            System.out.print(": ");
            String ans = s.next();

            if (ans.equals("상품관리")) {
                productloop();

            } else if (ans.equals("카테고리관리")) {
                cateloop();

            } else if (ans.equals("뒤로가기")) {
                return;

            } else {
                System.out.println("잘못된 입력");
            }
        }
    }

    static void cateviewloop() {
        while (true) {
            m.cateview();
            System.out.print(": ");
            String ans = s.next();

            if (ans.equals("뒤로가기")) {
                return;

            } else if (ans.matches("\\d+")) {
                int cID = Integer.parseInt(ans);
                pp.showbycate(cID);

            } else {
                System.out.println("잘못된 입력");
            }
        }
    }

    static void mainloop() {
        MakeAccount ma = new MakeAccount();

        while (true) {
            if (MakeAccount.Ami()) {
                if (MakeAccount.isOfficial()) {
                    m.adminview();
                } else {
                    m.userview();
                }
            } else {
                m.mainview();
            }

            System.out.print(": ");
            String ans = s.next();

            if (ans.equals("전체")) {
                allloop();

            } else if (ans.equals("카테고리")) {
                cateviewloop();

            } else if (ans.equals("장바구니")) {
                cartloop();

            } else if (ans.equals("회원관리")) {
                userloop();

            } else if (ans.equals("관리")) {
                adminloop();

            } else if (ans.equals("로그인")) {
                ma.loginUser();

            } else if (ans.equals("회원가입")) {
                ma.makeUser();

            } else if (ans.equals("로그아웃")) {
                ma.logoutUser();

            } else if (ans.equals("종료")) {
                System.out.println("프로그램을 종료합니다.");
                return;

            } else {
                System.out.println("잘못된 입력");
            }
        }
    }

    public static void main(String[] args) throws UnsupportedEncodingException {
        System.setOut(new java.io.PrintStream(System.out, true, "UTF-8"));

        ReadIt.createproduct();
        ReadIt.createcategories();
        ReadUser.createUser();
        ReadCart.createCart();

        mainloop();
    }
}