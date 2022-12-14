package Node;

import java.util.Iterator;


public class LinkedList <T> implements Iterable <T> {

    private Node head;
    private Node tail;


    public void addHead(T addHeadElement) {
        Node temp = new Node();
        temp.value = addHeadElement;
        if (head==null) {
            head = temp;
            tail = temp;
        } else {
            temp.next = head;
            head = temp;
        }
    }


    public void addTail(T addTailElement) {
        Node temp = new Node();
        temp.value = addTailElement;
        if(head==null){
            head = temp;
            tail = temp;
        } else {
            tail.next = temp;
            temp.previous = tail;
            tail = temp;
        }
    }


    public T getValueHead(){
        if(head==null) return null;
        T headValue = (T)head.value;
        return  headValue;
    }

    public T getValueHeadAndRemove() {
        if(head==null) return null;
        T headValue = (T)head.value;
        remove((T)head.value);
        return headValue;
    }


    public T getValueTail(){
        if (tail==null) return null;
        T tailValue = (T)tail.value;
        return tailValue;
    }

    public T getValueTailAndRemove() {
        if(tail==null) return null;
        T tailValue = (T)tail.value;
        remove((T)tail.value);
        return tailValue;
    }

    void listPrint() {
        Node temp = head;
        while (temp!=null) {
            System.out.println(temp.value);
            temp = temp.next;
        }

    }

    public boolean searchValue (T value) {
        Node temp = head;
        while (temp!=null) {
            if(temp.value == value ) return true;
            temp = temp.next;
        }
        return false;
    }


    public boolean emptyList(){
        Node temp = head;
        while (temp!=null) {
             if(temp.next!=null) return false;
        }
        return true;
    }

    public void remove(T value){
        if (head == null) return;
        if (head == tail) {
            head = null;
            tail = null;
            return;
        }
        if(head.value == value) {
            head = head.next;
            return;
        }
        Node temp = head;
        while (temp!=null & temp.next!=null) {
            if(temp.next.value == value) {
                if (tail == temp.next) {
                    tail = temp;
                }
                temp.next = temp.next.next;
                return;
            }
            temp = temp.next;
        }

    }

    public int size(){
        int size = 0;
        if(head==null) return 0;
        Node temp = head;
        while (temp!=null) {
            size++;
            temp = temp.next;
        }
        return size;
    }


    @Override
    public Iterator<T> iterator() {return new LinkedListIterator<>(head);}

    private static class LinkedListIterator<T> implements Iterator <T> {
        Node node;

        public LinkedListIterator(Node head) {
            node = head;
        }

        @Override
        public boolean hasNext() {
            return node!=null;
        }

        @Override
        public T next() {
            Node temp = node;
            node = node.next;
            return (T)temp.value;
        }

    }

    private static class Node <T>{
        Node next;
        Node previous;
        T value;
    }
}
