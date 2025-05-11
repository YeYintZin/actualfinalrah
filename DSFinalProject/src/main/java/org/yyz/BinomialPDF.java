package org.yyz;

import java.util.*;

public class BinomialPDF extends Calculation {
    public BinomialPDF(List<Double> pars) {
        super(pars);
    }

    @Override
    public void calc() {
        Calculation comb = new Combinations(pars);

    }

    @Override
    boolean isValid() {
        return false;
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
}
