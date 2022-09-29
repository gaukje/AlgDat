package uke6;

import hjelpeklasser.EnkeltLenketListe;
import hjelpeklasser.Liste;

import java.util.Iterator;

public class Oppg3_3_4 {
    public static void main(String[] args) {
        //3.3.4 - 1)

        Liste<Integer> liste = new EnkeltLenketListe<>();
        for (int i = 1; i < 10 ; i++) liste.leggInn(i);
        /*
        Iterator<Integer> iterator = liste.iterator();
        liste.fjern(0);
        System.out.println(iterator.next());
         */

        //3.3.4 - 2)
        System.out.println(liste);
        liste.fjernHvis(x -> x % 2 == 0);
        liste.forEach(x -> System.out.print(x + " "));
    }
}
