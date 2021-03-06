package ajurakudroot.sorteerimisalgoritmid;

import ajurakudroot.eesti.NumbriNimekiri;

import java.text.MessageFormat;
import java.util.Arrays;
import java.util.Random;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        var numbrid = new Random()
                .ints(20, 1, 100)
                .boxed()
                .map(i -> (Number) i)
                .collect(Collectors.toCollection(NumbriNimekiri::koosta));

        var tulemus = new UneSorteerija().sorteeri(numbrid);
        var sõnum = MessageFormat.format("{0} -> {1}",
                Arrays.toString(new NumbriNimekiri[]{numbrid}),
                Arrays.toString(new NumbriNimekiri[]{tulemus}));

        System.out.println(sõnum);
    }
}
