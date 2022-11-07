package uke12;

import java.util.Arrays;

public class Oppg6_1_1 {
    public static void main(String[] args) {
        /*
         Verdiene lik1, lik2 og lik3 blir henholdsvis true, false, true. En skulle kanskje tro at alle tre skulle bli false.
         Men kompilatoren observerer at i setningene String a = "A", String b = "A" og String d = s[0] inngår den samme tegnstrengen
         som i String[] s = {"A"}. Dermed blir instansen/objektet som inneholder "A" (en char-tabell med tegnet 'A' som eneste verdi)
         opprettet bare en gang. Variablene a, b og d refererer alle til den instansen (objektet). Men i setningen String c = new String("A")
         blir det oppettet en ny instans (en ny char-tabell) som inneholder "A". Dermed vil ikke c referere til det samme som a, b og d. Derfor blir lik2 false.

        Verdiene eq1, eq2 og eq3 det blir alle true siden innholdet i det som a, b, c og d refererer til er det samme. Tilsvarende får h1, h2, h3 og h4 samme verdi.
         */
        String[] s = {"A"};
        String a = "A", b = "A", c = new String("A"), d = s[0];

        boolean lik1 = (a == b), lik2 = (a == c), lik3 = (a == d);
        boolean eq1 = a.equals(b), eq2 = a.equals(c), eq3 = a.equals(d);
        int h1 = a.hashCode(), h2 = b.hashCode(), h3 = c.hashCode(), h4 = d.hashCode();

        System.out.println("lik1: " + lik1 + ",  lik2: " + lik2 + ",  lik3:" + lik3);
        System.out.println("eq1: " + eq1 + ",  eq2: " + eq2 + ",  eq3: " + eq3 );
        System.out.println("h1: " + h1 + ",  h2: " + h2 + ",  h3: " + h3 + ",  h4: " + h4);

        //Oppgave 2
        int[] aa = {1,2,3}, bb = aa, cc = {1,2,3};
        boolean lik11 = (aa == bb), lik22 = (aa == cc), lik33 = aa.equals(cc);

        System.out.println("lik1: " + lik11 + ",  lik2: " + lik22 + ",  lik3: " + lik33);
        System.out.println(Arrays.equals(aa, cc));
        //lik1 blir true siden a og b refererer til samme objekt (tabell), mens lik12 blir false siden a og c refererer til to objekter (tabeller) som har samme innhold, men som er forskjellige.
    }
}
