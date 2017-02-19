package function;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

/**
 * Created by sheamusohalloran on 18/02/2017.
 */
public class HigherOrderFunctionsInFunction {

    public static void main(String[] args) {
        List<String> words = Arrays.asList("dog", "cat", "mouse");

        Function<String, String> makeUppercase = String::toUpperCase;
        Function<String, String> makeExciting = s -> s + "!!";
        List<String> upperCaseExcitingWords = transform(words, makeUppercase, makeExciting);
        System.out.println(upperCaseExcitingWords);
    }

    public static <T> Function<T, T> composeAll(Function<T, T>... functions) {
        Function<T, T> result = Function.identity();
        for (Function<T, T> function : functions) {
            result = result.compose(function);
        }
        return result;
    }

    public static <T> List<T> transform(List<T> originalValues, Function<T, T>... transformers) {
        Function<T, T> funcs = composeAll(transformers);
        List<T> transformedValues = new ArrayList<T>();
        for (T value : originalValues) {
            transformedValues.add(funcs.apply(value));
        }
       return transformedValues;
    }
}
