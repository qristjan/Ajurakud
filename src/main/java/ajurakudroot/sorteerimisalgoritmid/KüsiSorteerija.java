package ajurakudroot.sorteerimisalgoritmid;

import ajurakudroot.eesti.NumbriNimekiri;
import ajurakudroot.eesti.Skänneerija;
import ajurakudroot.eesti.Süsteem;

import java.text.MessageFormat;
import java.util.Scanner;

public class KüsiSorteerija implements SortimisAlgoritmiLiides {

    @Override
    public NumbriNimekiri sorteeri(NumbriNimekiri nimekiri) {
        var tagastusNimekiri = NumbriNimekiri.koosta(nimekiri);
        int nimekirjaSuurus = nimekiri.suurus();
        var ajutine = 0L;

        var skänneerija = new Skänneerija(Süsteem.sisse);  // Create a Scanner object

        for (int i = 0; i < nimekirjaSuurus; i++) {
            for (int j = 1; j < (nimekirjaSuurus - i); j++) {
                var vasak = tagastusNimekiri.saa(j - 1).longValue();
                var parem = tagastusNimekiri.saa(j).longValue();

                Süsteem.välja.trükiRida(MessageFormat.format("Kas {0} on suurem kui {1}? (j)ah / (e)i", vasak, parem));
                var sisend = skänneerija.nextLine();  // Read user input

                if (sisend.trim().toLowerCase().startsWith("j")) {
                    // tõsta ringi
                    ajutine = vasak;
                    tagastusNimekiri.määra(j - 1, tagastusNimekiri.saa(j));
                    tagastusNimekiri.määra(j, ajutine);
                }
            }
        }

        return tagastusNimekiri;
    }
}
