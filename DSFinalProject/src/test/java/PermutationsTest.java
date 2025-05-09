import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.yyz.Calculation;
import org.yyz.Factorial;
import org.yyz.Permutations;

import java.util.*;

public class PermutationsTest {

    @Test
    public void testCalc() {
        List<Double> pars = new ArrayList<>();
        pars.add(5.0);
        pars.add(2.0);
        Calculation perm = new Permutations(pars);
        perm.calc();
        Assertions.assertEquals(20, perm.getResult());
    }

    @Test
    public void testCalc_nP0() {
        List<Double> pars = new ArrayList<>();
        pars.add(5.0);
        pars.add(0.0);
        Calculation perm = new Permutations(pars);
        perm.calc();
        Assertions.assertEquals(1, perm.getResult());
    }

    @Test
    public void testCalc_0Pr() {
        List<Double> pars = new ArrayList<>();
        pars.add(0.0);
        pars.add(5.0);
        Calculation perm = new Permutations(pars);
        perm.calc();
        Assertions.assertEquals(-1, perm.getResult());
    }

    @Test
    public void testCalc_DeciNegative() {
        List<Double> pars = new ArrayList<>();
        pars.add(-5.3);
        pars.add(-2.1);
        Calculation perm = new Permutations(pars);
        perm.calc();
        Assertions.assertEquals(-1, perm.getResult());
    }

    @Test
    public void test_RBiggerThanN() {
        List<Double> pars = new ArrayList<>();
        pars.add(2.0);
        pars.add(5.0);
        Calculation perm = new Permutations(pars);
        perm.calc();
        Assertions.assertEquals(-1, perm.getResult());
    }

    @Test
    public void testToString() {
        List<Double> pars = new ArrayList<>();
        pars.add(5.0);
        pars.add(2.0);
        Calculation perm = new Permutations(pars);
        String expected = "5P2 = 20";
        perm.calc();
        Assertions.assertEquals(expected, perm.toString());
    }

    @Test
    public void testProcess() {
        List<Double> pars = new ArrayList<>();
        pars.add(5.0);
        pars.add(2.0);
        Calculation perm = new Permutations(pars);
        String expected = "Computes 5! divided by (5 - 2)! = 20";
        perm.calc();
        Assertions.assertEquals(expected, perm.process());
    }

    @Test
    public void testAllCalc() {
        List<Double> pars = new ArrayList<>();
        pars.add(5.0);
        pars.add(2.0);
        Calculation perm = new Permutations(pars);
        String expected =
                "Full process: \n"
                + "5 * 4 * 3 * 2 * 1 = 120\n"
                + "3 * 2 * 1 = 6\n"
                + "Computes 5! divided by (5 - 2)! = 20";
        perm.calc();
        Assertions.assertEquals(expected, perm.allCalc());
    }
}
