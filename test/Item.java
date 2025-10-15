package test;
/**
 * 보편적인 item 클래스를 만듬
 */
public class Item {
    String itemName;
    int itemNum;
    int inventoryPos;

    public Item(String itemName, int itemNum, int inventoryPos) {
        this.itemName = itemName;
        this.itemNum = itemNum;
        this.inventoryPos = inventoryPos;
    }

    @Override
    public String toString() {
        return "Item{" +
                "itemName='" + itemName + '\'' +
                ", itemNum=" + itemNum +
                ", inventoryPos=" + (inventoryPos) +
                '}';
    }
}
