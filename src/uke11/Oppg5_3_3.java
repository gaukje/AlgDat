package uke11;

import hjelpeklasser.HeapPrioritetsKø;
import hjelpeklasser.PrioritetsKø;
import hjelpeklasser.Tabell;

public class Oppg5_3_3 {
    public static void main(String[] args) {
        //Programkode 5.3.3
        //Oppgave 1
        int[] a = {3,5,7,10,5,8,18,12,17,11,10,14};  // verdiene i Figur 5.3.2 a)
        PrioritetsKø<Integer> kø = HeapPrioritetsKø.naturligOrden();
        for (int k : a) kø.leggInn(k);

        kø.leggInn(6);  System.out.println(kø);     // legger inn 6
        kø.leggInn(10); System.out.println(kø);     // legger inn 10
        kø.leggInn(12); System.out.println(kø);     // legger inn 12

        // Utskrift:
        // [3, 5, 6, 10, 5, 7, 18, 12, 17, 11, 10, 14, 8]          se Figur 5.3.2 c)
        // [3, 5, 6, 10, 5, 7, 10, 12, 17, 11, 10, 14, 8, 18]      se Figur 5.3.2 d)
        // [3, 5, 6, 10, 5, 7, 10, 12, 17, 11, 10, 14, 8, 18, 12]  se Figur 5.3.2 e)

        //Oppgave 2)
        int[] b = {3,5,4,10,5,8,18,12,17,11,10,14};

        HeapPrioritetsKø<Integer> kø2 = HeapPrioritetsKø.naturligOrden();

        for (int k : b) kø2.leggInn(k);

        System.out.println(kø2.minimumsGrenen());

        // Utskrift: [3, 4, 8, 14]

        //Oppgave 3
        int n = 15;                           // velg n >= 0
        int[] c = Tabell.randPerm(n);         // en permutasjon av tallene fra 1 til n

        PrioritetsKø<Integer> kø3 = HeapPrioritetsKø.naturligOrden();
        for (int k: c) kø3.leggInn(k);         // ett og ett tall inn i køen

        while (!kø3.tom())
        {
            System.out.print(kø3.taUt() + " ");  // tar ut fra køen
        }
        // Utskrift: 1 2 3 4 5 6 7 8 9 10
    }
}
