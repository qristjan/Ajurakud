package ajurakudroot.kodune_pinu;

import org.junit.Assert;
import org.junit.Test;

public class KodunePinuTest {

    @Test
    public void looUusPinu() {
        var pinu = new KodunePinu<Long>();
        Assert.assertEquals(0, pinu.pikkus());
    }

    @Test
    public void looUusPinuJaLisaSinnaElemente() {
        var pinu = new KodunePinu<Long>();
        Assert.assertEquals(0, pinu.pikkus());
        for (int i = 0; i < 20; i++) {
            pinu.lisa((long) i);
        }
        Assert.assertEquals(19L, (long) pinu.vaata());
    }

    @Test
    public void looUusPinuJaVaataTühjaPinu() {
        var pinu = new KodunePinu<Long>();
        try {
            pinu.vaata();
        } catch (RuntimeException e) {
            Assert.assertEquals("Läksid liiga kaugele", e.getMessage());
        }
        Assert.fail("Oleks pidanud püüdma RuntimeExceptioni");
    }
}
