package HashTable;

import java.util.HashMap;
import java.util.Map;

public class HashTableLib {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        map.put(1,"Ali");
        map.put(2,"Amer");
        map.put(3 , "shanoon");
        map.remove(3);
        System.out.println(map);

        map.containsKey(1); // o(1)

        map.containsValue("Amer"); //o(n)
// todo : it iterate over key and value
        for (var item : map.entrySet()){
            System.out.println(item);
        }
// todo : it iterate just over key
        for (var item : map.keySet()){
            System.out.println(item);
        }


    }
    public char firstNonRebated(String str){
        Map<Character , Integer> map = new HashMap<>();
        var chars = str.toCharArray();
        for (var ch : chars){
            var count = map.containsKey(ch) ? map.get(ch) : 0;
            map.put(ch,count+1);
        }
        for(var ch : chars)
            if (map.get(ch)==1)
                return ch;

        return Character.MIN_VALUE;

    }
}
