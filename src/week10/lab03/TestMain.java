package week10.lab03;

public class TestMain {

    public static void main(String[] args) {
        MyArrayGeneric<String> myArray = new MyArrayGeneric<>(5);
        myArray.add("dd");
        myArray.add("ss");myArray.add("cc");myArray.add("DDD");
        System.out.println(myArray);

//        MyArray intArray = new MyArray(5);
//        intArray.add(10);
//        intArray.add(10);
//        intArray.add(20);
//        intArray.add(30);
//        intArray.add(40);
//        System.out.println(intArray);
    }
}
