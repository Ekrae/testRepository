package week10.lab04;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;

public class VocManager {
    String userName;
    Vector<Word> voc = new Vector<>();
    static Scanner scan = new Scanner(System.in);

    VocManager(String userName) {
        this.userName = userName;
    }

    void addWord(String eng, String kor){
        voc.add(new Word(eng,kor));
    }

    void makeVoc(String fileName) {
       try(Scanner sc = new Scanner(new File(fileName))){
           while (sc.hasNext()){
               String str = sc.nextLine();
               String[] temp = str.split("\t"); //영단어 \t 한글
               addWord(temp[0].trim(),temp[1].trim()); //데이터 넣거나 할때 공백 습관적으로 제거해주기!
           }
           System.out.println(userName+"의 단어장 생성이 완성되었습니다.");
           menu();
       }catch (FileNotFoundException e){
           System.out.println("파일을 찾을 수 없습니다!");
       }
    } //파일 가져와서, 영단어,뜻 분리해서 단어 추가하기.

    void menu() {
        int choice = 0;
        while (choice != 3) {
            System.out.println("\n------" + userName + "의 단어장 -------");
            System.out.println("1) 단어검색 2) 단어검색2 3) 종료");
            System.out.print("메뉴를 선택하세요 : ");
            choice = scan.nextInt();
            scan.nextLine();
            System.out.println();

            switch (choice) {
                case 1-> searchVoc();
                case 2-> searchVoc2();
                case 3-> System.out.println(userName + "의 단어장 프로그램을 종료합니다.");
            }

        }
    }

    public void searchVoc2() {
        System.out.println("------ 단어 검색 2 ------");
        System.out.print("검색할 부분 단어를 입력하세요 (영단어) : ");
        String sWord = scan.nextLine();
        for (Word W : voc){
            if (W.eng.indexOf(sWord) == 0){
                System.out.println(W.eng+" : "+ W.kor);
            }
        }
    }


    public void searchVoc() {
        System.out.println("------ 단어 검색 ------");
        System.out.print("검색할 단어를 입력하세요 (영단어) : ");
        String sWord = scan.nextLine();
        for (Word W : voc){
            if (W.eng.equals(sWord)){
                System.out.println("단어의 뜻 : "+ W.kor);
            }
        }

    }
}

