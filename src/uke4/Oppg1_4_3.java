package uke4;

import hjelpeklasser.Tabell;

import java.util.Arrays;
import java.util.Random;

public class Oppg1_4_3 {
    public static void main(String[] args) {
        //Oppg. 2 - Jeg tror at "Integer.compare(-1, 1)" returnerer -1
        //"Integer.compareUnsigned(-1, 1)" vil returnere 1, - søk opp.

        // Oppgave 7 - krever autoboksing

        double[] d = {5.7,3.14,7.12,3.9,6.5,7.1,7.11};
        Double[] b = new Double[d.length];

        // hvert element b lages som en instans av class Double
        for (int i = 0; i < b.length; i++) b[i] = d[i];  // autoboksing

        Tabell.innsettingssortering(b);
        //Tabell.skrivln(b);  // se Oppgave 5

        //Oppgave 8
        //For 'public static void f(int a, Integer b) { }' og 'public static void f(Integer a, int b) { }'
        //Kompilatoren vil sende en feilmelding ved metodekallet f(1,1)
        //En kan bestemme hvem av dem som skal brukes ved å konvertere ett av tallene til en Integer:
        // ' f(1, (Integer)1);  // nå brukes f(int a, Integer b)' eller: 'f((Integer)1,1);   // f(Integer a, int b)'

    }
    //Oppg. 5
    public static void skriv(Object[] a, int fra, int til){
        Tabell.fratilKontroll(a.length, fra, til);

        for (int i = fra; i < til; i++){
            System.out.println(a[i]+"");
        }
    }

    public static void skriv(Object[] a)
    {
        skriv(a,0,a.length);
    }

    public static void skrivln(Object[] a, int fra, int til)
    {
        skriv(a,fra,til);
        System.out.println();
    }

    // 1.4.3 - Oppgave 6
    public static void bytt(Object[] a, int i, int j)
    {
        Object temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }


}
