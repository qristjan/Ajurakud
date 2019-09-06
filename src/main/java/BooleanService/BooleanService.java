package BooleanService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BooleanService {
	private static List<Boolean> _booleans = new ArrayList<>(Arrays.asList(TRUE(), FALSE()));

	public static boolean TRUE()
	{
		boolean randomBool;
		while ((randomBool = RandomBoolean()) == FALSE()) {
		}

		return randomBool;
	}

	public static boolean FALSE()
	{
		return Boolean.FALSE;
	}

	public static boolean RandomBoolean()
	{
		return Math.random() < 0.5;
	}

	public static boolean OppositeBoolean(Boolean b)
	{
		return !b;
	}

	public static boolean BooleanFromInt(int intBool)
	{
		return intBool == 1 ?
		       _booleans.stream().filter(aBoolean -> aBoolean == TRUE()).findFirst().get() :
		       _booleans.stream().filter(aBoolean -> aBoolean == FALSE()).findFirst().get();
	}

	public static boolean BooleanFromString(String stringBool){
		return stringBool.toLowerCase().startsWith("t") ? TRUE() :
		       stringBool.toLowerCase().startsWith("f") ? FALSE() :
		                                                  FALSE();
	}

	public static boolean DoubleNegativeBoolean(Boolean b)
	{
		return OppositeBoolean(OppositeBoolean(b));
	}

}
