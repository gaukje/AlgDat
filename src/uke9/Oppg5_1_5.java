package uke9;

import hjelpeklasser.BinTre;

public class Oppg5_1_5 {
    public static void main(String[] args) {
        //Oppgave 1)
        int[] posisjon = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 17, 18, 19, 21, 23, 26, 27, 29};
        String[] verdi = "ABCDEFGHIJKLMNOPQRSTUV".split("");

        BinTre<String> tre = new BinTre<>(posisjon, verdi);  // den nye konstruktøren


        //Oppgave 2)

        int[] p1 = {1,2,3,5,6,7,10,11,12,13,21,24,25,42,43};
        String[] v1 = "DIHLOBAENGKMJFC".split("");

        BinTre<String> tre1 = new BinTre<>(p1,v1);




        int[] p2 = {1,2,3,5,6,7,10,11,12,13,21,24,25,42,43};
        String[] v2 = "EIBGAHKLODNMCJF".split("");

        BinTre<String> tre2 = new BinTre<>(p2,v2);

        System.out.println(tre2.antall());
        System.out.println(tre1.hent(25));


        //Oppgave 4)

        int[] fireP = {1,2,3,5,10,11,22,23,44,47};
        Integer[] fireV = {1,2,3,4,5,6,7,8,9,10};

        BinTre<Integer> fire = new BinTre<>(fireP, fireV);

        //Oppgave 5)

        BinTre<Integer> fem = new BinTre<>();

        int n = 15;
        for (int i = 1; i <= n; i++) fem.leggInn(i,i);


        //Oppgave 6)

        BinTre<Integer> seks = new BinTre<>();
        int n6 = 15, k6 = 1;
        for (int i = 1; i <= n6; i++) {
            seks.leggInn(k6,i);
            k6*=2;
        }

        //Oppgave 7)

        BinTre<Integer> syv = new BinTre<>();

        syv.leggInn(1 ,1);

        int n7 = 7, k7 = 2;

        for (int i = 1; i <= n7; i++) {
            syv.leggInn(k7, 2*i);
            syv.leggInn(2*k7-1, 2*i+1);
            k7 *= 2;
        }
    }
}
