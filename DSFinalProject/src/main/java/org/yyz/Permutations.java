package org.yyz;

import java.util.List;

public class Permutations extends Calculation {

    public Permutations(List<Double> pars) {
        super(pars);
        this.name = "Permutations";
        this.degreeOfComplexity = 2;
    }

    @Override
    public void calc() {
        calc(pars.getFirst(), pars.get(1));
    }

    /**
     * Calculates nPr
     * @param n Total
     * @param r Ways arranged in
     */
    public void calc(double n, double r) {
        if (!isValid()) {
            result = -1;
            return;
        }
        Factorial numerator = new Factorial(pars);
        Factorial denominator = new Factorial(pars);
        numerator.calc((int) n);
        denominator.calc((int) (n - r));
        calculations.add(numerator);
        calculations.add(denominator);
        result = numerator.result / denominator.result;
    }

    /**
     * Checks if nPr is valid, meaning both n and r are natural numbers, n != 0, and n > r
     * @return true if valid
     */
    @Override
    boolean isValid() {
        return pars.getFirst() > 0 &&
                pars.getFirst() % 1 == 0 &&
                pars.get(1) >= 0 &&
                pars.get(1) % 1 == 0 &&
                pars.get(0) > pars.get(1);
    }

    /**
     * Shows process of calculations
     * @return String containing full process
     */
    @Override
    public String process() {
        return "Computes "
                + pars.get(0).intValue() + "! " + "divided by ("
                + pars.get(0).intValue() + " - "
                + pars.get(1).intValue() + ")! = "
                + (int) result;
    }

    /**
     * Explains permutations
     * @return explanation
     */
    @Override
    public String explain() {
        return "nPr: " +
                "returns Permutation, the amount of combinations possible, with order mattering\n" +
                "n!/(n-r)!";
    }

    /**
     * Show processes for all calculations
     * @return all calculations
     */
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

    /**
     * Special toString displaying result
     * @return (nPr = x)
     */
    @Override
    public String toString() {
        return pars.get(0).intValue() + "P" + pars.get(1).intValue() + " = " + (int) result;
    }
}
