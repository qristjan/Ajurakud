package ajurakudroot.eesti;

import org.jetbrains.annotations.NotNull;

import java.io.OutputStream;
import java.io.PrintStream;

public class PrindiVoog extends PrintStream {

    public PrindiVoog(@NotNull OutputStream välja) {
        super(välja);
    }

    public void trükiRida(String rida){
        System.out.println(rida);
    }
}
