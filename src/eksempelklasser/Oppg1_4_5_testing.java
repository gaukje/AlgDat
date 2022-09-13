package eksempelklasser;

import java.util.Arrays;

public class Oppg1_4_5_testing {
    public static void main(String[] args) {
        //1.4.5 1)
        for (Studium s : Studium.values()) {
            System.out.println(s.toString() + " (" + s.name() + ")");
        }
        // Ingeniørfag - data (Data)
        // Informasjonsteknologi (IT)
        // Anvendt datateknologi (Anvendt)
        // Enkeltemnestudent (Enkeltemne)

        for (Maaned m : Maaned.values()) {
            System.out.println(m.toString() + " (" + m.name() + ")");
        }
        for (Maaned n : Maaned.hoest()){
            System.out.println(n.toString() + " (" + n.name() + ")" + n.mndNr());
        }
    }
}
