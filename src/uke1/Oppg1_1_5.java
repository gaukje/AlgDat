package uke1;
//Oppg. 1.1.5.1 - skal sjekke om koden gir riktige resultater

public class Oppg1_1_5 {
    public static void main(String[] args) {
        int []eks = {1,2,3,4};
        System.out.println(maks3(eks));
    }

    public static int maks3(int[] a)  // versjon 3 av maks-metoden
    {
        int sist = a.length - 1;       // siste posisjon i tabellen
        int m = 0;                     // indeks til største verdi
        int maksverdi = a[0];          // største verdi
        int temp = a[sist];            // tar vare på siste verdi
        a[sist] = 0x7fffffff;          // legger tallet 2147483647 sist

        for (int i = 0; ; i++)         // i starter med 0
            if (a[i] >= maksverdi)       // denne blir sann til slutt
            {
                if (i == sist)             // sjekker om vi er ferdige
                {
                    a[sist] = temp;          // legger siste verdi tilbake
                    return temp >= maksverdi ? sist : m;   // er siste størst?
                }
                else
                {
                    maksverdi = a[i];        // maksverdi oppdateres
                    m = i;                   // m oppdateres
                }
            }
    } // maks
}
