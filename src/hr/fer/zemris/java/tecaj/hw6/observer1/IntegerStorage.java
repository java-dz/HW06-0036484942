package hr.fer.zemris.java.tecaj.hw6.observer1;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * An integer storage that stores an <tt>int</tt> value and a list of
 * {@link IntegerStorageObserver integer storage observers}. When the
 * {@linkplain #setValue(int)} method is called, all observers are notified of
 * the change.
 *
 * @author Mario Bobic
 */
public class IntegerStorage {

    /** An integer value. */
    private int value;
    /** A list of integer storage observers. */
    private List<IntegerStorageObserver> observers;

    /**
     * Constructs an instance of <tt>IntegerStorage</tt> with the specified
     * initial value.
     *
     * @param initialValue the initial integer value
     */
    public IntegerStorage(int initialValue) {
        this.value = initialValue;
        this.observers = new ArrayList<>();
    }

    /**
     * Adds (registers) the specified <tt>observer</tt> to a list of observers
     * which will are notified of an integer value change.
     *
     * @param observer observer to be added
     */
    public void addObserver(IntegerStorageObserver observer) {
        Objects.requireNonNull(observer);
        if (!observers.contains(observer)) {
            observers.add(observer);
        }
    }

    /**
     * Removes (deregisters) the specified <tt>observer</tt> from the list of
     * observers.
     *
     * @param observer observer to be removed
     */
    public void removeObserver(IntegerStorageObserver observer) {
        observers.remove(observer);
    }

    /**
     * Removes all observers from the list of observers. There will be no
     * observers to notify after this call returns.
     */
    public void clearObservers() {
        observers.clear();
    }

    /**
     * Returns the integer value of this storage.
     *
     * @return the integer value of this storage
     */
    public int getValue() {
        return value;
    }

    /**
     * Sets the value of this storage to the specified <tt>value</tt> and
     * notifies all the observers of the change, if the <tt>value</tt> is not
     * the same as it was before this method was called.
     *
     * @param value value to be set, if different
     */
    public void setValue(int value) {
        // Only if new value is different than the current value:
        if (this.value != value) {
            // Update current value
            this.value = value;
            // Notify all registered observers
            for (IntegerStorageObserver observer : new ArrayList<>(observers)) {
                observer.valueChanged(this);
            }
        }
    }

}
