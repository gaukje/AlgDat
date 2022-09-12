package uke3;

import hjelpeklasser.Tabell;

public class Oppg1_3_8 {
    public static void main(String[] args) {
        // 4)
        int[] a = {3,5,6,10,10,11,13,14,16,20,0,0,0,0,0};  // en tabell
        int antall = 10;                                   // antall verdier

        if (antall >= a.length) throw new IllegalStateException("Tabellen er full");

        int nyverdi = 10;                                  // ny verdi
        int k = Tabell.binærsøk(a, 0, antall, nyverdi);    // søker i a[0:antall>
        if (k < 0) k = -(k + 1);                           // innsettingspunkt

        System.arraycopy(a, k, a, k + 1, antall - k);    // forskyver

        a[k] = nyverdi;                                    // legger inn
        antall++;                                          // øker antallet

        Tabell.skrivln(a, 0, antall);  // Se Oppgave 4 og 5 i Avsnitt 1.2.2

        //tidsforbrukInsOgUtv();
    }

    // 6)
    /*
    public static void tidsforbrukInsOgUtv(){
        int[] a = Tabell.randPerm(10000);
        int[] b = a.clone();
        long tid1 = System.currentTimeMillis();
        Tabell.utvalgssortering(a);
        tid1 = System.currentTimeMillis() - tid1;

        long tid2 = System.currentTimeMillis();
        Tabell.innsettingssortering(b);
        tid2 = System.currentTimeMillis() - tid2;

        System.out.println("Utvalgssortering :" + tid1);
        System.out.println("Insettingssortering : "+ tid2);
    }

     */
}
