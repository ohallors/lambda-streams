package methodreference;

/**
 * Created by sheamusohalloran on 29/01/2017.
 */
public class MethodReference {
    public static void main(String[] args) {
        String someString = "sheamus";
        String test = "PREFIX:";
        String result = transform(someString, test::concat);
        System.out.println("args = [" + result + "]");
    }

    public static String transform(String string1, FunctionalTransform func) {
        return func.transformSomething(string1);
    }
}
