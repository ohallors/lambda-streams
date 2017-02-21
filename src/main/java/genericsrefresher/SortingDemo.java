package genericsrefresher;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by sheamusohalloran on 20/02/2017.
 */
public class SortingDemo {
    private List<String> sampleStrings = Arrays.asList("this", "is", "a", "list", "of", "strings");

    // default sort from java 7
    public List<String> alphaSort() {
        Collections.sort(sampleStrings);
        return sampleStrings;
    }

    // default sort from java 8
    public List<String> alphaSortUsingStream() {
        return sampleStrings.stream()
                .sorted().collect(Collectors.toList());
    }

    // java 7 comparator with anonymous inner class - destructive
    public List<String> lengthReverseSortWithComparator() {
        Collections.sort(sampleStrings, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s2.length() - s1.length();
            }
        });
        return sampleStrings;
    }

    // use lambda as comparator - destructive
    public List<String> lengthSortWithLambda() {
        Collections.sort(sampleStrings, (s1, s2) -> s1.length() - s2.length());
        return sampleStrings;
    }

    // sort by length with sorted
    public List<String> lengthSortUsingComparator() {
        return sampleStrings.stream()
                .sorted((s1, s2) -> s1.length() - s2.length())
                .collect(Collectors.toList());
    }

    public List<String> lengthSortWithComparingInt() {
        return sampleStrings.stream()
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
    }

    public List<String> lengthSortThenAlphaSortUsingSorted() {
        return sampleStrings.stream()
                .sorted(Comparator.comparingInt(String::length)
                .thenComparing(Comparator.naturalOrder()))
                .collect(Collectors.toList());
    }

    public List<String> lengthThenReverseOrderAlpha() {
        return sampleStrings.stream()
                .sorted(Comparator.comparingInt(String::length)
                .thenComparing(Comparator.reverseOrder()))
                .collect(Collectors.toList());
    }
}
