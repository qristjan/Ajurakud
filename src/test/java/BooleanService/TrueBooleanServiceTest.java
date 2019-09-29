package BooleanService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class TrueBooleanServiceTest {

    @InjectMocks
    private TrueBooleanService trueBooleanService;

    @Test
    public void isMyBooleanTrue_true() {
        boolean myBoolean = true;
        assertTrue(trueBooleanService.isMyBooleanTrue(myBoolean));
    }

    @Test
    public void isMyBooleanTrue_false() {
        boolean myBoolean = false;
        assertFalse(trueBooleanService.isMyBooleanTrue(myBoolean));
    }

    @Test
    public void getTrueBoolean_isReturnedBooleanTrue() {
        assertTrue(trueBooleanService.getTrueBoolean());
        assertFalse(!trueBooleanService.getTrueBoolean());
    }

}
