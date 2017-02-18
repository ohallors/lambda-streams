package timing;

/**
 * Created by sheamusohalloran on 29/01/2017.
 */
@FunctionalInterface
public interface Op {
    void runOp();

    // static methods are allowed in interfaces in java8
    static void timeOp(Op operation) {
        long startTime = System.nanoTime();
        operation.runOp();
        long endTime = System.nanoTime();
        double ONE_BILLION = 1_000_000_000;
        double elapsedTime = (endTime - startTime)/ONE_BILLION;
        System.out.printf(" Elapsed time: %.3f seconds. %n", elapsedTime);

    }

    default Op combinedOp(Op op2) {
        return () -> {
            runOp();
            op2.runOp();
        };
    }
}
