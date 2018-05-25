package chapter2;

public class Merge {

    private static Comparable[] aux;
    public static void merge(Comparable[] a,int low,int mid,int high){
        int i=low,j=mid+1;
        for (int k = 0; k <=high; k++) {
            aux[k]=a[k];
        }
        for(int k=low;k<=high;k++){
            if(i>mid) a[k]=aux[j++];
            else if(j>high) a[k]=aux[i++];
            else if(less(aux[j],aux[i])) a[k]=aux[j++];
            else a[k]=aux[i++];
        }
    }

    public static void sort(Comparable[] a){
        aux=new Comparable[a.length];
        sort(a,0,a.length-1);
//        sortNew(a,0,a.length-1);
    }
    private static void sort(Comparable[] a,int low,int high){
        if(high<=low){
            return;
        }
        int mid=low+(high-low)/2;
        sort(a,low,mid);
        sort(a,mid+1,high);
        //如果左半边最大的值，小于或者等于则不进行归并操作
        if(less(a[mid+1],a[mid])){
            merge(a,low,mid,high);
        }
    }
    //改进插入排序处理小规模的子数组。而不是一直递归到最小规模数组
    private static void sortNew(Comparable[] a,int low ,int high){
        if(high-low<=15){
            //TODO
            Comparable[] b=new Comparable[high-low+1];
            for(int i=0;i<b.length;i++){
                b[i]=a[low+i];
            }
            Insertion.sort(b);
            for(int i=0;i<b.length;i++){
                a[low+i]=b[i];
            }
            return;
        }
        int mid=low+(high-low)/2;
        sort(a,low,mid);
        sort(a,mid+1,high);
        //如果左半边最大的值，小于或者等于则不进行归并操作
        if(less(a[mid+1],a[mid])){
            merge(a,low,mid,high);
        }
    }
    //merge改进，将a[]的后半部分降序复制到aux[]中，然后再将其归并到a[]中，这样可以去掉内循环中检测某半边是否用尽的代码。
    public static void mergeNew(Comparable[] a,int low,int mid,int high){
        int i=low,j=high;
        for(int k=low;k<=mid;k++){
            aux[k]=a[k];
        }
        int h=high;
        for(int k=mid+1;k<=high;k++){
            aux[k]=a[h--];
        }
        for(int k=low;k<=high;k++){
            if(less(aux[i],aux[j])){
                a[k]=aux[i++];
            }else{
                a[k]=aux[j--];
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
