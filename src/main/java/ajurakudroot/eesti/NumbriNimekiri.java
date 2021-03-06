package ajurakudroot.eesti;

import java.util.ArrayList;
import java.util.stream.Stream;

public class NumbriNimekiri extends ArrayList<Number> {

    public static NumbriNimekiri koosta(Number... numbrid) {
        var nimekiri = new NumbriNimekiri();
        for (Number number : numbrid) {
            nimekiri.lisa(number);
        }
        return nimekiri;
    }

    public int suurus(){
        return size();
    }

    public void lisa(Number number){
        add(number);
    }

    public boolean eemalda(Number number){
        return remove(number);
    }

    public Number saa(int indeks){
        return get(indeks);
    }

    public Stream<Number> voog(){
        return stream();
    }
}
