package kr.co.javaex.sec23.util;

import java.io.File;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import kr.co.javaex.sec23.domain.Cart;

public class ReadCart {

    static ObjectMapper mapper = new ObjectMapper();
    static File file = new File("carts.json");

    public Cart[] readcart() {
        try {
            if (!file.exists()) {
                return new Cart[0];
            }
            return mapper.readValue(file, Cart[].class);
        } catch (Exception e) {
            e.printStackTrace();
            return new Cart[0];
        }
    }

    public void savecart(List<Cart> list) {
        try {
            mapper.writeValue(file, list);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}