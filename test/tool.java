package test;

/**
 * item중, 내구도가 있는 존재들을 item을 확장시켜서 이용
 */
public class tool extends Item{
    int maxDuration;
    int currentDuration;

    public tool(String itemName, int itemNum, int inventoryPos, int maxDuration, int currentDuration) {
        super(itemName, itemNum, inventoryPos);
        this.maxDuration = maxDuration;
        this.currentDuration = currentDuration;
    }

    @Override
    public String toString() {
        return "tool{" +
                "maxDuration=" + maxDuration +
                ", currentDuration=" + currentDuration +
                ", itemName='" + itemName + '\'' +
                ", itemNum=" + itemNum +
                ", inventoryPos=" + (inventoryPos) +
                '}';
    }
}
