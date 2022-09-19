package uke5;

public class Oppg1_5_1 {
    public static void main(String[] args) {
        int[] tabell = {8,4,5,66,29,99};

        //1)
        System.out.println(a(10));

        //3
        System.out.println(tversrsum(72416));

        //4)
        System.out.println(sifferrot(956847));

        //7)
        System.out.println(kvardratTall(4));

        //8)
        System.out.println(sum(4,6));

        //9)
        System.out.println(maks(tabell, 2,4));

        //10)
        System.out.println(fakultet(5));

        //11)
        System.out.println(fib(40));
        // Vi får ikke den siste verdien fib(50) siden det vil ta svært lang tid. Vi får et negativt
        //tall. fib(50) er fort stort for datatypen int.
    }

    //1)
    public static int a(int n) {
        if (n < 0) throw new IllegalArgumentException("n er negativ!");
        int x = 0, y = 1, z = 1;
        for (int i = 0; i < n; i++) {
            z = 2*y + 3*x; x = y; y = z;
        }
        return z;
    }

    //3)
    public static int tversrsum(int n) {
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }

    //4)
    public static int sifferrot(int n) {
        while (n >= 10) n = tversrsum(n);
        return n;
    }

    //7)
    public static int kvardratTall(int n) {
        if (n == 1) return 1;
        else return kvardratTall(n-1)+n*n;
    }

    //8)
    public static int sum(int n, int k)
    {
        if (n == k) return n;
        int m = (n + k)/2;
        return sum(n,m) + sum(m+1,k);
    }

    //9)
    public static int maks (int[] a, int v, int h) {
        if (v == h) return v;
        int m = (v + h)/2;
        int mv = maks(a, v, m);
        int mh = maks(a, m+1, h);
        return a[mv] >= a[mh] ? mv : mh;
    }

    //10)
    public static int fakultet (int n) {
        return n < 2 ? 1 : fakultet(n-1)*n;
    }

    //11) - programkode 1.5.1 h)
    public static int fib(int n)         // det n-te Fibonacci-tallet
    {
        if (n <= 1) return n;              // fib(0) = 0, fib(1) = 1
        else return fib(n-1) + fib(n-2);   // summen av de to foregående
    }
}
