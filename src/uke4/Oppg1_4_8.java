package uke4;

import eksempelklasser.Komparator;
import hjelpeklasser.Tabell;

import java.util.Arrays;

public class Oppg1_4_8 {
    public static void main(String[] args) {
        //Oppg 2)
        /*
        I "Komparator.orden(x -> x) får vi det som tilsvarer f(x) = x i mattematikk, altså identitetsfunksjonen.
        "Komparator.naturligOrden()" vil i likhet med Komparator.orden siden x er en instans av en
        sammenlignbar type- dermed er de like.
         */

        //Oppg 4)
        String[] s = {"21","18","8","13","20","6","16","25","3","10"};
        Tabell.innsettingssortering(s, Komparator.orden(String::length).deretter(x -> x));
        System.out.println(Arrays.toString(s));
    }
}
