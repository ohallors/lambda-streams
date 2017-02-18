package function;

import java.util.function.BinaryOperator;

/**
 * Created by sheamusohalloran on 15/02/2017.
 */
public class MyBinaryOperator {

    public static void main(String[] args) {
        BinaryOperator<Integer> adder = Integer::sum;
        int sum = adder.apply(10, 2);
        System.out.println(sum);
    }
}
