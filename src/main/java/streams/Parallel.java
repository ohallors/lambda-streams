package streams;

import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import timing.Op;

/**
 * Created by sheamusohalloran on 27/02/2017.
 */
public class Parallel {
    public static void main(String[] args) {
//        Long val = LongStream.range(1, 1000000000).parallel().reduce(1, (i1, i2) -> i1 + i2);
//        System.out.println(val);
        double[] nums = randomNums(10_000_000);
        double result1 = fancySum1(nums);
        System.out.printf("serial result = %,.12f%n", result1);
        double result2 = fancySum2(nums);
        System.out.printf("serial result = %,.12f%n", result2);

        for (int i = 5; i < 9; i++) {
            int size = (int)Math.pow(10, i);
            double[] numbers = randomNums(size);
            Op serialSum = () -> fancySum1(numbers);
            Op parallelSum = () -> fancySum2(numbers);
            System.out.printf("Serial sum for length %,d.%n", size);
            Op.timeOp(serialSum);
            System.out.printf("Parallel sum for length %,d.%n", size);
            Op.timeOp(parallelSum);
        }
    }

    public static double fancySum1(double[] nums) {
        return DoubleStream.of(nums)
                .map(d -> Math.sqrt(2*d))
                .sum();
    }

    public static double fancySum2(double[] nums) {
        return DoubleStream.of(nums)
                .parallel()
                .map(d -> Math.sqrt(2*d))
                .sum();
    }

    public static double[] randomNums(int length) {
        double[] nums = new double[length];
        for (int i = 0; i < length; i++) {
            nums[i] = Math.random() * 3;
        }
        return nums;
    }
}
