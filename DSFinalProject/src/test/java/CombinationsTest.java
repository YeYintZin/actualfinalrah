import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.yyz.Calculation;
import org.yyz.Combinations;
import org.yyz.Permutations;

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

    @Test
    public void test_RBiggerThanN() {
        List<Double> pars = new ArrayList<>();
        pars.add(2.0);
        pars.add(5.0);
        Calculation comb = new Combinations(pars);
        comb.calc();
        Assertions.assertEquals(-1, comb.getResult());
    }

    @Test
    public void testToString() {
        List<Double> pars = new ArrayList<>();
        pars.add(5.0);
        pars.add(2.0);
        Calculation comb = new Combinations(pars);
        String expected = "5C2 = 10";
        comb.calc();
        Assertions.assertEquals(expected, comb.toString());
    }

    @Test
    public void testProcess() {
        List<Double> pars = new ArrayList<>();
        pars.add(5.0);
        pars.add(2.0);
        Calculation comb = new Combinations(pars);
        String expected =
                "Computes 5! divided by (5 - 2)!, which equals to 2! = 2, "
                + "then multipliying by 1 / 2!, giving the final result of 10";
        comb.calc();
        Assertions.assertEquals(expected, comb.process());
    }

    @Test
    public void testAllCalc() {
        List<Double> pars = new ArrayList<>();
        pars.add(5.0);
        pars.add(2.0);
        Calculation comb = new Combinations(pars);
        String expected = "Full process: \n"
                        + "Computes 5! divided by (5 - 2)! = 20\n"
                        + "2 * 1 = 2\n"
                        + "Computes 5! divided by (5 - 2)!, which equals to 2! = 2, "
                        + "then multipliying by 1 / 2!, giving the final result of 10";
        comb.calc();
        Assertions.assertEquals(expected, comb.allCalc());
    }
}
