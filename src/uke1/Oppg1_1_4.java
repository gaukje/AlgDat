package uke1;

public class Oppg1_1_4 {
    public static void main(String[] args) {
        int [] a = {10, 5, 7, 2, 9, 1, 3, 8, 4, 6};
        int sjekk = maks2(a);
        System.out.println(sjekk);
    }

    public static int maks2(int[]a) {
        int m = 0;                      //Indeks til største verdi.
        int maksVerdi = a[0];           //Største verdi.
        for(int i = 1; i < a.length; ++i) if (a[i] > maksVerdi) {
            maksVerdi = a[i];           //Største verdi oppdateres.
            m = i;                      //Indeks til største verdi oppdateres.
        }
        return m;
    }
}
