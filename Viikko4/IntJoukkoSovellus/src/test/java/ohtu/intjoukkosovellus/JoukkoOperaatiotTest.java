
package ohtu.intjoukkosovellus;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class JoukkoOperaatiotTest {
    
    private JoukkoToiminnot toiminnot;
    private IntJoukko eka;
    private IntJoukko toka;
    private ArrayList<Integer> vastauksenLuvut;
    private ArrayList<Integer> odotettu;
    
    @Before
    public void setUp() {
        toiminnot = new JoukkoToiminnot();
        eka = new IntJoukko();
        toka = new IntJoukko();
        eka.lisaa(3);
        eka.lisaa(4);
        eka.lisaa(1);
        toka.lisaa(3);
        toka.lisaa(2);
    }
    
    @Test
    public void testYhdiste() {
        vastauksenLuvut = toiminnot.yhdiste(eka,toka).getJoukko();
        odotettu = new ArrayList<>();
        Collections.addAll(odotettu, 1,2,3,4);
        assertEquals(odotettu, vastauksenLuvut);        
    } 
    
    @Test
    public void testLeikkaus() {
        vastauksenLuvut = toiminnot.leikkaus(eka,toka).getJoukko();
        odotettu = new ArrayList<>();
        Collections.addAll(odotettu, 3);
        assertEquals(odotettu, vastauksenLuvut);        
    } 
    
    @Test
    public void testErotus() {
        vastauksenLuvut = toiminnot.erotus(eka,toka).getJoukko();
        odotettu = new ArrayList<>();
         Collections.addAll(odotettu, 1,4);
        assertEquals(odotettu, vastauksenLuvut);        
    } 
    

    

}
