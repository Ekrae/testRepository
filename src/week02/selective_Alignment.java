package week02;

public class selective_Alignment {
    //정렬 알고리즘
    public static void work01(){
        int[] a = {2,34,21,94,65,930,42,73};
        for (int i = 0; i<a.length-1;i++){

            int min = i;
            for (int j=i+1;j<a.length;j++){ //최소찾는 과정
                if (a[min]>a[j]){
                    min = j;
                }
            }

            if (min==i){
                continue;
            }else{
                a[i] ^= a[min];
                a[min] ^= a[i];
                a[i] ^= a[min];
            }
        }
        for (int k: a){
            System.out.print(k+" ");
        }


    }
    public static void main(String[] args) {
        work01();
    }
}
