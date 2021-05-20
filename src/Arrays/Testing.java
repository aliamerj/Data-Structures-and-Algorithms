package Arrays;

import Arrays.Arrays;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

public class Testing {
    Arrays arraysTest;

    @BeforeEach
    public void setup() {
        arraysTest = new Arrays(4);
        arraysTest.insert(1);
        arraysTest.insert(2);
        arraysTest.insert(3);


    }

    @Test
    void maxTest() {
        int max = arraysTest.max();
        assertSame(3, max);
    }

    @Test
    void minTest() {
        int min = arraysTest.min();
        assertEquals(1, min);

    }
    @Test
    void insertTest(){
        arraysTest.insert(4);
        int[] insert ={1,2,3,4};
        assertEquals(java.util.Arrays.toString(insert), arraysTest.toString());
    }
    @Test
    void toStringTest(){
        String exp = "[1, 2, 3]";
        assertEquals(exp,arraysTest.toString());
    }
    @Test
    void indexTest(){
        int exp = 2;
        int act = arraysTest.index(1);
        assertEquals(exp,act);
    }
    @Test
    void removeTest(){
        int[] ex ={1,2};
        arraysTest.remove(2);
        assertEquals(java.util.Arrays.toString(ex),arraysTest.toString());
    }


}
