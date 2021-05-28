package ajurakudroot.eesti;

import java.util.Collections;
import java.util.List;

public class Kollektsioonid {
    public static void sega(List<?> list){
        Collections.shuffle(list);
    }

    public static NumbriNimekiri tühiNimekiri() { return new NumbriNimekiri(); };

}
