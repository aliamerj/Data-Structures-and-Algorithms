import java.util.ArrayList;
import java.util.Arrays;

public class ArraysConcept {
    public static void main(String[] args) {
        //todo first
//        int[] numbers = {1 , 2 ,3};
//        System.out.println(Arrays.toString(numbers));

        // todo second
        var list1 = new List(3);
        list1.insert(30);
        list1.insert(50);
        list1.insert(90);
        list1.insert(60);
        list1.insert(4);
        list1.remove(3);
        System.out.println(list1.indexOf(60));
        list1.print();
        System.out.println("the max number is : "+ list1.max());
        System.out.println("the min number is : "+ list1.min());
        var list2 = new List(4);
        list2.insert(1);
        list2.insert(50);
        list2.insert(2);
        list2.insert(3);
        list2.insert(4);
        System.out.println(" here ");
        list1.intersect(list2);





        // todo third
//        ArrayList<Integer> list = new ArrayList<>();
//        list.add(10);
//        list.add(20);
//        list.add(30);
//        list.add(40);
//        list.remove(0);
//        System.out.println(list);



    }

}
//TODO:- NEW CLASS HERE
class List {
    private int[] items;
    private int count;

    public List(int length) {
        items = new int[length];
    }

    public void print(){
        for (int i =0 ; i < count ; i++)
            System.out.println(items[i]);

    }
    public void insert(int item){
        // if array is full
        if (items.length == count){
            // make new Array
           int[] newItems = new int[count * 2];
           // copy all items in old array to new array
           for (int i =0 ; i < count ; i++)
               newItems[i] = items[i];
           items = newItems;
        }
        items[count++]= item;
    }
    public void remove(int index){
        // check if index < 0 (-1,-2...) or index >= number of list (count)
        if (index < 0 || index >= count)
            // if it is true make exception
            throw new IllegalArgumentException();
        // if it is not (index < count)
        for (int i = index ; i < count ; i++)
            // make the item that contain index = item beyond
            items[i]= items[i + 1];
        // reduce count
        count--;
    }
    public int indexOf(int item){
        for (int i = 0 ; i < count ; i++ )
            if (items[i] == item)
                return i;
        return -1 ;
    }
    public int max(){
        int max = 0;
        int item;
        for (int i = 0 ; i < count; i++){
            item = items[i];

            if (item > max)
                max = item;
        }
        return max;
    }
    public int min(){
        int min = items[0];
        int item;
        for (int i = 0 ; i < count; i++){
            item = items[i];

            if (item <= min)
                min = item;
        }
        return min;

    }
    public void intersect(List other) {
        var intersection = new List(count);

        for (int item : items)
            if (other.indexOf(item) >= 0)
                intersection.insert(item);
            intersection.print();
    }
    public void reverse() {
        int[] newItems = new int[count];

        for (int i = 0; i < count; i++)
            newItems[i] = items[count - i - 1];

        items = newItems;
    }
    }


