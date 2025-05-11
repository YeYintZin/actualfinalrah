package org.yyz;

import java.util.List;

public class Factorial extends Calculation {
    double param;

    public Factorial(List<Double> pars) {
        super(pars);
        this.name = "Factorial";
        this.degreeOfComplexity = 1;
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
     * Checks if n! is a natural number
     * @return boolean if the number is valid
     */
    @Override
    boolean isValid() {
        return pars.getFirst() >= 0 && pars.getFirst() % 1 == 0;
    }

    /**
     * Shows process of calculations
     * @return String containing full process
     */
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

    /**
     * Explains factorial
     * @return explanation
     */
    @Override
    public String explain() {
        return "n!, multiplication of n by n - 1, until n - 1 = 1.";
    }

    /**
     * Show processes for all calculations
     * @return all calculations
     */
    @Override
    public String allCalc() {
        return "Full process:\n" + process();
    }

    /**
     * Special toString displaying result
     * @return (n! = x)
     */
    @Override
    public String toString() {
        return (int) param + "! = " + (int) getResult();
    }
}
