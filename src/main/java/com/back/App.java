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
            } else if(command.startsWith("삭제")){
                actionDelete(command);
            } else if(command.startsWith("수정")){
                actionModify(command);
            }
        }
    }

    public void actionModify(String command) {
        String[] commandBits = command.split("=");

        if(commandBits.length < 2){
            System.out.println("번호를 입력해주세요.");
            return;
        }

        String idStr = commandBits[1];
        int id = Integer.parseInt(idStr);

        int modifyTargetIndex = findIndexById(id);

        if(modifyTargetIndex == -1){
            System.out.println("%d번 명언은 존재하지 않습니다.".formatted(id));
            return;
        }

        WiseSaying modifyTargetWiseSaying = wiseSayings[modifyTargetIndex];

        System.out.println("명언(기존) : %s".formatted(modifyTargetWiseSaying.saying));
        System.out.print("명언 : ");
        String newSaying = sc.nextLine();
        System.out.println("작가(기존) : %s".formatted(modifyTargetWiseSaying.author));
        System.out.print("작가 : ");
        String newAuthor = sc.nextLine();

        modify(modifyTargetWiseSaying, newSaying, newAuthor);

    }

    public void modify(WiseSaying modifyTargetWiseSaying, String newSaying, String newAuthor) {
        modifyTargetWiseSaying.saying = newSaying;
        modifyTargetWiseSaying.author = newAuthor;
    }

    public void actionDelete(String command) {

        String[] commandBits = command.split("=");

        if(commandBits.length < 2){
            System.out.println("번호를 입력해주세요.");
            return;
        }

        String idStr = commandBits[1];
        int id = Integer.parseInt(idStr);

        boolean result = delete(id);

        if(result){
            System.out.println("%d번 명언이 삭제되었습니다.".formatted(id));
        } else {
            System.out.println("%d번 명언은 존재하지 않습니다.".formatted(id));
        }
    }

    public int findIndexById(int id) {
        for(int i = 0; i < lastIndex; i++) {
            if(wiseSayings[i].id == id){
                return i;
            }
        }

        return -1;
    }

    public boolean delete(int id) {
        int deleteTargetIndex = findIndexById(id); // 삭제하고 싶은 명언이 저장될 위치

        if(deleteTargetIndex == -1){
            return false;
        }

        for(int i = deleteTargetIndex; i < lastIndex; i++){
            wiseSayings[i] = wiseSayings[i + 1];
        }

        lastIndex --;

        return true;
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