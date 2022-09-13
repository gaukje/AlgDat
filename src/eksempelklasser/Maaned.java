package eksempelklasser;

import java.util.Arrays;

public enum Maaned {
    JAN("Januar", 1),
    FEB("Februar", 2),
    MAR("Mars", 3),
    APR("April", 4),
    MAI("Mai", 5),
    JUN("Juni", 6),
    JUL("Juli", 7),
    AUG("August", 8),
    SEP("September", 9),
    OKT("Oktober", 10),
    NOV("November", 11),
    DES("Desember", 12);
    private final String navn;
    private final int mndNr;

    private Maaned(String navn, int mndNr) {
        this.navn = navn;
        this.mndNr = mndNr;
    }

    @Override
    public String toString() {
        return navn;
    }

    public int mndNr() {
        return mndNr;
    }

    public static String toString(int mnd) {
        if (mnd < 1 || mnd > 12) throw new IllegalArgumentException("Ulovlig månedsnummer!");

        return values()[mnd - 1].toString();
    }

    public static Maaned[] vaar() {
        return Arrays.copyOfRange(values(), 3, 5);
    }

    public static Maaned[] sommer() {
        return Arrays.copyOfRange(values(), 5, 8);
    }

    public static Maaned[] hoest() {
        return Arrays.copyOfRange(values(), 8, 10);
    }

    public static Maaned[] vinter() {
        return new Maaned[]{NOV, DES, JAN, FEB, MAR};
    }
}