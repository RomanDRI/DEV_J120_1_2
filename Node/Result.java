package Node;

import java.util.Iterator;

public class Result {

    public static void main(String[] args) {
        LinkedList <Integer> list = new LinkedList<Integer>();
        list.addHead(25);
        list.addTail(55);
        list.addTail(65);
        list.addTail(75);
        list.addTail(85);
        list.addTail(95);

        System.out.println("Переборка всего содержимого списка");

        for (Integer a: list) {
            System.out.println(a);
        }

        System.out.println("__________________________________");

        System.out.println("Переборка списка от головы до заданного значения");


        for (Integer a: list){
            System.out.println(a);
            if(a == 75) break;
        }

        System.out.println("__________________________________");

        System.out.println("Переборка списка от заданного значения до конца");

        Iterator <Integer> iterator =  list.iterator();
        while (iterator.hasNext()){
            if(iterator.next() == 65) {
                iterator.forEachRemaining(System.out::println);
            }
        }

        System.out.println("__________________________________");

        System.out.println("Value head is " + list.getValueHead());
        System.out.println("Value tail is " + list.getValueTail());

    }
}
