package week05;

public class TestMain {
    public static void main(String[] args) {
        System.out.println("202511492 이창민");
        //example01();
        example02();
    }

    private static void example02() {
        Vehicle car1 = new Vehicle("붉은색");
        car1.changeGear('D');
        car1.accelerate(20);
        car1.showStatus();

        Vehicle car2 = new Vehicle(car1);
        car2.changeGear('N');
        car2.tv.powerOnOff();
        car2.tv.channelUP();


        System.out.println("------------------------------");
        car1.showStatus();
        System.out.println("------------------------------");
        car2.showStatus();
    }

    private static void example01(){
        TV tv1 = new TV();
        tv1.powerOnOff();
        tv1.channelUP();
        tv1.channelUP();
        tv1.channelUP();
        tv1.channelUP();
        tv1.channelUP();
        tv1.channelUP();
        tv1.channelUP();
        tv1.channelUP();
        tv1.channelUP();
        tv1.powerOnOff();
        tv1.channelDown();
        tv1.powerOnOff();


    }
}
