package uke3;

import hjelpeklasser.Tabell;

public class Oppg1_3_2 {
    //1. 	Hvor mange inversjoner har premutasjonen 3 5 4 7 6 8 1 2 9 10
    // permutasjonen har følgende permutasjoner:(3,1), (3,2) ,(5,4), (5,1), (5,2), (4,1), (4,2), (7,6), (7,1), (7,2), (6,1), (6,2) (8,1), (8,2)
    public static void main(String[] args) {
        int[] a = {3, 5, 4, 7, 6, 8, 1, 2, 9, 10};
        System.out.println(Tabell.inversjoner(a));
    }
}
