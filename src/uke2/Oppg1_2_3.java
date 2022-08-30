package uke2;

import hjelpeklasser.Tabell;

import java.io.IOException;

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
}
