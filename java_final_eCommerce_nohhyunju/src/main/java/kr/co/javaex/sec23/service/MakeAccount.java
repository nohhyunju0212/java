package kr.co.javaex.sec23.service;

import java.util.*;
import kr.co.javaex.sec23.domain.User;
import kr.co.javaex.sec23.util.ReadUser;

public class MakeAccount {

    static boolean login = false;
    static User loginUser = null;

    public static boolean Ami(){
        return login;
    }

    public static String myid(){
        if(loginUser == null){
            return null;
        }
        return loginUser.getId();
    }

    public static boolean isOfficial(){
        if(loginUser == null){
            return false;
        }

        if(loginUser.getRole() == null){
            return false;
        }

        return loginUser.getRole().equals("관리자");
    }

    public static User me(){
        return loginUser;
    }

    public void makeUser() {
        Scanner s = new Scanner(System.in);
        ReadUser read = new ReadUser();

        User[] users = read.readUser();
        List<User> list = new ArrayList<>(Arrays.asList(users));

        User nu = new User();

        String id;
        String name;
        String password;
        String phone;
        String email;

        while (true) {
            boolean same = false;
            boolean ok = true;

            System.out.println("회원ID 입력 (영문/숫자 5~15)");
            id = s.next();

            if (id.length() < 5) {
                System.out.println("회원ID가 너무 짧습니다.");
                continue;
            }

            if (id.length() > 15) {
                System.out.println("회원ID가 너무 깁니다.");
                continue;
            }

            for (int i = 0; i < id.length(); i++) {
                char ch = id.charAt(i);

                if (!(Character.isLetter(ch) || Character.isDigit(ch))) {
                    System.out.println("특수부호는 id에 넣을 수 없습니다.");
                    ok = false;
                    break;
                }
            }

            if (!ok) {
                continue;
            }

            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getId().equals(id)) {
                    same = true;
                    break;
                }
            }

