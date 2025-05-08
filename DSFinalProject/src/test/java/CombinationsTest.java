import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.yyz.Calculation;
import org.yyz.Combinations;

import java.util.*;

public class CombinationsTest {
    @Test
    public void testCalc() {
        List<Double> pars = new ArrayList<>();
        pars.add(5.0);
        pars.add(2.0);
        Calculation combinations = new Combinations(pars);
        combinations.calc();
        Assertions.assertEquals(10, combinations.getResult());
    }

    @Test
    public void testCalc_nP0() {
        List<Double> pars = new ArrayList<>();
        pars.add(5.0);
        pars.add(0.0);
        Calculation combinations = new Combinations(pars);
        combinations.calc();
        Assertions.assertEquals(1, combinations.getResult());
    }

    @Test
    public void testCalc_0Pr() {
        List<Double> pars = new ArrayList<>();
        pars.add(0.0);
        pars.add(1.0);
        Calculation combinations = new Combinations(pars);
        combinations.calc();
        Assertions.assertEquals(-1, combinations.getResult());
    }

    @Test
    public void testCalcDecimalNegative() {
        List<Double> pars = new ArrayList<>();
        pars.add(-5.2);
        pars.add(-2.3);
        Calculation combinations = new Combinations(pars);
        combinations.calc();
        Assertions.assertEquals(-1, combinations.getResult());
    }
}
