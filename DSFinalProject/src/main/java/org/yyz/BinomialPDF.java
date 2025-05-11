package org.yyz;

import java.util.*;

public class BinomialPDF extends Calculation {
    public BinomialPDF(List<Double> pars) {
        super(pars);
        this.name = "Binomial Probability Density Function";
        this.degreeOfComplexity = 3;
    }

    @Override
    public void calc() {
        calc(pars.get(0).intValue(), pars.get(1).intValue(), pars.get(2));
    }

    /**
     * Computes the Binomial Probability Density Function
     * @param n Total attempts
     * @param x Amount of successful attempts
     * @param p Probability of success
     */
    public void calc(int n, int x, double p) {
        if (!isValid()) {
            result = -1;
            return;
        }
        Combinations comb = new Combinations(pars);
        comb.calc(n, x);
        calculations.add(comb);
        double success = Math.pow(p, x);
        double failure = Math.pow(1 - p, n - x);
        this.result = comb.result * success * failure;
    }

    /**
     * Checks if the function is computable, meaning nCr is computable,
     * and probability is between 0-1
     * @return true if valid
     */
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

    /**
     * Shows process of calculations
     * @return String containing full process
     */
    @Override
    public String process() {
        return pars.getFirst().intValue() + "C" + pars.get(1).intValue()
                + " * "
                + pars.get(2) + "^" + pars.get(1).intValue() + " * "
            + (1 - pars.get(2)) + "^" + (int) (pars.get(0) - pars.get(1));
    }

    /**
     * Explains permutations
     * @return explanation
     */
    @Override
    public String explain() {
        return "Returns the probability of x successes in a total of n trials, based on probability p";
    }

    /**
     * Show processes for all calculations
     * @return all calculations
     */
    @Override
    public String allCalc() {
        StringBuilder s = new StringBuilder();
        s.append("Full process: " + "\n");
        for (int i = 0; i < 1; i++) {
            s.append(calculations.get(i).process());
            s.append("\n");
        }
        s.append(process());
        return s.toString();
    }

    /**
     * Special toString displaying result
     * @return (nCr * p^n * (1 - p)^(n - r)= num)
     */
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
