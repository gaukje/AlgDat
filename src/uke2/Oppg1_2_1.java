package uke2;

import java.util.Arrays;

public class Oppg1_2_1 {
    public static void main(String[] args) {
        int[]a = {1,2,3,4,5,6};
        System.out.println(forAlle(a));
    }
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

    public static int min(int[] a){
        return min(a,0,a.length);
    }

    public static int forAlle(int[] a){
        int[] b = Arrays.copyOfRange(a,3,5);
        int heltallEks = 0;
        for(int n : b){
             heltallEks += n;
         }
        return heltallEks;
    }
    //1.2.5
}



