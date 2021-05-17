package Stack;

import java.util.Arrays;
import java.util.Stack;

public class StackJ {
    private int size;
    private int[] items = new int[5];

    public void push(int item) {
        if (size == items.length)
            throw new StackOverflowError();
        items[size++] = item;
    }

    public int pop() {
        if (size == 0)
            throw new IllegalStateException();

        return items[--size];
    }

    public int peek() {
        if (size == 0)
            throw new IllegalStateException();
        return items[size - 1];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        var contain = Arrays.copyOfRange(items, 0, size);
        return Arrays.toString(contain);
    }

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int[] stack = new int[pushed.length];
        int top = -1;
        int pop = 0;
        for(int i = 0; i < pushed.length; i++) {
            stack[++top] = pushed[i];
            while(popNotBigAndTopNotSmallAndItemExist(popped,stack, top, pop)) {
                top--;
                pop++;
            }
        }
        return top == -1;
    }

    private boolean popNotBigAndTopNotSmallAndItemExist(int[] popped, int[] stack, int top, int pop ) {

        return pop < popped.length && top >= 0 && stack[top] == popped[pop];
    }
}
