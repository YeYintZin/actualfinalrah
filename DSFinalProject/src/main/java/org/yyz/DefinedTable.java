package org.yyz;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public class DefinedTable extends Table {
    private String name;

    public DefinedTable(List<String> header, Map<Double, List<Double>> datas, String name) {
        super(header, datas);
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        DefinedTable that = (DefinedTable) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name);
    }

    @Override
    public String toString() {
        return name + "\n" + super.toString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
