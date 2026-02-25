import junit.framework.TestCase;

public class CalcTest extends TestCase {

    public void testAdd() {
        Calc calc = new Calc();
        assertEquals(5.0, calc.add(2.0, 3.0), 0.01);
        assertEquals(-1.0, calc.add(-2.0, 1.0), 0.01);
        assertEquals(0.0, calc.add(0.0, 0.0), 0.01);
    }

    public void testSubtract() {
        Calc calc = new Calc();
        assertEquals(-1.0, calc.subtract(2.0, 3.0), 0.01);
        assertEquals(-3.0, calc.subtract(-2.0, 1.0), 0.01);
        assertEquals(0.0, calc.subtract(0.0, 0.0), 0.01);
    }

}