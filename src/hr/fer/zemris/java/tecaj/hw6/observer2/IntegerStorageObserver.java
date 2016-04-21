package hr.fer.zemris.java.tecaj.hw6.observer2;

/**
 * This interface represents an integer storage observer. It provides a single
 * method, {@linkplain #valueChanged(IntegerStorageChange)} that is called by
 * the {@linkplain IntegerStorage} when its value is changed. Every time the
 * object's state changes, the object will invoke all of the registered actions
 * by using methods of prescribed interface.
 *
 * @author Mario Bobic
 */
public interface IntegerStorageObserver {

	/**
	 * Notifies all the registered observers that a value has been changed.
	 * 
	 * @param change the object which represents an integer value change
	 */
	public void valueChanged(IntegerStorageChange change);
	
}
