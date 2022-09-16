package uke4;

import eksempelklasser.Komparator;
import eksempelklasser.Person;
import hjelpeklasser.Tabell;

import java.util.Arrays;

public class Oppg1_4_7 {
    public static void main(String[] args) {
        //Oppgave 2)
        Double[] d = {5.7,3.14,7.12,3.9,6.5,7.1,7.11};
        Tabell.innsettingssortering(d, Komparator.naturligOrden());
        System.out.println(Arrays.toString(d));
        Tabell.innsettingssortering(d, Komparator.omvendtOrden());
        System.out.println(Arrays.toString(d));

        //Oppgave 3
        Boolean[] b = {false, true, true, false, false, true, false, true};
        Tabell.innsettingssortering(b, Komparator.naturligOrden());
        System.out.println(Arrays.toString(b));

        //Oppgave 4
        Person[] p = new Person[5];                       // en persontabell
        p[0] = new Person("Kari", "Svendsen");            // Kari Svendsen
        p[1] = new Person("Boris", "Zukanovic");          // Boris Zukanovic
        p[2] = new Person("Ali", "Kahn");                 // Ali Kahn
        p[3] = new Person("Azra", "Zukanovic");           // Azra Zukanovic
        p[4] = new Person("Kari", "Pettersen");           // Kari Pettersen

        Tabell.innsettingssortering(p, Komparator.orden(Person::etternavn));
        System.out.println(Arrays.toString(p));

        //Oppgave 5
        Integer[] a = {13,25,11,3,2,21,10,1,33,100};  // en Integer-tabell
        Tabell.innsettingssortering(a, Komparator.orden(x -> x.toString()));
        System.out.println(Arrays.toString(a)); // [1, 10, 100, 11, 13, 2, 21, 25, 3, 33]
    }
}
