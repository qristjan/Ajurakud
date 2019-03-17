package loom;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class KoerTest {

    @Test
    public void testKoerHaugatus() {
        Koer koer = new Koer();
        Assert.assertEquals("Auh!", koer.getHaugatus());
    }

}
