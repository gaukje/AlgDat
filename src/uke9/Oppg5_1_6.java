package uke9;

import hjelpeklasser.BinTre;
import hjelpeklasser.Liste;
import hjelpeklasser.Oppgave;
import hjelpeklasser.TabellListe;

import java.sql.SQLOutput;
import java.util.StringJoiner;

public class Oppg5_1_6 {
    public static void main(String[] args) {

        //Oppgave 1)
        //Verdier i nivåorden:
        //Tre 1: D I H L O B A E N G K M J F C
        // Tre 2: E I B G A H K L O D N M C J F

        //Oppgave 3)
        //int[] posisjon = {1,2,3,4,5,6,7,10,11,13,14,22,23,28,29};  // posisjoner og
        //String[] verdi = "EIBGAHKLODNMCJF".split("");              // verdier i nivåorden

        //BinTre<String> tre = new BinTre<>(posisjon, verdi);        // en konstruktør

        //tre.nivåorden();  // Utskrift: E I B G A H K L O D N M C J F
        //OK!

        //tre.nivåorden(c -> System.out.print(c + " "));  // lambda-uttrykk som argument
        //OK!
        /*
        Liste<String> liste = new TabellListe<>();  // en liste
        tre.nivåorden(c -> liste.leggInn(c));          // lambda-uttrykk som argument
        System.out.println(liste);                     // skriver ut listen
        OK!
         */

        //tre.nivåorden(Oppgave.konsollutskrift().deretter(c -> System.out.print(' ')));

        //Oppgave 4)

        /*

        int[] p = {1,2,3,4,5,6,7,10,11,13,14,22,23,28,29};  // posisjoner i nivåorden
        String v = "EIBGAHKLODNMCJF";                       // verdier i nivåorden

        BinTre<String> tre1 = new BinTre<>();

        for (int i = 0; i < p.length; i++) tre1.leggInn(p[i], v.charAt(i));

        StringJoiner s = new StringJoiner(", ", "[", "]");

        tre.nivåorden(c -> s.add(c.toString()));

        String verdier = s.toString();
        System.out.println(verdier);

         */
        int[] posisjon = {1,2,3,4,5,6,7,10,11,13,14,22,23,28,29};  // posisjoner og
        String[] verdi = "EIBGAHKLODNMCJF".split("");              // verdier i nivåorden

        BinTre<String> tre = new BinTre<>(posisjon, verdi);        // en konstruktør

        char[] d = {(char) 0};

        //tre.nivåorden(c -> { if (c > d[0]) d[0] = c;});
    }
}
