package Stack;

import java.util.Arrays;
import java.util.Stack;

public class StackJ {
    private int size ;
    private int[] items = new int[5];
    public void push(int item){
        if (size == items.length)
            throw new StackOverflowError();
        items[size++] = item;
    }
    public int pop (){
        if (size== 0)
            throw new IllegalStateException();

        return items[--size];
    }
    public int peek(){
        if (size == 0)
            throw new IllegalStateException();
        return items[size - 1];
    }
    public boolean isEmpty(){
        return size == 0;
    }
    @Override
    public String toString(){
        var contain = Arrays.copyOfRange(items,0 , size);
        return Arrays.toString(contain);
    }
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int top=0 ;
        int index= 0;
        Stack<Integer> stack = new Stack<Integer>();
         if (top  < popped.length && pushed.length == popped.length){
             while (index+1 < popped.length){
                 int popValue = popped[index];
                 if(popValue != pushed[top] && top+1 < pushed.length){
                     stack.push(pushed[top]);
                         top++;
                 } else if (popped[index]== stack.pop()){
                         stack.pop();
                         top--;
                 }
                 else
                     index++;
                 }

             }

        return stack.isEmpty();
        }



    }

