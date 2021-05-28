package ajurakudroot.sorteerimisalgoritmid;

import ajurakudroot.eesti.HäirimiseErind;
import ajurakudroot.eesti.Niit;
import ajurakudroot.eesti.NumbriNimekiri;
import com.google.common.collect.Comparators;
import com.google.common.collect.Ordering;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class StaliniSorteerijaTest {
    @Test
    public void sorteeri_sorteerib_õnneliktee() {
        // arranzeeri
        var sorteerija = new StaliniSorteerija();
        var numbrid = NumbriNimekiri.koosta(10, 5, 20);

        // tee
        var result = sorteerija.sorteeri(numbrid);

        // kinnita
        assertThat(result).isEqualTo(NumbriNimekiri.koosta(10, 20));
    }

    @Test
    public void sorteeri_sorteerib_suvalisi_nimekirju() {
        // arranzeeri
        var sorteerija = new StaliniSorteerija();
        var numbrid = new Random()
                .ints(20, 1, 50)
                .boxed()
                .map(i -> (Number) i)
                .collect(Collectors.toCollection(NumbriNimekiri::koosta));

        // tee
        var result = sorteerija.sorteeri(numbrid);

        // kinnita
        List<Number> resultSorted = numbrid.stream().sorted().collect(Collectors.toList());
        assertThat(result).isSorted();
    }

    @Test
    public void sorteeri_sorteerib_tühinimekiri() {
        // arranzeeri
        var sorteerija = new StaliniSorteerija();
        var numbrid = NumbriNimekiri.koosta();

        // tee
        var result = sorteerija.sorteeri(numbrid);

        // kinnita
        assertThat(result).isSorted();
    }

    @Test
    public void sorteeri_sorteerib_nullnimekiri() {
        // arranzeeri
        var sorteerija = new StaliniSorteerija();

        // tee
        var result = sorteerija.sorteeri(null);

        // kinnita
        assertThat(result).isNull();
    }

    @Test
    public void sorteeri_sorteerib_suvalisi_nimekirju_SUUR_TEST() {
        // arranzeeri
        var sorteerija = new StaliniSorteerija();
        var numbrid = new Random()
                .ints(1000, 1, 50)
                .boxed()
                .map(i -> (Number) i)
                .collect(Collectors.toCollection(NumbriNimekiri::koosta));

        // tee
        var result = sorteerija.sorteeri(numbrid);

        // kinnita
        assertThat(result).isSorted();
    }
}
