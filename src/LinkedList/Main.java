package LinkedList;

import org.w3c.dom.Node;

import static LinkedList.LinkedList.*;

public class Main {
     public static void main(String[] args) {
        var list = new LinkedList();
         list.addLast(3);
         list.addLast(2);
         list.addLast(1);
         list.first.next.next = list.first;

      //  list.MakeLoop(list.first, list.first.next.next);

         System.out.println(list.cycleList());


    }
}
