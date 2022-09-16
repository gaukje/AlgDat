package uke4;

import eksempelklasser.Dato;
import eksempelklasser.Person;
import hjelpeklasser.Tabell;

import java.awt.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.NoSuchElementException;

import static hjelpeklasser.Tabell.fratilKontroll;

public class Oppg1_4_9 {
    public static void main(String[] args) {
        // Oppgave 1)
        String[] s = {"Sohil", "Per", "Thanh", "Ann", "Kari", "Jon"};       // String-tabell
        Comparator<String> c = Comparator.comparing(String::length);  // etter lengde
        innsettingssortering(s, c.thenComparing(x -> x));       // vanlig orden
        System.out.println(Arrays.toString(s));                        // skriver ut

        // Oppgave 3a)
        int[] x = {3, 5, 6, 2, 6, 1, 4, 7, 7, 4};         // x-koordinater
        int[] y = {3, 6, 3, 5, 5, 2, 1, 4, 2, 4};         // y-koordinater

        Point[] punkt = new Point[x.length];     // en punkttabell
        for (int i = 0; i < punkt.length; i++) punkt[i] = new Point(x[i], y[i]);

        for (Point p : punkt) System.out.print("(" + p.x + "," + p.y + ") ");
        System.out.println();                    // linjeskift

        // Utskriften blir:
        // (3,3) (5,6) (6,3) (2,5) (6,5) (1,2) (4,1) (7,4) (7,2) (4,4)
        // (1,2) (2,5) (3,3) (4,1) (4,4) (5,6) (6,3) (6,5) (7,2) (7,4)

        //Oppgave 3b)
        /*
        Tabell.innsettingssortering(punkt, (p1, p2) ->
                {
                    int d = p1.x - p2.x;    // forskjellen mellom x-koordinatene
                    if (d != 0) return d;
                    return p1.y - p2.y;     // forskjellen mellom x-koordinatene
                }
        );
        */
        /*
        //Oppgave 3c)
        innsettingssortering(punkt,
                Comparator.comparingInt((Point p) -> p.x).thenComparingInt(p -> p.y));

        for (Point p : punkt) System.out.print("(" + p.x + "," + p.y + ") ");


        //Oppgave 3d)
        innsettingssortering(punkt,
                Comparator.comparingInt(p -> p.x).thenComparingInt(p -> p.y));

        for (Point p : punkt) System.out.print("(" + p.x + "," + p.y + ") ");
         */
        //Hvis vi fjerne "point" fra "point p", får vi feilmelding

        //Oppgave 3e)
        Tabell.innsettingssorteringC(punkt,
                Comparator.comparingDouble(Point::getX).thenComparingDouble(Point::getY));

        //Hopper over oppgave 3f) og 3g)

        //Oppgave 4a)
        Dato[] d = new Dato[5];           // en datotabell
        d[0] = new Dato(24,12,2014);      // 24/12-2014
        d[1] = new Dato(24,12,2012);      // 24/12-2012
        d[2] = new Dato(9,12,2013);       // 9/12-2013
        d[3] = new Dato(25,12,2012);      // 25/12-2012
        d[4] = new Dato(10,12,2013);      // 10/12-2013

        //Oppgave 4b)
        Tabell.innsettingssorteringC(d, Comparator.naturalOrder());
        for (Dato v : d) System.out.print(v + " ");

        // Utskrift: 24/12-2012 25/12-2012 9/12-2013 10/12-2013 24/12-2014
    }

    //Oppgave 1)
    public static <T> void innsettingssortering(T[] a, Comparator<? super T> c) {
        for (int i = 1; i < a.length; i++)  // starter med i = 1
        {
            T verdi = a[i];        // verdi er et tabellelemnet
            int j = i - 1;        // j er en indeks

            // sammenligner og forskyver:
            for (; j >= 0 && c.compare(verdi, a[j]) < 0; j--) a[j + 1] = a[j];

            a[j + 1] = verdi;      // j + 1 er rett sortert plass
        }
    }
}
