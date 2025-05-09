package org.yyz;

import java.util.List;

public class Combinations extends Calculation {
    public Combinations(List<Double> pars) {
        super(pars);
    }

    @Override
    public void calc() {
        calc(pars.get(0).intValue(), pars.get(1).intValue());
    }

    public void calc(int n, int r) {
        if (!isValid()) {
            result = -1;
            return;
        }
        Calculation perm = new Permutations(pars);
        Calculation factor = new Factorial(pars.subList(1, pars.size()));
        perm.calc();
        factor.calc();
        calculations.add(perm);
        calculations.add(factor);
        result = (1 / factor.result) * perm.result;
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
                + pars.get(1).intValue() + ")!, which equals to "
                + calculations.get(1)
                + ", then multipliying by 1 / "
                + pars.get(1).intValue() + "!, giving the final result of "
                + (int) result;
    }

    @Override
    public String explain() {
        return "";
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
        return pars.get(0).intValue() + "C" + pars.get(1).intValue() + " = " + (int) result;
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public double getResult() {
        return super.getResult();
    }
}
