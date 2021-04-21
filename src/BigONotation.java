public class BigONotation {
    /* //TODO: Rating Big O (A-> ....) * (A) IS THE BEST
    A= O(1)
    B= (log n )
    C= O(n)
    D= O(n log n)
    E= O(n^k)
    F= O(k^n)
    G= O(n!)
     */

    public static void main(String[] args){
        // O(1)
//        System.out.println("Hi");
//        System.out.println(increase(5));
//        System.out.println(loop(5));
//        System.out.println(fibonacci(3));
        System.out.println(more(5));

    }
    //TODO: O(1)
    private static int plus(){
        int a = 1;
        int b = 2;
        int x = a + b;
        return x;
    }
    //TODO: O(1)
    private static int plusLoop(int n){
        int number =0 ;
        for (int i =1 ;i<= 5 ; i++ ){
            number +=i;
        }
        return number;
    }

    //TODO: O(log n)
    //1 n=5 -> i = 2 ,number=3
    //2 n=5 -> i = 4 , number =7
    //3 n=5 -> i = 8 stop 8>5
    private static int increase(int n){
        int number =0 ;
        for (int i = 1; i <= n ;i *= 2){
            number += i;
        }
        return number;

    }

    // TODO:O(n)
    //1 n=5 -> i = 2 , number = 3
    //2 n=5 -> i = 3 , number= 6
    //3 n=5 -> i = 4 , number= 10
    //4 n=5 -> i = 5 , number= 15
    //5 n=5 -> i = 6 stop
    private static int loop(int n){
        int number=0;
        for(int i = 1; i <= n; i++)
            number +=i;
        return number;
    }
    //TODO: O(n log n)
    //  loop O(n) + increase O(log n)
    private static int loopIncrease(int n){
       int  number= 0 ;
        for (int i = 1; i <= n ; i++ )
            for (int q = 1; q <= n ; q *=2 )
                number += q;
        return number;
    }
    // TODO: O(n^k)
    //     O(n^2) there is two loops inside
    private static int sameLoops(int n){
        int number =0;
        for (int i = 1; i <= n ; i++ )
            for (int q = 1; q <= n ; q++ )
                number += q;
        return number;

    }
    // TODO: O(k^n)
    //   there is references
    private static int fibonacci (int n){
        if (n <= 0)
            return 0;
        else if (n <= 2 )
            return 1;
        else
            return fibonacci(n- 1 )+ fibonacci(n-2);
    }
    // TODO: O(n!)
    //     there is references *2
    private static int more(int n){
        if (n> 0){
            return n * more(n-1);
        }
        return 1;
    }




}
