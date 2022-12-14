package uke8;
import java.util.*;

public class TabellStakk<T> implements Stakk<T>
{
    private T[] a;                     // en T-tabell
    private int antall;                // antall verdier på stakken

    public TabellStakk()               // konstruktør - tabellengde 8
    {
        this(8);
    }

    @SuppressWarnings("unchecked")     // pga. konverteringen: Object[] -> T[]
    public TabellStakk(int lengde)     // valgfri tabellengde
    {
        if (lengde < 0)
            throw new IllegalArgumentException("Negativ tabellengde!");

        a = (T[])new Object[lengde];     // oppretter tabellen
        antall = 0;                      // stakken er tom
    }

    @Override
    public void leggInn(T verdi)
    {
        if (antall == a.length)
            a = Arrays.copyOf(a, antall == 0 ? 1 : 2*antall);   // dobler

        a[antall++] = verdi;
    }

    @Override
    public T kikk()
    {
        if (antall == 0)       // sjekker om stakken er tom
            throw new NoSuchElementException("Stakken er tom!");

        return a[antall-1];    // returnerer den øverste verdien
    }
    @Override
    public T taUt()
    {
        if (antall == 0)       // sjekker om stakken er tom
            throw new NoSuchElementException("Stakken er tom!");

        antall--;             // reduserer antallet

        T temp = a[antall];   // tar var på det øverste objektet
        a[antall] = null;     // tilrettelegger for resirkulering

        return temp;          // returnerer den øverste verdien
    }

    @Override
    public int antall() {
        return antall;
    }

    @Override
    public boolean tom() {
        return antall == 0;
}
    //4.1.2 - 1)
    @Override
    public void nullstill() {
        for (int i = 0; i < antall; i++) a[i] = null;
        antall = 0;
    }
    //4.1.2 - 2)
    @Override
    public String toString() {
        if (tom()) return "[]";

        StringBuilder s = new StringBuilder();
        s.append('[');
        s.append(a[antall-1]);

        for (int i = antall - 2; i >= 0; i--) {
            s.append(',').append(' ').append(a[i]);
        }
        s.append(']');

        return s.toString();
    }

    //4.1.2 - 3)
    public static <T> void snu(Stakk<T> A) {
        Stakk<T> B = new TabellStakk<T>();
        Stakk<T> C = new TabellStakk<T>();

        while(!A.tom()) B.leggInn(A.taUt());
        while(!B.tom()) C.leggInn(B.taUt());
        while(!C.tom()) A.leggInn(C.taUt());
    }

    //4.1.2 - 4)
    public static <T> void kopier(Stakk<T> A, Stakk<T> B) {
        Stakk<T> C = new TabellStakk<T>();
        while (!A.tom()) C.leggInn(A.taUt());
        while (!C.tom()) {
            T t = C.taUt();
            B.leggInn(t);
            A.leggInn(t);
        }
    }

    //4.1.2 - 5)
    public static <T> void snu2(Stakk<T> A) {
        Stakk<T> B = new TabellStakk<T>();
        int n = A.antall() - 1;

        while (n > 0) {
            T temp = A.taUt();
            for (int j = 0; j < n; j++) B.leggInn(A.taUt());
            A.leggInn(temp);
            while (!B.tom()) A.leggInn(B.taUt());
            n--;
        }
    }
    //4.1.2 - 6)
    public static <T> void kopier2(Stakk<T> A, Stakk<T> B) {
        int n = A.antall();

        while (n > 0) {
            for (int j = 0; j < n; j++) B.leggInn(A.taUt());
            T temp = B.kikk();

            for (int j = 0; j < n; j++) A.leggInn(B.taUt());
            B.leggInn(temp);
            n--;
        }
    }

    //4.1.2 - 7)
    public static <T> void sorter2(Stakk<T> A, Comparator<? super T> c) {
        Stakk<T> B = new TabellStakk<>();
        T temp; int n = 0;

        while (!A.tom()) {
            temp = A.taUt();
            n = 0;
            while (!B.tom() && c.compare(temp, B.kikk()) < 0) {
                n++; A.leggInn(B.taUt());
            }
            B.leggInn(temp);
            for (int i = 0; i < n; i++) B.leggInn(A.taUt());
        }
        while (!B.tom()) A.leggInn(B.taUt());
    }


    // de andre metodene skal inn her!

}  // class TabellStakk