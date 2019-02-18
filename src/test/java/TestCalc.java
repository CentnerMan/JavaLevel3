import org.junit.*;
import ru.lebedev.se.Homework6.lesson6.Calculator;

public class TestCalc {

    Calculator calculator;

    @Before
    public void init() {
        System.out.println("init");
        calculator = new Calculator();
    }

    @Test
    public void test1() {
        Assert.assertEquals(4, calculator.add(2,2));
    }

    @Test
    public void test2() {
        Assert.assertEquals(5, calculator.add(3,2));
    }

    @Test
    public void test3() {
        Assert.assertEquals(6, calculator.add(4,2));
    }

    @Test(expected = ArithmeticException.class, timeout = 100)
    @Ignore(value = "Не хочу ждать!!!")
    public void test4() {
        try {
            Thread.sleep(500000000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        calculator.div(10,0);
    }

    @After
    public void shutdown() {
        System.out.println("END!");
    }
}
