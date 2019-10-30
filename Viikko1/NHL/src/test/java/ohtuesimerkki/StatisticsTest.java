package ohtuesimerkki;


import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class StatisticsTest {
    
    Reader readerStub = new Reader() {
        public List<Player> getPlayers() {
            ArrayList<Player> players = new ArrayList<>();
            
            players.add(new Player("Semenko", "EDM", 4, 12));
            players.add(new Player("Lemieux", "PIT", 45, 54));
            players.add(new Player("Kurri",   "EDM", 37, 53));
            players.add(new Player("Yzerman", "DET", 42, 56));
            players.add(new Player("Gretzky", "EDM", 35, 89));
            
            return players;
        }
    };
    
    Statistics stats;
    
    public StatisticsTest() {
    }
    
    @Before
    public void setUp() {
        stats = new Statistics(readerStub);
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void pelaajienHakuPalauttaaOikeanPelaajan() {
        assertEquals("Semenko", stats.search("Semenko").getName());
    }
    
    @Test
    public void pelaajienHakuPalauttaaNullJosPelaajaEiOle() {
        assertEquals(null, stats.search("Käpistelijä"));
    }
    
    @Test
    public void tiiminHakuPalauttaaOikeanMaaranPelaajia() {
        assertEquals(3, stats.team("EDM").size());
    }
    
    @Test
    public void tiiminHakuPalauttaaNollaJosTiimissaEiPelaajia() {
        assertEquals(0, stats.team("Käpistelijät").size());
    }

    @Test
    public void topScorersPalauttaaOikeanMaaranPelaajia() {
        assertEquals(3, stats.topScorers(3).size());
    }
    
    @Test
    public void topScorersEiPalautaMitaanJosKysytaanNegatiivistaMaaraaPelaajia() {
        assertEquals(0, stats.topScorers(-3).size());
    }
    
    @Test
    public void topScorersPalauttaaOikeanParhaanPelaajan() {
        assertEquals("Gretzky", stats.topScorers(1).get(0).getName());
    }


}
