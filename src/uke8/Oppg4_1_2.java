package uke8;

public class Oppg4_1_2 {
    public static void main(String[] args) {

    }

    public static <T> void snu(Stakk<T> A) {
        Stakk<T> B = new TabellStakk<T>();
        Stakk<T> C = new TabellStakk<T>();

        while(!A.tom()) B.leggInn(A.taUt());
        while(!B.tom()) C.leggInn(B.taUt());
        while(!C.tom()) A.leggInn(C.taUt());
    }
}
