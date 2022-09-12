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

        char[] c = "JASMIN".toCharArray();
        System.out.println(maks(c));
    }

    public static int maks(char[] a){
        int m = 0;
        char maksverdi = a[0];

        for (int i = 1; i < a.length; i++)if (a[i] > 0){
            maksverdi = a[i];
            m = i;
        }
        return m;
    }
}
