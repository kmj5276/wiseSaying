package com.back;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("==명언 앱==");

        int lastNo = 0;

        WiseSaying wiseSaying = null; //비어있는 WiseSaying 변수 선언

        while(true) {
            System.out.print("명령) ");
            String command = sc.nextLine(); //입력 받기

            if(command.equals("종료")){
                break;
            } else if (command.equals("등록")) {
                System.out.print("명언 : ");
                String saying = sc.nextLine();
                System.out.print("작가 : ");
                String author = sc.nextLine();

                lastNo++;

                wiseSaying = new WiseSaying;
                wiseSaying.id = lastNo;
                wiseSaying.saying = saying;
                wiseSaying.author = author;

                System.out.println(lastNo + "번 명언이 등록되었습니다.");
            } else if(command.equals("목록")){
                System.out.println("번호 / 작가 / 명언");
                System.out.println("----------------------");
                System.out.println("%d / %s / %s".formatted(wiseSaying.id, wiseSaying.author, wiseSaying.saying));

            }
        }
    }
}
