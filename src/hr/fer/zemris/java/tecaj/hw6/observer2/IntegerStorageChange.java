package hr.fer.zemris.java.tecaj.hw6.observer2;

import java.util.Objects;

/**
 * This class represents an integer storage change of value. This class offers
 * read-only attributes for fetching the integer storage object, the integer
 * value of this object before the change has happened and the integer value of
 * this object after the change has happened.
 *
 * @author Mario Bobic
 */
public class IntegerStorageChange {

	/** The integer storage object. */
	public final IntegerStorage istorage;
	/** The integer value before the change has happened. */
	public final int beforeChange;
	/** The integer value after the change has happened. */
	public final int afterChange;
	
	/**
	 * Construct an instance of <tt>IntegerStorageChange</tt> with the specified
	 * integer storage object, integer value before the change has happened and
	 * integer value after the change has happened.
	 * 
	 * @param istorage integer storage object
	 * @param beforeChange integer value before the change has happened
	 * @param afterChange integer value after the change has happened
	 */
	public IntegerStorageChange(IntegerStorage istorage, int beforeChange, int afterChange) {
		Objects.requireNonNull(istorage);
		this.istorage = istorage;
		this.beforeChange = beforeChange;
		this.afterChange = afterChange;
	}
	
}
