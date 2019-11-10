
package ohtu.verkkokauppa;

public class PankkitoimiIO implements PankkiIO {
    
    private Pankki pankki;

    public PankkitoimiIO(Pankki pankki) {
        this.pankki = pankki;
    }
           
    @Override
    public boolean tilisiirto(String nimi, int viite, String tilinumero, String kaupanTili, int summa) {
        return this.pankki.tilisiirto(nimi, viite, tilinumero, kaupanTili, summa);
    }
    
}
