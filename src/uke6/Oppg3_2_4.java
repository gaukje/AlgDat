package uke6;

import hjelpeklasser.Liste;
import hjelpeklasser.TabellListe;

public class Oppg3_2_4 {
    public static void main(String[] args) {
        //3.2.4 - 2)
        String[] s = {"Jens","Per","Kari","Ole","Berit","Jens","Anne","Nils","Siv"};

        Liste<String> liste = new TabellListe<>();

        for (String navn : s) liste.leggInn(0,navn);    //Legger inn først

        System.out.println("Vi henter " + liste.hent(5) + ".");
        System.out.println("Nils er på plass " + liste.indeksTil("Nils") + "!");

        liste.oppdater(2,"Anna");  // bytter ut Anne med Anna på plass 2

        System.out.println(liste.fjern(0) + " er slettet!");
        System.out.println("Listeinnhold: " + liste);

        liste.fjernHvis(x -> x.equals("Jens"));  // fjerner alle forekomster av Jens
        liste.forEach(x -> System.out.print(x + " "));
    }
}
