package japanese;

import loom.Koer;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class DogHandlerTest {

    @Test
    //public void test名付ける犬() throws exception: No tests found matching Method test?????(japanese.DogHandlerTest)
    //Seems like junit doesnt agree with japanese language :D
    public void testSetDogName() {
        Koer koer = new Koer();
        DogHandler.名付ける犬(koer);
        Assert.assertEquals("サイタマ", koer.getNimi());
    }

}
