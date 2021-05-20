package queue;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class queueLibraries {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        //todo :- add to add
        //  it throws exception is queue full
        queue.add(10);
        queue.add(20);
        queue.add(30);
        queue.add(40);

        //todo[ offer it return false is queue full]
        queue.offer(5);
        System.out.println(queue);

        // todo :- remove the first item in queue ,
        //  it throws exception is queue empty
        queue.remove();

        //todo  if there is item will delete if not it doesn't  do any  think
          queue.poll();

          // todo = to show the first item in queue
          //  it throws exception is queue empty
        queue.element();

        // todo :- peek to show the first item in queue
        //  without deleted it return <null> is queue empty
        var getFirst = queue.peek();
        System.out.println(getFirst);



    }

}
