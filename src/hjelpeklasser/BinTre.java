package hjelpeklasser;

import uke8.Stakk;
import uke8.TabellStakk;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Consumer;

public class BinTre<T>           // et generisk binærtre
{
    private static final class Node<T>  // en indre nodeklasse
    {
        private T verdi;            // nodens verdi
        private Node<T> venstre;    // referanse til venstre barn/subtre
        private Node<T> høyre;      // referanse til høyre barn/subtre

        private Node(T verdi, Node<T> v, Node<T> h)    // konstruktør
        {
            this.verdi = verdi; venstre = v; høyre = h;
        }

        private Node(T verdi) { this.verdi = verdi; }  // konstruktør

    } // class Node<T>

    private Node<T> rot;      // referanse til rotnoden
    private int antall;       // antall noder i treet

    public BinTre() { rot = null; antall = 0; }          // konstruktør

    //5.1.5 c)
    public BinTre(int[] posisjon, T[] verdi)  // konstruktør
    {
        if (posisjon.length > verdi.length) throw new
                IllegalArgumentException("Verditabellen har for få elementer!");

        for (int i = 0; i < posisjon.length; i++) leggInn(posisjon[i],verdi[i]);
    }

    //5.1.5 c)
    public final void leggInn(int posisjon, T verdi)  // final: kan ikke overstyres
    {
        if (posisjon < 1) throw new
                IllegalArgumentException("Posisjon (" + posisjon + ") < 1!");

        Node<T> p = rot, q = null;    // nodereferanser

        int filter = Integer.highestOneBit(posisjon) >> 1;   // filter = 100...00

        while (p != null && filter > 0)
        {
            q = p;
            p = (posisjon & filter) == 0 ? p.venstre : p.høyre;
            filter >>= 1;  // bitforskyver filter
        }

        if (filter > 0) throw new
                IllegalArgumentException("Posisjon (" + posisjon + ") mangler forelder!");
        else if (p != null) throw new
                IllegalArgumentException("Posisjon (" + posisjon + ") finnes fra før!");

        p = new Node<>(verdi);          // ny node

        if (q == null) rot = p;         // tomt tre - ny rot
        else if ((posisjon & 1) == 0)   // sjekker siste siffer i posisjon
            q.venstre = p;                // venstre barn til q
        else
            q.høyre = p;                  // høyre barn til q

        antall++;                       // en ny verdi i treet
    }

    public int antall() { return antall; }               // returnerer antallet

    public boolean tom() { return antall == 0; }         // tomt tre?

    //5.1.5 j)
    private Node<T> finnNode(int posisjon)  // finner noden med gitt posisjon
    {
        if (posisjon < 1) return null;

        Node<T> p = rot;   // nodereferanse
        int filter = Integer.highestOneBit(posisjon >> 1);   // filter = 100...00

        for (; p != null && filter > 0; filter >>= 1)
            p = (posisjon & filter) == 0 ? p.venstre : p.høyre;

        return p;   // p blir null hvis posisjon ikke er i treet
    }

    public boolean finnes(int posisjon)
    {
        return finnNode(posisjon) != null;
    }

    public T hent(int posisjon)
    {
        Node<T> p = finnNode(posisjon);

        if (p == null) throw new
                IllegalArgumentException("Posisjon (" + posisjon + ") finnes ikke i treet!");

        return p.verdi;
    }

    public T oppdater(int posisjon, T nyverdi)
    {
        Node<T> p = finnNode(posisjon);

        if (p == null) throw new
                IllegalArgumentException("Posisjon (" + posisjon + ") finnes ikke i treet!");

        T gammelverdi = p.verdi;
        p.verdi = nyverdi;

        return gammelverdi;
    }

    public T fjern(int posisjon)
    {
        if (posisjon < 1) throw new
                IllegalArgumentException("Posisjon(" + posisjon + ") < 1!");

        Node<T> p = rot, q = null;               // hjelpepekere
        int filter = Integer.highestOneBit(posisjon >> 1);   // binært siffer

        while (p != null && filter > 0)
        {
            q = p;
            p = (filter & posisjon) == 0 ? p.venstre : p.høyre;
            filter >>= 1;
        }

        if (p == null) throw new
                IllegalArgumentException("Posisjon(" + posisjon + ") er utenfor treet!");

        if (p.venstre != null || p.høyre != null) throw new
                IllegalArgumentException("Posisjon(" + posisjon + ") er ingen bladnode!");

        if (p == rot) rot = null;
        else if (p == q.venstre) q.venstre = null;
        else q.høyre = null;

        antall--;  //
        return p.verdi;
    }

