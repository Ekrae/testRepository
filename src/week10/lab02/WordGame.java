package week10.lab02;

import java.util.Scanner;

public class WordGame {
    String startWord;
    Player[] players;
    static Scanner scanner = new Scanner(System.in);

    public WordGame(String startWord) {
        this.startWord = startWord;
    }

    void createPlayers(){
        System.out.print("게임에 참가할 인원은 몇명입니까 >> ");
        int numPlayers = scanner.nextInt();
        players = new Player[numPlayers];

        for(int i=0; i<players.length; i++){
            System.out.print("참가자의 이름을 입력하세요 >> ");
            String name = scanner.next();
            players[i] = new Player(name);
        }
    }

    void run() {
        System.out.println("끝말잇기 게임을 시작합니다....");
        createPlayers();
        String lastWord = startWord;
        System.out.println("시작하는 단어는 "+lastWord+"입니다.");
        // 게임 루틴 구현
        while (true){
            for(int i=0; i<players.length; i++){
                String getWord = players[i].getWordFromUser();
                if (players[i].checkSuccess(lastWord)){
                    lastWord = getWord;
                }else{
                    System.out.println(players[i].name+"이(가) 졌습니다.");
                    return;
                }
            }
        }
    }
}
