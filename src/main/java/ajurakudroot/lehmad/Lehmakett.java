package ajurakudroot.lehmad;

public class Lehmakett {

    public static void main(String[] args) throws LehmaErind {
        Lehm ema = new Lehm("Emalehm");
        ema.lehmaKett().lehm("Markus").lehm("Siim").lehm("Kristjan");
        ema.kirjutaLasteNimed();
    }

}
