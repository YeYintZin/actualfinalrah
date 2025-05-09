package org.yyz;

import java.util.List;

public class Factorial extends Calculation {
    double param;

    public Factorial(List<Double> pars) {
        super(pars);
    }

    @Override
    public void calc() {
        calc(pars.getFirst().intValue());
    }

    /**
     * Calculates n!
     * @param num parameter
     */
    public void calc(int num) {
        if (!isValid()) {
            result = -1;
            return;
        }
        if (num == 0) {
            result = 1;
            return;
        }
        double result = num;
        for (double i = num - 1; i > 1; i--) {
            result *= i;
        }
        this.result = result;
        param = num;
    }

    /**
     * Checks if n! is a real number
     * @return
     */
    @Override
    boolean isValid() {
        return pars.getFirst() >= 0 && pars.getFirst() % 1 == 0;
    }

    @Override
    public String process() {
        if (pars.getFirst() == 0) {
            return """
                    Proof that 0! = 1:
                    n! = n(n - 1)!
                    n! / n = (n - 1)!
                    Replace n with 1
                    1! / 1 = (1 - 1)!
                    1 = 0!""";
        }
        StringBuilder s = new StringBuilder();
        s.append((int) param);
        for (int i = (int) param - 1; i > 0; i--) {
            s.append(" * ").append(i);
        }
        return s + " = " + (int) getResult();
    }

    @Override
    public String explain() {
        return "n!, multiplication of n by n - 1, until n - 1 = 1.";
    }

    @Override
    public String allCalc() {
        return process();
    }

    @Override
    public String toString() {
        return (int) param + "! = " + (int) getResult();
    }
}
