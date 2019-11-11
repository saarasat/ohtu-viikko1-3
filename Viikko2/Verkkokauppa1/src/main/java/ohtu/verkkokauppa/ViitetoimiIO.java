
package ohtu.verkkokauppa;


import org.springframework.stereotype.Component;

@Component
public class ViitetoimiIO implements ViitegeneraattoriIO {

    private Viitegeneraattori viitegeneraattori;
    
    public ViitetoimiIO(Viitegeneraattori viitegeneraattori) {
        this.viitegeneraattori = viitegeneraattori;
    }
       
    @Override
    public int uusi() {
        return this.viitegeneraattori.uusi();
    }
    
}
