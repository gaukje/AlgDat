package uke2;

import hjelpeklasser.Tabell;

import java.io.IOException;

import static hjelpeklasser.Tabell.*;

public class Oppg1_2_3 {
    //Legg metodene Programkode 1.2.3 a) og 1.2.3 d), inn i samleklassen Tabell.

    // Oppg 1.2.3 - 3
    //Gjør om maks-metoden i Programkode 1.2.1 b), som du nå skal ha lagt inn i class Tabell,
    // slik at parameterverditesten blir erstattet med Programkode 1.2.3 b) og c)

    public static void main(String[] args) throws IOException {
        int [] a = Tabell.randPerm(10);
        int [] c = null;
        Tabell.maks(a, -1, 10);
        //Tabell.maks(a, 0, 11);
        //Tabell.maks(a,10, 0);
        //Tabell.maks(a,0,0);
        //Tabell.maks(c,0,0);
    }

    //Oppgave 5

    public static void skriv(int[] a, int fra, int til)
    {
        fratilKontroll(a.length,fra,til);

        for (int i = fra; i < til; i++) System.out.print(a[i] + " ");
    }

    public static void skrivln(int[] a, int fra, int til)
    {
        fratilKontroll(a.length,fra,til);

        for (int i = fra; i < til; i++) System.out.print(a[i] + " ");
        System.out.println();
    }

    public static void skriv(char[] c, int fra, int til)
    {
        fratilKontroll(c.length,fra,til);

        for (int i = fra; i < til; i++) System.out.print(c[i] + " ");
    }

    public static void skrivln(char[] c, int fra, int til)
    {
        fratilKontroll(c.length,fra,til);

        for (int i = fra; i < til; i++) System.out.print(c[i] + " ");
        System.out.println();
    }
}
