import org.junit.Assert;
import org.junit.Test;

import static ru.lebedev.se.Homework6.TestMain.AfterFour;
import static ru.lebedev.se.Homework6.TestMain.checkOneAndFour;

/**
 * Java 3, JavaLevel3.
 *
 * @author Anatoly Lebedev
 * @version 1.0.0 20.02.2019
 * @link https://github.com/Centnerman
 */

public class TestDZ {

    @Test
    public void testArr1() {
        Assert.assertArrayEquals(new int[]{1, 7}, AfterFour(new int[]{1, 2, 4, 4, 2, 3, 4, 1, 7}));
    }

    @Test
    public void testArr2() {
        Assert.assertArrayEquals(new int[]{2, 3, 8, 1, 7}, AfterFour(new int[]{1, 2, 4, 4, 2, 3, 8, 1, 7}));
    }

    @Test
    public void testArr3() {
        Assert.assertArrayEquals(new int[0], AfterFour(new int[]{1, 2, 3, 2, 2, 3, 6, 1, 4}));
    }

    @Test(expected = RuntimeException.class)
    public void testArr4() {
        AfterFour(new int[]{1, 2, 3, 2, 2, 3, 6, 1, 7});
    }

    @Test
    public void testCheck1() {
        Assert.assertTrue(checkOneAndFour(new int[]{1, 4, 1, 4, 1, 4}));
    }

    @Test
    public void testCheck2() {
        Assert.assertTrue(checkOneAndFour(new int[]{4, 1, 4, 1, 4}));
    }

    @Test
    public void testCheck3() {
        Assert.assertFalse(checkOneAndFour(new int[]{4, 4, 1, 4, 1, 4}));
    }

}
