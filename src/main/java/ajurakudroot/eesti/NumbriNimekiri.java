package ajurakudroot.eesti;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class NumbriNimekiri extends ArrayList<Number> {

    public static NumbriNimekiri koosta(Number... numbrid) {
        var nimekiri = new NumbriNimekiri();
        for (Number number : numbrid) {
            nimekiri.lisa(number);
        }
        return nimekiri;
    }

    public static NumbriNimekiri koosta(List<Number> numbrid) {
        var nimekiri = new NumbriNimekiri();
        for (Number number : numbrid) {
            nimekiri.lisa(number);
        }
        return nimekiri;
    }

    public static NumbriNimekiri koosta(NumbriNimekiri numbrid) {
        var nimekiri = new NumbriNimekiri();
        for (Number number : numbrid) {
            nimekiri.lisa(number);
        }
        return nimekiri;
    }

    public int suurus(){
        return size();
    }

    public synchronized void lisa(Number number){
        add(number);
    }

    public boolean eemalda(Number number){
        return remove(number);
    }

    public Number määra(int indeks, Number number){
        return set(indeks, number);
    }

    public Number saa(int indeks){
        return get(indeks);
    }

    public boolean onTühi(){
        return isEmpty();
    }

    public Stream<Number> voog(){
        return stream();
    }
}
