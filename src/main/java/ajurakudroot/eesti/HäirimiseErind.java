package ajurakudroot.eesti;

public class HäirimiseErind extends InterruptedException{
    public HäirimiseErind(String s) {
        super(s);
    }

    public void trükiPinumäluJälg() {
        super.printStackTrace();
    }
}
