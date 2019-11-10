package ohtu.verkkokauppa;

public class Viitegeneraattori {

    private int seuraava;
    
    public Viitegeneraattori(){
        this.seuraava = 1;    
    }
    
    public int uusi(){
        return seuraava++;
    }
}
