package org.yyz;

import java.util.List;

public class Combinations extends Calculation {
    public Combinations(List<Double> pars) {
        super(pars);
        this.name = "Combinations";
        this.degreeOfComplexity = 2;
    }

    @Override
    public void calc() {
        calc(pars.get(0).intValue(), pars.get(1).intValue());
    }

    /**
     * Calculates nCr
     * @param n Total
     * @param r Ways arranged in
     */
    public void calc(int n, int r) {
        if (!isValid()) {
            result = -1;
            return;
        }
        Permutations perm = new Permutations(pars);
        Factorial factor = new Factorial(pars.subList(1, pars.size()));
        perm.calc(n, r);
        factor.calc(r);
        calculations.add(perm);
        calculations.add(factor);
        result = (1 / factor.result) * perm.result;
    }

    /**
     * Checks if nCr is valid, meaning both n and r are natural numbers, n != 0, and n > r
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
                + pars.get(1).intValue() + ")!, which equals to "
                + calculations.get(1)
                + ", then multipliying by 1 / "
                + pars.get(1).intValue() + "!, giving the final result of "
                + (int) result;
    }

    /**
     * Explains permutations
     * @return explanation
     */
    @Override
    public String explain() {
        return "nCr: " +
                "returns Combinations, the amount of combinations possible, with order not mattering\n" +
                "n!/(n-r)! * 1 / r!";
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
        return pars.get(0).intValue() + "C" + pars.get(1).intValue() + " = " + (int) result;
    }
}
