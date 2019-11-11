package ohtu.verkkokauppa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Kauppa {
    
    @Autowired
    private VarastotoimiIO varastoIO;
    
    @Autowired
    private PankkitoimiIO pankkiIO;
    
    @Autowired
    private ViitetoimiIO viiteIO;
    
    private Ostoskori ostoskori;
    private String kaupanTili;
    
    public Kauppa() {
        kaupanTili = "33333-44455";
    }

    public void aloitaAsiointi() {
        ostoskori = new Ostoskori();
    }

    public void poistaKorista(int id) {
        Tuote t = varastoIO.haeTuote(id); 
        varastoIO.palautaVarastoon(t);
    }

    public void lisaaKoriin(int id) {
        if (varastoIO.saldo(id)>0) {
            Tuote t = varastoIO.haeTuote(id);             
            ostoskori.lisaa(t);
            varastoIO.otaVarastosta(t);
        }
    }

    public boolean tilimaksu(String nimi, String tiliNumero) {
        int viite = viiteIO.uusi();
        int summa = ostoskori.hinta();
        
        return pankkiIO.tilisiirto(nimi, viite, tiliNumero, kaupanTili, summa);
    }

}
