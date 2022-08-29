package uke1;

import java.util.Random;

import static uke1.Oppg1_1_2.maks1;

//Oppgave 1.1.10 - Koden er for det meste kopiert men med noen justeringer.
public class Oppg1_1_10 {
    public static void main(String[] args) {

        int n = 200_000, antall = 4_000; // tabellstørrelse og gjentagelser
        long tid = 0;                    // for tidsmåling
        int a[] = randPerm(n);           // en permutasjon av 1, . .  n

        tid = System.currentTimeMillis();    // leser av klokken
        for (int i = 0; i < antall; i++) kostnader(a);
        tid = System.currentTimeMillis() - tid;    // medgått tid
        System.out.println("Faste kostnader: " + tid + " millisek");

        tid = System.currentTimeMillis();    // leser av klokken
        for (int i = 0; i < antall; i++) maks1(a);  // Programkode 1.1.2
        tid = System.currentTimeMillis() - tid;     // medgått tid
        System.out.println("Maks1-metoden: " + tid + " millisek");

        tid = System.currentTimeMillis();    // leser av klokken
        for (int i = 0; i < antall; i++) Oppg1_1_4.maks2(a);  // Programkode 1.1.4
        tid = System.currentTimeMillis() - tid;     // medgått tid
        System.out.println("Maks2-metoden: " + tid + " millisek");

        tid = System.currentTimeMillis();    // leser av klokken
        for (int i = 0; i < antall; i++) Oppg1_1_5.maks3(a);  // Programkode 1.1.5
        tid = System.currentTimeMillis() - tid;     // medgått tid
        System.out.println("Maks3-metoden: " + tid + " millisek");
    }

    public static int kostnader(int[] a)  // legges i class Program
    {
        int m = 0;
        for (int i = 1; i < a.length; i++) {
        }  // en tom blokk
        return m;
    }


    public static int[] randPerm(int number) {

        int[] array = new int[number];
        for (int i = 0; i < number; i++)
            array[i] = i;//  ww w  . j a va 2 s.c o  m

        int index, temp;
        Random random = new Random();
        for (int i = number; i > 1; i--) {
            index = random.nextInt(i);
            temp = array[i - 1];
            array[i - 1] = array[index];
            array[index] = temp;
        }

        return array;
    }
}
