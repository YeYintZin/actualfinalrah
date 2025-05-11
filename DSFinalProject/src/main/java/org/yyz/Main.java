package org.yyz;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Table table = new InputTable("DSFinalProject/src/main/resources/test.csv");
        BasicStat calc1 = new BasicStat(table);
        System.out.println(calc1.normalDistributionPDF("x", 1));
    }
}