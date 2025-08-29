package com.back;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("==명언 앱==");
        int lastNo = 0;
        String wiseSaying = "";
        String author = "";

        while(true) {
            System.out.print("명령) ");
            String command = sc.nextLine(); //입력 받기

            if(command.equals("종료")){
                break;
            } else if (command.equals("등록")) {
                System.out.print("명언 : ");
                wiseSaying = sc.nextLine();
                System.out.print("작가 : ");
                author = sc.nextLine();
                lastNo++;
                System.out.println(lastNo + "번 명언이 등록되었습니다.");
            } else if(command.equals("목록")){
                System.out.println("번호 / 작가 / 명언");
                System.out.println("----------------------");
                System.out.println("%d / %s / %s".formatted(lastNo, author, wiseSaying));

            }
        }
    }
}
