package methodreference;


/**
 * Created by sheamusohalloran on 29/01/2017.
 */
public class Tests {
    public static void main(String[] args) {
        String s = "Test";

        String result1 = Utils.transform(s, Utils::makeExciting);
        System.out.println(result1);

        String prefix = "Blah";
        String result2 = Utils.transform(s, prefix::concat);
        System.out.println(result2);

        String result3 = Utils.transform(s, String::toUpperCase);
        System.out.println(result3);
    }
}
