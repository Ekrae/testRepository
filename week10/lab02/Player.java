package week10.lab02;

import java.util.Scanner;

public class Player {
    String name;
    String word;
    static Scanner scanner = new Scanner(System.in);

    public Player(String name) {
        this.name = name;
    }

    public String getWordFromUser(){
        System.out.print(name + " >> ");
        word = scanner.next();
        return word;
    }

    public boolean checkSuccess(String lastWord){

        return this.word.charAt(0) == lastWord.charAt(lastWord.length()-1);//자바에는 -1 인덱스가 없음
    }
}
