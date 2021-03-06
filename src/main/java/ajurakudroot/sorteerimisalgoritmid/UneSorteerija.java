package ajurakudroot.sorteerimisalgoritmid;

import ajurakudroot.eesti.LoenduriRiiv;
import ajurakudroot.eesti.NiidiHäirimiseErind;
import ajurakudroot.eesti.Niit;
import ajurakudroot.eesti.NumbriNimekiri;

public class UneSorteerija implements SortimisAlgoritmiLiides{

    @Override
    public NumbriNimekiri sorteeri(NumbriNimekiri nimekiri) {
        var sorteeritudNimekiri = new NumbriNimekiri();
        var loenduriRiiv = new LoenduriRiiv(nimekiri.suurus());

        for (var number : nimekiri){
            new Niit(() -> {
                loenduriRiiv.loeAlla();

                try {
                    loenduriRiiv.oota();
                    Niit.maga(number.longValue() * 10);
                    sorteeritudNimekiri.lisa(number);
                } catch (NiidiHäirimiseErind e) {
                    e.trükiPinumäluJälg();
                }
            }).start();
        }

        try {
            Niit.maga(kõigeSuurim(nimekiri) * 11);
        } catch (NiidiHäirimiseErind e) {
            e.trükiPinumäluJälg();
        }

        return sorteeritudNimekiri;
    }

    public long kõigeSuurim(NumbriNimekiri nimekiri) {
        long maksimaalne = 1;
        for (int i = 0; i < nimekiri.size(); i++) {
            if (nimekiri.saa(i).longValue() > maksimaalne) {
                maksimaalne = nimekiri.saa(i).longValue();
            }
        }
        return maksimaalne;
    }
}
