package ajurakudroot.sorteerimisalgoritmid;

import ajurakudroot.eesti.HäirimiseErind;
import ajurakudroot.eesti.Niit;
import ajurakudroot.eesti.NumbriNimekiri;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

// TODO: SIIMER(06.03.2021 kell 16:03) - töötab minu masina peal
// TODO: SIIMER(06.03.2021 kell 16:06) - parandasin testid, töötab jälle mu masina peal
// TODO: Kahtlustan, et kristjan jookseb EEPROM MÄLU peal
@RunWith(MockitoJUnitRunner.class)
public class UneSorteerijaTest {

    @Test
    public void sorteeri_sorteerib_õnneliktee() {
        // arranzeeri
        var sorteerija = new UneSorteerija();
        var numbrid = NumbriNimekiri.koosta(10, 5, 20);

        // tee
        var result = sorteerija.sorteeri(numbrid);

        // kinnita
        assertThat(result).isEqualTo(NumbriNimekiri.koosta(5, 10, 20));
    }

    @Test
    public void sorteeri_sorteerib_suvalisi_nimekirju() {
        // arranzeeri
        var sorteerija = new UneSorteerija();
        var numbrid = new Random()
                .ints(20, 1, 50)
                .boxed()
                .map(i -> (Number) i)
                .collect(Collectors.toCollection(NumbriNimekiri::koosta));

        // tee
        var result = sorteerija.sorteeri(numbrid);

        try {
            Niit.maga(100);
        } catch (HäirimiseErind häirimiseErind) {
            häirimiseErind.printStackTrace();
        }
        // kinnita
        List<Number> resultSorted = numbrid.stream().sorted().collect(Collectors.toList());
        assertThat(result).isEqualTo(resultSorted);
    }

    @Test
    public void sorteeri_sorteerib_tühinimekiri() {
        // arranzeeri
        var sorteerija = new UneSorteerija();
        var numbrid = NumbriNimekiri.koosta();

        // tee
        var result = sorteerija.sorteeri(numbrid);

        // kinnita
        assertThat(result).isEqualTo(NumbriNimekiri.koosta());
    }

    @Test
    public void sorteeri_sorteerib_nullnimekiri() {
        // arranzeeri
        var sorteerija = new UneSorteerija();

        // tee
        var result = sorteerija.sorteeri(null);

        // kinnita
        assertThat(result).isEqualTo(null);
    }

    @Test
    public void sorteeri_sorteerib_suvalisi_nimekirju_SUUR_TEST() {
        // arranzeeri
        var sorteerija = new UneSorteerija();
        var numbrid = new Random()
                .ints(1000, 1, 50)
                .boxed()
                .map(i -> (Number) i)
                .collect(Collectors.toCollection(NumbriNimekiri::koosta));

        // tee
        var result = sorteerija.sorteeri(numbrid);

        try {
            Niit.maga(100);
        } catch (HäirimiseErind häirimiseErind) {
            häirimiseErind.trükiPinumäluJälg();
        }
        // kinnita
        List<Number> resultSorted = numbrid.stream().sorted().collect(Collectors.toList());
        assertThat(result).isEqualTo(resultSorted);
    }
}
