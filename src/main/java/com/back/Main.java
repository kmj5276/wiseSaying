package com.back;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("==명언 앱==");
        int no = 1;

        while(true) {
            System.out.print("명령) ");
            String command = sc.nextLine(); //입력 받기

            if(command.equals("종료")){
                break;
            } else if (command.equals("등록")) {
                System.out.print("명언 : ");
                String wiseSaying = sc.nextLine();
                System.out.print("작가 : ");
                String author = sc.nextLine();
                System.out.println(no + "번 명언이 등록되었습니다.");
                no++;
            }
        }
    }
}
