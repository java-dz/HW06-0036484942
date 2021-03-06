package hr.fer.zemris.java.tecaj.hw6.observer1;

/**
 * This class implements the {@linkplain IntegerStorageObserver} and writes out
 * square of the integer stored in the IntegerStorage to the standard output
 * when the value is changed.
 *
 * @author Mario Bobic
 */
public class SquareValue implements IntegerStorageObserver {

    @Override
    public void valueChanged(IntegerStorage istorage) {
        int value = istorage.getValue();
        System.out.printf("Provided new value: %d, square is: %d%n",
                value, value*value);
    }

}
