package Searching;

public class Main {
    public static void main(String[] args) {
        var search = new Search();
        int[] list = {1,2,3,4,5};
        var t=search.ternarySearch(list,4);
        System.out.println(t);
    }
}
