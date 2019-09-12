package BooleanService;

import java.util.function.Predicate;

public class TrueBooleanService {

    /**
     * returns false if myBoolean is null
     * @param myBoolean
     * @return
     */
    public boolean isMyBooleanTrue(Boolean myBoolean) {
        try {
            assert myBoolean;
        } catch (AssertionError e) {
            // Yes, this does catch an ERROR. So what, are you going to call the police?
            return false;
        }
        return true;
    }

    public Boolean getTrueBoolean() {
        return new TrueBoolean().TRUE();
    }

}
