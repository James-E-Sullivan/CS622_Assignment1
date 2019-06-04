package search;

import org.junit.Test;

import static org.junit.Assert.*;

public class ParcelComparatorTest {

    private ParcelComparator<Integer> intComp = new ParcelComparator<>();

    @Test
    public void highValue() {
        assertEquals(intComp.highValue(0, 1), (Integer) 1);
    }

    @Test
    public void lowValue() {
        assertEquals(intComp.lowValue(0, 1), (Integer) 0);
    }
}