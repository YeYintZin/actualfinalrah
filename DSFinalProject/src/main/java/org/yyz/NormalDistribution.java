package org.yyz;

import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class NormalDistribution extends Calculation implements TableCalc {
    private Table table;
    private int degreeOfComplexity;
    private double result;

    public NormalDistribution(Table table) {
        super();
        this.table = table;
        this.name = "Normal Distribution";
        this.degreeOfComplexity = 4;
    }

    @Override
    public Table getTable() {
        return table;
    }

    /**
     * Gets every data in a column
     * @param name Name of the column
     * @return List containing all datas of a column
     */
    @Override
    public List<Double> getColumn(String name) {
        return TableCalc.super.getColumn(name);
    }

    /**
     * Calculates the mean of a column
     * @param name Name of the column
     * @return The mean
     */
    public double mean(String name) {
        List<Double> column = getColumn(name);
        double result = 0;
        for (Double value : column) {
            result += value;
        }
        return result / column.size();
    }

    /**
     * Calculates the Z score, how far a data point is of the mean. If Z = 0, then its on the mean.
     * @param name Name of the column
     * @param x A data point
     * @return The Z score of a data point
     */
    public double zScore(String name, double x) {
        return (x - mean(name)) / standardDeviation(name);
    }

    /**
     * Calculates the standard deviation
     * @param name Name of the column
     * @return The standard deviation
     */
    public double standardDeviation(String name) {
        List<Double> column = getColumn(name);
        double result = 0;
        double mean = mean(name);
        for (Double value : column) {
            result += Math.pow(value - mean, 2);
        }
        result = Math.sqrt(result / (column.size() - 1));
        return result;
    }

    /**
     * Computes the normal probability density function, which unlike its Binomial counterpart,
     * returns the probability density, not the probability itself.
     * @param name Name of the column
     * @param x Data point to evaluate probability density
     * @return The probability Density
     */
    public double calc(String name, double x) {
        double sd = standardDeviation(name);
        double base = 1 / (sd * Math.sqrt(2 * Math.PI));
        double exponent = - Math.pow(zScore(name, x), 2) / 2;
        double result = base * Math.pow(Math.E, exponent);
        this.result = result;
        return result;
    }

    @Override
    public String toString() {
        return "Probability density at specific point: " + result;
    }

    @Override
    public void calc() {
        Scanner s = new Scanner(System.in);
        System.out.println("Name of column");
        String name = s.nextLine();
        System.out.println("Value of datapoint");
        double x = s.nextDouble();
        calc(name, x);
    }

    @Override
    boolean isValid() {
        return true;
    }

    @Override
    public String process() {
        return "e^-0.5z^2 / (sd * (sqrt(2pi)))";
    }

    /**
     * Provides an explanation of the probability density function
     * @return String containing explanation
     */
    @Override
    public String explain() {
        return "Computes the normal probability density function.";
    }

    /**
     * Shows all calc
     * @return Currently impossible to make.
     */
    @Override
    public String allCalc() {
        return "NaN";
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
