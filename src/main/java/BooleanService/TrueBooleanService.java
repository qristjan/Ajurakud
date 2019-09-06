package BooleanService;

public class TrueBooleanService extends BooleanService {

    public static final boolean TRUE = 1 == 1 && "1".equals("1");

    public Boolean getTrueBoolean() {
        return TRUE == TRUE();
    }

    public Boolean getTrueBooleanButItsFalse() {
        return !getTrueBoolean();
    }

}
