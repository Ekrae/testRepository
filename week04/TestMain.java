package week04;

public class TestMain {
    public static void main(String[] args) {
        System.out.println("202511492 이창민");
        example01();
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
