package HashTable;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Testing {
    HashTableLib hashTableLib;
    HashTable hashTableTest;
    @BeforeEach
    public void setup(){
        hashTableLib = new HashTableLib();
        hashTableTest = new HashTable();


    }
    @Test
    public void firstNonRebatedTest(){
        String str = "abcda";
        String str2 = "abbc";
        String str3 = "abc";
        String str4 = "aabb";
        String str5 = "";
        assertEquals('b', hashTableLib.firstNonRebated(str));
        assertEquals('a', hashTableLib.firstNonRebated(str2));
        assertEquals('a', hashTableLib.firstNonRebated(str3));
        assertEquals(Character.MIN_VALUE, hashTableLib.firstNonRebated(str4));
        assertEquals(Character.MIN_VALUE, hashTableLib.firstNonRebated(str5));

    }
    @Test
    public void putTest(){
        hashTableTest.put(1,"ALI");

    }
}
