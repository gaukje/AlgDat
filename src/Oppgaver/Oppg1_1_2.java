
package Oppgaver;
public class Oppg1_1_2 {

    //Oppgave 1.1.2.1 og 1.1.2.2
    public static void main(String[] args) {
        int [] a = {8, 4, 17, 10, 6, 20, 1, 11, 15, 3, 18, 9, 2, 7, 19};

        int min_index = min(a);
        System.out.println(min_index);
        System.out.println(a[min_index]);
    }
    //Maks metoden fra 1.1.2 - eksempel
    public static int maks1(int[] a)  // a er en heltallstabell
    {
        if (a.length < 1)
            throw new java.util.NoSuchElementException("Tabellen a er tom!");

        int m = 0;  // indeks til foreløpig største verdi (m for maks)

        for (int i = 1; i < a.length; i++) // obs: starter med i = 1
        {
            if (a[i] > a[m]) m = i;  // indeksen oppdateres
        }

        return m;  // returnerer indeksen/posisjonen til største verdi

    } // maks

    static int min(int[] a){
        //initialiserer med første element
        int min_value = a[0];
        int min_index = 0;

        //Loop over alle resterende elementer og sjekker om vi finner et mindre tall
        for(int i=1; i < a.length; ++i){
            int value = a[i];
            int index = i;

            if(value < min_value){
                min_value = value;
                min_index = index;
            }
        }
        //Returnerer index til minste verdi
        return min_index;
    }
}

