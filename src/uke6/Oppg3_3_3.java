package uke6;

import hjelpeklasser.EnkeltLenketListe;
import hjelpeklasser.Liste;

public class Oppg3_3_3 {
    public static void main(String[] args) {
        //3.3.3 - 1)
        int[] s = {1,2,3,4,5,6,7,8,9};

        Liste<Integer> liste = new EnkeltLenketListe<>();

        for (int n : s) liste.leggInn(0, n);

        System.out.println(liste);

        System.out.println(liste.fjern(s.length - 1)+ " har blitt fjernet");
        System.out.println(liste);

        System.out.println(liste.fjern(0)+ " har blitt fjernet");
        System.out.println(liste);

        while (liste.antall() > 0) {
            liste.fjern(0);
            System.out.println(liste);
        }
    }
}
