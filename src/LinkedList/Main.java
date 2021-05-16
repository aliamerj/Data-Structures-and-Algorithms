package LinkedList;

import org.w3c.dom.Node;

import static LinkedList.LinkedList.*;

public class Main {
     public static void main(String[] args) {
        var list = new LinkedList();
         list.addLast(4);
         list.addLast(3);
         list.addLast(2);
         list.addLast(1);
      //   printList(list);
         list.deleteNode(list.first);
         printList(list);
       //  System.out.println(list.lookFor(list.first.next.next));

      //   print(list.cycleList(),1);

    }
}
