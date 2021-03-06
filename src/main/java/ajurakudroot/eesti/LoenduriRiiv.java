package ajurakudroot.eesti;

import java.util.concurrent.CountDownLatch;

public class LoenduriRiiv extends CountDownLatch {

    public LoenduriRiiv(int hulk) {
        super(hulk);
    }

    public void loeAlla(){
        countDown();
    }

    public void oota() throws NiidiHäirimiseErind {
        try {
            await();
        } catch (InterruptedException e) {
            throw new NiidiHäirimiseErind(e.getMessage());
        }
    }
}
