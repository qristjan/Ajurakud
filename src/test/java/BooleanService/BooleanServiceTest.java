package BooleanService;

import org.junit.Assert;
import org.junit.Test;

public class BooleanServiceTest {

	@Test
	public void testOppositeBoolean_ReturnsOppositeBoolean(){
		boolean oppositeBoolean = BooleanService.OppositeBoolean(BooleanService.TRUE());

		Assert.assertEquals(BooleanService.FALSE(), oppositeBoolean);
	}

	@Test
	public void testDoubleNegativeBoolean_ReturnsDoubleOppositeBoolean(){
		boolean doubleNegativeBoolean = BooleanService.DoubleNegativeBoolean(BooleanService.FALSE());
		Assert.assertEquals(BooleanService.FALSE(), doubleNegativeBoolean);
	}

	@Test
	public void testBooleanFromInt_ReturnsBooleanFromInt(){
		boolean oneBoolean = BooleanService.BooleanFromInt(1);
		Assert.assertEquals(BooleanService.TRUE(), oneBoolean);
	}

	@Test
	public void testBooleanFromString_ReturnsTrueFromTrue(){
		boolean bool  = BooleanService.BooleanFromString("TRUE");
		Assert.assertEquals(BooleanService.TRUE(), bool);
	}

	@Test
	public void testBooleanFromString_ReturnFalseFromFalse(){
		boolean bool  = BooleanService.BooleanFromString("FALSE");
		Assert.assertEquals(BooleanService.FALSE(), bool);
	}






}
