package week10.example;

import java.util.*;

public class TestMain {

    public static void main(String[] args) {
        //example01();
        //example02();
        //example03();
        //example04();
        example05();
        //example06();
    }

    // HashMap
    private static void example06() {
        HashMap<String, Word> map = new HashMap<>();
        map.put("red", new Word("red", "빨강"));
        map.put("green", new Word("green", "초록"));
        map.put("blue", new Word("blue", "파랑"));
        map.put("red", new Word("red", "빨강색"));

        Word w = new Word("blue", "파랑");
        map.put("blue", w);
        map.put("skyblue", w);
        System.out.println(map);
        //변수 타입도 alt+enter로 쉽게 가능!
        Set<Map.Entry<String, Word>> set = map.entrySet();
        Iterator<Map.Entry<String, Word>> it = set.iterator();
        while (it.hasNext()) {
            Map.Entry<String, Word> entry = it.next();
            String key = entry.getKey();
            Word value = entry.getValue();
            System.out.println(key + "=" + value);
        }

        Collection<Word> list = map.values();
        Iterator<Word> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    // 교집합 구하기
    private static void example05() {
        Set<Word> set = new HashSet<>();
        set.add(new Word("red", "빨강"));
        set.add(new Word("green", "초록"));
        set.add(new Word("blue", "파랑"));

        Set<Word> set2 = new HashSet<>();
        set2.add(new Word("red", "빨강"));
        set2.add(new Word("yellow", "노랑"));
        set2.add(new Word("blue", "파랑"));

        Set<Word> intersection = new HashSet<>(set2);
        intersection.retainAll(set);
        System.out.println(intersection);
    }

    // HashSet
    private static void example04() {
        Set<Word> set = new HashSet<>();
        set.add(new Word("red", "빨강"));
        set.add(new Word("green", "초록"));
        set.add(new Word("blue", "파랑"));
        set.add(new Word("red", "빨강"));
        set.add(new Word("green", "초록"));
        set.add(new Word("blue", "파랑"));
        System.out.println(set);

        Iterator<Word> setIt = set.iterator();
        while (setIt.hasNext()) {
            Word w = setIt.next();
            System.out.println(w);
        }
    }

    //Iterator 사용하기
    private static void example03() {
        List<Word> list = new LinkedList<>();
        list.add(new Word("red", "빨강"));
        list.add(new Word("green", "초록"));
        list.add(new Word("blue", "파랑"));

        Iterator<Word> it = list.iterator();
        while (it.hasNext()) {
            Word w = it.next();
            if (w.equals(new Word("green", "초록"))) {
                it.remove();
            }
        }
        System.out.println(list);

        ListIterator<Word> it2 = list.listIterator();
        while (it2.hasNext()) {
            Word w = it2.next();
            System.out.println(w);
        }
        System.out.println("-------------");
        while (it2.hasPrevious()) {
            Word w = it2.previous();
            System.out.println(w);
        }
    }

    // ArrayList & Linked List
    private static void example02() {
        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();

        long startTime;
        long endTime;
        startTime = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            arrayList.add(i);
        }
        endTime = System.nanoTime();
        System.out.println("ArrayList 걸린시간  : " + (endTime - startTime) + "ns");

        startTime = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            linkedList.add(0, i);
        }
        endTime = System.nanoTime();
        System.out.println("LinkedList 걸린시간 : " + (endTime - startTime) + "ns");
    }

    // ArrayList와 Linked List 사용
    private static void example01() {
        List<Word> list = new ArrayList<>();
        list.add(new Word("red", "빨강"));
        list.add(new Word("green", "초록"));
        list.add(new Word("blue", "파랑"));
        list.add(new Word("red", "빨강"));

        Object[] arr1 = list.toArray();
        for (Object o : arr1) {
            if (o instanceof Word word) {
                System.out.println(word);
            }
        }

        Word[] arr = list.toArray(new Word[list.size()]);
    }
}
