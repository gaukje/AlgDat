package uke4;

import hjelpeklasser.Tabell;

import java.util.Arrays;

public class Oppg1_4_2 {
    public static void main(String[] args) {
        //Oppg. 1
        String[] s = {"Sohil","Per","Thanh","Fatima","Kari","Jasmin"};
        int k = Tabell.maks(s);        // hvilken maks-metode?
        System.out.println(s[k]);      // Utskrift:  Thanh
        //Kjører koden^, og fjerner String-maksmetoden fra 1.4.1

        //Oppg. 2
        String[] t = {"Per","Kari","Ole","Anne","Ali","Eva"};
        Tabell.innsettingssortering(t);
        System.out.println(Arrays.toString(t));  // [Ali, Anne, Eva, Kari, Ole, Per]
    }
}
