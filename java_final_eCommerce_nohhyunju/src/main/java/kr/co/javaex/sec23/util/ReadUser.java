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

            list.add(new User("user01", "김가나", "Abc123", "01011112222", "noh1@test.com", "정상", "일반회원"));
            list.add(new User("user02", "이나다", "Qwe456", "01022223333", "noh2@test.com", "정상", "일반회원"));
            list.add(new User("user03", "박다라", "Zxc789", "01033334444", "noh3@test.com", "정상", "일반회원"));
            list.add(new User("user04", "최라마", "Asd111", "01044445555", "noh4@test.com", "정상", "일반회원"));
            list.add(new User("user05", "황마사", "Qaz222", "01055556666", "noh5@test.com", "정상", "일반회원"));
            list.add(new User("official", "노현주", "1234", "01000009072", "nmi123nmi@naver.com", "정상", "관리자"));

            mapper.writeValue(json, list);

            System.out.println("회원 JSON 생성 완료");

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