package kr.co.javaex.sec23.util;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import kr.co.javaex.sec23.domain.Cart;

public class ReadCart {

    static ObjectMapper mapper = new ObjectMapper();
    static File json = new File("src/main/java/kr/co/javaex/sec23/repository/cart.json");

    public static void createCart() {
        try {
            List<Cart> list = new ArrayList<>();
            mapper.writeValue(json, list);

        } catch (Exception e) {
            System.out.println("cart생성이 오류내는 중");
        }
    }

    public Cart[] readcart() {
        try {
            if (!json.exists()) {
                return new Cart[0];
            }
            return mapper.readValue(json, Cart[].class);
        } catch (Exception e) {
            e.printStackTrace();
            return new Cart[0];
        }
    }

    public void savecart(List<Cart> list) {
        try {
            mapper.writeValue(json, list);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}