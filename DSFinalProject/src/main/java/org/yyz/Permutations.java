package org.yyz;

import java.util.List;

public class Permutations extends Calculation {

    public Permutations(List<Double> pars) {
        super(pars);
    }

    @Override
    public void calc() {
        if (!isValid()) {
            result = -1;
            return;
        }
        Calculation numerator = new Factorial(pars);
        Factorial denominator = new Factorial(pars);
        numerator.calc();
        denominator.calc((int) (pars.get(0) - pars.get(1)));
        calculations.add(numerator);
        calculations.add(denominator);
        result = numerator.result / denominator.result;
    }

    @Override
    boolean isValid() {
        return pars.getFirst() > 0 &&
                pars.getFirst() % 1 == 0 &&
                pars.get(1) >= 0 &&
                pars.get(1) % 1 == 0 &&
                pars.get(0) > pars.get(1);
    }

    @Override
    public String process() {
        return "Computes "
                + pars.get(0).intValue() + "! " + "divided by ("
                + pars.get(0).intValue() + " - "
                + pars.get(1).intValue() + ")! = "
                + (int) result;
    }

    @Override
    public String explain() {
        return "nPr: " +
                "returns Permutation, the amount of combinations possible, with order mattering\n" +
                "n!/(n-r)!";
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
}
