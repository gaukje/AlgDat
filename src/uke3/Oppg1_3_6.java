package uke3;

import hjelpeklasser.Tabell;

public class Oppg1_3_6 {
    public static void main(String[] args) {
        int[] a = {1, 3, 4, 4, 5, 7, 7, 7, 7, 8, 9, 10, 10, 12, 15, 15, 15};
        System.out.println(binærsøk1(a, 0,a.length, 4));
        System.out.println(binærsøk1(a, 0,a.length, 7));
        System.out.println(binærsøk1(a, 0,a.length, 10));
        System.out.println(binærsøk1(a, 0,a.length, 15));
        System.out.println("\n 3.binærsøk: \n");
        // 3) - Hos de tre første returneres det indeksen til den siste forekomsten av verdiene, men på siste deloppgave
        // får vi indeksen til den midterste forekomsten.
        System.out.println(Tabell.binærsøk(a,0, a.length, 4));
        System.out.println(Tabell.binærsøk(a,0, a.length, 7));
        System.out.println(Tabell.binærsøk(a,0, a.length, 10));
        System.out.println(Tabell.binærsøk(a,0, a.length, 15));

        // 4) Ser at når vi bruker 3.binærsøks-metode så får vi alltid indeksen til første forekomst av verdien vi leter etter.
    }

    //1. versjon av binærsøk
    public static int binærsøk1(int[] a, int fra, int til, int verdi)
    {
        Tabell.fratilKontroll(a.length,fra,til);  // se Programkode 1.2.3 a)
        int v = fra, h = til - 1;  // v og h er intervallets endepunkter

        while (v <= h)    // fortsetter så lenge som a[v:h] ikke er tom
        {
            int m = (v + h)/2;      // heltallsdivisjon - finner midten
            int midtverdi = a[m];   // hjelpevariabel for midtverdien

            if (verdi == midtverdi) return m;          // funnet
            else if (verdi > midtverdi) v = m + 1;     // verdi i a[m+1:h]
            else  h = m - 1;                           // verdi i a[v:m-1]
        }

        return -(v + 1);    // ikke funnet, v er relativt innsettingspunkt
    }

    public static int binærsøk(int[] a, int verdi)  // søker i hele a
    {
        return binærsøk1(a,0,a.length,verdi);  // bruker metoden over
    }

    //2. versjon av binærsøk

    public static int binærsøk2(int[] a, int fra, int til, int verdi)
    {
        Tabell.fratilKontroll(a.length,fra,til);  // se Programkode 1.2.3 a)
        int v = fra, h = til - 1;    // v og h er intervallets endepunkter

        while (v <= h)  // fortsetter så lenge som a[v:h] ikke er tom
        {
            int m = (v + h)/2;     // heltallsdivisjon - finner midten
            int midtverdi = a[m];  // hjelpevariabel for  midtverdien

            if (verdi > midtverdi) v = m + 1;        // verdi i a[m+1:h]
            else if (verdi < midtverdi) h = m - 1;   // verdi i a[v:m-1]
            else return m;                           // funnet
        }

        return -(v + 1);   // ikke funnet, v er relativt innsettingspunkt
    }
}
