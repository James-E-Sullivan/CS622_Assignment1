import org.junit.Test;

import static org.junit.Assert.*;

public class Assessment1_PartBTest {

    @Test
    public void alwaysReturns1() {
        Assessment1_PartB object1 = new Assessment1_PartB();
        assertEquals(1, object1.alwaysReturns1());
    }
}