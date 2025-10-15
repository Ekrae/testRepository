package test;

public class TestMain {
    public static Item[] inventory = new Item[5]; //Item 클래스로 도구도 저장 가능.
    public static void main(String[] args) {
        inventory[1] = new Item("stick",5,1);
        inventory[3] = new tool("bow",1,3,10,9);

        for (Item k : inventory){
            if (k!=null){
                System.out.println(k);
            }
        }
    }
}
