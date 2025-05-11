package org.yyz;
import java.util.*;

public abstract class Calculation {
    protected List<Double> pars;
    protected List<Calculation> calculations = new ArrayList<>();
    protected double result;
    protected String name;
    protected int degreeOfComplexity;

    public abstract void calc();
    abstract boolean isValid();
    public abstract String process();
    public abstract String explain();
    public abstract String allCalc();

    public Calculation(List<Double> pars) {
        this.pars = pars;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Calculation that = (Calculation) o;
        return Double.compare(result, that.result) == 0 && Objects.equals(pars, that.pars) && Objects.equals(calculations, that.calculations);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pars, calculations, result);
    }

    public double getResult() {
        return result;
    }
}
