package fizzbuzz;

import ajurakud.Ajurakud;

public class Printer implements Ajurakud {

    public static void kirjuta(String tekst) {
        System.out.println(tekst);
    }

    @Override
    public void mõtle() throws InterruptedException
    {
        ära();
    }

    private void ära()
    {
        System.exit(1337);
    }
}
