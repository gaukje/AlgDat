package eksempelklasser;

@FunctionalInterface                        //Legges i mappen eksempelklasser
public interface Komparator<T> {            //et funksjongrensesnitt
    int compare(T x, T y);                  //en abstrakt metode
}
