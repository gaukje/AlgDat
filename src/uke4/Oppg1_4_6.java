package uke4;

import eksempelklasser.Student;
import eksempelklasser.Studium;
import hjelpeklasser.Tabell;

import java.util.Arrays;

public class Oppg1_4_6 {
    public static void main(String[] args) {
        Student[] s = new Student[9];                             // en studenttabell

        s[0] = new Student("Caro","Svendsen", Studium.Data);      // Kari Svendsen
        s[1] = new Student("Boris","Zukanovic",Studium.IT);      // Boris Zukanovic
        s[2] = new Student("Ali","Kahn",Studium.Anvendt);        // Ali Kahn
        s[3] = new Student("Azra","Zukanovic",Studium.IT);       // Azra Zukanovic
        s[4] = new Student("Kari","Pettersen",Studium.Data);     // Kari Pettersen
        s[5] = new Student("Anders","Åsen",Studium.Elektro);     // Anders Åsen
        s[6] = new Student("Kari","Østsiden",Studium.Elektro);   // Kari Østsiden
        s[7] = new Student("Per","Jensen",Studium.Enkeltemne);   // Per Jensen
        s[8] = new Student("Kari","Lie",Studium.Enkeltemne);     // Kari Lie
        /*
        Tabell.innsettingssortering(s, (s1,s2) ->
                {
                    int k = s1.studium().compareTo(s2.studium());
                    return k != 0 ? k : s1.compareTo(s2);
                }
        );
        for (Student t : s) System.out.println(t);
         */

        //Oppgave 3)
        Tabell.innsettingssortering(s, (s1,s2) -> {
            int k = s1.studium().compareTo(s2.studium());
            if (k != 0) return k;
            k = s1.fornavn().compareTo(s2.fornavn());
            if (k != 0) return k;;
            return s1.etternavn().compareTo(s2.etternavn());
        });

        for (Student t : s) System.out.println(t);

        //1.4.6 5)
        String[] t = {"21","18","8","13","20","6","16","25","3","10"};
        Tabell.innsettingssortering(t, (t1,t2) -> {
            int k = t1.length() - t2.length();
            return k != 0 ? k : t1.compareTo(t2);
        });

        System.out.println(Arrays.toString(t));
        // Utskrift: [Per, Lars, Kari, Bodil, Berit, Anders]
    }
}
