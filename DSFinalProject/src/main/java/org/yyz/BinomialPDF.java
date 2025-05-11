package org.yyz;

import java.util.*;

public class BinomialPDF extends Calculation {
    public BinomialPDF(List<Double> pars) {
        super(pars);
        this.name = "Binomial Probability Density Function";
    }

    @Override
    public void calc() {
        calc(pars.get(0).intValue(), pars.get(1).intValue(), pars.get(2));
    }

    public void calc(int n, int x, double p) {
        if (!isValid()) {
            result = -1;
            return;
        }
        Combinations comb = new Combinations(pars);
        comb.calc(n, x);
        double success = Math.pow(p, x);
        double failure = Math.pow(1 - p, n - x);
        this.result = comb.result * success * failure;
    }

    @Override
    boolean isValid() {
        return pars.getFirst() > 0 &&
                pars.getFirst() % 1 == 0 &&
                pars.get(1) >= 0 &&
                pars.get(1) % 1 == 0 &&
                pars.get(0) > pars.get(1) &&
                pars.get(2) >= 0 &&
                pars.get(2) <= 1;
    }

    @Override
    public String process() {
        return pars.getFirst().intValue() + "C" + pars.get(1).intValue()
                + " * "
                + pars.get(2) + "^" + pars.get(1)
            + (1 - pars.get(2)) + "^" + (int) (pars.get(0) - pars.get(1));
    }

    @Override
    public String explain() {
        return "Returns the probability of x successes in a total of n trials, based on probability p";
    }

    @Override
    public String allCalc() {
        StringBuilder s = new StringBuilder();
        s.append("Full process: " + "\n");
        for (int i = 0; i < 2; i++) {
            s.append(calculations.get(i).process());
            s.append("\n");
        }
        s.append(process());
        return s.toString();
    }

    @Override
    public String toString() {
        return pars.getFirst().intValue()
                + "C"
                + pars.get(1).intValue()
                + " * " + pars.get(2)
                + "^" + pars.get(1).intValue()
                + " * " + (1 - pars.get(2))
                + "^" + (int) (pars.get(0) - pars.get(1))
                + " = " + result;
    }
}
