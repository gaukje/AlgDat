package eksempelklasser;

    public final class Heltall implements Comparable<eksempelklasser.Heltall>
{
    private final int verdi;    // et heltall som instansvariabel

    public Heltall(int verdi) { this.verdi = verdi; }   // konstruktør

    public int intVerdi() { return verdi; }             // aksessor

    public int compareTo(eksempelklasser.Heltall h)        // Heltall som parameter
    {
        if (verdi < h.verdi) return -1;
        else if (verdi == h.verdi) return 0;
        return verdi - h.verdi;
    }

    public boolean equals(Object o)
    {
        if (o == this) return true;   // sammenligner med seg selv
        if (!(o instanceof eksempelklasser.Heltall)) return false;  // feil datatype
        return verdi == ((eksempelklasser.Heltall)o).verdi;
    }

    public boolean equals(eksempelklasser.Heltall h) { return verdi == h.verdi; }

    //public int hashCode() { return 31 + verdi; }

    public String toString() { return Integer.toString(verdi); }

} // class Heltall


