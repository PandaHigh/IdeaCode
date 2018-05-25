package utilSort;

import chapter2.*;

import java.util.Random;

public class SortCompare {
    public static double time(String alg,Double[] a){
        double startTime = System.currentTimeMillis();//获取当前时间
        if(alg.equals("Insertion")) Insertion.sort(a);
        if(alg.equals("Selection")) Selection.sort(a);
        if(alg.equals("Shell")) Shell.sort(a);
        if(alg.equals("Merge")) Merge.sort(a);
        if(alg.equals("Quick")) Quick.sort(a);
        double endTime = System.currentTimeMillis();
        return endTime-startTime;
    }
    public static double timeRandomInput(String alg,int N,int T){
        double total=0.0;
        Double[]a =new Double[N];
        Random random=new Random();
        for(int t=0;t<T;t++){
            for (int i = 0; i < N; i++) {
                a[i]=1000*random.nextDouble();
            }
            total +=time(alg,a);
        }
        return total;
    }
    public static void main(String[] args){
        String alg1="Quick";
        String alg2="Merge";
        int N=1000;
        int T=100;
        double t1=timeRandomInput(alg1,N,T);
        double t2=timeRandomInput(alg2,N,T);
        System.out.printf("For %d random Double\n%s is ",N,alg1);
        System.out.printf("%.1f times faster than %s\n",t2/t1,alg2);
    }
}
