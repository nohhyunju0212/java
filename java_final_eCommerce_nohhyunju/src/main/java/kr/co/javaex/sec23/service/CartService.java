package kr.co.javaex.sec23.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import kr.co.javaex.sec23.domain.Cart;
import kr.co.javaex.sec23.domain.Product;
import kr.co.javaex.sec23.util.ReadCart;
import kr.co.javaex.sec23.util.ReadIt;

public class CartService {

    ReadCart rc = new ReadCart();
    ReadIt rp = new ReadIt();

    List<Cart> getList() {
        Cart[] arr = rc.readcart();

        if (arr == null) {
            return new ArrayList<>();
        }

        return new ArrayList<>(Arrays.asList(arr));
    }

    List<Product> getProList() {
        Product[] arr = rp.readpro();

        if (arr == null) {
            return new ArrayList<>();
        }

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
        boolean found = false;

        for (int i = 0; i < list.size(); i++) {
            Cart c = list.get(i);

            if (c.getUserID().equals(userID) && c.getpID() == pID) {
                list.remove(i);
                found = true;
                break;
            }
        }

        if (found) {
            rc.savecart(list);
            System.out.println("삭제 완료");
        } else {
            System.out.println("상품 없음");
        }
    }

    public void clearCart(String userID) {
        List<Cart> list = getList();
        boolean found = false;

        for (int i = list.size() - 1; i >= 0; i--) {
            Cart c = list.get(i);

            if (c.getUserID().equals(userID)) {
                list.remove(i);
                found = true;
            }
        }

        if (found) {
            rc.savecart(list);
            System.out.println("전체 삭제 완료");
        } else {
            System.out.println("장바구니 비어있음");
        }
    }

    public void orderOne(String userID, int pID) {
        List<Cart> cartList = getList();
        List<Product> proList = getProList();

        Cart targetCart = null;
        Product targetPro = null;

        for (Cart c : cartList) {
            if (c.getUserID().equals(userID) && c.getpID() == pID) {
                targetCart = c;
                break;
            }
        }

        if (targetCart == null) {
            System.out.println("상품 없음");
            return;
        }

        for (Product p : proList) {
            if (p.getpID() == pID) {
                targetPro = p;
                break;
            }
        }

        if (targetPro == null) {
            System.out.println("상품 정보 없음");
            return;
        }

        if (targetPro.getPcs() < targetCart.getQty()) {
            System.out.println("재고 부족");
            return;
        }

        targetPro.setPcs(targetPro.getPcs() - targetCart.getQty());

        if (targetPro.getPcs() == 0) {
            targetPro.setState("판매중지");
        } else {
            targetPro.setState("정상");
        }

        cartList.remove(targetCart);

        rp.savepro(proList);
        rc.savecart(cartList);

        System.out.println("주문 완료 : " + targetCart.getName());
        System.out.println("해당 상품 장바구니에서 삭제 완료");
    }

    public void orderAll(String userID) {
        List<Cart> cartList = getList();
        List<Product> proList = getProList();
        List<Cart> mine = new ArrayList<>();

        for (Cart c : cartList) {
            if (c.getUserID().equals(userID)) {
                mine.add(c);
            }
        }

        if (mine.isEmpty()) {
            System.out.println("장바구니 비어있음");
            return;
        }

        for (Cart c : mine) {
            Product targetPro = null;

            for (Product p : proList) {
                if (p.getpID() == c.getpID()) {
                    targetPro = p;
                    break;
                }
            }

            if (targetPro == null) {
                System.out.println("상품 정보 없음 : " + c.getName());
                return;
            }

            if (targetPro.getPcs() < c.getQty()) {
                System.out.println("재고 부족 : " + c.getName());
                return;
            }
        }

        for (Cart c : mine) {
            for (Product p : proList) {
                if (p.getpID() == c.getpID()) {
                    p.setPcs(p.getPcs() - c.getQty());

                    if (p.getPcs() == 0) {
                        p.setState("판매중지");
                    } else {
                        p.setState("정상");
                    }

                    System.out.println("주문 완료 : " + c.getName());
                    break;
                }
            }
        }

        for (int i = cartList.size() - 1; i >= 0; i--) {
            Cart c = cartList.get(i);

            if (c.getUserID().equals(userID)) {
                cartList.remove(i);
            }
        }

        rp.savepro(proList);
        rc.savecart(cartList);

        System.out.println("전체 주문 완");
    }
}