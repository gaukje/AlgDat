package uke3;

import hjelpeklasser.Tabell;

public class Oppg1_3_5 {
    public static void main(String[] args) {
        //Oppg 2)
        int[] a = {2, 15, 16, 20, 23, 25, 25, 29, 35, 38, 40, 41,};
        System.out.println(Tabell.lineærsøk(a, 1));
        System.out.println(lineærsøk(a,40));
        System.out.println(lineærsøkHopp(a, 3, 23));            //5b)
    }
    //Oppg 3)
    public static int lineærsøk(int[] a, int verdi) // legges i class Tabell
    {
        if (a.length == 0 || verdi > a[a.length-1])
            return -(a.length + 1);  // verdi er større enn den største

        int i = a.length - 1; for( ; a[i] > verdi; i--);  // siste verdi er vaktpost

        return verdi == a[i] ? i : -(i + 1);   // sjekker innholdet i a[i]
    }
    //Oppg 5 a)
    public static int lineærsøkHopp(int[] a, int k, int verdi) // legges i class Tabell
    {
        if (k < 1)
            throw new IllegalArgumentException("Må ha k > 0!");

        int j = k - 1;
        for (; j < a.length && verdi > a[j]; j += k);

        int i = j - k + 1;  // søker i a[j-k+1:j]
        for (; i < a.length && verdi > a[i]; i++);

        if (i < a.length && a[i] == verdi) return i;  // funnet
        else return -(i + 1);
    }
}
