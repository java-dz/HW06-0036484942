package hr.fer.zemris.java.tecaj.hw6.demo3;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * This class represents a collection of prime numbers. The prime numbers are
 * not stored anywhere in memory, but are fetched in execution time by the
 * iterator.
 *
 * @author Mario Bobic
 */
public class PrimesCollection implements Iterable<Integer> {

    /** Number of primes for iteration. */
    private int count;

    /**
     * Constructs an instance of <tt>PrimesCollection</tt> with the specified
     * number of primes for iteration.
     * <p>
     * If the specified number of primes <tt>count</tt> is less than zero, an
     * {@linkplain IllegalArgumentException} is thrown.
     *
     * @param count number of primes for iteration
     * @throws IllegalArgumentException if count is less than 0
     */
    public PrimesCollection(int count) {
        if (count < 0) {
            throw new IllegalArgumentException("n must not be less than 0.");
        }
        this.count = count;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new PrimesIterator();
    }

    /**
     * Iterator through the first <tt>count<tt> prime numbers.
     *
     * @author Mario Bobic
     */
    private class PrimesIterator implements Iterator<Integer> {

        /** Number of remaining elements for this iterator. */
        private int remaining = count;
        /** Used to continue searching for the next element from this prime. */
        private int lastReturned = -1;

        @Override
        public boolean hasNext() {
            return remaining > 0;
        }

        @Override
        public Integer next() {
            if (!hasNext()) {
                throw new NoSuchElementException("Iterator exhausted.");
            }

            int i = lastReturned+1;
            while (!isPrime(i)) {
                i++;
            }

            remaining--;
            return (lastReturned = i);
        }

        /**
         * Returns true if passed arguments is a prime number. This method considers
         * the first prime number to be 2.
         *
         * @param number number that is tested for prime
         * @return true if number is prime
         */
        private boolean isPrime(int number) {
            if (number <= 1) {
                return false;
            }

            // lowest value for checking for prime numbers
            int numberSqrt = (int) Math.sqrt((double) number);
            for (int i = 2; i <= numberSqrt; i++) {
                if (number % i == 0) {
                    return false;
                }
            }
            return true;
        }

    }

}
