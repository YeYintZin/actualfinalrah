package org.yyz;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        menu();
    }

    /**
     * Main menu, front end
     */
    public static void menu() {
        boolean exit = false;
        String menu = "\n"
                + "Statistics Calculator:\n"
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
                    Table table = tableMaker();
                    if (table.header != null || table.datas != null) {
                        submenu(new NormalDistribution(table));
                        break;
                    }
                    System.out.println("Table is null");
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

    /**
     * Menu showing options of calculation
     * @param calculation Whichever calculation user picks
     */
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
        if (calculation instanceof NormalDistribution) {
            calculation.calc();
        } else {
            for (int i = iterate; i > 0; i--) {
                pars.add(scanDouble());
            }
            calculation.pars = pars;
            calculation.calc();
        }
        String submenu = "Options:\n"
                + "1. Calculate\n"
                + "2. Show Process\n"
                + "3. Explanation\n"
                + "4. AllCalc\n"
                + "5. Exit\n";
        if (calculation.result == -1) {
            System.out.println("Error in parameters!" + "\n");
            return;
        }
        while (!subexit) {
            System.out.println(submenu);
            switch (scanInt()) {
                case 1:
                    System.out.println(calculation);
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

    /**
     * Makes a table or takes it from a csv file, given by user
     * @return
     */
    public static Table tableMaker() {
        System.out.println("1- Make Table  2- Scan table");
        int scan = scanInt();
        if (scan == 1) {
            System.out.println("Enter amount of columns");
            int column = scanInt();
            List<String> head = new ArrayList<>();
            for (int i = 1; i <= column; i++) {
                System.out.println("Enter column #" + i + " name:");
                head.add(scanString());
            }
            Map<Double, List<Double>> rows = makeRows(column);
            System.out.println("Enter name of this table");
            return new DefinedTable(head, rows, scanString());
        } else if (scan == 2) {
            System.out.println("Enter path: ");
            return new InputTable(scanString());
        }
        return null;
    }

    /**
     * Helper method to make a table
     * @param column Amount of columns wanted for a table
     * @return Datas of table
     */
    public static Map<Double, List<Double>> makeRows(int column) {
        boolean add = true;
        Map<Double, List<Double>> datas = new HashMap<>();
        while (add) {
            List<Double> row = new ArrayList<>();
            System.out.println("Enter data at column 1:");
            double first = scanDouble();
            for (int i = 2; i < column + 1; i++) {
                System.out.println("Enter data at column " + i + ":");
                row.add(scanDouble());
            }
            datas.put(first, row);
            System.out.println("Keep adding row? 1- Yes  2- No");
            if (scanInt() == 2) {
                add = false;
            }
        }
        return datas;
    }

    /**
     * Scans int from user
     * @return integer
     */
    public static int scanInt() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    /**
     * Scans double from user
     * @return double
     */
    public static double scanDouble() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextDouble();
    }

    /**
     * Scans string from user
     * @return string
     */
    public static String scanString() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}