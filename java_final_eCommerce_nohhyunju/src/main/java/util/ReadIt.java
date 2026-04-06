package util;
import java.util.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import domain.Categorie;
import domain.Product;

import java.io.File;


public class ReadIt {
    static ObjectMapper mapper = new ObjectMapper();
    static File json = new File("C:/Users/kopo441/Desktop/test/Javaproject/java_final_eCommerce_nohhyunju/src/main/java/repository/categories.json");
    static File jsonp = new File("C:/Users/kopo441/Desktop/test/Javaproject/java_final_eCommerce_nohhyunju/src/main/java/repository/products.json");

    public static void createcategories() {
        try {
            List<Categorie> list = new ArrayList<>();

            list.add(new Categorie(1, null, "남성", 1));
            list.add(new Categorie(2, null, "여성", 2));
            list.add(new Categorie(3, 1, "남성 목걸이", 1));
            list.add(new Categorie(4, 1, "남성 반지", 2));
            list.add(new Categorie(5, 1, "남성 귀걸이", 3));
            list.add(new Categorie(6, 2, "여성 목걸이", 4));
            list.add(new Categorie(7, 2, "여성 반지", 5));
            list.add(new Categorie(8, 2, "여성 팔찌", 6));

            mapper.writeValue(json, list);

        } catch (Exception e) {
            System.out.println("카테고리 생성 중 문제 발생");
        }
    }

    public Categorie[] readca(){
        try{

            Categorie[] cate = mapper.readValue(json, Categorie[].class);
            return cate;

        }catch (Exception e){
            System.out.println("readca 쪽에서 문제 일으키는 중");
            return null;
        }

    }

    public void saveca(List<Categorie> cali){
        try{
            mapper.writeValue(json, cali);
        }catch (Exception e){
            System.out.println("saveca 쪽에서 문제 일으키는 중");
        }
    }

    public static void create() {
        try {
            List<Product> list = new ArrayList<>(); //직접 타이핑이 번거로워 product 생성 부분만 gpt 사용

            list.add(new Product(101, "나비 목걸이", 144000, "나비 모양 복걸이", 3, "정상", 6));
            list.add(new Product(102, "플로럴 목걸이", 135000, "꽃 모양 복걸이", 2, "정상", 6));
            list.add(new Product(103, "강아지 목걸이", 115000, "강아지 모양 복걸이", 6, "정상", 6));
            list.add(new Product(104, "고양이 목걸이", 110000, "고양이 모양 복걸이", 3, "정상", 6));
            list.add(new Product(105, "새 목걸이", 104000, "새 모양 복걸이", 0, "판매중지", 6));

            list.add(new Product(106, "금 반지", 214000, "금색 반지", 30, "정상", 7));
            list.add(new Product(107, "하트 반지", 244000, "하트 모양 반지", 3, "정상", 7));
            list.add(new Product(108, "나비 반지", 264000, "나비 모양 반지", 8, "정상", 7));
            list.add(new Product(109, "복숭아 반지", 324000, "복숭아 모양 반지", 1, "정상", 7));
            list.add(new Product(110, "다이아 반지", 1144000, "다이아 반지", 1, "정상", 7));

            list.add(new Product(111, "예쁜 팔찌", 224000, "예쁜 팔찌", 0, "판매중지", 8));
            list.add(new Product(112, "다이아 팔찌", 1534000, "다이아 팔찌", 3, "정상", 8));
            list.add(new Product(113, "에메랄드 팔찌", 1834000, "에메랄드 팔찌", 8, "정상", 8));
            list.add(new Product(114, "금 팔찌", 334000, "금 팔찌", 2, "정상", 8));
            list.add(new Product(115, "은 팔찌", 54000, "은 팔찌", 3, "정상", 8));

            list.add(new Product(116, "심플 은 반지", 77000, "은 반지", 3, "정상", 4));
            list.add(new Product(117, "심플 금 반지", 477000, "금 반지", 2, "정상", 4));
            list.add(new Product(118, "체인 반지", 177000, "체인 반지", 1, "정상", 4));
            list.add(new Product(119, "휴 반지", 7000, "한숨이 나오는 반지", 0, "판매중지", 4));
            list.add(new Product(120, "골룸의 반지", 11177000, "반지의 제왕에서 나오는 골룸 반지", 1, "정상", 4));

            list.add(new Product(121, "간지나는 귀걸이", 50000, "간지나게 생긴 귀걸이", 3, "정상", 5));
            list.add(new Product(122, "냄새나는 귀걸이", 5000, "냄새나게 생긴 귀걸이", 10, "정상", 5));
            list.add(new Product(123, "검정색 귀걸이", 41000, "나쁘지 않은 검정색 귀걸이", 3, "정상", 5));
            list.add(new Product(124, "귀걸이", 40000, "단순하게 생긴 귀걸이", 0, "판매중지", 5));
            list.add(new Product(125, "간지나는 귀걸이", 50000, "간지나게 생긴 귀걸이", 3, "정상", 5));

            list.add(new Product(126, "심플 은 목걸이", 70000, "단순하게 생긴 은 목걸이", 3, "정상", 3));
            list.add(new Product(127, "알 수 없는 목걸이", 1170000, "알수 없게 생긴 목걸이이다.", 0, "판매 중지", 3));
            list.add(new Product(128, "검정색 목걸이", 50000, "그냥 검정색 목걸이", 3, "정상", 3));
            list.add(new Product(129, "문어모양 목걸이", 190000, "붉은색 루비 목걸이", 3, "정상", 3));
            list.add(new Product(130, "마지막 목걸이", 10000000, "내가 적은 마지막 카테고리 목걸이이다.", 1, "정상", 3));

            mapper.writeValue(jsonp, list);

            System.out.println("상품 JSON 생성 완료");

        } catch (Exception e) {
            System.out.println("product 가 오류내는 중");
        }
    }

        public Product[] readpro(){
            try{

                Product[] pro = mapper.readValue(jsonp, Product[].class);
                return pro;

            }catch (Exception e){
                System.out.println("pro가 문제 일으키는중 쪽에서 문제 일으키는 중");
                return null;
            }

        }


    }


