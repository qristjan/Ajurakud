package ajurakudroot.eesti;

import org.jetbrains.annotations.NotNull;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

public class PuhverdatudSisendVoog extends BufferedInputStream {

    public PuhverdatudSisendVoog(@NotNull InputStream sisse) {
        super(sisse);
    }
}
