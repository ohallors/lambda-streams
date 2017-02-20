package methodreference;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * Created by sheamusohalloran on 29/01/2017.
 */
public class Utils {
    public static String transform(String s, StringFunction f) {
        return f.applyFunction(s);
    }

    public static <T> List allMatches(List<T> list, Predicate<T> predicate) {
        List<T> returnList = new ArrayList<T>();
        for (T item: list) {
            if (predicate.test(item)) {
                returnList.add(item);
            }
        }
        return returnList;
    }


    public static String makeExciting(String s) {
        return s + "!!";
    }

    private Utils() {}
}
