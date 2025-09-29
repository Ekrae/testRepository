package week02;
import java.util.Scanner;
public class LabWork {
    public static void lab01(){
        //주문금액 계산하기
        final int COFFEE = 100;

    }
    public static void lab02(){

    }
    public static void lab03(){

    }
    public static void lab04(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("학번:");
        String snum = scanner.next();
        scanner.nextLine();
        System.out.print("이름:");
        String sname = scanner.nextLine();
        System.out.print("나이:");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.print("주소:");
        String add = scanner.nextLine();

        System.out.println("학번:"+snum);
        System.out.println("이름:"+sname);
        System.out.println("나이:"+age);
        System.out.println("주소:"+add);
        
        
    }
    public static void main(String[] args) {
        System.out.println("202511492 이창민");
        lab04();

    }
}
