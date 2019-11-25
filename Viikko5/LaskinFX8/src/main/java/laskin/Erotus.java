package laskin;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Erotus extends Komento {
    
    private int palautettavaArvo;
    
    public Erotus(TextField tuloskentta, TextField syotekentta, Button nollaa, Button undo, Sovelluslogiikka sovellus) {
        super(tuloskentta, syotekentta, nollaa, undo, sovellus);    
    }

    @Override
    public void suorita() {
        int arvo = 0;        
        try {
           arvo = Integer.parseInt(syotekentta.getText());            
        } catch (Exception e) { }
        
        try {
           palautettavaArvo = Integer.parseInt(tuloskentta.getText());            
        } catch (Exception e) { }

        sovellus.miinus(arvo);
        int laskunTulos = sovellus.tulos();
        syotekentta.setText("");
        tuloskentta.setText("" + laskunTulos);
    } 
    
    @Override
    public void peru() {
        tuloskentta.setText("" + palautettavaArvo);   
    }
}