package chapter2;


public class Insertion {
    public static void sort(Comparable[] a){
        int N=a.length;
        for (int i = 1; i < N; i++) {
            for(int j=i;j>0&&less(a[j],a[j-1]);j--){
                exch(a,j,j-1);
            }
        }
        //内循环将较大的元素都向右移动而不总是交换两个元素，可大幅度提高插入排序的速度。
//        for(int i=1;i<N;i++){
//            Comparable tmp=a[i];
//            int j=i;
//            for(;j>0&&less(tmp,a[j-1]);j--){
//                a[j]=a[j-1];
//            }
//            a[j]=tmp;
//        }
    }
    private static boolean less(Comparable v,Comparable w){
        return v.compareTo(w)<0;
    }
    private static void exch(Comparable[] a,int i,int j){
        Comparable t=a[i];
        a[i]=a[j];
        a[j]=t;
    }
    public static void show(Comparable[] a){
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+" ");
        }
        System.out.println();
    }

    public static boolean isSorted(Comparable[] a){
        for (int i = 1; i < a.length; i++) {
            if(less(a[i],a[i-1])) return false;
        }
        return true;
    }

}

