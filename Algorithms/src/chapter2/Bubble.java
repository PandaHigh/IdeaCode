package chapter2;

public class Bubble {
    public static void sort(Comparable[] a){
        int N=a.length;
        for (int i = 0; i < N; i++) {
            for(int j=0;j<N-i-1;j++){
                if(less(a[j+1],a[j])){
                    exch(a,j,j+1);
                }
            }
        }
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