    public void nivåorden()                // skal ligge i class BinTre
    {
        if (tom()) return;                   // tomt tre

        Kø<Node<T>> kø = new TabellKø<>();   // Se Avsnitt 4.2.2
        kø.leggInn(rot);                     // legger inn roten

        while (!kø.tom())                    // så lenge som køen ikke er tom
        {
            Node<T> p = kø.taUt();             // tar ut fra køen
            System.out.print(p.verdi + " ");   // skriver ut

            if (p.venstre != null) kø.leggInn(p.venstre);
            if (p.høyre != null) kø.leggInn(p.høyre);
        }
    }

    //Oppgave 5.1.6 - 3)
    public void nivåorden(Oppgave<? super T> oppgave)    // ny versjon
    {
        if (tom()) return;                   // tomt tre
        Kø<Node<T>> kø = new TabellKø<>();   // Se Avsnitt 4.2.3
        kø.leggInn(rot);                     // legger inn roten

        while (!kø.tom())                    // så lenge køen ikke er tom
        {
            Node<T> p = kø.taUt();             // tar ut fra køen
            oppgave.utførOppgave(p.verdi);     // den generiske oppgaven

            if (p.venstre != null) kø.leggInn(p.venstre);
            if (p.høyre != null) kø.leggInn(p.høyre);
        }
    }

    //Oppgave 5.1.7 - 7)
    private static <T> void postorden(Node<T> p, Oppgave<? super T> oppgave)
    {
        if (p.venstre != null) postorden(p.venstre,oppgave);
        if (p.høyre != null) postorden(p.høyre,oppgave);
        oppgave.utførOppgave(p.verdi);
    }

    public void postorden(Oppgave<? super T> oppgave)
    {
        if (rot != null) postorden(rot,oppgave);
    }

    //Oppgave 5.1.7 - 8)
    public void nullstill()
    {
        if (!tom()) nullstill(rot);  // nullstiller
        rot = null; antall = 0;      // treet er nå tomt
    }

    private void nullstill(Node<T> p)
    {
        if (p.venstre != null)
        {
            nullstill(p.venstre);      // venstre subtre
            p.venstre = null;          // nuller peker
        }
        if (p.høyre != null)
        {
            nullstill(p.høyre);        // høyre subtre
            p.høyre = null;            // nuller peker
        }
        p.verdi = null;              // nuller verdien
    }

    //Oppgave 5.1.10 - 1)
    private static <T> void preorden(Node<T> p, Oppgave<? super T> oppgave)
    {
        while (true)
        {
            oppgave.utførOppgave(p.verdi);
            if (p.venstre != null) preorden(p.venstre,oppgave);
            if (p.høyre == null) return;      // metodekallet er ferdig
            p = p.høyre;
        }
    }

    //Oppgave 5.1.10 - 4)
    private static <T> void inorden(Node<T> p, Oppgave<? super T> oppgave)
    {
        while (true)
        {
            if (p.venstre != null) inorden(p.venstre,oppgave);
            oppgave.utførOppgave(p.verdi);
            if (p.høyre == null) return;      // metodekallet er ferdig
            p = p.høyre;
        }
    }

    //Oppgave 5.1.10 - 7)

    //Oppgave 5.1.11
    private class InordenIterator implements Iterator<T>
    {
        private Stakk<Node<T>> s = new TabellStakk<>();
        private Node<T> p = null;

        private Node<T> først(Node<T> q)   // en hjelpemetode
        {
            while (q.venstre != null)        // starter i q
            {
                s.leggInn(q);                  // legger q på stakken
                q = q.venstre;                 // går videre mot venstre
            }
            return q;                        // q er lengst ned til venstre
        }

        private InordenIterator()          // konstruktør
        {
            if (tom()) return;               // treet er tomt
            p = først(rot);                  // bruker hjelpemetoden
        }

        @Override
        public T next()
        {
            if (!hasNext()) throw new NoSuchElementException("Ingen verdier!");

            T verdi = p.verdi;                        // tar vare på verdien

            if (p.høyre != null) p = først(p.høyre);  // p har høyre subtre
            else if (s.tom()) p = null;               // stakken er tom
            else p = s.taUt();                        // tar fra stakken

            return verdi;                             // returnerer verdien
        }

        @Override
        public boolean hasNext()
        {
            return p != null;
        }

    } // InordenIterator

    public Iterator<T> iterator()     // skal ligge i class BinTre
    {
        return new InordenIterator();
    }

    //5.1.12 - oppgave 5 - returnere antall bladnoder - bruker en rekursiv hjelpemetode
    private static int antallBladnoder(Node<?> p)
    {
        if (p.venstre == null && p.høyre == null) return 1;

        return (p.venstre == null ? 0 : antallBladnoder(p.venstre))
                + (p.høyre == null ? 0 : antallBladnoder(p.høyre));
    }

    public int antallBladnoder()
    {
        return rot == null ? 0 : antallBladnoder(rot);
    }
} // class BinTre<T>