import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.yyz.BinomialPDF;
import org.yyz.Calculation;

import java.util.*;

public class BinomialPDFTest {
    @Test
    public void testCalc() {
        List<Double> pars = new ArrayList<>();
        pars.add(10.0);
        pars.add(4.0);
        pars.add(0.4);
        Calculation bpdf = new BinomialPDF(pars);
        bpdf.calc();
        Assertions.assertEquals(0.250822656, bpdf.getResult());
    }

    @Test
    public void testCalc0Cr() {
        List<Double> pars = new ArrayList<>();
        pars.add(0.0);
        pars.add(4.0);
        pars.add(0.4);
        Calculation bpdf = new BinomialPDF(pars);
        bpdf.calc();
        Assertions.assertEquals(-1, bpdf.getResult());
    }

    @Test
    public void testCalcnC0() {
        List<Double> pars = new ArrayList<>();
        pars.add(10.0);
        pars.add(0.0);
        pars.add(0.4);
        Calculation bpdf = new BinomialPDF(pars);
        bpdf.calc();
        Assertions.assertEquals(0.006046617599999997, bpdf.getResult());
    }

    @Test
    public void testCalcBelowImpossible() {
        List<Double> pars = new ArrayList<>();
        pars.add(10.0);
        pars.add(4.0);
        pars.add(-0.2);
        Calculation bpdf = new BinomialPDF(pars);
        bpdf.calc();
        Assertions.assertEquals(-1, bpdf.getResult());
    }

    @Test
    public void testCalcAboveGaranteed() {
        List<Double> pars = new ArrayList<>();
        pars.add(10.0);
        pars.add(4.0);
        pars.add(1.2);
        Calculation bpdf = new BinomialPDF(pars);
        bpdf.calc();
        Assertions.assertEquals(-1, bpdf.getResult());
    }
}
