package uke5;

import hjelpeklasser.Tabell;

import java.util.Arrays;

public class Oppg1_5_7 {
    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,6,7,8,9,10};
        //Oppgave 1
        kvikksortering1(a,0,9);
    }
    //Oppgave 1
    private static void kvikksortering0(int[] a, int v, int h)
    {
        System.out.println("Kallet med [" + v + ":" + h + "] starter!");
        if (v >= h) return;   // tomt eller maks ett element

        int k = Tabell.sParter0(a,v,h,(v + h)/2);   // se Programkode 1.3.9 f)
        kvikksortering0(a,v,k-1);
        kvikksortering0(a,k+1,h);
        System.out.println( "Kallet med [" + v + ":" + h + "] er ferdig!");
    }

    //Oppgave2
    private static void kvikksortering1 (int[] a, int v, int h) {
        System.out.println("a[" + v + ":" + h + "] legges på stakken");
        int m = (v + h)/2;
        int p = Tabell.sParter0(a, v, h, m); //Bruker midtverdien
        if (v < p - 1) kvikksortering0(a,v, p-1); //Sorterer intervallet a[v : p -1]
        if (p + 1 > h) kvikksortering0(a, p + 1, h); //Sorterer intervallet a[p + 1 : h]
    }
    public static void kvikksortering(int[] a) // sorterer hele tabellen
    {
        if (a.length > 1) kvikksortering1(a, 0, a.length - 1);
    }
}
