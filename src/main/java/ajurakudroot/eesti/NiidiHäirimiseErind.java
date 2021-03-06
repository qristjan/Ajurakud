package ajurakudroot.eesti;

public class NiidiHäirimiseErind extends InterruptedException{
    public NiidiHäirimiseErind(String s) {
        super(s);
    }

    public void trükiPinumäluJälg() {
        super.printStackTrace();
    }
}
