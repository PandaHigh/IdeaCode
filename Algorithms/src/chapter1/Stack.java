package chapter1;

import java.util.Iterator;

/**
 * 算法 1.2 下压堆栈（链表实现）
 * @param <T>
 */
public class Stack<T> implements Iterable<T> {
    @Override
    public Iterator<T> iterator() {
        return new stackIterator();
    }

    /**
     * 迭代器
     */
    public class stackIterator implements Iterator<T>{
        private Node current=firstNode;
        @Override
        public boolean hasNext() {
            return current!=null;
        }

        @Override
        public T next() {
            T data=current.data;
            current=current.next;
            return data;
        }
    }
    /**
     * Node 节点
     */
    private class Node{
        Node next;
        T data;
    }
    private Node firstNode;//栈顶（最近添加的元素）
    private int N;//元素数量

    /**
     * 从链表表头压入元素（入栈）
     * @param data 节点的数据
     */
    public void push(T data){
        Node oldFirstNode=firstNode;
        firstNode=new Node();
        firstNode.data=data;
        firstNode.next=oldFirstNode;
        N++;
    }

    /**
     * 取出链表表头（出栈）
     * @return 返回出栈节点的数据
     */
    public T pop(){
        Node popNode=firstNode;
        firstNode=firstNode.next;
        N--;
        return popNode.data;
    }

    /**
     * 栈是否为空
     * @return true：栈为空 false：栈不为空
     */
    public boolean isEmpty(){
        return N==0;
    }

    /**
     * @return 栈中元素的数量
     */
    public int size(){
        return N;
    }
}
