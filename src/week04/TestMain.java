package week04;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TestMain {
    
    public static void main(String[] args) {
        System.out.println("202511492 이창민");
        System.out.println();
        lab01();
        System.out.println();
        lab02();
    }

    
    final static int ADDVALUE = 2;  //기본 값 외에 스코어에 추가할 요소 개수
    //컨트롤 알트 엘: 정렬
    public static void lab01() {
        //변수선언
        int[][] scores;
        String[] names;
        double[] avgs;    //평균만 저장
        //파일 읽고 이름과 스코어 2개 배열 리턴해야 하는데, 이게 불가능(. 차라리 readfile을 메인 스레드에 넣기
        //스캐너도 참조?니까? 배열처럼 공유 될 듯? -> 안됨...

        File file = new File("res/scores.txt");
        try {
            Scanner scanner = new Scanner(file);
            final int ROW = scanner.nextInt(); //행 개수 받아오기

            scores = new int[ROW][];
            names = new String[ROW];  //공간마련
            avgs = new double[ROW];

            while (scanner.hasNext()) {

                for (int i = 0; i < ROW; i++) {
                    final int COL = scanner.nextInt(); //열 몇개인지

                    scores[i] = new int[COL + ADDVALUE];
                    names[i] = scanner.next();         //이름 받아오기
                    for (int j = 0; j < COL; j++) {
                        scores[i][j] = scanner.nextInt(); //수 받아오기
                    }
                }
            }
            //함수 읽어오는 부분 끝!
            addMoreInfo(scores, avgs);
            printScores(scores, names, avgs);


        } catch (FileNotFoundException e) {
            System.out.println("파일을 찾을 수 없습니다!");
        }


    }

    private static void printScores(int[][] scores, String[] names, double[] avgs) {
        for (int i = 0; i < scores.length; i++) { //i가 행
            System.out.print(names[i] + " >> ");
            for (int k = 0; k < scores[i].length - ADDVALUE; k++) {
                System.out.print(scores[i][k] + " ");
            }//랭크 기본값이 0으로 되어있음!
            System.out.print(": " + scores[i][scores[i].length - ADDVALUE] + " : " + avgs[i] + " : " + (scores[i][scores[i].length - ADDVALUE + 1] + 1));
            System.out.println();
        }
    }

    private static void addMoreInfo(int[][] scores, double[] avgs) {
        for (int j = 0; j < scores.length; j++) { //행단위실행
            int sum = getSumScores(scores, j);

            scores[j][scores[j].length - ADDVALUE] = sum;//합 저장
            avgs[j] = (double) sum / (scores[j].length - ADDVALUE); //평균 저장
        }
        getRanking(scores, avgs);//랭크 저장

    }

    private static void getRanking(int[][] scores, double[] avg) {
        for (int i = 0; i < scores.length - 1; i++) {
            for (int j = i + 1; j < scores.length; j++) { //j는 다른애, i가 나

                if (avg[i] < avg[j]) {
                    scores[i][scores[i].length - ADDVALUE + 1]++;
                } else if (avg[i] > avg[j]) {
                    scores[j][scores[j].length - ADDVALUE + 1]++;
                }
            }
        }
    }

    private static int getSumScores(int[][] scores, int row) {
        int sum = 0;
        for (int i = 0; i < scores[row].length - ADDVALUE; i++) {
            sum += scores[row][i];
        }
        return sum;
    }


    public static void lab02(){
        TV tv1 = new TV();

        tv1.powerOnOff();  //실험 실행문
        for (int j = 0; j < 9; j++) {
            tv1.channelUP();
        }
        for (int j = 0; j < 9; j++) {
            tv1.channelDown();
        }
        tv1.powerOnOff();
        tv1.channelDown();
        tv1.powerOnOff();
        tv1.volumeUp();
        tv1.volumeDown();
        tv1.volumeDown();
        for (int i=0;i<12;i++){
            tv1.volumeUp();
        }

        tv1.volumeDown();


    }
}
