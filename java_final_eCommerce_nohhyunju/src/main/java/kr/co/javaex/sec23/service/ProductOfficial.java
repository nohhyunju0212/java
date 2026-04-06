package kr.co.javaex.sec23.service;

import java.util.*;
import kr.co.javaex.sec23.domain.Product;
import kr.co.javaex.sec23.util.ReadIt;

public class ProductOfficial {

    boolean official = true;


    public void ceP() {
        if (!official) return;

        Scanner s = new Scanner(System.in);
        ReadIt read = new ReadIt();

        Product[] pro = read.readpro();
        List<Product> list = new ArrayList<>(Arrays.asList(pro));

        Product np = new Product();

        int id;
        boolean check;


        while (true) {
            check = false;
            System.out.println("상품 pID 입력");
            id = s.nextInt();

            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getpID() == id) {
                    check = true;
                    break;
                }
            }

            if (check) {
                System.out.println("이미 존재하는 pID입니다.");
            } else {
                np.setpID(id);
                break;
            }
        }


        System.out.println("상품 이름 입력");
        String name = s.next();
        np.setName(name);

        System.out.println("가격 입력");
        int price = s.nextInt();
        np.setPrice(price);

        System.out.println("설명 입력");
        String ex = s.next();
        np.setEx(ex);

        System.out.println("재고 수량 입력");
        int pcs = s.nextInt();
        np.setPcs(pcs);

        if (pcs == 0) {
            np.setState("판매중지");
        } else {
            np.setState("정상");
        }

        System.out.println("카테고리 ID 입력");
        int cID = s.nextInt();
        np.setcID(cID);

        list.add(np);
        read.savepro(list);

        System.out.println("상품 등록 완료");
    }

    public void edP() {
        if (!official) return;

        Scanner s = new Scanner(System.in);
        ReadIt read = new ReadIt();

        Product[] pro = read.readpro();
        List<Product> list = new ArrayList<>(Arrays.asList(pro));

        int id;
        Product target = null;

        while (true) {
            System.out.println("수정할 상품 pID 입력");
            id = s.nextInt();

            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getpID() == id) {
                    target = list.get(i);
                    break;
                }
            }

            if (target == null) {
                System.out.println("존재하지 않는 pID입니다.");
            } else {
                break;
            }
        }


        System.out.println("새 이름 입력");
        String name = s.next();
        target.setName(name);

        System.out.println("새 가격 입력");
        int price = s.nextInt();
        target.setPrice(price);

        System.out.println("새 설명 입력");
        String ex = s.next();
        target.setEx(ex);

        System.out.println("새 재고 입력");
        int pcs = s.nextInt();
        target.setPcs(pcs);

        if (pcs == 0) {
            target.setState("판매중지");
        } else {
            target.setState("정상");
        }

        System.out.println("새 카테고리 ID 입력");
        int cID = s.nextInt();
        target.setcID(cID);

        read.savepro(list);
        System.out.println("상품 수정 완료");
    }
}