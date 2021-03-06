package ajurakudroot.postgre;

import org.junit.Assert;
import org.junit.Test;

public class PostgreDBTest {

    @Test
    public void test() {
        PostgreDB db = PostgreDB.getInstance();

        db.createTable("test");
        Assert.assertNull(db.getTableData("test"));

        String testJson = "{\"test\":2}";
        db.addRow("test", testJson);
        Assert.assertEquals(String.format("[%s]", testJson), db.getTableData("test"));

        db.deleteTable("test");
    }

}
