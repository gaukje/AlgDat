package uke2;

import hjelpeklasser.Tabell;

import static hjelpeklasser.Tabell.*;

public class Oppg1_2_4 {
    public static void main(String[] args) {

        //1.2.4 - oppg.1 gjennomført på hjelpeklasser.Tabell og hjelpeklasser.Program
        int [] a = Tabell.randPerm(20);
        int [] b = nestMaks(a);

        int m = b[0], nm = b[1];

        Tabell.skrivln(a);        // se Oppgave 5 i Avsnitt 1.2.2
        System.out.print("Størst(" + a[m] + ") har posisjon " + m);
        System.out.println(", nest størst(" + a[nm] + ") har posisjon " + nm);

    }

    //1.2.4 - Oppg. 2
    public static int[] nestMaks(int[] a)  // legges i class Tabell
    {
        if (a.length < 2) throw   // må ha minst to verdier!
                new java.util.NoSuchElementException("a.length(" + a.length + ") < 2!");

        int m = maks(a);  // m er posisjonen til tabellens største verdi

        Tabell.bytt(a, a.length - 1, m);

        int nm = Tabell.maks(a, 0, a.length - 1);

        if(nm == m) {
            nm = a.length - 1;
        }

        Tabell.bytt(a, a.length - 1, m);

        return new int[] {m,nm};      // m i posisjon 0 , nm i posisjon 1

    } // nestMaks
}
