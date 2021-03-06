package ajurakudroot.sorteerimisalgoritmid;

import ajurakudroot.eesti.LoenduriRiiv;
import ajurakudroot.eesti.HäirimiseErind;
import ajurakudroot.eesti.Niit;
import ajurakudroot.eesti.NumbriNimekiri;

public class UneSorteerija implements SortimisAlgoritmiLiides{

    @Override
    public NumbriNimekiri sorteeri(NumbriNimekiri nimekiri) {
        if(nimekiri == null){
            return null;
        }

        if(nimekiri.onTühi()){
            return NumbriNimekiri.koosta();
        }

        var sorteeritudNimekiri = new NumbriNimekiri();
        var loenduriRiiv = new LoenduriRiiv(nimekiri.suurus());

        for (var number : nimekiri){
            new Niit(() -> {
                loenduriRiiv.loeAlla();

                try {
                    loenduriRiiv.oota();
                    Niit.maga(number.longValue() * 60);
                    sorteeritudNimekiri.lisa(number);
                } catch (HäirimiseErind e) {
                    e.trükiPinumäluJälg();
                }
            }).start();
        }

        try {
            Niit.maga(kõigeSuurim(nimekiri) * 100);
        } catch (HäirimiseErind e) {
            e.trükiPinumäluJälg();
        }

        return sorteeritudNimekiri;
    }

    private long kõigeSuurim(@org.jetbrains.annotations.NotNull NumbriNimekiri nimekiri) {
        long maksimaalne = 1;
        for (int i = 0; i < nimekiri.size(); i++) {
            if (nimekiri.saa(i).longValue() > maksimaalne) {
                maksimaalne = nimekiri.saa(i).longValue();
            }
        }
        return maksimaalne;
    }
}
