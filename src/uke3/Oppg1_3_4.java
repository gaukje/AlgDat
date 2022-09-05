package uke3;


import hjelpeklasser.Tabell;

public class Oppg1_3_4 {
    //Oppg 1.3.4 - 3)
    public static void main(String[] args) {
        int[] a = {7,5,9,2,10,4,1,8,6,3};     // en usortert heltallstabell
        Tabell.utvalgssortering(a);           // stigende sortering
        Tabell.snu(a);                        // tabellen snus
        Tabell.skriv(a);                      // 10 9 8 7 6 5 4 3 2 1
    }
    public static void selectionSort(int[] a){

        for(int i = 0; i < a.length; i++) {
            int m = i;                              // indeks til den foreløpig minste
            int minVerdi = a[i];                    // verdien til den foreløpig minste

            for(int j = 0; j < a.length; j++) {

                if(a[j] < minVerdi) {
                    minVerdi = a[j];                // ny minste verdi
                    m = j;                          // indeks til ny minste verdi
                }
            }
            // Bytter om a[i] og a[m]
            a[m] = a[i];
            a[i] = minVerdi;
        }
        //I a[m] = a[i]; a[i] = minverdi; inngår det to tilordninger og tre tabellaksesser,
        // mens det i int temp = a[i]; a[i] = a[m]; a[m] = temp; inngår tre tilordninger og fire tabellaksesser.
        // Vi sparer en tilordning og to tabellaksesser. Men dette vil ikke ha noen målbar effekt på
        // algoritmens effektivitet. Innsparingen skjer i den ytre løkken og den går bare n − 1 ganger.
        // Det er innsparinger i den indre løkken som vil kunne få effekt.
    }
}
