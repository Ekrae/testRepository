package week13;

import java.util.*;

/**
 * 정렬 여러번 할 때 아예 비교 클래스 만들어서 사용
 */
class StdComparator implements Comparator<Student>{
    int flag=0;

    public StdComparator(int flag) {
        this.flag = flag;
    }

    @Override
    public int compare(Student o1, Student o2) {
        switch (this.flag){
            case 0->{return o1.sid.compareTo(o2.sid);}
            case 1->{return o1.sid.compareTo(o2.sid)*-1;}
            case 2->{return o1.score-o2.score;}
            case 3->{return (o1.score-o2.score)*-1;}
            case 4->{return o1.name.compareTo(o2.name);}
            case 5->{return o1.name.compareTo(o2.name)*-1;}
        }
        return 0;
    }
}

public class TestMain {
    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();
        list.add(new Student("홍기린","200",0));
        list.add(new Student("홍구린","210",23));
        list.add(new Student("홍이린","220",14));
        list.add(new Student("영기린","230",76));
        list.add(new Student("강기로","240",43));
        Collections.shuffle(list);
        System.out.println(list);
        Collections.sort(list, new StdComparator(3) {
        });







        //Collections.sort(list);  //==? 이름순 오름차순

//        Collections.sort(list, new Comparator<Student>() {
//            @Override
//            public int compare(Student o1, Student o2) {  //계속 메서드 재정의 할 필요 없을때 익명객체 이용
//                return (o1.score-o2.score)*-1;
//            }
//        });
//        System.out.println(list);


//        Integer[] arr = {10,5,8,9,15,6,7};
//        List<Integer> list = Arrays.asList(arr);
//        List<Integer> list1 = new ArrayList<>();
//        Collections.addAll(list1,arr);
//        Collections.shuffle(list);
//        printList(list);
//        Collections.sort(list);
//        printList(list);
//        Collections.reverse(list);
//        printList(list);


//        int[] arr = {10,5,8,9,15,6,7};
//        List<Integer> list = Arrays.asList(arr);    이거는 안됨! 기본 데이터 타입을 리스트로 전환하는건 불가(templete)으로 만들어져서


    }

    private static void printList(List<Integer> list) {
        for (int i : list){
            System.out.print(i+"\t");
        }
        System.out.println();
    }


}
