package chapter2;

public class MaxPQ <Key extends Comparable<Key>> {
    private Key[] pq;
    private int N;
    public MaxPQ(int maxN){
        pq=(Key[])new Comparable[maxN+1];
    }
    public MaxPQ(Key[] a){
        pq=(Key[]) new Comparable[a.length+1];
        for (int i = 0; i < a.length; i++) {
            insert(a[i]);
        }
    }
    public boolean isEmpty(){
        return N==0;
    }
    public int size(){
        return N;
    }
    public void insert(Key v){
        if(N==(pq.length-1))resize(2*pq.length);
        pq[++N]=v;
        swim(N);
    }
    public Key delMax(){
        Key max=pq[1];
        exch(pq,1,N--);
        pq[N+1]=null;
        sink(1);
        if(N>0&&N==pq.length/4-1)resize(pq.length/2);
        return max;
    }
    private void swim(int k){
        while(k>1&&less(pq[k/2],pq[k])){
            exch(pq,k/2,k);
            k=k/2;
        }
    }
    private void sink(int k){
        while(2*k<=N){
            int j=2*k;
            if(j<N&&less(pq[j],pq[j+1])) j++;
            if(!less(pq[k],pq[j])) break;
            exch(pq,k,j);
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
    private void resize(int max){
        Key[] temp=(Key[])new Comparable[max];
        for (int i = 0; i < N; i++) {
            temp[i]=pq[i];
        }
        pq=temp;
    }
}
