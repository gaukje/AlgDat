package uke4;

import hjelpeklasser.Tabell;

public class Oppg1_4_1 {
    public static void main(String[] args) {
        int[] a = {5,2,7,3,9,1,8,4,6};
        double[] d = {5.7,3.14,7.12,3.9,6.5,7.1,7.11};
        String[] s = {"Sohil","Per","Thanh","Fatima","Kari","Jasmin"};

        int k = Tabell.maks(a);     // posisjonen til den største i a
        int l = Tabell.maks(d);     // posisjonen til den største i d
        int m = Tabell.maks(s);     // posisjonen til den største i s

        System.out.println(a[k] + "\n " + d[l] + "\n " + s[m]);

        //Oppg. 2
        char[] c = "JASMIN".toCharArray();
        System.out.println(maks(c));

        //Oppg. 3
        Integer[] tre = {5,2,7,3,9,1,8,4,6};
        System.out.println(maksI(tre));

        //Oppg. 4
        Integer e = 1;
        Integer f = 0;
        System.out.println(test(e,f));
    }
    //Oppg 2
    public static int maks(char[] a){
        int m = 0;
        char maksverdi = a[0];

        for (int i = 1; i < a.length; i++)if (a[i] > 0){
            maksverdi = a[i];
            m = i;
        }
        return m;
    }
    public static int maksI(Integer[] a)    // legges i class Tabell
    {
        int m = 0;                          // indeks til største verdi
        Integer maksverdi = a[0];            // største verdi

        for (int i = 1; i < a.length; i++) if (a[i].compareTo(maksverdi) > 0)
        {
            maksverdi = a[i];  // største verdi oppdateres
            m = i;             // indeks til største verdi oppdaters
        }
        return m;  // returnerer posisjonen til største verdi
    }
    public static int test(Integer a, Integer b)    // legges i class Tabell
    {
       return a.compareTo(b);
    }
}
