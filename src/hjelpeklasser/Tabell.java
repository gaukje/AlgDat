package hjelpeklasser;


import eksempelklasser.Komparator;

import java.util.Arrays;
import java.util.Comparator;
import java.util.NoSuchElementException;
import java.util.Random;

public class Tabell {
    private Tabell() {}
    // privat standardkonstruktør - hindrer instansiering
    // Programkode 1.1.8 d)
    public static void bytt(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    //Programkode 1.1.8 e)
    public static int[] randPerm(int n)  // en effektiv versjon
    {
        Random r = new Random();         // en randomgenerator
        int[] a = new int[n];            // en tabell med plass til n tall

        Arrays.setAll(a, i -> i + 1);    // legger inn tallene 1, 2, . , n

        for (int k = n - 1; k > 0; k--)  // løkke som går n - 1 ganger
        {
            int i = r.nextInt(k + 1);        // en tilfeldig tall fra 0 til k
            bytt(a, k, i);                   // bytter om
        }

        return a;                        // permutasjonen returneres
    }

    //Programkode 1.1.8 f)
    public static void randPerm(int[] a)  // stokker om a
    {
        Random r = new Random();     // en randomgenerator

        for (int k = a.length - 1; k > 0; k--) {
            int i = r.nextInt(k + 1);  // tilfeldig tall fra [0,k]
            bytt(a, k, i);
        }
    }

    //Programkode 1.2.1 b)

    public static int maks(int[] a, int fra, int til)
    {
        if (a == null) throw new NullPointerException("Parametertabellen a er null");

        fratilKontroll(a.length,fra,til);
        if (fra == til)
            throw new NoSuchElementException
                    ("fra(" + fra + ") = til(" + til + ") - tomt tabellintervall!");

        int m = fra;              // indeks til største verdi i a[fra:til>
        int maksverdi = a[fra];   // største verdi i a[fra:til>

        for (int i = fra + 1; i < til; i++)
        {
            if (a[i] > maksverdi)
            {
                m = i;                // indeks til største verdi oppdateres
                maksverdi = a[m];     // største verdi oppdateres
            }
        }

        return m;  // posisjonen til største verdi i a[fra:til>
    }

    //Programkode 1.2.1 c)

    public static int maks(int[] a)  // bruker hele tabellen
    {
        return maks(a,0,a.length);     // kaller metoden over
    }

    //Oppg. 1.2.1.1
    public static int min(int[] a, int fra, int til) {
        if (fra < 0 || til > a.length || fra >= til) {
            throw new IllegalArgumentException("Illegalt intervall!");
        }

        int m = fra;              // indeks til minste verdi i a[fra:til>
        int minVerdi = a[fra];   // største verdi i a[fra:til>

        for (int i = fra + 1; i < til; i++)
            if (a[i] < minVerdi) {
                m = i;                // indeks til minste verdi oppdateres
                minVerdi = a[m];     // minste verdi oppdateres
            }

        return m;  // posisjonen til minste verdi i a[fra:til>
    }

    //Oppg 1.2.2
    public static void skriv(int[] a, int fra, int til) {
        if(fra < 0 || til > a.length || fra >= til) {
            throw new IllegalArgumentException("Ulovlig intervall!");
        }

        for(int i = fra; i < til; i++) {
            System.out.print(" "+a[i]);
        }
    }

    public static void skriv(int[] a) {
        skriv(a, 0, a.length);
    }

    public static void skrivln(int[] a, int fra, int til) {
        skriv(a, fra, til);
        System.out.println();
    }

    public static void skrivln(int[] a) {
        skrivln(a, 0, a.length);
    }

    //Oppg 1.2.3 :

    //Oppg 1.2.3 a)
    public static void fratilKontroll(int tablengde, int fra, int til)
    {
        if (fra < 0)                                  // fra er negativ
            throw new ArrayIndexOutOfBoundsException
                    ("fra(" + fra + ") er negativ!");

        if (til > tablengde)                          // til er utenfor tabellen
            throw new ArrayIndexOutOfBoundsException
                    ("til(" + til + ") > tablengde(" + tablengde + ")");

        if (fra > til)                                // fra er større enn til
            throw new IllegalArgumentException
                    ("fra(" + fra + ") > til(" + til + ") - illegalt intervall!");
    }

    //Oppg 1.2.3 d)
    public static void vhKontroll(int tablengde, int v, int h)
    {
        if (v < 0)
            throw new ArrayIndexOutOfBoundsException("v(" + v + ") < 0");

        if (h >= tablengde)
            throw new ArrayIndexOutOfBoundsException
                    ("h(" + h + ") >= tablengde(" + tablengde + ")");

        if (v > h + 1)
            throw new IllegalArgumentException
                    ("v = " + v + ", h = " + h);
    }

    //1.2.4 - oppg1 - nestmaks
    public static int[] nestMaks(int[] a)  // legges i class Tabell
    {
        int n = a.length;   // tabellens lengde

        if (n < 2) throw   // må ha minst to verdier!
                new java.util.NoSuchElementException("a.length(" + n + ") < 2!");

        int m = maks(a);  // m er posisjonen til tabellens største verdi

        int nm;           // nm skal inneholde posisjonen til nest største verdi

        if (m == 0)                            // den største ligger først
        {
            nm = maks(a, 1, n);                  // leter i a[1:n>
        }
        else if (m == n - 1)                   // den største ligger bakerst
        {
            nm = maks(a, 0, n - 1);              // leter i a[0:n-1>
        }
        else
        {
            int mv = maks(a, 0, m);              // leter i a[0:m>
            int mh = maks(a, m + 1, n);          // leter i a[m+1:n>
            nm = a[mh] > a[mv] ? mh : mv;        // hvem er størst?
        }

        return new int[] {m,nm};      // m i posisjon 0 , nm i posisjon 1

    } // nestMaks

    //1.3.1 a)
    public static void snu(int[] a, int v, int h)  // snur intervallet a[v:h]
    {
        while (v < h) bytt(a, v++, h--);
    }

    public static void snu(int[] a, int v)  // snur fra og med v og ut tabellen
    {
        snu(a, v, a.length - 1);
    }

    public static void snu(int[] a)  // snur hele tabellen
    {
        snu(a, 0, a.length - 1);
    }

    //1.3.1 b)
    public static boolean nestePermutasjon(int[] a)
    {
        int i = a.length - 2;                    // i starter nest bakerst
        while (i >= 0 && a[i] > a[i + 1]) i--;   // går mot venstre
        if (i < 0) return false;                 // a = {n, n-1, . . . , 2, 1}

        int j = a.length - 1;                    // j starter bakerst
        while (a[j] < a[i]) j--;                 // stopper når a[j] > a[i]
        bytt(a,i,j); snu(a,i + 1);               // bytter og snur

        return true;                             // en ny permutasjon
    }

    // 1.3.2 a)
    public static int inversjoner(int[] a)
    {
        int antall = 0;  // antall inversjoner
        for (int i = 0; i < a.length - 1; i++)
        {
            for (int j = i + 1; j < a.length; j++)
            {
                if (a[i] > a[j]) antall++;  // en inversjon siden i < j
            }
        }
        return antall;
    }

    //1.3.2 c)
    public static boolean erSortert(int[] a)  // legges i samleklassen Tabell
    {
        for (int i = 1; i < a.length; i++)      // starter med i = 1
            if (a[i-1] > a[i]) return false;      // en inversjon

        return true;
    }

    public static void utvalgssortering(int[] a)
    {
        for (int i = 0; i < a.length - 1; i++)
            bytt(a, i, min(a, i, a.length));  // to hjelpemetoder
    }
    // 1.3.4. 9)
    public static void utvalgsSortering(int[] a, int fra, int til){
        fratilKontroll(a.length, fra, til);
        for(int i = fra; i < til - 1; i++) {
            bytt(a, i, min(a, i, til));
        }
    }

    // 1.3.5
    public static int lineærsøk(int[] a, int verdi) // legges i class Tabell
    {
        if (a.length == 0 || verdi > a[a.length-1])
            return -(a.length + 1);  // verdi er større enn den største

        int i = 0; for( ; a[i] < verdi; i++);  // siste verdi er vaktpost

        return verdi == a[i] ? i : -(i + 1);   // sjekker innholdet i a[i]
    }

    // 1.3.6 - binærsøk (3.versjon, hopp fra venstre)
    public static int binærsøk(int[] a, int fra, int til, int verdi)
    {
        Tabell.fratilKontroll(a.length,fra,til);  // se Programkode 1.2.3 a)
        int v = fra, h = til - 1;  // v og h er intervallets endepunkter

        while (v < h)  // obs. må ha v < h her og ikke v <= h
        {
            int m = (v + h)/2;  // heltallsdivisjon - finner midten

            if (verdi > a[m]) v = m + 1;   // verdi må ligge i a[m+1:h]
            else  h = m;                   // verdi må ligge i a[v:m]
        }
        if (h < v || verdi < a[v]) return -(v + 1);  // ikke funnet
        else if (verdi == a[v]) return v;            // funnet
        else  return -(v + 2);                       // ikke funnet
    }

    // 1.3.8 - innsettingssortering
    public static void innsettingssortering(int[] a, int fra, int til)
    {
        fratilKontroll(a.length, fra, til);
        for (int i = fra + 1; i < til; i++)  // starter med a[fra + 1] siden "fra" er det første elementet
        {
            int temp = a[i];  // hjelpevariabel
            int j = i - 1; for (; j >= fra && temp < a[j]; j--) a[j+1] = a[j];
            a[j+1] = temp;
        }
    }
    // 1.3.9 - partisjonering - 1.3.9 a)
    private static int parter0(int[] a, int v, int h, int skilleverdi)
    {
        while (true)                                  // stopper når v > h
        {
            while (v <= h && a[v] < skilleverdi) v++;   // h er stoppverdi for v
            while (v <= h && a[h] >= skilleverdi) h--;  // v er stoppverdi for h

            if (v < h) bytt(a,v++,h--);                 // bytter om a[v] og a[h]
            else  return v;  // a[v] er nåden første som ikke er mindre enn skilleverdi
        }
    }

    //1.3.9 f)
    public static int sParter0(int[] a, int v, int h, int indeks)
    {
        bytt(a, indeks, h);           // skilleverdi a[indeks] flyttes bakerst
        int pos = parter0(a, v, h - 1, a[h]);  // partisjonerer a[v:h - 1]
        bytt(a, pos, h);              // bytter for å få skilleverdien på rett plass
        return pos;                   // returnerer posisjonen til skilleverdien
    }

    // 1.3.9 h)
    private static void kvikksortering0(int[] a, int v, int h)  // en privat metode
    {
        if (v >= h) return;  // a[v:h] er tomt eller har maks ett element
        int k = sParter0(a, v, h, (v + h)/2);  // bruker midtverdien
        kvikksortering0(a, v, k - 1);     // sorterer intervallet a[v:k-1]
        kvikksortering0(a, k + 1, h);     // sorterer intervallet a[k+1:h]
    }

    public static void kvikksortering(int[] a, int fra, int til) // a[fra:til>
    {
        fratilKontroll(a.length, fra, til);  // sjekker når metoden er offentlig
        kvikksortering0(a, fra, til - 1);  // v = fra, h = til - 1
    }

    public static void kvikksortering(int[] a)   // sorterer hele tabellen
    {
        kvikksortering0(a, 0, a.length - 1);
    }

    // 1.4.1 - maksmetode med datatype double
    public static int maks(double[] a)     // legges i class Tabell
    {
        int m = 0;                           // indeks til største verdi
        double maksverdi = a[0];             // største verdi

        for (int i = 1; i < a.length; i++) if (a[i] > maksverdi)
        {
            maksverdi = a[i];     // største verdi oppdateres
            m = i;                // indeks til største verdi oppdaters
        }
        return m;     // returnerer posisjonen til største verdi
    }

    //1.4.1 - maksmetode med datatype string
    /*
    public static int maks(String[] a)    // legges i class Tabell
    {
        int m = 0;                          // indeks til største verdi
        String maksverdi = a[0];            // største verdi

        for (int i = 1; i < a.length; i++) if (a[i].compareTo(maksverdi) > 0)
        {
            maksverdi = a[i];  // største verdi oppdateres
            m = i;             // indeks til største verdi oppdaters
        }
        return m;  // returnerer posisjonen til største verdi
    }

     */

    //1.4.2 - generisk maks metode
    public static <T extends Comparable<? super T>> int maks(T[] a)
    {
        int m = 0;                     // indeks til største verdi
        T maksverdi = a[0];            // største verdi

        for (int i = 1; i < a.length; i++) if (a[i].compareTo(maksverdi) > 0)
        {
            maksverdi = a[i];  // største verdi oppdateres
            m = i;             // indeks til største verdi oppdaters
        }
        return m;  // returnerer posisjonen til største verdi
    } // maks

    //1.4.2 - oppgave 2 - generisk innsettingssortering
    public static <T extends Comparable<? super T>> void innsettingssortering(T[] a)
    {
        for (int i = 1; i < a.length; i++)  // starter med i = 1
        {
            T verdi = a[i];        // verdi er et tabellelemnet
            int  j = i - 1;        // j er en indeks
            // sammenligner og forskyver:
            for (; j >= 0 && verdi.compareTo(a[j]) < 0 ; j--) a[j+1] = a[j];

            a[j + 1] = verdi;      // j + 1 er rett sortert plass
        }
    }

    //1.4.3 - Oppgave 5 - skriv, skrivln og bytt med datatypen Object
    public static void skriv(Object[] a, int fra, int til){
        Tabell.fratilKontroll(a.length, fra, til);

        for (int i = fra; i < til; i++){
            System.out.println(a[i]+"");
        }
    }

    public static void skriv(Object[] a)
    {
        skriv(a,0,a.length);
    }

    public static void skrivln(Object[] a, int fra, int til)
    {
        skriv(a,fra,til);
        System.out.println();
    }

    // 1.4.3 - Oppgave 6
    public static void bytt(Object[] a, int i, int j)
    {
        Object temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static Integer[] randPermInteger(int n)
    {
        Integer[] a = new Integer[n];               // en Integer-tabell
        Arrays.setAll(a, i -> i + 1);               // tallene fra 1 til n

        Random r = new Random();   // hentes fra  java.util

        for (int k = n - 1; k > 0; k--)
        {
            int i = r.nextInt(k+1);  // tilfeldig tall fra [0,k]
            bytt(a,k,i);             // bytter om
        }
        return a;  // tabellen med permutasjonen returneres
    }

    //1.4.6 - 1)
    public static <T> void innsettingssortering(T[] a, Komparator<? super T> c)
    {
        for (int i = 1; i < a.length; i++)  // starter med i = 1
        {
            T verdi = a[i];        // verdi er et tabellelemnet
            int  j = i - 1;        // j er en indeks

            // sammenligner og forskyver:
            for (; j >= 0 && c.compare(verdi,a[j]) < 0 ; j--) a[j+1] = a[j];

            a[j + 1] = verdi;      // j + 1 er rett sortert plass
        }
    }

    //1.4.6 - 4)
    public static <T> int maks(T[] a, Komparator<? super T> c) {
        return maks(a, 0, a.length, c);
    }
    //1.4.6 - 4)
    public static <T> int maks(T[] a, int fra, int til, Komparator<? super T> c) {
        fratilKontroll(a.length, fra, til);
        if (fra == til) throw new NoSuchElementException
        ("fra(" + fra + ") = til(" + til + ") - tomt tabellintervall!");

        int m = fra;                           // indeks til største verdi
        T maksverdi = a[fra];             // største verdi

        for (int i = 1; i < til; i++) {
            if (c.compare(a[i], maksverdi) > 0) {   // bruker komparatoren
                maksverdi = a[i];     // største verdi oppdateres
                m = i;                // indeks til største verdi oppdaters
            }
        }
        return m;     // returnerer posisjonen til største verdi
    }
    // 1.4.9:
    //Komparator versjon av innsettignssortering
    public static <T> void innsettingssorteringC(T[] a, Comparator<? super T> c)
    {
        for (int i = 1; i < a.length; i++)  // starter med i = 1
        {
            T verdi = a[i];        // verdi er et tabellelemnet
            int  j = i - 1;        // j er en indeks

            // sammenligner og forskyver:
            for (; j >= 0 && c.compare(verdi,a[j]) < 0 ; j--) a[j+1] = a[j];

            a[j + 1] = verdi;      // j + 1 er rett sortert plass
        }
    }

    //generisk versjon av bytt()
    public static <T> void byttG(T[] a, int i, int j)
    {
        T temp = a[i]; a[i] = a[j]; a[j] = temp;
    }
    //komparator-versjon av min()
    public static <T> int min(T[] a, int fra, int til, Comparator<? super T> c)
    {
        if (fra < 0 || til > a.length || fra >= til)
            throw new IllegalArgumentException("Illegalt intervall!");

        int m = fra;           // indeks til minste verdi i a[fra:til>
        T minverdi = a[fra];   // minste verdi i a[fra:til>

        for (int i = fra + 1; i < til; i++) if (c.compare(a[i], minverdi) < 0)
        {
            m = i;               // indeks til minste verdi oppdateres
            minverdi = a[m];     // minste verdi oppdateres
        }

        return m;  // posisjonen til minste verdi i a[fra:til>
    }

    public static <T> int min(T[] a, Comparator<? super T> c)  // bruker hele tabellen
    {
        return min(a,0,a.length,c);     // kaller metoden over
    }

    //Utvalgssortering - lager en komparator-versjon av min() og en generisk versjon av bytt()
    public static <T> void utvalgssortering(T[] a, Comparator<? super T> c)
    {
        for (int i = 0; i < a.length - 1; i++)
            bytt(a, i, min(a, i, a.length, c));  // to hjelpemetoder
    }

    //Binærsøk
    public static <T>
    int binærsøk(T[] a, int fra, int til, T verdi, Comparator<? super T> c)
    {
        Tabell.fratilKontroll(a.length,fra,til);  // se Programkode 1.2.3 a)
        int v = fra, h = til - 1;    // v og h er intervallets endepunkter

        while (v <= h)  // fortsetter så lenge som a[v:h] ikke er tom
        {
            int m = (v + h)/2;     // heltallsdivisjon - finner midten
            T midtverdi = a[m];  // hjelpevariabel for  midtverdien

            int cmp = c.compare(verdi, midtverdi);

            if (cmp > 0) v = m + 1;        // verdi i a[m+1:h]
            else if (cmp < 0) h = m - 1;   // verdi i a[v:m-1]
            else return m;                 // funnet
        }

        return -(v + 1);   // ikke funnet, v er relativt innsettingspunkt
    }

    public static <T> int binærsøk(T[] a, T verdi, Comparator<? super T> c)
    {
        return binærsøk(a,0,a.length,verdi,c);  // bruker metoden over
    }

    public static <T>
    int parter(T[] a, int v, int h, T skilleverdi, Comparator<? super T> c)
    {
        while (v <= h && c.compare(a[v],skilleverdi) < 0) v++;
        while (v <= h && c.compare(skilleverdi,a[h]) <= 0) h--;

        while (true)
        {
            if (v < h) Tabell.bytt(a,v++,h--); else return v;
            while (c.compare(a[v],skilleverdi) < 0) v++;
            while (c.compare(skilleverdi,a[h]) <= 0) h--;
        }
    }


    //Generisk-/komparator versjon for kvikksortering og følgende metoder:
    public static <T> int parter(T[] a, T skilleverdi, Comparator<? super T> c)
    {
        return parter(a,0,a.length-1,skilleverdi,c);  // kaller metoden over
    }

    public static <T>
    int sParter(T[] a, int v, int h, int k, Comparator<? super T> c)
    {
        if (v < 0 || h >= a.length || k < v || k > h) throw new
                IllegalArgumentException("Ulovlig parameterverdi");

        bytt(a,k,h);   // bytter - skilleverdien a[k] legges bakerst
        int p = parter(a,v,h-1,a[h],c);  // partisjonerer a[v:h-1]
        bytt(a,p,h);   // bytter for å få skilleverdien på rett plass

        return p;    // returnerer posisjonen til skilleverdien
    }

    public static <T>
    int sParter(T[] a, int k, Comparator<? super T> c)   // bruker hele tabellen
    {
        return sParter(a,0,a.length-1,k,c); // v = 0 og h = a.lenght-1
    }

    private static <T>
    void kvikksortering(T[] a, int v, int h, Comparator<? super T> c)
    {
        if (v >= h) return;  // hvis v = h er a[v:h] allerede sortert

        int p = sParter(a,v,h,(v + h)/2,c);
        kvikksortering(a,v,p-1,c);
        kvikksortering(a,p+1,h,c);
    }

    public static <T>
    void kvikksortering(T[] a, Comparator<? super T> c) // sorterer hele tabellen
    {
        kvikksortering(a,0,a.length-1,c);
    }


    //Generisk-/komparator versjon for kvikksortering og følgende metoder:
    private static <T>
    void flett(T[] a, T[] b, int fra, int m, int til, Comparator<? super T> c)
    {
        int n = m - fra;   // antall elementer i a[fra:m>
        System.arraycopy(a,fra,b,0,n); // kopierer a[fra:m> over i b[0:n>

        int i = 0, j = m, k = fra;     // løkkevariabler og indekser

        while (i < n && j < til)  // fletter b[0:n> og a[m:til>, legger
            a[k++] = c.compare(b[i],a[j]) <= 0 ? b[i++] : a[j++];  // resultatet i a[fra:til>

        while (i < n) a[k++] = b[i++];  // tar med resten av b[0:n>
    }

    public static <T>
    void flettesortering(T[] a, T[] b, int fra, int til, Comparator<? super T> c)
    {
        if (til - fra <= 1) return;     // a[fra:til> har maks ett element

        int m = (fra + til)/2;          // midt mellom fra og til

        flettesortering(a,b,fra,m,c);   // sorterer a[fra:m>
        flettesortering(a,b,m,til,c);   // sorterer a[m:til>

        flett(a,b,fra,m,til,c);         // fletter a[fra:m> og a[m:til>
    }

    public static <T> void flettesortering(T[] a, Comparator<? super T> c)
    {
        T[] b = Arrays.copyOf(a, a.length/2);
        flettesortering(a,b,0,a.length,c);  // kaller metoden over
    }
}
