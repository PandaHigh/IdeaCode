package chapter1;

import chapter2.*;

public class Test {
    public static void main(String[] args){
        int[] a=new int[]{1,20,63,29,54,38,20,16};
        Integer[] b=new Integer[a.length];
        for (int i = 0; i < a.length; i++) {
            b[i]=a[i];
        }
        Heap.sort(b);
        for (int i = 0; i < b.length; i++) {
            System.out.println((int)b[i]);
        }
    }


}


