package streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import model.Employee;
import model.EmployeeUtils;

/**
 * Created by sheamusohalloran on 22/02/2017.
 */
public class Map {
    public static void main(String[] args) {
        Double[] nums =  {1.0, 2.0, 3.0, 4.0, 5.0};
        Double[] squares = Stream.of(nums).toArray(Double[]::new);

        Integer[] ids = {1, 2, 4, 8};
        Stream.of(ids)
                .map(EmployeeUtils::findById).forEach(System.out::println);

    }
}
