package week06.homeAppPractice;

public class TestMain {
    public static void main(String[] args) {
        System.out.println("202511492 이창민");
//        TV tv = new TV("건국TV",7);
//        tv.menu();
//        Refrigerator refrigerator = new Refrigerator("꽁꽁",0);
//        refrigerator.menu();
//        Vacuum vacuum = new Vacuum("청소기",2);
//        vacuum.menu();

//        Boiler boiler = new Boiler("난방보일러",30);
//        boiler.menu();
        Home home = new Home(5);
        home.buyHa(new TV("건국TV",7));
        home.buyHa(new Refrigerator("꽁꽁",0));
        home.buyHa(new Vacuum("청소기",2));
        home.buyHa(new Boiler("난방보일러",30));
        home.open();


    }
}
