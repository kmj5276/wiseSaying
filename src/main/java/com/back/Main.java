package com.back;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("==명언 앱==");

        while(true) {
            System.out.println("명령) ");
            String command = sc.nextLine(); //입력 받기

            if(command.equals("종료")){
                break;
            }
        }
    }
}