            if (same) {
                System.out.println("이미 존재하는 회원ID입니다.");
            } else {
                nu.setId(id);
                break;
            }
        }

        System.out.println("이름 입력");
        name = s.next();
        nu.setName(name);

        while (true) {
            boolean hasup = false;

            System.out.println("비밀번호 입력 (대문자 포함)");
            password = s.next();

            if (password.length() < 5) {
                System.out.println("비밀번호가 너무 짧습니다.");
                continue;
            }

            if (password.length() > 15) {
                System.out.println("비밀번호가 너무 깁니다.");
                continue;
            }

            for (int i = 0; i < password.length(); i++) {
                if (Character.isUpperCase(password.charAt(i))) {
                    hasup = true;
                    break;
                }
            }

            if (!hasup) {
                System.out.println("대문자가 최소 1개 필요합니다.");
            } else {
                nu.setPassword(password);
                break;
            }
        }

        while (true) {
            boolean ok = true;

            System.out.println("전화번호 입력 (숫자만)");
            phone = s.next();

            for (int i = 0; i < phone.length(); i++) {
                if (!Character.isDigit(phone.charAt(i))) {
                    ok = false;
                    break;
                }
            }

            if (!ok) {
                System.out.println("숫자만 입력하세요.");
            } else {
                nu.setPhone(phone);
                break;
            }
        }

        while (true) {
            boolean same = false;
            boolean hasAt = false;

            System.out.println("이메일 입력");
            email = s.next();

            for (int i = 0; i < email.length(); i++) {
                if (email.charAt(i) == '@') {
                    hasAt = true;
                    break;
                }
            }

            if (!hasAt) {
                System.out.println("@가 포함되어야 합니다.");
                continue;
            }

            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getEmail().equals(email)) {
                    same = true;
                    break;
                }
            }

            if (same) {
                System.out.println("이미 존재하는 이메일입니다.");
            } else {
                nu.setEmail(email);
                break;
            }
        }

        nu.setState("정상");
        nu.setRole("일반회원");

        list.add(nu);
        read.saveUser(list);

        System.out.println("회원가입 완료");
    }

    public void loginUser() {
        if (login) {
            System.out.println("이미 로그인 상태입니다.");
            return;
        }

        Scanner s = new Scanner(System.in);
        ReadUser read = new ReadUser();

        User[] users = read.readUser();

        String email;
        String password;
        User target = null;

        while (true) {
            target = null;
            System.out.println("이메일 입력");
            email = s.next();

            for (int i = 0; i < users.length; i++) {
                if (users[i].getEmail().equals(email)) {
                    target = users[i];
                    break;
                }
            }

            if (target == null) {
                System.out.println("존재하지 않는 이메일입니다.");
            } else {
                break;
            }
        }

        while (true) {
            System.out.println("비밀번호 입력");
            password = s.next();

            if (target.getPassword().equals(password)) {
                if (target.getState().equals("탈퇴요청")) {
                    System.out.println("탈퇴 요청 처리되어있습니다. 지금 로그인하시면 탈퇴요청이 취소됩니다. 로그인하시겠습니까?");
                    String ans = s.next();

                    if (ans.equals("y")) {
                        target.setState("정상");
                        List<User> list = new ArrayList<>(Arrays.asList(users));
                        read.saveUser(list);
                    } else if (ans.equals("n")) {
                        System.out.println("로그인이 취소되었습니다.");
                        return;
                    } else {
                        System.out.println("y 또는 n만 입력하세요.");
                        continue;
                    }
                }

                login = true;
                loginUser = target;

                ProductOfficial po = new ProductOfficial();
                Categoriesoffical co = new Categoriesoffical();

                if (isOfficial()) {
                    po.official = true;
                    Categoriesoffical.official = true;
                } else {
                    po.official = false;
                    Categoriesoffical.official = false;
                }

                System.out.println(target.getName() + "님 로그인 성공");
                break;
            } else {
                System.out.println("비밀번호가 틀렸습니다.");
            }
        }
    }

    public void logoutUser() {
        if (!login) {
            System.out.println("로그인 상태가 아닙니다.");
            return;
        }

        System.out.println(loginUser.getName() + "님 로그아웃");
        login = false;
        loginUser = null;

        ProductOfficial po = new ProductOfficial();
        po.official = false;
        Categoriesoffical.official = false;
    }

    public void rename() {
        if (!login) {
            System.out.println("로그인 후 이용 가능합니다.");
            return;
        }

        Scanner s = new Scanner(System.in);
        ReadUser read = new ReadUser();

        User[] users = read.readUser();
        List<User> list = new ArrayList<>(Arrays.asList(users));

        System.out.println("새 이름 입력");
        String name = s.next();
        loginUser.setName(name);

        read.saveUser(list);
        System.out.println("이름 수정 완료");
    }

    public void rephone() {
        if (!login) {
            System.out.println("로그인 후 이용 가능합니다.");
            return;
        }

        Scanner s = new Scanner(System.in);
        ReadUser read = new ReadUser();

        User[] users = read.readUser();
        List<User> list = new ArrayList<>(Arrays.asList(users));

        while (true) {
            boolean ok = true;

            System.out.println("새 전화번호 입력 (숫자만)");
            String phone = s.next();

            for (int i = 0; i < phone.length(); i++) {
                if (!Character.isDigit(phone.charAt(i))) {
                    ok = false;
                    break;
                }
            }

            if (!ok) {
                System.out.println("숫자만 입력하세요.");
            } else {
                loginUser.setPhone(phone);
                break;
            }
        }

        read.saveUser(list);
        System.out.println("전화번호 수정 완료");
    }

    public void reemail() {
        if (!login) {
            System.out.println("로그인 후 이용 가능합니다.");
            return;
        }

        Scanner s = new Scanner(System.in);
        ReadUser read = new ReadUser();

        User[] users = read.readUser();
        List<User> list = new ArrayList<>(Arrays.asList(users));

        while (true) {
            boolean same = false;
            boolean hasAt = false;

            System.out.println("새 이메일 입력");
            String email = s.next();

            for (int i = 0; i < email.length(); i++) {
                if (email.charAt(i) == '@') {
                    hasAt = true;
                    break;
                }
            }

            if (!hasAt) {
                System.out.println("@가 포함되어야 합니다.");
                continue;
            }

            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getEmail().equals(email)) {
                    same = true;
                    break;
                }
            }

            if (same) {
                System.out.println("이미 존재하는 이메일입니다.");
            } else {
                loginUser.setEmail(email);
                break;
            }
        }

        read.saveUser(list);
        System.out.println("이메일 수정 완료");
    }

    public void newpassword() {
        if (!login) {
            System.out.println("로그인 후 이용 가능합니다.");
            return;
        }

        Scanner s = new Scanner(System.in);

        while (true) {
            System.out.println("현재 비밀번호 입력");
            String pw = s.next();

            if (!loginUser.getPassword().equals(pw)) {
                System.out.println("비밀번호가 틀렸습니다.");
            } else {
                break;
            }
        }

        while (true) {
            boolean hasup = false;

            System.out.println("새 비밀번호 입력 (대문자 포함)");
            String newPw = s.next();

            if (newPw.length() < 5) {
                System.out.println("비밀번호가 너무 짧습니다.");
                continue;
            }

            if (newPw.length() > 15) {
                System.out.println("비밀번호가 너무 깁니다.");
                continue;
            }

            for (int i = 0; i < newPw.length(); i++) {
                if (Character.isUpperCase(newPw.charAt(i))) {
                    hasup = true;
                    break;
                }
            }

            if (!hasup) {
                System.out.println("대문자가 최소 1개 필요합니다.");
            } else {
                loginUser.setPassword(newPw);
                break;
            }
        }

        ReadUser read = new ReadUser();
        User[] users = read.readUser();
        List<User> list = new ArrayList<>(Arrays.asList(users));

        read.saveUser(list);
        System.out.println("비밀번호 변경 완료");
    }

    public void deleteme() {
        if (!login) {
            System.out.println("로그인 후 이용 가능합니다.");
            return;
        }

        loginUser.setState("탈퇴요청");

        ReadUser read = new ReadUser();
        User[] users = read.readUser();
        List<User> list = new ArrayList<>(Arrays.asList(users));

        read.saveUser(list);

        System.out.println("회원 탈퇴 요청 완료");
    }
}