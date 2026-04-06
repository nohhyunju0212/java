package service;
import java.util.*;
import domain.Categorie;
import util.ReadIt;


public class Categoriesoffical {

    boolean official = true;
    final String ID = "official";
    final String password = "1234";

    boolean official_login(String id, String password){

        if(!ID.equals(id)){
            System.out.println("잘못된 ID입니다.");
            return false;
        }
        else if(!password.equals(this.password)){
            System.out.println("잘못된 비번입니다.");
            return false;
        }
        else{
            System.out.println("관리자로 로그인하셨습니다.");
            official =true;
            return true;
        }

    }

    public void NewCategories(){
        if(!official){
            return;
        }
        Scanner s = new Scanner(System.in);
        ReadIt cateread = new ReadIt();
        int i;
        String str;
        Categorie[] cate = cateread.readca();
        List<Categorie> list = new ArrayList<>(Arrays.asList(cate));
        // 배열을 array로 변환하는 것은 chat gpt에게 검색하여 배웠습니다.
        Categorie nc = new Categorie();


        System.out.println("새로 생성할 카테고리의 cID를 입력하십시오");
        i=s.nextInt();
        nc.setcID(i);
        System.out.println("카테고리의 상위카테고리의 ID를 입력하세요");
        i = s.nextInt();
        nc.setUpoID(i);
        System.out.println("카테고리의 이름을 설정하십시오.");
        str = s.nextLine();
        nc.setName(str);
        nc.setNumber(cate[cate.length].getNumber()+1);

        list.add(nc);
        cateread.saveca(list);


    }






}
