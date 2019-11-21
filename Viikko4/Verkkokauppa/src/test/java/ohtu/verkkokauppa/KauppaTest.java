package ohtu.verkkokauppa;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class KauppaTest {

    private Pankki pankki; 
    private Viitegeneraattori viite;
    private Varasto varasto;
    private Kauppa k;

    @Before
    public void setUp() {
        pankki = mock(Pankki.class);
        viite = mock(Viitegeneraattori.class);
        varasto = mock(Varasto.class);
        k = new Kauppa(varasto, pankki, viite);              
    }


    @Test
    public void ostoksenPaaytyttyaPankinMetodiaTilisiirtoKutsutaan() {
        when(viite.uusi()).thenReturn(42);
        when(varasto.saldo(1)).thenReturn(10); 
        when(varasto.haeTuote(1)).thenReturn(new Tuote(1, "maito", 5));

        k.aloitaAsiointi();
        k.lisaaKoriin(1);     
        k.tilimaksu("pekka", "12345");

        verify(pankki).tilisiirto(anyString(), anyInt(), anyString(), anyString(),anyInt());   
    }

    @Test
    public void ostoksenPaaytyttyaPankinMetodiaTilisiirtoKutsutaanOikeillaArvoilla() {
        when(viite.uusi()).thenReturn(42);
        when(varasto.saldo(1)).thenReturn(10); 
        when(varasto.haeTuote(1)).thenReturn(new Tuote(1, "maito", 5));

        k.aloitaAsiointi();
        k.lisaaKoriin(1);     
        k.tilimaksu("pekka", "12345");

        verify(pankki).tilisiirto("pekka", 42, "12345", "33333-44455", 5);
    }

    @Test
    public void ostoksenPaaytyttyaTilisiirtoaKutsutaanOikeillaArvoillaKunKaksiEriTuotetta() {
        when(viite.uusi()).thenReturn(30);
        when(varasto.saldo(1)).thenReturn(10); 
        when(varasto.saldo(2)).thenReturn(5);
        when(varasto.haeTuote(1)).thenReturn(new Tuote(1, "maito", 5));
        when(varasto.haeTuote(2)).thenReturn(new Tuote(2, "mehu", 10));

        k.aloitaAsiointi();
        k.lisaaKoriin(1);
        k.lisaaKoriin(2);     
        k.tilimaksu("pekkaliisa", "12123");

        verify(pankki).tilisiirto("pekkaliisa", 30, "12123", "33333-44455", 15);
    }
    
    @Test
    public void ostoksenPaaytyttyaTilisiirtoaKutsutaanOikeillaArvoillaKunKaksiSamaaTuotetta() {
        when(viite.uusi()).thenReturn(30);
        when(varasto.saldo(1)).thenReturn(10);
        when(varasto.haeTuote(1)).thenReturn(new Tuote(1, "maito", 5));

        k.aloitaAsiointi();
        k.lisaaKoriin(1);
        k.lisaaKoriin(1);     
        k.tilimaksu("liisa", "1212344");

        verify(pankki).tilisiirto("liisa", 30, "1212344", "33333-44455", 10);
    }

    @Test
    public void ostoksenPaaytyttyaTilisiirtoaKutsutaanOikeillaArvoillaKunKaksiTuotettaJaVainToistaOn() {
        when(viite.uusi()).thenReturn(4);
        when(varasto.saldo(1)).thenReturn(10); 
        when(varasto.saldo(2)).thenReturn(0);
        when(varasto.haeTuote(1)).thenReturn(new Tuote(1, "maito", 5));
        when(varasto.haeTuote(2)).thenReturn(new Tuote(2, "mehu", 10));

        k.aloitaAsiointi();
        k.lisaaKoriin(1);
        k.lisaaKoriin(2);     
        k.tilimaksu("pekkaliisa", "12123");

        verify(pankki).tilisiirto("pekkaliisa", 4, "12123", "33333-44455", 5);
    }

    @Test
    public void kauppaPyytaaJokaiselleMaksulleUudenViitteen() {
        k.aloitaAsiointi();
        k.lisaaKoriin(1);
        k.tilimaksu("pekka", "1111");

        verify(viite).uusi();
    }

    @Test
    public void edellisenOstoksenHintaEiNayUudessaOstoksessa() {
        when(viite.uusi()).thenReturn(4).thenReturn(5);
        when(varasto.saldo(1)).thenReturn(10); 
        when(varasto.haeTuote(1)).thenReturn(new Tuote(1, "mehu", 10));

        k.aloitaAsiointi();
        k.lisaaKoriin(1);
        k.tilimaksu("pekka", "1111");

        verify(pankki).tilisiirto("pekka", 4, "1111", "33333-44455", 10);

        k.aloitaAsiointi();
        k.lisaaKoriin(1);
        k.tilimaksu("pekka", "1111");

        verify(pankki).tilisiirto("pekka", 5, "1111", "33333-44455", 10);
    }

    @Test
    public void ostoskoristaPoistaminenOnnistuu() {
        k.aloitaAsiointi();
        Tuote t = new Tuote(1, "maito", 5);
        when(varasto.haeTuote(1)).thenReturn(t); 

        k.lisaaKoriin(1);
        k.poistaKorista(1);

        verify(varasto).haeTuote(1);
        verify(varasto).palautaVarastoon(t);

    }

}