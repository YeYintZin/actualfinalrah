package org.yyz;

import java.util.*;

public interface TableCalc {
    Table getTable();

    default List<Double> getColumn(String name) {
        Table table = getTable();
        List<Double> column = new ArrayList<>();
        if (table.header.getFirst().equals(name)) {
            column.addAll(table.datas.keySet());
        } else {
            for (List<Double> row : table.datas.values()) {
                column.add(row.get(table.header.indexOf(name) - 1));
            }
        }
        return column;
    }
}
