package uke1;
//OPPG 1.1.3.5


//Har ikke med "Maks" som blir gjennomgått i eks 1.1.2 hvor vi heller kunne ha skrivd følgende kode:
// public static int[] minmaks(int[] a){ public static int[] {min(a), maks(a)} }
public class Oppg1_1_3 {
    public static void main(String[] args) {
        int [] a = {8, 6};


        int[] b = minmaks(a);
        //System.out.println(b); NB endre for å teste minmaks metoden.

        //1.1.3.6:
        long sjekkFakultet = fak(5);
        long sjekkFakultetFasit = fac(5);
        System.out.println(sjekkFakultet+"\n"+sjekkFakultetFasit);

    }

    public static int[] minmaks(int[] a) {
        int min = 0, minVerdi = a[0];
        int maks = 0, maksVerdi = a[0];
        int verdi = 0;

        for(int i = 1; i < a.length; ++i) {             //Sammenligner 1 gang i for-løkka siden vi ikke starter i "i = 0"
            verdi = a[i];
            if(verdi > maksVerdi){                      //Sammenligner 1 gang.
                maks = i;
            } else if(verdi < minVerdi) {               //Sammenligner 1 gang.
                min = i;
            }
        }
        return new int[]{min, maks};
    }

    //OPPG 1.1.3.6

    public static long fak(int n) {
        if(n >= 2) {
            return n*fak(n-1);
        } else {
            return 1;
        }                               //Antall multiplikasjoner er avhengig av n.
    }
    // Fasit til 1.1.3.6:
    public static long fac(int n)
    {
        if (n < 0)
            throw new IllegalArgumentException("n < 0");
        long fak = 1;

        for (int i = 2; i <= n; i++) fak *= i;

        return fak;
    }
}


