/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.verkkokauppa;


public interface VarastoIO {
    
    Tuote haeTuote(int id);    
 
    void palautaVarastoon(Tuote t);
 
    int saldo(int id);
        
    void otaVarastosta(Tuote t);
    
    
}
