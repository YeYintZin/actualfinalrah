package org.yyz;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Double> pars = new ArrayList<>();
        pars.add(5.0);
        pars.add(2.0);
        Calculation comb = new Combinations(pars);
        comb.calc();
        System.out.println(comb);
        System.out.println(comb.process());
    }
}