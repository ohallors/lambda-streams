package genericsrefresher;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Created by sheamusohalloran on 20/02/2017.
 */
public class SortGolfers {
    private List<Golfer> golfers = Arrays.asList(
            new Golfer("Jack", "Nicklaus", 68),
            new Golfer("Tiger", "Woods", 70),
            new Golfer("Tom", "Watson", 70),
            new Golfer("Ty", "Webb", 68),
            new Golfer("Bubba", "Watson", 70)
    );

    // default sort by score
    public void defaultSort() {
        golfers.stream().sorted().forEach(System.out::println);
    }

    // sort by score then last name
    public void scoreThenByLastName() {
        golfers.stream()
                .sorted(Comparator.comparingInt(Golfer::getScore)
                .thenComparing(Golfer::getLast))
                .forEach(System.out::println);
    }

    // sort by score then last name then first
    public void scoreThenByLastFirstName() {
        golfers.stream()
                .sorted(Comparator.comparingInt(Golfer::getScore)
                .thenComparing(Golfer::getLast)
                .thenComparing(Golfer::getFirst))
                .forEach(System.out::println);
    }
}
