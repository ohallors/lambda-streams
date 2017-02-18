package methodreference;

/**
 * Created by sheamusohalloran on 29/01/2017.
 */
public class Utils {
    public static String transform(String s, StringFunction f) {
        return f.applyFunction(s);
    }

    public static String makeExciting(String s) {
        return s + "!!";
    }

    private Utils() {}
}
