package Heaps;

import java.util.PriorityQueue;

class KthLargest {

    PriorityQueue<Integer> heap;
    int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        heap = new PriorityQueue<>();
        minHeap(k, nums);
    }


    private void minHeap(int k, int[] nums) {
        for (int i = 0; i < k && i < nums.length; i++) {
            heap.offer(nums[i]);
        }
        for (int i = k; i < nums.length; i++){
                bubbleUp(nums[i]);
            }

        }

    public int add(int val) {
        if(!heap.isEmpty() && heap.size()>=k ) {
            bubbleUp(val);
        }else heap.offer(val);
        return heap.element();

    }

    private void bubbleUp(int val) {
        if (val > heap.element()) {
            heap.remove();
            heap.offer(val);
        }
    }
}