package Searching;

public class Search {
    public int linerSearch(int[] list , int target){
        for (var i : list)
            if (list[i] == target)
                return i;

        return -1;
    }
    public int binarySearch(int[] list, int target){
        return binarySearch(list,target,0,list.length-1);
    }
    private int binarySearch(int[] list, int target , int first , int last ){

        if (first > last)
            return -1;

        int middle = (first + last)/2;
        if (list[middle] == target)
            return target;
        if (list[middle] < target)
            return binarySearch(list,target,middle-1 , list.length-1);
        if (list[middle] > target)
            return binarySearch(list,target,first,middle-1);
        return -1;

    }

    public int binarySearchIr(int[] list ,int target){
        int first = 0;
        int last = list.length-1;
        while (first <= last){
            int middle = (first+last)/2;
            if (list[middle]== target)
                return middle;
            if (list[middle]> target)
                last = middle-1;
            else if (list[middle] < target)
                first = middle+1;
        }
        return -1;
    }
    public int ternarySearch(int[] array, int target) {
        return ternarySearch(array, target, 0, array.length - 1);
    }

    private int ternarySearch(
            int[] array, int target, int first, int last) {

        if (first > last)
            return -1;

        int partitionSize = (last - first) / 3;
        int mid1 = first + partitionSize;
        int mid2 = last - partitionSize;

        if (array[mid1] == target)
            return mid1;

        if (array[mid2] == target)
            return mid2;

        if (target < array[mid1])
            return ternarySearch(array, target, first, mid1 - 1);

        if (target > array[mid2])
            return ternarySearch(array, target, mid2 + 1, last);

        return ternarySearch(array, target, mid1 + 1, mid2 - 1);
    }
    public int jumpSearch(int[] array, int target) {
        int blockSize = (int) Math.sqrt(array.length);
        int start = 0;
        int next = blockSize;

        while (start < array.length && array[next - 1] < target) {
            start = next;
            next += blockSize;
            if (next > array.length)
                next = array.length;
        }

        for (var i = start; i < next; i++)
            if (array[i] == target)
                return i;

        return -1;
    }
    public int exponentialSearch(int[] array, int target) {

        int bound = 1;
        while (bound < array.length && array[bound] < target)
            bound *= 2;

        int left = bound / 2;
        int right = Math.min(bound, array.length - 1);

        return binarySearch(array, target, left, right);
    }


}
