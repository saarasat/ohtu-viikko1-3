package ohtu.verkkokauppa;

import org.springframework.stereotype.Component;

@Component
public class Viitegeneraattori {

    private int seuraava;
    
    public Viitegeneraattori(){
        this.seuraava = 1;    
    }
    
    public int uusi(){
        return seuraava++;
    }
}
