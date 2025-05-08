package org.yyz;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public abstract class Table {
    private List<String> header;
    private Map<Double, List<Double>> datas;

    public Table() {

    }

    public Table(List<String> header, Map<Double, List<Double>> datas) {
        this.header = header;
        this.datas = datas;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Table table = (Table) o;
        return Objects.equals(header, table.header) && Objects.equals(datas, table.datas);
    }

    @Override
    public int hashCode() {
        return Objects.hash(header, datas);
    }

    @Override
    public String toString() {
        String result = "";
        for (String header : header) {
            result += header + ", ";
        }
        result = result.substring(0, result.length() - 2);
        result += "\n";
        for (Double key : datas.keySet()) {
            result += key + ", ";
            for (Double value : datas.get(key)) {
                result += value + ", ";
            }
            result = result.substring(0, result.length() - 2);
            result += "\n";
        }
        return result;
    }

    public List<String> getHeader() {
        return header;
    }

    public void setHeader(List<String> header) {
        this.header = header;
    }

    public Map<Double, List<Double>> getDatas() {
        return datas;
    }

    public void setDatas(Map<Double, List<Double>> datas) {
        this.datas = datas;
    }
}
