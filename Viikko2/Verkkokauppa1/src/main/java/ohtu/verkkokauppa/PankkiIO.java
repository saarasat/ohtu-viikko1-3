/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.verkkokauppa;


public interface PankkiIO {
        
    
    boolean tilisiirto(String nimi, int viite, String tilinumero, String kaupanTili, int summa);  

    
}
