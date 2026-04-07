package kr.co.javaex.sec23.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import kr.co.javaex.sec23.domain.Product;
import kr.co.javaex.sec23.util.ReadIt;

public class ProductPage {

    ReadIt readit = new ReadIt();

    Product[] getAllProducts() {
        Product[] products = readit.readpro();
        if (products == null) {
            return new Product[0];
        }
        return products;
    }

    boolean canShow(Product p)
    {
        return p != null && !p.getState().equals("판매중지");
    }

    List<Product> getVisibleProducts() {
        Product[] products = getAllProducts();
        List<Product> list = new ArrayList<>();

        for (Product p : products) {
            if (canShow(p)) {
                list.add(p);
            }
        }
        return list;
    }

    public void showall() {
        List<Product> list = getVisibleProducts();

        if (list.isEmpty()) {
            System.out.println("조회할 상품이 없습니다.");
            return;
        }

        System.out.println("===== 상품 목록 =====");

        for (int i = 0; i < list.size(); i++) {
            Product p = list.get(i);

            System.out.println("상품번호 : " + p.getpID());
            System.out.println("상품명 : " + p.getName());
            System.out.println("가격 : " + p.getPrice());
            System.out.println("카테고리번호 : " + p.getcID());
            System.out.println("--------------------");
        }
    }

    public void showbycate(int cID) {
        List<Product> list = getVisibleProducts();
        boolean found = false;

        System.out.println("===== 카테고리벌 상품 목록 =====");
        for (Product p : list) {
            if (p.getcID() == cID) {
                System.out.println("상품번호 : " + p.getpID());
                System.out.println("상품명 : " + p.getName());
                System.out.println("가격 : " + p.getPrice());
                System.out.println("카테고리번호 : " + p.getcID());
                System.out.println("--------------------");
                found = true;
            }
        }

        if (!found) {
            System.out.println("해당 카테고리에 상품이 없습니다.");
        }
    }

    public void priceshow() {
        List<Product> list = getVisibleProducts();

        list.sort(Comparator.comparingInt(Product::getPrice));

        if (list.isEmpty()) {
            System.out.println("조회할 상품이 없습니다.");
            return;
        }

        System.out.println("===== 가격순 상품 목록 =====");
        for (Product p : list) {
            System.out.println("상품번호 : " + p.getpID());
            System.out.println("상품명 : " + p.getName());
            System.out.println("가격 : " + p.getPrice());
            System.out.println("--------------------");
        }
    }

    List<Product> searchProducts(String itemname) {
        List<Product> list = getVisibleProducts();
        List<Product> result = new ArrayList<>();

        for (Product p : list) {
            if (p.getName() != null && p.getName().contains(itemname)) {
                result.add(p);
            }
        }

        return result;
    }

    public void showsearch(String keyword) {
        List<Product> result = searchProducts(keyword);

        if (result.isEmpty()) {
            System.out.println("검색 결과가 없습니다.");
            return;
        }

        System.out.println("===== 검색 결과 =====");

        for (int i = 0; i < result.size(); i++) {
            Product p = result.get(i);

            System.out.println("상품번호 : " + p.getpID());
            System.out.println("상품명 : " + p.getName());
            System.out.println("가격 : " + p.getPrice());
            System.out.println("카테고리번호 : " + p.getcID());
            System.out.println("--------------------");
        }
    }
    public Product findById(int pID) {
        List<Product> list = getVisibleProducts();

        for (int i = 0; i < list.size(); i++) {
            Product p = list.get(i);

            if (p.getpID() == pID) {
                return p;
            }
        }

        return null;
    }

    public void showdeep(String name) {
        List<Product> list = getVisibleProducts();

        for (int i = 0; i < list.size(); i++) {
            Product p = list.get(i);

            if (p.getName() != null && p.getName().equals(name)) {
                System.out.println("===== 상품 상세페이지 =====");
                System.out.println("상품번호 : " + p.getpID());
                System.out.println("상품명 : " + p.getName());
                System.out.println("가격 : " + p.getPrice());
                System.out.println("상품설명 : " + p.getEx());
                System.out.println("재고수량 : " + p.getPcs());
                System.out.println("상품상태 : " + p.getState());
                System.out.println("카테고리번호 : " + p.getcID());
                System.out.println("=========================");
                return;
            }
        }

        System.out.println("해당 상품을 찾을 수 없습니다.");
    }
}