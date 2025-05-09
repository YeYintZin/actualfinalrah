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
        result = (1 / factor.result) * perm.result;
    }

    @Override
    boolean isValid() {
        return pars.get(0) > 0 ||
                pars.get(1) >= 0 ||
                pars.get(0) % 1 == 0 ||
                pars.get(1) % 1 == 0 ||
                pars.get(0) > pars.get(1);
    }

    @Override
    public String process() {
        return "";
    }

    @Override
    public String explain() {
        return "";
    }

    @Override
    public String allCalc() {
        return "";
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
