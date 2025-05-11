package org.yyz;

import java.util.List;
import java.util.Objects;

public class NormalDistribution implements TableCalc {
    private Table table;
    private int degreeOfComplexity;

    public NormalDistribution(Table table) {
        this.table = table;
        this.degreeOfComplexity = 4;
    }

    @Override
    public Table getTable() {
        return table;
    }

    @Override
    public List<Double> getColumn(String name) {
        return TableCalc.super.getColumn(name);
    }

    public double mean(String name) {
        List<Double> column = getColumn(name);
        double result = 0;
        for (Double value : column) {
            result += value;
        }
        return result / column.size();
    }

    public double zScore(String name, double x) {
        return (x - mean(name)) / standardDeviation(name);
    }

    public double standardDeviation(String name) {
        List<Double> column = getColumn(name);
        double result = 0;
        double mean = mean(name);
        for (Double value : column) {
            result += Math.pow(value - mean, 2);
        }
        return Math.sqrt(result / (column.size() - 1));
    }

    public double normalDistributionCalc(String name, double x) {
        double sd = standardDeviation(name);
        double base = 1 / (sd * Math.sqrt(2 * Math.PI));
        double exponent = - Math.pow(zScore(name, x), 2) / 2;
        System.out.println(mean(name) + standardDeviation(name) + "\t" + exponent + "\t" + base);
        return base * Math.pow(Math.E, exponent);
    }

    @Override
    public String toString() {
        return "NormalDistribution{}";
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        NormalDistribution that = (NormalDistribution) o;
        return degreeOfComplexity == that.degreeOfComplexity && Objects.equals(table, that.table);
    }

    @Override
    public int hashCode() {
        return Objects.hash(table, degreeOfComplexity);
    }
}
