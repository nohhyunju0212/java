package kr.co.javaex.sec23.util;

import java.util.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import kr.co.javaex.sec23.domain.User;
import java.io.File;

public class ReadUser {

    static ObjectMapper mapper = new ObjectMapper();

    static File json = new File("src/main/java/kr/co/javaex/sec23/repository/users.json");

    public static void createUser() {
        try {
            List<User> list = new ArrayList<>();
            //이름을 제외한 나머지 부분에서 뒤
            list.add(new User("user01", "양록빈", "Abc123", "01011112222", "noh1@test.com", "정상", "일반회원"));
            list.add(new User("user02", "곽소정", "Qwe456", "01022223333", "noh2@test.com", "정상", "일반회원"));
            list.add(new User("user03", "강이도은", "Zxc789", "01033334444", "noh3@test.com", "정상", "일반회원"));
            list.add(new User("user04", "정아영", "Asd111", "01044445555", "noh4@test.com", "정상", "일반회원"));
            list.add(new User("user05", "고윤", "Qaz222", "01055556666", "noh5@test.com", "정상", "일반회원"));
            list.add(new User("official", "노현주", "1234", "01000009072", "nmi123nmi@naver.com", "정상", "관리자"));

            mapper.writeValue(json, list);



        } catch (Exception e) {
            System.out.println("createUser 오류");
        }
    }

    public User[] readUser() {
        try {
            User[] user = mapper.readValue(json, User[].class);
            return user;
        } catch (Exception e) {
            System.out.println("readUser 오류");
            return null;
        }
    }

    public void saveUser(List<User> list) {
        try {
            mapper.writeValue(json, list);
        } catch (Exception e) {
            System.out.println("saveUser 오류");
        }
    }
}