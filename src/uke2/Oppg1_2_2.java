package uke2;

import hjelpeklasser.*;

//Oppgave 2
public class Oppg1_2_2 {
    public static void main(String[] args) {            // hovedprogram
        int[] a = Tabell.randPerm(20);              // en tilfeldig tabell
        for (int k : a) System.out.print(k + " ");      // skriver ut a

        int m = Tabell.maks(a);                     // finner posisjonen til største verdi

        System.out.println("\nStørste verdi ligger på plass " + m);

        skriv(a, 3, 6);
        System.out.println("");
        skriv(a);
    }
    // main


//Oppgave 3 - "Lag metoden public static void bytt(char[] c, int i, int j)"

//Oppgave 4 - "Lag metoden public static void skriv(int[] a, int fra, int til).
//Den skal skrive ut tallene i intervallet a[fra:til>"

    public static void skriv(int[] a, int fra, int til) {
        if(fra < 0 || til > a.length || fra >= til) {
            throw new IllegalArgumentException("Ulovlig intervall!");
        }

        for(int i = fra; i < til; i++) {
            System.out.print(" "+a[i]);
        }
    }

    public static void skriv(int[] a) {
        skriv(a, 0, a.length);
    }
}