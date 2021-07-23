package Arrays;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

public class Arrays {
    private int[] items;
    private int count;

    public Arrays(int length) {
        items = new int[length];
    }

    public void print() {
        for (int i = 0; i < count; i++)
            System.out.println(items[i]);
    }

    public void insert(int item) {
        // if array is full
        if (items.length == count) {
            // make new Array
            int[] newItems = new int[count * 2];
            // copy all items in old array to new array
            for (int i = 0; i < count; i++)
                newItems[i] = items[i];
            items = newItems;
        }
        items[count++] = item;
    }

    public void remove(int index) {
        // check if index < 0 (-1,-2...) or index >= number of list (count)
        if (index < 0 || index >= count)
            // if it is true make exception
            throw new IllegalArgumentException();
        // if it is not (index < count)
        for (int i = index; i < count; i++)
            // make the item that contain index = item beyond
            items[i] = items[i + 1];
        // reduce count
        count--;
    }

    public int indexOf(int item) {
        for (int i = 0; i < count; i++)
            if (items[i] == item)
                return i;
        return -1;
    }

    public int max() {
        int max = 0;
        int item;
        for (int i = 0; i < count; i++) {
            item = items[i];

            if (item > max)
                max = item;
        }
        return max;
    }

    public int min() {
        int min = items[0];
        int item;
        for (int i = 0; i < count; i++) {
            item = items[i];

            if (item <= min)
                min = item;
        }
        return min;

    }

    public void intersect(Arrays other) {
        var intersection = new Arrays(count);

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
    public String toString() {
        var array = new Arrays(count);
        int[] list = new int[count];
        for (int i = 0; i < count; i++)
            list[i] = items[i];
        return java.util.Arrays.toString(list);
    }

    public int index(int index) {
        return items[index];
    }
}