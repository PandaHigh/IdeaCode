package chapter2;

public class Quick {

    public static void sort(Comparable[] a){
//        tmp=new Comparable[a.length];
        sort(a,0,a.length-1);
    }
    private static void sort(Comparable[] a,int low,int high){
        if(high<=low){return; }
        int j=partition(a,low,high);
        sort(a,low,j-1);
        sort(a,j+1,high);
    }
//    private static Comparable[] tmp;
//    private static int partition(Comparable[] a,int low,int high){
//        Comparable tmpValue=a[low];
//        for(int i=low;i<=high;i++){
//            tmp[i]=a[i];
//        }
//        int m=low;
//        int n=high;
//        for(int i=low+1;i<=high;i++){
//            if(less(tmp[i],tmpValue)){
//                a[m++]=tmp[i];
//            }else{
//                a[n--]=tmp[i];
//            }
//        }
//        a[m]=tmpValue;
//        return m;
//    }
    private static int partition(Comparable[] a,int low,int high){
        int i=low;
        int j=high+1;
        Comparable tmp=a[i];
        while(true){
            while(less(a[++i],tmp)){
                if(i==high) break;
            }
            while(less(tmp,a[--j]));
            if(i>=j) break;
            exch(a,i,j);
        }
        exch(a,low,j);
        return j;
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
