
package ohtu.intjoukkosovellus;

import java.util.ArrayList;
import java.util.Collections;


public class JoukkoToiminnot {
    
    private ArrayList<Integer> ekaJoukko;
    private ArrayList<Integer> tokaJoukko;
    
    public IntJoukko yhdiste(IntJoukko eka, IntJoukko toka) {
        ekaJoukko = eka.getJoukko();
        tokaJoukko = toka.getJoukko();
        ArrayList<Integer> yhdiste = new ArrayList<>();
        for (Integer luku : ekaJoukko) {
            yhdiste.add(luku);
        }
        for (Integer luku : tokaJoukko) {
            if (!yhdiste.contains(luku)) {
                yhdiste.add(luku);
            }
        }
        Collections.sort(yhdiste);
        return new IntJoukko(yhdiste);
    }

    
    public IntJoukko leikkaus(IntJoukko eka, IntJoukko toka) {
        ekaJoukko = eka.getJoukko();
        tokaJoukko = toka.getJoukko();
        ArrayList<Integer> leikkaus = new ArrayList<>();
        for (Integer luku : ekaJoukko) {
            if (tokaJoukko.contains(luku)) {
                leikkaus.add(luku);
            }
        }
        Collections.sort(leikkaus);
        return new IntJoukko(leikkaus);
    }

    
    public IntJoukko erotus(IntJoukko eka, IntJoukko toka) {
        ekaJoukko = eka.getJoukko();
        tokaJoukko = toka.getJoukko();
        ArrayList<Integer> erotus = new ArrayList<>();
        for (Integer luku : ekaJoukko) {
            if (!tokaJoukko.contains(luku)) {
                erotus.add(luku);
            }
        }
        Collections.sort(erotus);
        return new IntJoukko(erotus);
    }
    
}