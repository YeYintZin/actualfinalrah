import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.yyz.InputTable;
import org.yyz.NormalDistribution;
import org.yyz.Table;

public class NormalPDFTest {
    @Test
    public void testMean() {
        Table table = new InputTable("src/test/resources/table.csv");
        NormalDistribution nd = new NormalDistribution(table);
        double result = nd.mean("f(x)");
        Assertions.assertEquals((double) 55 / 6, result);
    }

    @Test
    public void testSD() {
        Table table = new InputTable("src/test/resources/table.csv");
        NormalDistribution nd = new NormalDistribution(table);
        double result = nd.standardDeviation("f(x)");
        Assertions.assertEquals(9.745084230865666, result);
    }

    @Test
    public void testZscore() {
        Table table = new InputTable("src/test/resources/table.csv");
        NormalDistribution nd = new NormalDistribution(table);
        double result = nd.zScore("f(x)", 4);
        Assertions.assertEquals((4 - ((double) 55 /6)) / 9.745084230865666, result);
    }

    @Test
    public void testNormal() {
        Table table = new InputTable("src/test/resources/table.csv");
        NormalDistribution nd = new NormalDistribution(table);
        double result = nd.calc("f(x)", 4);
        Assertions.assertEquals(0.03557017048218384, result);
    }
}
