package org.yyz;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        boolean exit = false;
        String menu = "Statistics Calculator:\n"
                + "1. Factorial\n"
                + "2. Permutations\n"
                + "3. Combinations\n"
                + "4. BinomialPDF\n"
                + "5. NormalDistributionPDF\n"
                + "6. Exit\n";
        while (!exit) {
            System.out.println(menu);
            switch (scanInt()) {
                case 1:
                    submenu(new Factorial(new ArrayList<>()));
                break;
                case 2:
                    submenu(new Permutations(new ArrayList<>()));
                break;
                case 3:
                    submenu(new Combinations(new ArrayList<>()));
                break;
                case 4:
                    submenu(new BinomialPDF(new ArrayList<>()));
                break;
                case 5:
                    System.out.println("e");
                break;
                case 6:
                    System.out.println("Closing program...");
                    exit = true;
                break;
                default:
                    System.out.println("Invalid option. Pick between 1-6");
                break;
            }
        }
    }

    public static void submenu(Calculation calculation) {
        int iterate;
        boolean subexit = false;
        List<Double> pars = new ArrayList<>();
        if (calculation instanceof Factorial) {
            iterate = 1;
        } else if (calculation instanceof Permutations || calculation instanceof Combinations) {
            iterate = 2;
        } else if (calculation instanceof BinomialPDF) {
            iterate = 3;
        } else {
            iterate = 0;
        }
        System.out.println("Enter parameters for " + calculation.name);
        for (int i = iterate; i > 0; i--) {
            pars.add(scanDouble());
        }
        calculation.pars = pars;
        String submenu = "Options:\n"
                + "1. Calculate\n"
                + "2. Show Process\n"
                + "3. Explanation\n"
                + "4. AllCalc\n"
                + "5. Exit\n";
        calculation.calc();
        while (!subexit) {
            System.out.println(submenu);
            switch (scanInt()) {
                case 1:
                    if (calculation.result == -1) {
                        System.out.println("Wrong parameters!");
                    } else {
                        System.out.println(calculation);
                    }
                break;
                case 2:
                    System.out.println(calculation.process());
                break;
                case 3:
                    System.out.println(calculation.explain());
                break;
                case 4:
                    System.out.println(calculation.allCalc());
                break;
                case 5:
                    System.out.println("Returning to main menu...");
                    subexit = true;
                break;
                default:
                    System.out.println("Invalid option. Pick between 1-5");
                    break;
            }
        }
    }

    public static int scanInt() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public static double scanDouble() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextDouble();
    }
}