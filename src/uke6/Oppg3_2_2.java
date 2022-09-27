package uke6;

import hjelpeklasser.Liste;
import hjelpeklasser.TabellListe;

public class Oppg3_2_2 {
    public static void main(String[] args) {
        //3.2.2 - oppg. 2
        String[] s = {"Per", "Kari", "Ole", "Azra", "", "", "leila"};
        Liste<String> liste = new TabellListe<>(s);
        System.out.println(liste.hent(3));
        System.out.println(liste.inneholder("Ole"));
        System.out.println(liste.indeksTil(""));

        //Oppgave 3)
        System.out.println(liste);

        //3.2.3 - 1)
        liste.fjern("");
        System.out.println(liste);
    }
}
