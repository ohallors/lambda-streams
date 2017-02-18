package timing;

import java.util.Arrays;

/**
 * Created by sheamusohalloran on 29/01/2017.
 */
public class TimingTests {
    public static void main(String[] args) {
        for (int i = 3; i < 8; i++) {
            int size = (int)Math.pow(10, i);
            System.out.printf("Sorting array of length %,d. %n", size);
            Op.timeOp(() -> sortArray(size));
        }

        Op sortArray5 = () -> sortArray(500000);
        Op sortArray6 = () -> sortArray(6000000);
        Op doBoth = sortArray5.combinedOp(sortArray6);
        System.out.printf("Sorting array of length %,d. %n", 5);
        Op.timeOp(sortArray5);
        System.out.printf("Sorting array of length %,d. %n", 6);
        Op.timeOp(sortArray6);
        System.out.printf("Doing both %,d. %n", 11);
        Op.timeOp(doBoth);
    }

    public static double[] randomNums(int length) {
        double[] nums = new double[length];
        for (int i = 0; i < length; i++) {
            nums[i] = Math.random();
        }
        return nums;
    }

    public static void  sortArray(int length) {
        double[] nums = randomNums(length);
        Arrays.sort(nums);
    }
}
