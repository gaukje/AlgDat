package hjelpeklasser;

import java.util.*;
import java.util.stream.Stream;

public class SBinTre<T> // implements Beholder<T>
{
    private static final class Node<T> // en indre nodeklasse
    {
        private T verdi;                 // nodens verdi
        private Node<T> venstre, høyre;  // venstre og høyre barn

        private Node(T verdi, Node<T> v, Node<T> h)  // konstruktør
        {
            this.verdi = verdi;
            venstre = v;
            høyre = h;
        }

        private Node(T verdi)  // konstruktør
        {
            this(verdi, null, null);
        }
    } // class Node

    private Node<T> rot;                       // refranse til rotnoden
    private int antall;                        // antall noder
    private final Comparator<? super T> comp;  // komparator

    public SBinTre(Comparator<? super T> c)    // konstruktør
    {
        rot = null;
        antall = 0;
        comp = c;
    }

    public int antall()        // antall verdier i treet
    {
        return antall;
    }

    public boolean tom()       // er treet tomt?
    {
        return antall == 0;
    }

    //5.2.2
    public static <T extends Comparable<? super T>> SBinTre<T> sbintre()
    {
        return new SBinTre<>(Comparator.naturalOrder());
    }

    public static <T> SBinTre<T> sbintre(Comparator<? super T> c)
    {
        return new SBinTre<>(c);
    }

    //5.2.3
    public final boolean leggInn(T verdi)    // skal ligge i class SBinTre
    {
        Objects.requireNonNull(verdi, "Ulovlig med nullverdier!");

        Node<T> p = rot, q = null;               // p starter i roten
        int cmp = 0;                             // hjelpevariabel

        while (p != null)       // fortsetter til p er ute av treet
        {
            q = p;                                 // q er forelder til p
            cmp = comp.compare(verdi,p.verdi);     // bruker komparatoren
            p = cmp < 0 ? p.venstre : p.høyre;     // flytter p
        }

        // p er nå null, dvs. ute av treet, q er den siste vi passerte

        p = new Node<>(verdi);                   // oppretter en ny node

        if (q == null) rot = p;                  // p blir rotnode
        else if (cmp < 0) q.venstre = p;         // venstre barn til q
        else q.høyre = p;                        // høyre barn til q

        antall++;                                // én verdi mer i treet
        return true;                             // vellykket innlegging
    }

    public static <T> SBinTre<T> sbintre(Stream<T> s, Comparator<? super T> c)
    {
        SBinTre<T> tre = new SBinTre<>(c);             // komparatoren c
        s.forEach(tre::leggInn);                       // bygger opp treet
        return tre;                                    // treet returneres
    }

    public static <T extends Comparable<? super T>> SBinTre<T> sbintre(Stream<T> s)
    {
        return sbintre(s, Comparator.naturalOrder());  // naturlig ordning
    }

    //Nødvendige metoder for å fullføre oppgaver til 5.2.3
    public String toString()
    {
        StringJoiner s = new StringJoiner(", ", "[", "]");
        if (!tom()) inorden(x -> s.add(x != null ? x.toString() : "null"));
        return s.toString();
    }

    private static <T> void inorden(Node<T> p, Oppgave<? super T> oppgave)
    {
        if (p.venstre != null) inorden(p.venstre,oppgave);
        oppgave.utførOppgave(p.verdi);
        if (p.høyre != null) inorden(p.høyre,oppgave);
    }

    public void inorden(Oppgave <? super T> oppgave)
    {
        if (!tom()) inorden(rot,oppgave);
    }

    // 5.2.5 - a)
    private static <T> Node<T> balansert(T[] a, int v, int h)  // en rekursiv metode
    {
        if (v > h) return null;                       // tomt intervall -> tomt tre

        int m = (v + h)/2;                            // midten
        T verdi = a[m];                               // midtverdien

        while (v < m && verdi.equals(a[m-1])) m--;    // til venstre

        Node<T> p = balansert(a, v, m - 1);           // venstre subtre
        Node<T> q = balansert(a, m + 1, h);           // høyre subtre

        return new Node<>(verdi, p, q);               // rotnoden
    }

    // 5.2.5 - b)
    public static <T> SBinTre<T> balansert(T[] a, Comparator<? super T> c)
    {
        SBinTre<T> tre = new SBinTre<>(c);          // oppretter et tomt tre
        tre.rot = balansert(a, 0, a.length - 1);    // bruker den rekursive metoden
        tre.antall = a.length;                      // setter antallet
        return tre;                                 // returnerer treet
    }

    public static <T extends Comparable<? super T>> SBinTre<T> balansert(T[] a) {
        return balansert(a, Comparator.naturalOrder());
    }

    //5.2.6 a)
    public boolean inneholder(T verdi)     // skal ligge i klassen SBinTre
    {
        if (verdi == null) return false;            // treet har ikke nullverdier

        Node<T> p = rot;                            // starter i roten
        while (p != null)                           // sjekker p
        {
            int cmp = comp.compare(verdi, p.verdi);   // sammenligner
            if (cmp < 0) p = p.venstre;               // går til venstre
            else if (cmp > 0) p = p.høyre;            // går til høyre
            else return true;                         // cmp == 0, funnet
        }
        return false;                               // ikke funnet
    }

    //5.2.6 - 2)
    public int antall(T verdi) {
        Node<T> p = rot;
        int antallVerdi = 0;

        while (p != null) {
            int cmp = comp.compare(verdi, p.verdi);
            if (cmp < 0) p = p.venstre;

            else {
                if (cmp == 0) antallVerdi++;
                p = p.høyre;
            }
        }
        return antallVerdi;
    }

    //5.2.7 - 1) - maks
    public T maks() {
        if (tom()) throw new NoSuchElementException("Treet er tomt!");

        Node<T> p = rot;
        T maks = null;

        while (p.høyre != null) p = p.høyre;
        return p.verdi;
    }

    //5.3.1
    public boolean erMintre(Comparator<? super T> c) // legges i BinTre
    {
        if (rot == null) return true;    // et tomt tre er et minimumstre
        else return erMintre(rot,c);     // kaller den private hjelpemetoden
    }

    private static <T> boolean erMintre(Node<T> p, Comparator<? super T> c)
    {
        if (p.venstre != null)
        {
            if (c.compare(p.venstre.verdi,p.verdi) < 0) return false;
            if (!erMintre(p.venstre,c)) return false;
        }
        if (p.høyre != null)
        {
            if (c.compare(p.høyre.verdi,p.verdi) < 0) return false;
            if (!erMintre(p.høyre,c)) return false;
        }
        return true;
    }

    public String minimumsGrenen(Comparator<? super T> c) {
        StringJoiner s = new StringJoiner(", ", "[", "]");

        Node<T> p = rot;
        while (p != null) {
            s.add(p.verdi.toString());
            if (p.høyre == null) p = p.venstre;                 //Har ikke høyre barn
            else if (p.venstre == null) p = p.høyre;            //Har ikke venstre barn
            else {
                int cmp = c.compare(p.venstre.verdi, p.høyre.verdi);
                p = cmp <= 0 ? p.venstre : p.høyre;
            }
        }
        return s.toString();
    }
} // class SBinTre