package uke5;

public class Oppg1_5_2 {
    public static void main(String... args)
    {
        //1)
        /*
        System.out.println("main() starter!");
        int sum = tverrsum(729536);
        System.out.println("main() er ferdig!");
         */

        //2)
        int sum = euklid(3,8);
        System.out.println(sum);

        //6)
        //Rekursjonstreet for fib(5) har 15 noder. Rekursjonstreet for fib(6) vil få 25 noder.
    }

    //1)
    public static int tverrsum(int n)
    {
        System.out.println("tverrsum(" + n + ") starter!");
        int sum = (n < 10) ? n : tverrsum(n / 10) + (n % 10);
        System.out.println("tverrsum(" + n + ") er ferdig!");
        return sum;
    }

    //2)
    public static int euklid(int a, int b)
    {
        System.out.println("euklid(" + a + "," + b + ") starter!");
        if (b == 0)
        {
            System.out.println("euklid(" + a + "," + b + ") er ferdig!");
            return a;
        }
        int r = a % b;            // r er resten
        int k = euklid(b,r);       // rekursivt kall
        System.out.println("euklid(" + a + "," + b + ") er ferdig!");
        return k;
    }
}
