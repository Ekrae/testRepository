package week10.lab03;

public class MyArrayGeneric<E> {
    private final int CAPACITY;
    private int count = 0;
    E[] arr;

    public MyArrayGeneric(int CAPACITY) {
        this.CAPACITY = CAPACITY;
        arr = (E[])new Object[this.CAPACITY];
    }

    public void add(E e) {
        if (this.count < this.CAPACITY)
            arr[count++] = e;
        else
            System.out.println("공간부족");
    }

    public E getElement(int index) {
        if (index >= 0 && index < count)
            return arr[index];
        else
            return null;
    }

    public int getCAPACITY(){
        return this.CAPACITY;
    }

    @Override
    public String toString() {
        String result = "";
        for(E e : arr) {
            result += e+"\n";
        }
        return result;
    }
}
