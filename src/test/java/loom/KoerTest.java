package loom;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
class Koer {

    @Test
    void testKoerHaugatus() {
        Koer koer = new Koer();
        Assert.assertEquals("Auh!", koer.getHaugatus());
    }

}
