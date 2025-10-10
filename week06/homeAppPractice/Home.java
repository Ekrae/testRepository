package week06.homeAppPractice;

import java.util.Scanner;

public class Home {
    private HomeAppliance[] ha;
    private final int capacity;
    private int count = 0;

    public Home(int capacity) {
        this.capacity = capacity;
        if (this.capacity>0){
            ha = new HomeAppliance[this.capacity];
        }
    }
    public void buyHa(HomeAppliance appliance){
        if (this.count<this.capacity) {
            ha[this.count++] = appliance;
            System.out.println(appliance.getHaName() + "이 잘 배치되었습니다.");
        }else
            System.out.println("더이상 공간이 없습니다.");
    }

    public void open(){
        Scanner scanner = new Scanner(System.in);

        while (true){
            System.out.println("\n제어할 가전제품을 선택하세요!!");
            for (int i = 0; i<count; i++){
                System.out.println((i+1)+") "+ha[i].getHaName());
            }
            System.out.print("제품을 선택하세요 : ");
            int index = scanner.nextInt();
             if (index>=1 && index<=count){
                 ha[index-1].menu();
             }else{
                 System.out.println("가전제품 제어를 종료합니다.");
                 break;
             }
        }
    }
}
