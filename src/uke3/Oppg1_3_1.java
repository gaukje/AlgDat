package uke3;

import hjelpeklasser.Tabell;

public class Oppg1_3_1 {
    public static void main(String[] args) {
        int[] a = {2, 3, 6, 4, 1, 5};
        int[] b = {2, 3, 6, 1, 5, 4};
        int[] c = {2, 3, 1, 6, 5, 4};
        int[] d = {2, 3, 6, 5, 4, 1};
        int[] e = {2, 6, 5, 4, 3, 1};

        Tabell.nestePermutasjon(a);
        Tabell.nestePermutasjon(b);
        Tabell.nestePermutasjon(c);
        Tabell.nestePermutasjon(d);
        Tabell.nestePermutasjon(e);
        //Tabell.skrivln(a);
        //Tabell.skrivln(b);
        //Tabell.skrivln(c);
        //Tabell.skrivln(d);
        //Tabell.skrivln(e);

        //int[] tre = {3, 1, 4, 9, 7, 10, 8, 6, 5, 2};
        // Tabell.skrivln(tre);
    }
}
