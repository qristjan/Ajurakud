package ajurakudroot.sorteerimisalgoritmid;

import ajurakudroot.eesti.Kollektsioonid;
import ajurakudroot.eesti.NumbriNimekiri;

public class StaliniSorteerija implements SortimisAlgoritmiLiides{

    @Override
    public NumbriNimekiri sorteeri(NumbriNimekiri nimekiri) {
        if(nimekiri == null){
            return null;
        }

        if(nimekiri.onTühi()){
            return Kollektsioonid.tühiNimekiri();
        }

        var sorteeritud = new NumbriNimekiri();
        var max = 0;
        for (Number number : nimekiri) {
            if(number.intValue() > max){
                sorteeritud.lisa(number);
                max = number.intValue();
            }
        }

        return sorteeritud;
    }
}
