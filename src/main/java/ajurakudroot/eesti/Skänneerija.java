package ajurakudroot.eesti;

import java.util.Scanner;

public class Skänneerija {
    private final Scanner skänneerija;

    public Skänneerija(PuhverdatudSisendVoog sisse) {
        this.skänneerija = new Scanner(sisse);
    }

    public String nextLine() {
        return skänneerija.nextLine();
    }
}
