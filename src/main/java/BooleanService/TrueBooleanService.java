package BooleanService;

import java.util.function.Predicate;

public class TrueBooleanService extends BooleanService {

    public static final boolean TRUE = 1 == 1 && "1".equals("1");

    public Boolean getTrueBoolean() {
        return TRUE == TRUE();
    }

    public Boolean getTrueBooleanButItsFalse() {
        return !getTrueBoolean();
    }

    public Predicate<MyBoolean> getBooleanPredicate(boolean BOOLEAN) {
        return b -> BOOLEAN == TRUE;
    }

    public boolean getBooleanByPredicate(Predicate<MyBoolean> predBOOLEAN) {
        return predBOOLEAN.test(new TrueBoolean());
    }

}
