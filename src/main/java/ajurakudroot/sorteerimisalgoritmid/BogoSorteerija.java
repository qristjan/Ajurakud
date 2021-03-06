package ajurakudroot.sorteerimisalgoritmid;

import ajurakudroot.eesti.Kollektsioonid;
import ajurakudroot.eesti.NumbriNimekiri;
import ajurakudroot.eesti.Süsteem;

import java.util.Arrays;

public class BogoSorteerija implements SortimisAlgoritmiLiides {

    @Override
    public NumbriNimekiri sorteeri(NumbriNimekiri nimekiri) {
        var praeguneNimekiri = NumbriNimekiri.koosta(nimekiri);
        var iteratsioone = 1L;

        while (!onSorteeritud(praeguneNimekiri)) {
            Süsteem.välja.trükiRida(Arrays.toString(new NumbriNimekiri[]{praeguneNimekiri}));
            Kollektsioonid.sega(praeguneNimekiri);
            iteratsioone++;
        }

        Süsteem.välja.trükiRida("Sorting took " + iteratsioone + " iterations.");

        return praeguneNimekiri;
    }

    private boolean onSorteeritud(NumbriNimekiri nimekiri) {
        for (int i = 0; i < nimekiri.suurus() - 1; ++i) {
            if (nimekiri.saa(i).longValue() >= nimekiri.saa(i + 1).longValue()) {
                return false;
            }
        }
        return true;
    }
}
