package ajurakudroot.eesti;

public class Niit extends Thread{

    public static void maga(long millisekundeid) throws HäirimiseErind {
        try {
            Thread.sleep(millisekundeid);
        } catch (InterruptedException e) {
            throw new HäirimiseErind(e.getMessage());
        }
    }

    public Niit(Runnable target) {
        super(target);
    }
}
