package com.back;

import java.util.Scanner;

public class App {

    Scanner sc = new Scanner(System.in);
    int lastNo = 0;
    int lastIndex = 0;
    WiseSaying[] wiseSayings = new WiseSaying[100];

    public void run(){

        System.out.println("==명언 앱==");

        while(true) {
            System.out.print("명령) ");
            String command = sc.nextLine(); //입력 받기

            if(command.equals("종료")){
                break;
            } else if(command.equals("등록")) {
                actionWrite();
            } else if(command.equals("목록")){
                actionList();
            } else if(command.equals("삭제?id=1")){
                actionDelete();
            }
        }
    }

    public void actionDelete() {
        delete();
        System.out.println("1번 명언이 삭제되었습니다.");
    }

    public void delete() {
        int deleteTargetIndex = -1; // 삭제하고 싶은 명언이 저장될 위치

        for(int i = 0; i < lastIndex; i++) {
            if(wiseSayings[i].id == 1){
                deleteTargetIndex = i;
            }
        }

        for(int i = deleteTargetIndex; i < lastIndex; i++){
            wiseSayings[i] = wiseSayings[i + 1];
        }

        lastIndex --;
    }

    public void actionList() {
        System.out.println("번호 / 작가 / 명언");
        System.out.println("----------------------");

        WiseSaying[] wiseSayings = wiseSayingListDesc();

        for (WiseSaying wiseSaying : wiseSayings) {
            System.out.println("%d / %s / %s".formatted(wiseSaying.id, wiseSaying.author, wiseSaying.saying));
        }
    }

    public WiseSaying[] wiseSayingListDesc() {

        WiseSaying[] descList = new WiseSaying[lastIndex];
        int descListIndex = 0;

        for(int i = lastIndex - 1; i >= 0; i--){
            descList[descListIndex] = wiseSayings[i];
            descListIndex++;
        }

        return descList;
    }

    public void actionWrite () {
        System.out.print("명언 : ");
        String saying = sc.nextLine();
        System.out.print("작가 : ");
        String author = sc.nextLine();

        WiseSaying wiseSaying = write(saying, author);

        System.out.println("%d번 명언이 등록되었습니다.".formatted(wiseSaying.id));
    }
    public WiseSaying write(String saying, String author) {
        lastNo++;

        WiseSaying wiseSaying = new WiseSaying();
        wiseSaying.id = lastNo;
        wiseSaying.saying = saying;
        wiseSaying.author = author;

        wiseSayings[lastIndex++] = wiseSaying;

        return wiseSaying;
    }
}