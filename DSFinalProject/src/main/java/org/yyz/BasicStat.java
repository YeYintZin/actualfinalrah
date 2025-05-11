package org.yyz;

import java.util.List;

public class BasicStat implements TableCalc {
    private Table table;

    public BasicStat(Table table) {
        this.table = table;
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

    public double standardDeviation(String name) {
        List<Double> column = getColumn(name);
        double result = 0;
        double mean = mean(name);
        for (Double value : column) {
            result += Math.pow(value - mean, 2);
        }
        return Math.sqrt(result / (column.size() - 1));
    }

    public double normalDistributionPDF(String name, double x) {
        double sd = standardDeviation(name);
        double base = 1 / (sd * Math.sqrt(2 * Math.PI));
        double exponent = - Math.pow(x - mean(name), 2) / (2 * Math.pow(sd, 2));
        System.out.println(mean(name) + standardDeviation(name) + "\t" + exponent + "\t" + base);
        return base * Math.pow(Math.E, exponent);
    }

}
