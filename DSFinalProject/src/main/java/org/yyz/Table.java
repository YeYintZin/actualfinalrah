package org.yyz;

import java.util.*;

public abstract class Table {
    protected List<String> header;
    protected Map<Double, List<Double>> datas;

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
        StringBuilder result = new StringBuilder();
        for (String header : header) {
            result.append(header).append(", ");
        }
        result = new StringBuilder(result.substring(0, result.length() - 2));
        result.append("\n");
        for (Double key : datas.keySet()) {
            result.append(key).append(", ");
            for (Double value : datas.get(key)) {
                result.append(value).append(", ");
            }
            result = new StringBuilder(result.substring(0, result.length() - 2));
            result.append("\n");
        }
        return result.toString();
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
