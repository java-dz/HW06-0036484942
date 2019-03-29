package hr.fer.zemris.java.tecaj.hw6.observer1;

/**
 * This class implements the {@linkplain IntegerStorageObserver} and counts the
 * number of times value stored integer has been changed since the registration.
 * This count is written out to the standard output every time the value is
 * changed.
 *
 * @author Mario Bobic
 */
public class ChangeCounter implements IntegerStorageObserver {

    /** Number of times the value has been changed since registration. */
    private int count = 0;

    @Override
    public void valueChanged(IntegerStorage istorage) {
        System.out.println("Number of value changes since tracking: " + ++count);
    }

}
