package kr.co.javaex.sec23.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import kr.co.javaex.sec23.domain.Cart;
import kr.co.javaex.sec23.domain.Product;
import kr.co.javaex.sec23.util.ReadCart;

public class CartService {

    ReadCart rc = new ReadCart();

    List<Cart> getList() {
        Cart[] arr = rc.readcart();
        return new ArrayList<>(Arrays.asList(arr));
    }

    int getNextID(List<Cart> list) {
        int max = 0;
        for (Cart c : list) {
            if (c.getCartID() > max) {
                max = c.getCartID();
            }
        }
        return max + 1;
    }

    public void addCart(String userID, Product p, int qty) {
        List<Cart> list = getList();

        for (Cart c : list) {
            if (c.getUserID().equals(userID) && c.getpID() == p.getpID()) {
                c.setQty(c.getQty() + qty);
                rc.savecart(list);
                System.out.println("수량 증가");
                return;
            }
        }

        Cart item = new Cart(
                getNextID(list),
                userID,
                p.getpID(),
                p.getName(),
                p.getPrice(),
                qty
        );

        list.add(item);
        rc.savecart(list);
        System.out.println("장바구니 추가 완료");
    }

    public void showCart(String userID) {
        List<Cart> list = getList();
        boolean found = false;

        System.out.println("===== 장바구니 =====");

        for (Cart c : list) {
            if (c.getUserID().equals(userID)) {
                System.out.println("상품번호 : " + c.getpID());
                System.out.println("상품명 : " + c.getName());
                System.out.println("가격 : " + c.getPrice());
                System.out.println("수량 : " + c.getQty());
                System.out.println("----------------");
                found = true;
            }
        }

        if (!found) {
            System.out.println("비어있음");
        }
    }

    public void updateQty(String userID, int pID, int qty) {
        List<Cart> list = getList();

        for (Cart c : list) {
            if (c.getUserID().equals(userID) && c.getpID() == pID) {
                c.setQty(qty);
                rc.savecart(list);
                System.out.println("수량 변경 완료");
                return;
            }
        }

        System.out.println("상품 없음");
    }

    public void deleteItem(String userID, int pID) {
        List<Cart> list = getList();

        list.removeIf(c -> c.getUserID().equals(userID) && c.getpID() == pID);

        rc.savecart(list);
        System.out.println("삭제 완료");
    }

    public void clearCart(String userID) {
        List<Cart> list = getList();

        list.removeIf(c -> c.getUserID().equals(userID));

        rc.savecart(list);
        System.out.println("전체 삭제 완료");
    }

    public void orderOne(String userID, int pID) {
        List<Cart> list = getList();

        for (Cart c : list) {
            if (c.getUserID().equals(userID) && c.getpID() == pID) {
                System.out.println("주문 완료 : " + c.getName());
                return;
            }
        }

        System.out.println("상품 없음");
    }

    public void orderAll(String userID) {
        List<Cart> list = getList();
        boolean found = false;

        for (Cart c : list) {
            if (c.getUserID().equals(userID)) {
                System.out.println("주문 완료 : " + c.getName());
                found = true;
            }
        }

        if (!found) {
            System.out.println("장바구니 비어있음");
        }
    }
}