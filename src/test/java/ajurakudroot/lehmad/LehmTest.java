package ajurakudroot.lehmad;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class LehmTest {

    Lehm ema;

    @Before
    public void setup() {
        ema = new Lehm("Emalehm");
    }

    @Test
    public void emaLehmIlmaLehmaketitaJaIlmaLasteta() {
        Assert.assertNull(ema.lapsed());
    }

    @Test
    public void emaLehmLehmaketigaJaIlmaLasteta() {
        ema.lehmaKett();
        Assert.assertEquals(0, ema.lapsed().size());
    }

    @Test
    public void emaLehmIlmaLehmaketitaJaÜheLapsega() {
        try {
            ema.lehm("Laps");
            Assert.fail("Test ei saa õnnestuda, sest lehmaketti ei ole ja lapsi ei saa kuhugi kinnitada ning nad jooksevad ära");
        } catch (LehmaErind e) {
            Assert.assertEquals("Kus on lehmakett, ah?", e.getMessage());
        }
    }

    @Test
    public void emaLehmLehmaketiJaÜheLapsega() {
        try {
            ema.lehmaKett().lehm("Laps");
            Assert.assertEquals(1, ema.lapsed().size());
            Assert.assertEquals("Laps", ema.lapsed().get(0).nimi());
        } catch (LehmaErind e) {
            Assert.fail("Test nagu ei tohiks failida");
        }
    }

    @Test
    public void emaLehmLehmaketiJaKolmeLapsega() {
        try {
            ema.lehmaKett().lehm("Laps").lehm("Lehm").lehm("Siga");
            Assert.assertEquals(3, ema.lapsed().size());
            Assert.assertEquals("Laps\uD83D\uDD17Lehm\uD83D\uDD17Siga", ema.lasteNimed());
        } catch (LehmaErind e) {
            Assert.fail("Test nagu ei tohiks failida");
        }
    }


}
