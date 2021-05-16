package Stack;

public class Main { ;

    public static void main(String[] args) {
        var stack = new StackJ();
       // System.out.println(stack.pop());
     //   System.out.println(stack.peek());
        int[] pu = {1,2,3,4,5};
        int[] po = {4,5,3,2,1};
        var result  = stack.validateStackSequences( pu ,po);
        System.out.println(result);

    }
}
