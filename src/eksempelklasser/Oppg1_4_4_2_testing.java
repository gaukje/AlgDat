package eksempelklasser;

import hjelpeklasser.Tabell;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Stream;

public class Oppg1_4_4_2_testing {
    public static void main(String[] args) {
        Person[] p = new Person[7];                   // en persontabell

        p[0] = new Person("Kari","Svendsen");         // Kari Svendsen
        p[1] = new Person("Boris","Zukanovic");       // Boris Zukanovic
        p[2] = new Person("Ali","Kahn");              // Ali Kahn
        p[3] = new Person("Azra","Zukanovic");        // Azra Zukanovic
        p[4] = new Person("Kari","Pettersen");        // Kari Pettersen
        p[5] = new Person("Per", "Magnusson");
        p[6] = new Person("Ali", "Person");

        int m = Tabell.maks(p);                       // posisjonen til den største
        System.out.println(p[m] + " er størst");      // skriver ut den største

        Tabell.innsettingssortering(p);               // generisk sortering
        System.out.println(Arrays.toString(p));       // skriver ut sortert

        // Utskrift:

        // Boris Zukanovic er størst
        // [Ali Kahn, Kari Pettersen, Kari Svendsen, Azra Zukanovic, Boris Zukanovic]
        Arrays.stream(p).max(Comparator.naturalOrder()).ifPresent(System.out::println);
    }
}
