package chapter1;

import java.util.Iterator;

public class Queue<T> implements Iterable<T> {
    /**
     * 定义了节点的嵌套类
     */
    private class Node{
        Node next;
        T data;
    }
    private Node first;
    private Node last;
    private int N;

    /**
     * 链表是否为空
     * @return true：链表为空 false：链表不为空
     */
    public boolean isEmpty(){
        return first==null;
    }

    /**
     * 返回链表大小
     * @return 元素数量
     */
    public int size(){
        return N;
    }

    /**
     * 向链表尾部添加元素
     */
    public void enqueue(T data){
        Node nextNode=new Node();
        nextNode.data=data;
        if(first==null){
            first=nextNode;
            last=nextNode;
        }else{
            last.next=nextNode;
            last=nextNode;
        }
        N++;
    }

    /**
     * 从链表表头移除元素，实现FIFO队列
     * @return 移除的元素数据
     */
    public T dequeue(){
        T data=first.data;
        first=first.next;
        if(isEmpty()){
            last=null;
        }
        N--;
        return data;
    }

    /**
     * 移除下标位置为k的节点
     * @param k 下标位置
     * @return 被移除节点的数据
     */
    public T remove(int k){
        T data=null;
        if (k == 1) {
            data=first.data;
            first=first.next;
        }else{
            Node currentNode=first;
            for(int i=1;i<k-1;i++){
                currentNode=currentNode.next;
            }
            data=currentNode.next.data;
            currentNode.next=currentNode.next.next;
        }
        N--;
        return data;
    }

    /**
     * 查找链表中是否存在该节点
     * @param data 要查找的节点数据
     * @return true：链表中存在该节点 false：链表中不存在该节点
     */
    public boolean find(T data){
        return findNode(data)!=null;
    }
    /**
     * 迭代器实现
     * @return 迭代器
     */
    @Override
    public Iterator<T> iterator() {
        return new queueIterator();
    }
    private class queueIterator implements Iterator<T>{
        private Node current=first;
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
     * 接受一个链表节点作为参数并删除该节点的后续节点
     * @param data 链表节点数据
     * @return true：删除成功 false：删除失败
     */
    public boolean removeAfter(T data){
        boolean removeDone=false;
        Node node=findNode(data);//找到节点
        if(node!=null){
            node.next=null;
            removeDone=true;
        }
        Iterator<T> iterator = iterator();
        int n=0;
        while(iterator.hasNext()){
            iterator.next();
            n++;
        }
        this.N=n;//重置链表大小
        return removeDone;
    }

    /**
     *接受两个链表节点作为参数，将第二个节点插入链表并使其成为地一个节点的后续节点
     * @param data1 第一个链表节点数据
     * @param data2 第二个链表节点数据
     * @return true：插入成功 false：插入失败
     */
    public boolean insertAfter(T data1,T data2){
        boolean insertDone=false;
        Node node2=new Node();
        node2.data=data2;
        Node node=findNode(data1);
        if(node!=null) {
            node2.next = node.next;
            node.next = node2;
            insertDone = true;
            this.N++;
        }
        return insertDone;
    }
    /**
     * 查找data在链表中的节点
     * @param data 节点数据
     * @return 参数data对应的节点，若未找到则返回null
     */
    private Node findNode(T data){
        Node node=first;
        do{
            if(node.data.equals(data)){
                break;
            }else {
                node=node.next;
            }
        }while(node!=null);
        return node;
    }

    /**
     * 查找链表中位置为index的节点
     * @param index 查找位置
     * @return index位置对应的节点
     */
    private Node findNode(int index){
        Node node=first;
        for (int i = 0; i < index; i++) {
            node=node.next;
        }
        return node;
    }
}
