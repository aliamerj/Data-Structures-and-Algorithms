package LinkedList ;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class LinkedList {
     class Node {
         int  value;
         Node next;

        private Object Obj;
        public  Node(int value, Object obj) {
            this.value = value;
            this.Obj = obj;
        }

        public int[] toArray(int number) {
            int[] array = new int[number];
            var current = first;
            var index = 0;
            while (current != null) {
                array[index] = current.value;
                current = current.next;
                index++;
            }
            return array;
        }
    }
     Node first;
    public Node last;
    private int size;

    public void addLast(int item) {
        var node = new Node(item, null);
        if (isEmpty())
            first = last = node;
        else {
            last.next = node;
            last = node;
        }
        size++;
    }

    private boolean isEmpty() {
        return first== null;
    }

    public int[] toArray() {
        int[] array = new int[size];
        var current = first;
        var index = 0;
        while (current != null) {
            array[index] = current.value;
            current = current.next;
            index++;
        }
        return array;
    }
    public  static void print(Node linkedList , int numberOfItem ){
        var list  = Arrays.toString(linkedList.toArray(numberOfItem));
        System.out.println(list);
    }
    public  static void printList(LinkedList linkedList ){
        var list  = Arrays.toString(linkedList.toArray());
        System.out.println(list);
    }

    public Node mergeTwoLists(Node l1, Node l2){
        var elementList1 = l1;
        var elementList2 = l2;
        var node = new Node(0,null);
        var current = node;
        while (elementList1 != null && elementList2 !=null){
            if (elementList1.value >= elementList2.value){
                current.next = elementList2;
                elementList2 = elementList2.next;
            }else{
                current.next = elementList1;
                elementList1 = elementList1.next;
            }
            current = current.next;
        }
        if (elementList1 == null)
            current.next = elementList2;
        else
            current.next = elementList1;
        return node.next;
    }

    public Node reserveSublist(Node head , int left , int right ){
        if(head==null || left==right)
            return head;

        Node start=head;
        Node end=head;
        Node startP=null,endP=null;

        // startP stores the node  just before the left position
        // start stores the node at left position
        for(int i=1;i<left;i++)
        {
            startP=start;
            start=start.next;
        }

        // endP stores the node just after the right postion
        // end  stores the node at right position
        for(int i=1;i<right;i++)
        {
            end=end.next;
            endP=end.next;

        }

        //Reversing the nodes between left to right
        Node prev=start;
        Node curr=start.next;
        while(curr!=endP){

            Node nextt=curr.next;
            curr.next=prev;
            prev=curr;
            curr=nextt;
        }
        // to connect the node at right position to nodes present before left
        if(startP!=null)
            startP.next=end;

        // to connect the node at left position to nodes present after right
        start.next=endP;

        // if left position doesn't start with position 1 then we will simply return head
        if(left!=1)
            return head;
        else
            return end;

    }
    public void reverse() {
        if (isEmpty()) return;

        var firstItem = first;
        var secondItem = first.next;
        while (secondItem != null) {
            var next = secondItem.next;
            secondItem.next = firstItem;
            firstItem = secondItem;
            secondItem = next;
        }
        last = first;
        last.next = null;
        first = firstItem;

    }
    public int indexOf(int indexOfn) {
        int index = 0;
        var current = first;
        while (current != null) {
            if (current.value == indexOfn) return index;
            current = current.next;
            index++;
        }

        return -1;

    }
    public boolean contain(int item) {
        return indexOf(item) != -1;

    }
    public void removeFirst() {
        if (first == last || isEmpty()) {
            removeEmptyOneItem();
        } else {
            var second = first.next;
            first.next = null;
            first = second;
        }
        size--;
    }

    public void removeLast() {
        if (first == last || isEmpty()) {
            removeEmptyOneItem();
        } else {
            var previous = getPrevious(last);
            last = previous;
            last.next = null;
        }
        size--;
    }

    private Node getPrevious(Node node) {
        var current = first;
        while (current != null) {
            if (current.next == node) return current;
            current = current.next;

        }
        return null;
    }

    private void removeEmptyOneItem() {
        if (isEmpty())
            throw new NoSuchElementException();
        if (first == last)
            first = last = null;
    }

    public int getSize() {
        return size;
    }
    public int getKthFromTheEnd(int k) {
        if (isEmpty())
            throw new IllegalStateException();
        var a = first;
        var b = first;
        for (int i = 0; i < k - 1; i++) {
            b = b.next;
            if (b == null)
                throw new IllegalArgumentException();
        }
        while (b != last) {
            a = a.next;
            b = b.next;
        }
        return a.value;
    }
    public Node search(Node node , int key){
        while (node != null && node.value != key)
            node= node.next;
        return node;
    }

    public Node deleteDuplicates(Node head ){
        Node current = first;
        Node other = first.next;
        var node = new Node(0,null);
        while (current.value != other.value) {
            current = current.next;
            if (current == null){
                other = current.next;
                current = first;
            }
            if (current.value == other.value)
                removeByValue(current.value);
        }
        return node;
    }

    public void removeByValue(int item) {
        Node current = first;
        Node prev = null;

        if (current != null && current.value == item) {
            first = current.next;
            return;}

        while (current != null && current.value != item){
            prev = current;
            current = current.next;
        }
        if (current == null)
            return;

        prev.next = current.next;

        size--;


    }
    public boolean cycleList(){
       var node = new Node(0,null);
       var fast = first;
       var slow = first;
        int cyclelen =0;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast ){
            while (slow != fast ){
                cyclelen++;
                fast = fast.next;
                     }
            var start = first;
            while (cyclelen -- > 0 )
                start = start.next;

            var iter = first;
            while (iter != start){
                iter = iter.next;
                start = start.next;
            }
                return true;
            }
        }

        return false ;
    }









//    public void MakeLoop(Node node1 , Node with){
//        var node = new Node(0,null);
//        if (node1 != null && with != null ){
//             node.next = node1;
//             node = with;

//

      }
