package eksempelklasser;

import hjelpeklasser.Tabell;

import java.util.Arrays;

public class Oppg1_4_4_1testingAvEksemeplklassene {
    public static void main(String[] args) {
        int[] a = {5,2,7,3,9,1,8,10,4,6};          // en int-tabell
        Heltall[] h = new Heltall[a.length];       // en Heltall-tabell

        for (int i = 0; i < h.length; i++) h[i] = new Heltall(a[i]);
        Tabell.innsettingssortering(h);           // generisk sortering
        System.out.println(Arrays.toString(h));   // utskrift
        //Sjekk løsningsforslaget til 1.4.4 - c)
        //Konklusjonen er at vi må være meget forsiktige med å utføre regnestykker med store tall i int-format.
        // Det kan gi feil resultat både med hensyn på fortegn og størrelse.

        // 1.4.4 d)
        Heltall x = new Heltall(3), y = new Heltall(3);
        System.out.println(x.compareTo(y) + "  " + x.equals(y));
        //Her vil x.compareTo(y) gi 0 fordi begge inneholder verdien 3 og er dermed like. Men x.equals(y) vil gi false
        // hvis vi bruker den versjonen av equals som vi arver fra class Object.
        // Den versjonen av equals gir false hvis vi sammenligner to forskjellige objekter.
        // Poenget er at x og y er to forskjellige objekter, men de inneholder samme verdi.
        // Metoden equals i class Object er kodet slik at x.equals(y) og x == y gir samme resultat.

        //1.4.4 e)
        Heltall x1 = new Heltall(3), y1 = new Heltall(3);  // x og y er like
        System.out.println(x1.hashCode() + "  " + y1.hashCode());
    }
}
