package hr.fer.zemris.java.tecaj.hw6.observer1;

/**
 * This class implements the {@linkplain IntegerStorageObserver} and writes out
 * double value of the integer stored in the IntegerStorage to the standard
 * output when the value is changed, but only the <tt>n</tt> times since its
 * registration.
 *
 * @author Mario Bobic
 */
public class DoubleValue implements IntegerStorageObserver {

    /** Number of times left before deregistration. */
    private int count;

    /**
     * Constructs an instance of <tt>DoubleValue</tt> with the specified number
     * of times the double value will be written before deregistration.
     *
     * @param n number of times the double value will be written before deregistration
     */
    public DoubleValue(int n) {
        count = n;
    }

    @Override
    public void valueChanged(IntegerStorage istorage) {
        if (count > 0) {
            System.out.println("Double value: " + 2*istorage.getValue());
            count--;
        } else {
            istorage.removeObserver(this);
        }
    }

}
