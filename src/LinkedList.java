import java.util.Arrays;
import java.util.NoSuchElementException;

public class LinkedList {
    public static void main(String[] args) {
        var list = new LinkedList();
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);
        System.out.println(Arrays.toString(list.toArray()));
        System.out.println(list.getKthFromTheEnd(1));


    }

    private class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    private Node first;
    private Node last;
    private int size;


    public void addLast(int item) {
        var node = new Node(item);
        if (isEmpty())
            first = last = node;
        else {
            last.next = node;
            last = node;
        }
        size++;
    }

    public void addFirst(int item) {
        var node = new Node(item);
        if (isEmpty()) {
            first = last = node;
        } else {
            first.next = node;
            first = node;
        }
        size++;
    }

    private boolean isEmpty() {
        return first == null;
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


}
