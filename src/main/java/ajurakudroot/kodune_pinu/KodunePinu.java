package ajurakudroot.kodune_pinu;

import java.util.Arrays;

public class KodunePinu<KLASS> {

    private KLASS[] pinu;
    private int kogus = 0;

    @SuppressWarnings("unchecked")
    public KodunePinu() {
        this.pinu = (KLASS[]) new Object[0];
    }

    public int pikkus() {
        return pinu.length;
    }

    public KLASS vaata() {
        if (this.kogus == 0) {
            return null;
        }
        return this.pinu[this.kogus - 1];
    }

    public KLASS vaata(int indeks) {
        if (indeks > this.pinu.length) {
            throw new RuntimeException("Läksid liiga kaugele");
        }
        return this.pinu[indeks];
    }

    public void lisa(KLASS element) {
        if (this.kogus == this.pinu.length) {
            this.pinu = Arrays.copyOf(this.pinu, kogus + 1);
        }
        this.pinu[this.kogus++] = element;
    }

    public KLASS võta() {
        var temp = this.pinu[this.pinu.length - 1];
        this.pinu[this.pinu.length - 1] = null;
        return temp;
    }

}
