package org.yyz;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class InputTable extends Table {
    private String path;

    public InputTable(String path) {
        try (Scanner sc = new Scanner(new File(path))) {
            setHeader(Arrays.stream(sc.nextLine().split(",")).toList());
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
        this.path = path;
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
