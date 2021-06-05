package Heaps;

public class Main {
    public static void main(String[] args) {
        var heap = new Heap();
        heap.insert(10);
        heap.insert(5);
        heap.insert(7);
       var in = heap.lastStoneWeight(new int[]{2,7,4,1,8,1});
        System.out.println(in);
    }
}
