package kr.co.javaex.sec23.service;

import java.util.*;
import kr.co.javaex.sec23.domain.Categorie;
import kr.co.javaex.sec23.util.ReadIt;

public class Categoriesoffical {

    public static boolean official = true;


    public void DeleteCategories() {
        if (!official) return;

        Scanner s = new Scanner(System.in);
        ReadIt cateread = new ReadIt();

        Categorie[] cate = cateread.readca();
        List<Categorie> list = new ArrayList<>(Arrays.asList(cate));

        int targetId;
        Categorie target = null;

        while (true) {
            System.out.println("삭제할 카테고리의 cID를 입력하십시오.");
            targetId = s.nextInt();

            for (int j = 0; j < list.size(); j++) {
                if (list.get(j).getcID() == targetId) {
                    target = list.get(j);
                    break;
                }
            }

            if (target == null) {
                System.out.println("존재하지 않는 cID입니다. 다시 입력하십시오.");
            } else {
                break;
            }
        }

        int deletedNumber = target.getNumber();

        list.remove(target);


        for (int j = 0; j < list.size(); j++) {
            if (list.get(j).getNumber() > deletedNumber) {
                list.get(j).setNumber(list.get(j).getNumber() - 1);
            }
        }

        cateread.saveca(list);
        System.out.println("카테고리 삭제 완료");
    }


    public void UpdateCategories() {
        if (!official) return;

        Scanner s = new Scanner(System.in);
        ReadIt cateread = new ReadIt();

        Categorie[] cate = cateread.readca();
        List<Categorie> list = new ArrayList<>(Arrays.asList(cate));

        int targetId;
        Categorie target = null;
        String str;
        int i;

        while (true) {
            System.out.println("수정할 카테고리의 cID를 입력하십시오.");
            targetId = s.nextInt();

            for (int j = 0; j < list.size(); j++) {
                if (list.get(j).getcID() == targetId) {
                    target = list.get(j);
                    break;
                }
            }

            if (target == null) {
                System.out.println("존재하지 않는 cID입니다. 다시 입력하십시오.");
            } else {
                break;
            }
        }


        while (true) {
            System.out.println("새 상위카테고리 ID를 입력하세요 (null 입력 시 대분류)");

            str = s.next();

            if (str.equalsIgnoreCase("null")) {
                target.setUpoID(null);
                break;
            }

            try {
                i = Integer.parseInt(str);

                boolean exists = false;

                for (int j = 0; j < list.size(); j++) {
                    if (list.get(j).getcID() == i) {
                        exists = true;
                        break;
                    }
                }

                if (exists) {
                    target.setUpoID(i);
                    break;
                } else {
                    System.out.println("존재하지 않는 ID입니다.");
                }

            } catch (Exception e) {
                System.out.println("숫자 또는 null만 입력");
            }
        }


        System.out.println("새 카테고리 이름 입력");
        str = s.next();
        target.setName(str);

        cateread.saveca(list);
        System.out.println("카테고리 수정 완료");
    }
}