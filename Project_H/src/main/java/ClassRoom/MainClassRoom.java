package ClassRoom;

import java.util.Scanner;

public class MainClassRoom {
    static String Item[][] = new String[20][2];
    static int icount = 0;


    public static void main(String[] args) {
        boolean init =false;

        Scanner s = new Scanner(System.in);

        MainClassRoom.P_MainScreen();

        while(true){
            System.out.println("탐색할 곳을 입력하세요.");
            String con = s.nextLine();
            if (con.equals("Profcom") || con.equals("profcom") || con.equals("prof_com")){
                MainClassRoom.ProfCom();
                init = true;
            }
            else if(con.equals("BACK") || con.equals("back") || con.equals("Back")){
                MainClassRoom.P_MainScreen();
                init =false;
            }
            else if(con.equals("mycom")||con.equals("my_com")||con.equals("My_com") || con.equals("My_com")){

            }
            else if(con.equals("password") || con.equals("Password") || con.equals("PASSWORD")){
                System.out.println("비밀 번호를 입력하시오. ");
            }
        }





    }

    static void P_MainScreen(){
        System.out.println("┌──────────────────────────────────────────────────────────────────────────────┐"+"--Map--");
        System.out.println("│                                                                              │");
        System.out.println("│ Notice     ┌──────────────────── White Board ─────────────────────┐          │");
        System.out.println("│ [Paper]    │                                                      │          │");
        System.out.println("│            │                  [   Hint_2   ]                      │          │");
        System.out.println("│            └──────────────────────────────────────────────────────┘          │");
        System.out.println("│                                                                              │");
        System.out.println("│     ┌──────────────┐        ┌──────────────┐        ┌──────────────┐         │");
        System.out.println("│     │   [____]     │        │   [____]     │        │   [____]     │         │" + "              *주변을 탐색 하실 수 있습니다.");
        System.out.println("│     │    |__|      │        │    |__|      │        │    |__|      │         │" + "              *[ ]안에 입력된 글자를 입력하시면 탐색이 가능합니다. ");
        System.out.println("│     └──────────────┘        └──────────────┘        └──────────────┘         │" + "              *Map 검색시 이동가능한 장소가 출력됩니다. ");
        System.out.println("│                                                                              │" + "              *언제든지 최종 비밀번호를 시도해 보실 수 있습니다." );
        System.out.println("│           ┌──────────────┐        ┌──────────────┐        ┌──────────────┐   │" + "               UNLOCK을 입력하시면 도전이 가능합니다.");
        System.out.println("│           │   [____]     │        │   [My_Com]   │        │   [____]     │   │" + "              *");
        System.out.println("│           │    |__|      │        │     |__|     │        │    |__|      │   │");
        System.out.println("│           └──────────────┘        └──────────────┘        └──────────────┘   │");
        System.out.println("│                                                                              │");
        System.out.println("│                 ┌───────────────────────────────┐                            │");
        System.out.println("│                 │          [ Prof_com ]         │                            │");
        System.out.println("│                 │                               │                            │");
        System.out.println("│                 │                               │                            │");
        System.out.println("│                 └───────────────────────────────┘                            │");
        System.out.println("│                                                             |*  UNLOCK  *|   │");
        System.out.println("└──────────────────────────────────────────────────────────────────────────────┘");
        System.out.println("MyItem List ▽");

        if(Item==null){

        }
        else{
            for (int i=0; i<icount;i++){
                System.out.println(Item[i]);
            }
        }
    }

    static void ProfCom(){
        System.out.println("┌──────────────────────────────────────────────────────────────────────────────┐");
        System.out.println("│                                                                   BACK ->    │" + "              *비밀번호 창이 존재할 경우 Password 입력 후 비밀번호 창이 활성화 될 때 ");
        System.out.println("│                 ┌──────────────────────────────────────┐                     │" + "               비밀번호를 입력하시면 됩니다. ");
        System.out.println("│                 │                                      │                     │" + "              *BACK 입력 시 뒤로가기가 가능합니다. ");
        System.out.println("│                 │                                      │                     │");
        System.out.println("│                 │                                      │                     │");
        System.out.println("│                 │          [  _  _  _  _   ]           │                     │");
        System.out.println("│                 │          PASSWORD REQUIRED           │                     │");
        System.out.println("│                 │                                      │                     │");
        System.out.println("│                 │                                      │                     │");
        System.out.println("│                 │                                      │                     │");
        System.out.println("│                 └──────────────────────────────────────┘                     │");
        System.out.println("│                                                                              │");
        System.out.println("└──────────────────────────────────────────────────────────────────────────────┘");

    }

    static void mycom(){



            System.out.println("┌──────────────────────────────────────────────────────────────────────────────┐");
            System.out.println("│                                                                    BACK ->   │");
            System.out.println("│                                                                              │");
            System.out.println("│                    ┌──────────────────────────────────────┐                  │");
            System.out.println("│                    │                                      │                  │");
            System.out.println("│                    │                                      │                  │");
            System.out.println("│                    │                                      │                  │");
            System.out.println("│                    │                                      │                  │");
            System.out.println("│                    │            Monitor Screen            │                  │" + "              *주변을 탐색 하실 수 있습니다.");
            System.out.println("│                    └──────────────────────────────────────┘                  │" + "              *[ ]안에 입력된 글자를 입력하시면 탐색이 가능합니다. ");
            System.out.println("│                                       |                                      │" + "              *BACK 입력 시 뒤로가기가 가능합니다. ");
            System.out.println("│                                   _________                                  │");
            System.out.println("│                                                                              │");
            System.out.println("│                             [Crumpled Paper]                                 │");
            System.out.println("│                         ((      ________      ))                             │");
            System.out.println("│                       ((     __/  __   \\__     ))                           │");
            System.out.println("│                         ((  /  _ /  \\ _  \\   ))                            │");
            System.out.println("│                            \\_/ /_/\\_\\ \\_/                                │");
            System.out.println("│                                                                              │");
            System.out.println("│                                                                              │");
            System.out.println("│     ┌───────────────────────┐                    ┌───────────────────────┐   │");
            System.out.println("│     │  / / / / / / / / / /  │                    │  / / / / / / / / / /  │   │");
            System.out.println("│     │ / / / / / / / / / /   │                    │ / / / / / / / / / /   │   │");
            System.out.println("│     │/ / / / / / / / / /    │                    │/ / / / / / / / / /    │   │");
            System.out.println("│     │                       │                    │      [Notebook]       │   │");
            System.out.println("│     └───────────────────────┘                    └───────────────────────┘   │");
            System.out.println("│                                                                              │");
            System.out.println("└──────────────────────────────────────────────────────────────────────────────┘");

    }




}
