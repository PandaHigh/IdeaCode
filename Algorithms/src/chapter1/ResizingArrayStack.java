package chapter1;

import java.util.Iterator;

/**
 * 算法1.1 下压栈（能够动态调整数组大小的实现）
 * @param <T>
 */

public class ResizingArrayStack<T> implements Iterable<T> {
    /**
     * 栈里存的item数量
     */
    private int N=0;
    /**
     * 用来实现栈存放的数组
     */
    private T[] a=(T[])new Object[1];

    /**
     * 栈是否为空
     * @return true：栈为空 false：栈不为空
     */
    public boolean isEmpty(){return N==0;}

    /**
     * 返回栈中存放的item数量
     * @return 数量
     */
    public int size(){return N;}

    /**
     * 动态改变数组的大小，防止栈溢出或者浪费
     * @param max 数组大小
     */
    private void resize(int max){
        T[] b=(T[])new Object[max];
        for (int i = 0; i < a.length; i++) {
            b[i]=a[i];
        }
        a=b;
    }

    /**
     * 压入数据
     * @param data
     */
    public void push(T data){
        if(N==a.length){
            resize(2*a.length);
        }
        a[N]=data;
        N++;
    }

    /**
     * 弹出数据
     * @return 返回弹出的数据
     */
    public T pop(){
        if(N>0&&N==(a.length/4)){
            resize(a.length/2);
        }
        T data=a[N-1];
        a[N-1]=null;
        N--;
        return data;
    }

    /**
     * 迭代器
     * @return 返回一个迭代器
     */
    @Override
    public Iterator<T> iterator() {
        return new ReverseArrayIterator();
    }

    public class ReverseArrayIterator implements Iterator<T>{
        private int i=N;
        @Override
        public boolean hasNext() {
            return i>0;
        }

        @Override
        public T next() {
            i--;
            return a[i];
        }
        /**
         * 暂时不实现remove（）方法
         */
        public void remove(){
            throw new UnsupportedOperationException("not such method exist");
        }
    }
}
