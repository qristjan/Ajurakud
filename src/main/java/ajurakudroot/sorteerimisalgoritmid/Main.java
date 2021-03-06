package ajurakudroot.sorteerimisalgoritmid;

import ajurakudroot.eesti.NumbriNimekiri;

import java.text.MessageFormat;
import java.util.Arrays;
import java.util.Random;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        sorteerijaNäide(new BogoSorteerija());
    }


    private static void sorteerijaNäide(SortimisAlgoritmiLiides liides) {
        var numbrid = new Random()
                .ints(10, 1, 100)
                .boxed()
                .map(i -> (Number) i)
                .collect(Collectors.toCollection(NumbriNimekiri::koosta));

        var tulemus = liides.sorteeri(numbrid);
        var sõnum = MessageFormat.format("{0} -> {1}",
                Arrays.toString(new NumbriNimekiri[]{numbrid}),
                Arrays.toString(new NumbriNimekiri[]{tulemus}));

        System.out.println(sõnum);
    }
}
