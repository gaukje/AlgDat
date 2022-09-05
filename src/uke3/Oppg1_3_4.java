package uke3;


import hjelpeklasser.Tabell;

//Sjekk DATS2300 mappa og gå inn på notat for oppgaver som ikke er her.

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

    // 9)
    public static void utvalgsSortering(int[] a, int fra, int til){
        Tabell.fratilKontroll(a.length, fra, til);
        for(int i = fra; i < til - 1; i++) {
            Tabell.bytt(a, i, Tabell.min(a, i, til));
        }
    }

    // 10) - Utvalgssortering er ikke stabil fordi metoden kan bytte plass på verdier for å få tabell sortert, men
    // vil likevel prioritere den første laveste verdien fremfor samme verdi på en tilfeldig plass i tabellen.

    // 11) Sjekket fasit - evt. gjør d på nytt
}
