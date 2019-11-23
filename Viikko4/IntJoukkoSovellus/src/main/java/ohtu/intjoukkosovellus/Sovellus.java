package ohtu.intjoukkosovellus;

import java.util.Scanner;

public class Sovellus {

    private IntJoukko A, B, C;
    private Scanner lukija;
    private JoukkoToiminnot toiminnot;
    
    
    public void kaynnistaSovellus(Scanner lukija) {
        A = new IntJoukko();
        B = new IntJoukko();
        C = new IntJoukko();
        this.toiminnot = new JoukkoToiminnot();
        this.lukija = lukija;
        
        System.out.println("Tervetuloa joukkolaboratorioon!");
        System.out.println("Käytössäsi ovat joukot A, B ja C.");
        System.out.println("Komennot ovat lisää(li), poista(p), kuuluu(k), yhdiste(y), erotus(e), leikkaus(le) ja lopetus(quit)(q).");
        System.out.println("Joukon nimi komentona tarkoittaa pyyntöä tulostaa joukko.");
    
        
        while (true) {

            String luettu = lukija.nextLine();

            if (luettu.equals("li")) lisaa(lukija);
            else if (luettu.equalsIgnoreCase("p")) poista(lukija);
            else if (luettu.equalsIgnoreCase("k")) kuuluu(lukija);
            else if (luettu.equalsIgnoreCase("y")) joukkoToiminnot("y", lukija);
            else if (luettu.equalsIgnoreCase("le")) joukkoToiminnot("l", lukija);
            else if (luettu.equalsIgnoreCase("e")) joukkoToiminnot("e", lukija);
            else if (luettu.equalsIgnoreCase("A")) System.out.println(A.toString());
            else if (luettu.equalsIgnoreCase("B")) System.out.println(B.toString());
            else if (luettu.equalsIgnoreCase("C")) System.out.println(C.toString());
            else if (luettu.equalsIgnoreCase(("q"))) { 
                System.out.println("Lopetetaan, moikka!");
                break;
            } else {
                System.out.println("Komennot ovat lisää(li), poista(p), kuuluu(k), yhdiste(y), erotus(e), leikkaus(le) ja lopetus(quit)(q).");
                System.out.println("Joukon nimi komentona tarkoittaa pyyntöä tulostaa joukko.");
            }
        }
    }
    
    private IntJoukko mikaJoukko(String joukko) {
        if (joukko.equalsIgnoreCase("A")) return A;
        if (joukko.equalsIgnoreCase("B")) return B;
        if (joukko.equalsIgnoreCase("A")) return C;
        return null;
    }

    private void lisaa(Scanner lukija) {
        System.out.println("Mihin joukkoon? ");
        IntJoukko joukko = mikaJoukko(lukija.nextLine());
        System.out.println("Mikä luku lisätään? ");
        int luku = lukija.nextInt();
        if (luku == (int)luku && joukko != null) {
            joukko.lisaa(luku);        
        } else {
            System.out.println("Syötä tiedot oikeassa muodossa!");
        }
        
    }

    private void poista(Scanner lukija) {
        System.out.println("Mistä joukosta poistetaan? ");
        IntJoukko joukko = mikaJoukko(lukija.nextLine());
        System.out.println("Mikä luku poistetaan? ");
        int luku = lukija.nextInt();
        if (luku == (int)luku && joukko != null) {
            joukko.poista(luku);
        } else {
            System.out.println("Syötä tiedot oikeassa muodossa!");
        }
    }

    private void kuuluu(Scanner lukija) {
        System.out.println("Mikä joukko?");
        IntJoukko joukko = mikaJoukko(lukija.nextLine());
        if (joukko == null) System.out.println("Ei ole joukko");
        System.out.println("Mikä luku?");
        int luku = Integer.valueOf(lukija.nextLine());
        if (luku == (int)luku && joukko != null) {
            if (joukko.kuuluu(luku)) System.out.println("kuuluu joukkoon");
            else System.out.println("ei kuulu joukkoon");
        } else {
            System.out.println("Syötä tiedot oikeassa muodossa!");
        }
    }
    
    private void joukkoToiminnot(String toiminto, Scanner lukija) {
        System.out.println("Mikä joukko?");
        IntJoukko ekaJoukko = mikaJoukko(lukija.nextLine());
        if (ekaJoukko == null) System.out.println("Ei ole joukko");
        System.out.println("Mihin joukkoon verrataan?");
        IntJoukko tokaJoukko = mikaJoukko(lukija.nextLine());
        
        if (tokaJoukko == null) System.out.println("Ei ole joukko");
        if (toiminto.equalsIgnoreCase("y")) System.out.println(toiminnot.yhdiste(ekaJoukko,tokaJoukko).toString());
        else if (toiminto.equalsIgnoreCase("l")) System.out.println(toiminnot.leikkaus(ekaJoukko,tokaJoukko).toString());
        else if (toiminto.equalsIgnoreCase("e")) System.out.println(toiminnot.erotus(ekaJoukko,tokaJoukko).toString());
    }
    
    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);
        Sovellus sovellus = new Sovellus();
        sovellus.kaynnistaSovellus(lukija);
    }
    
}
