package lehmad;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Lehm {

    private String nimi;
    private List<Lehm> lapsed;

    Lehm lehmaKett() {
        lapsed = new ArrayList<>();
        return this;
    }

    Lehm(String nimi) {
        this.nimi = nimi;
    }

    Lehm lehm(String nimi) throws LehmaErind {
        if (lapsed == null) {
            throw new LehmaErind("Kus on lehmakett, ah?");
        }
        lapsed.add(new Lehm(nimi));
        return this;
    }

    String nimi() {
        return this.nimi;
    }

    List<Lehm> lapsed() {
        return this.lapsed;
    }

    void kirjutaLasteNimed() {
        System.out.println(lasteNimed());
    }

    String lasteNimed() {
        return lapsed.stream().map(Lehm::nimi).collect(Collectors.joining("\uD83D\uDD17"));
    }

}
