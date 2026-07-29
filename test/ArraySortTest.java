import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArraySortTest {
    @Test
    public void testNumberSortWhenItsOdd(){
        ArraySort sort = new ArraySort();
        int [] numbers = {2, 5, 3, 8, 2, 1};
        int [] expected = sort.getNumberSorted(numbers);
        int[] actual = {5, 2, 8, 3, 1, 2};
        assertArrayEquals(expected, actual);
    }

}
