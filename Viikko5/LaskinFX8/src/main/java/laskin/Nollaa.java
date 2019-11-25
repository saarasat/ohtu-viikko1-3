package laskin;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Nollaa extends Komento {
    
    private int palautettavaArvo;
    
    public Nollaa(TextField tuloskentta, TextField syotekentta, Button nollaa, Button undo, Sovelluslogiikka sovellus) {
        super(tuloskentta, syotekentta, nollaa, undo, sovellus);    
    }

    @Override
    public void suorita() {
        try {
           palautettavaArvo = Integer.parseInt(tuloskentta.getText());            
        } catch (Exception e) {
        }
        syotekentta.setText("");
        tuloskentta.setText("" + 0);
    } 
    
    @Override
    public void peru() {
        tuloskentta.setText("" + palautettavaArvo);
        
    }
    

}


