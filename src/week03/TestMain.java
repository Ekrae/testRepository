package week03;

import java.util.Scanner;
import java.util.Random;
public class TestMain {
    public static void main(String[] args) {
        System.out.println("202511492 이창민");
        lab01();
        System.out.println(); //for 가독성
        lab02();
        System.out.println();
        lab03();
    }

    public static void lab01(){
        Scanner scanner = new Scanner(System.in);

        System.out.print("무슨 커피 드릴까요? ");
        String selectedMenu = scanner.next();
        int price = switch (selectedMenu){
            case "Americano","Espresso" -> 2500;

            case "Cappuccino","CafeLatte"->3500;
            default -> {
                System.out.println("판매하는 제품이 아닙니다");
                yield 0;
            }
        };
        if (price!=0){
            System.out.println(selectedMenu+"는 "+price+"원입니다.");
        }
    }

    public static String translate(int Selected){
        return switch (Selected){
            case 0-> "가위";
            case 1->"바위";
            case 2->"보";
            default -> "오류";
        };
    }
    public static int Winer(int u,int c){
        //어떤 연산기호 하나면 승패 판별 가능....
        //if 덧셈, 곱셈->결과만으로 누구의 기여인지 모름 -> 빼기,나누기,xor?
        //0가
        //1바
        //2보
        //
        //가-보 = -2,앞
        //가-바 = -1,뒤
        //가-가 = 0,무승
        //
        //바-가=1,앞
        //바-보=-1,뒤
        //바-바 = 0,무승
        //
        //보-가 = 2, 뒤
        //보-바 = 1,앞
        //보-보 = 0,무승
        //
        //-2 -1 0 1 2
        //앞 뒤 무 앞 뒤
        //0 1 2 0 1
        int func = (u-c+2)%3;
        if (func==0) {
            return 1;
        }else if (func==1){
            return 0;
        }else{
            return -1;
        }
    }
    public static void lab02(){
        Scanner scanner = new Scanner(System.in); //기본세팅
        Random r = new Random();

        System.out.println("가위(0), 바위(1), 보(2)중에 하나를 입력하세요.");
        System.out.println("3판 2선승제로 진행됩니다. 먼저 2승을 하는 사람이 승리합니다!");
        System.out.println();

        int userWinCount = 0,comWinCount = 0;
        for (int i=0;i<3;i++) {
            System.out.println("--- 현재 스코어 ---");
            System.out.println("사용자: "+ userWinCount +"승, 컴퓨터: "+comWinCount+"승");
            System.out.print("입력 : ");

            int userSelect = scanner.nextInt();  //유저랑 컴 입력get
            int computerSelect = r.nextInt(3);

            System.out.println("사용자: "+translate(userSelect)+", 컴퓨터: "+translate(computerSelect));

            switch (Winer(userSelect,computerSelect)){
                case 1->{
                    userWinCount++;
                    System.out.println("사용자가 이겼습니다!");
                }
                case 0->{
                            comWinCount++;
                            System.out.println("컴퓨터가 이겼습니다.");
                }
                case -1-> {
                    i--;
                    System.out.println("무승부입니다.");
                }
            } //승리자 누군지
            if (userWinCount>=2){
                System.out.println("--- 최종 결과 ---");
                System.out.println("최종 승리자는 사용자입니다!");
                break;
            } else if (comWinCount>=2) {
                System.out.println("--- 최종 결과 ---");
                System.out.println("아쉽지만 최종 승리자는 컴퓨터입니다.");
                break;
            }
        }
    }
    public static void lab03(){
        int[] lotto = makeLotto();

        selectAlignment(lotto);     //주소값 전달-> 직접 수정됨
        for (int k: lotto){
            System.out.print(k + " ");
        }

    }

    private static void selectAlignment(int[] lotto) {  //선택정렬 돌아감
        for (int i = 0; i<lotto.length-1;i++){

            int min = i;
            for (int j=i+1;j<lotto.length;j++){ //최소찾는 과정
                if (lotto[min]>lotto[j]){
                    min = j;
                }
            }
            if (min==i){
                continue;
            }else{
                lotto[i] ^= lotto[min];
                lotto[min] ^= lotto[i];
                lotto[i] ^= lotto[min];
            }
        }
    }

    private static int[] makeLotto() {
        Random random = new Random();

        int[] lotto = new int[6];
        for (int i=0;i<lotto.length;i++){
            lotto[i] = random.nextInt(46)+1;
            for (int j=0;j<i;j++){
                if (lotto[i]==lotto[j]){
                    i--;
                    break;
                }
            }
        }     //lotto 숫자 뽑기

        return lotto;
    }


}

