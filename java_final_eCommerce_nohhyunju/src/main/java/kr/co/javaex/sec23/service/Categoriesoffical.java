package kr.co.javaex.sec23.service;

import java.util.*;
import kr.co.javaex.sec23.domain.Categorie;
import kr.co.javaex.sec23.util.ReadIt;

public class Categoriesoffical {

    public static boolean official = true;

    public void newcate() {
        if (!official) return;

        Scanner s = new Scanner(System.in);
        ReadIt cateread = new ReadIt();

        Categorie[] cate = cateread.readca();
        List<Categorie> list = new ArrayList<>(Arrays.asList(cate));

        Categorie nc = new Categorie();

        int cID;
        boolean same;
        String str;
        int number;

        while (true) {
            same = false;
            System.out.println("새 카테고리 cID 입력");
            cID = s.nextInt();

            for (int j = 0; j < list.size(); j++) {
                if (list.get(j).getcID() == cID) {
                    same = true;
                    break;
                }
            }

            if (same) {
                System.out.println("이미 존재하는 cID");
            } else {
                nc.setcID(cID);
                break;
            }
        }

        while (true) {
            System.out.println("상위카테고리 ID 입력 (null 입력 시 대분류)");
            str = s.next();

            if (str.equalsIgnoreCase("null")) {
                nc.setUpoID(null);
                break;
            }

            try {
                int up = Integer.parseInt(str);

                boolean ok = false;

                for (Categorie c : list) {
                    if (c.getcID() == up) {
                        ok = true;
                        break;
                    }
                }

                if (ok) {
                    nc.setUpoID(up);
                    break;
                } else {
                    System.out.println("없는 ID");
                }

            } catch (Exception e) {
                System.out.println("숫자 또는 null");
            }
        }

        System.out.println("이름 입력");
        nc.setName(s.next());

        System.out.println("순서 입력");
        number = s.nextInt();
        nc.setNumber(number);

        list.add(nc);
        cateread.saveca(list);

        System.out.println("추가 완료");
    }

    public void upcate() {
        if (!official) return;

        Scanner s = new Scanner(System.in);
        ReadIt cateread = new ReadIt();

        List<Categorie> list = new ArrayList<>(Arrays.asList(cateread.readca()));

        int id;
        Categorie target = null;

        while (true) {
            target = null;
            System.out.println("수정할 cID");
            id = s.nextInt();

            for (Categorie c : list) {
                if (c.getcID() == id) {
                    target = c;
                    break;
                }
            }

            if (target == null) {
                System.out.println("없음");
            } else break;
        }

        while (true) {
            System.out.println("새 상위ID (null 가능)");
            String str = s.next();

            if (str.equalsIgnoreCase("null")) {
                target.setUpoID(null);
                break;
            }

            try {
                int up = Integer.parseInt(str);

                boolean ok = false;

                for (Categorie c : list) {
                    if (c.getcID() == up) {
                        ok = true;
                        break;
                    }
                }

                if (ok) {
                    target.setUpoID(up);
                    break;
                } else {
                    System.out.println("없는 ID");
                }

            } catch (Exception e) {
                System.out.println("숫자 또는 null");
            }
        }

        System.out.println("새 이름");
        target.setName(s.next());

        cateread.saveca(list);
        System.out.println("수정 완료");
    }

    public void delcate() {
        if (!official) return;

        Scanner s = new Scanner(System.in);
        ReadIt cateread = new ReadIt();

        List<Categorie> list = new ArrayList<>(Arrays.asList(cateread.readca()));

        int id;
        Categorie target = null;

        while (true) {
            target = null;
            System.out.println("삭제할 cID");
            id = s.nextInt();

            for (Categorie c : list) {
                if (c.getcID() == id) {
                    target = c;
                    break;
                }
            }

            if (target == null) {
                System.out.println("없음");
            } else break;
        }

        int num = target.getNumber();
        list.remove(target);

        for (Categorie c : list) {
            if (c.getNumber() > num) {
                c.setNumber(c.getNumber() - 1);
            }
        }

        cateread.saveca(list);
        System.out.println("삭제 완료");
    }
}