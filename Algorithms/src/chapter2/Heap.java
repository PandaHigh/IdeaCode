package chapter2;


public class Heap {
    public static void sort(Comparable[] tmpArray){
        int N=tmpArray.length;
        for(int k=N/2;k>=1;k--){
            sink(tmpArray,k,N);
        }
        while(N>1){
            exch(tmpArray,0,N-1);
            N--;
            sink(tmpArray,1,N);
        }
    }
    private static void sink(Comparable[] a,int k,int N){
        while(2*k<=N){
            int j=2*k;
            if(j<N&&less(a[j-1],a[j])) j++;
            if(!less(a[k-1],a[j-1])) break;
            exch(a,k-1,j-1);
            k=j;
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
