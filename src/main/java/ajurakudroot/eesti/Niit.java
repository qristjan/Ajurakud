package ajurakudroot.eesti;

public class Niit extends Thread{

    public static void maga(long millisekundeid) throws NiidiHäirimiseErind {
        try {
            Thread.sleep(millisekundeid);
        } catch (InterruptedException e) {
            throw new NiidiHäirimiseErind(e.getMessage());
        }
    }

    public Niit(Runnable target) {
        super(target);
    }
}
