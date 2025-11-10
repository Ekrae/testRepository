package week09;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class TestMain {
    public static void main(String[] args) {

        FileManager.fileMerge("words1.txt", "words2.txt", "words.txt");
        example02();

        //example01();
//        try{
//            String data1 = args[0];
//            String data2 = args[1];
//
//            int num1 = Integer.parseInt(data1);
//            int num2 = Integer.parseInt(data2);
//            System.out.println(num1+num2);
////            System.out.println(data1);
////            System.out.println(data2);
//
//        }catch (ArrayIndexOutOfBoundsException e){
//            System.out.println("매개변수 확인 요망");
//        }catch (NumberFormatException e){
//            System.out.println("숫자인 문자열인지 확인해라");
//        }catch (Exception e){
//            System.out.println(e.getStackTrace());
//        }finally {
//
//        }


    }
    private static void example02() {
        Scanner sc = new Scanner(System.in);
        while (true){
            System.out.println("1)아메리카노 2)카페라떼 3)계산 4)종료");
            System.out.println("메뉴 선택 : ");
            try{
                int choice = sc.nextInt();
                if (!(choice>=1&&choice<=4)){
                    throw new MenuRangeCheckException(" plz reselect menu because of user's intelligence issue");
                }
            }catch (MenuRangeCheckException e){
                System.out.println(e.getMessage());
            }catch (InputMismatchException e){ //입력버퍼 비워줘야 에러난거 다시 고침
                sc.nextLine();
            }

        }
    }

    private static void example01() {
        int num = 100;
        Random rand = new Random();
        while (true){
            try{
                int result = num/rand.nextInt(100);
                if (result>30)
                    return;
                System.out.println(result);
            }catch(ArithmeticException e){
                System.out.println("0으로는 나눌 수 없음");
            }finally {
                System.out.println("다음 연산");
            }

        }
    }

}
