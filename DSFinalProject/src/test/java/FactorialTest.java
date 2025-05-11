import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.yyz.Calculation;
import org.yyz.Factorial;

import java.util.*;

public class FactorialTest {

    @Test
    public void testCalc() {
        List<Double> pars = new ArrayList<>();
        pars.add(5.0);
        Calculation fac = new Factorial(pars);
        fac.calc();
        Assertions.assertEquals(120, fac.getResult());
    }

    @Test
    public void testDecimalNegCalc() {
        List<Double> pars = new ArrayList<>();
        pars.add(-4.2);
        Calculation fac = new Factorial(pars);
        fac.calc();
        Assertions.assertEquals(-1, fac.getResult());
    }

    @Test
    public void testCalc0() {
        List<Double> pars = new ArrayList<>();
        pars.add(0.0);
        Calculation fac = new Factorial(pars);
        fac.calc();
        Assertions.assertEquals(1, fac.getResult());
    }

    @Test
    public void testToString() {
        List<Double> pars = new ArrayList<>();
        pars.add(5.0);
        Calculation fac = new Factorial(pars);
        String expected = "5! = 120";
        fac.calc();
        Assertions.assertEquals(expected, fac.toString());
    }

    @Test
    public void testProcess() {
        List<Double> pars = new ArrayList<>();
        pars.add(5.0);
        Calculation fac = new Factorial(pars);
        String expected = "5 * 4 * 3 * 2 * 1 = 120";
        fac.calc();
        String result = fac.process();
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testAllCalc() {
        List<Double> pars = new ArrayList<>();
        pars.add(5.0);
        Calculation fac = new Factorial(pars);
        String expected = "Full process:\n5 * 4 * 3 * 2 * 1 = 120";
        fac.calc();
        Assertions.assertEquals(expected, fac.allCalc());
    }
}
