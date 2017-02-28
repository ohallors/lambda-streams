package model;

import java.util.function.Supplier;

/**
 * Created by sheamusohalloran on 28/02/2017.
 */
public  class FibonacciMaker implements Supplier<Long> {
    private long previous = 0;
    private long current = 1;

    public FibonacciMaker() {
    }

    @Override
    public Long get() {
        long next = current + previous;
        previous = current;
        current = next;
        return previous;
    }
}
