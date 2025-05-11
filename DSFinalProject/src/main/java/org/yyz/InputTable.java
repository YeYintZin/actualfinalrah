package org.yyz;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class InputTable extends Table {
    private String path;

    public InputTable(String path) {
        super();
        this.path = path;
        try (Scanner sc = new Scanner(new File(path))) {
            header = new ArrayList<>(Arrays.asList(sc.nextLine().split(",")));
            header.set(0, header.get(0).substring(1));
            Map<Double, List<Double>> map = new LinkedHashMap<>();
            while (sc.hasNextLine()) {
                String[] strings = sc.nextLine().split(",");
                Double key = Double.parseDouble(strings[0]);
                map.put(key, strArToDbList(strings));
            }
            setDatas(map);
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public List<Double> strArToDbList(String[] strings) {
        List<Double> result = new ArrayList<>();
        for (int i = 1; i < strings.length; i++) {
            result.add(Double.parseDouble(strings[i]));
        }
        return result;
    }

    @Override
    public String toString() {
        return "Table at " + path + "\n" + super.toString();
    }
}
