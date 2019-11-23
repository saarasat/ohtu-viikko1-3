
package ohtu.intjoukkosovellus;

import java.util.*;

public class IntJoukko {

    private ArrayList<Integer> joukko;

    public IntJoukko() {
        joukko = new ArrayList<>();
    }    
    
    public IntJoukko(ArrayList<Integer> joukko) {
        this.joukko = joukko;
    }

    public boolean lisaa(int luku) {
        if (!joukko.contains(luku)) {
            joukko.add(luku);
            return true;
        }
        return false;
    }

    public boolean kuuluu(int luku) {
        if (joukko.contains(luku)) {
            return true;
        }
        return false;
    }

    public boolean poista(int luku) {
        if (joukko.contains(luku)) {
            joukko.remove(joukko.indexOf(luku));
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder tulos = new StringBuilder();
        tulos.append("{ ");
        for (Integer luku : joukko) {
            if (joukko.indexOf(luku) == joukko.size()-1) tulos.append(luku);
            else tulos.append(luku + ", ");
        }
        tulos.append(" }");
        return tulos.toString();
    }
   
    public ArrayList<Integer> getJoukko() {
       return this.joukko;
    }

}
