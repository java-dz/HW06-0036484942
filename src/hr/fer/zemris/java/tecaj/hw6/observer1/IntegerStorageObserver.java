package hr.fer.zemris.java.tecaj.hw6.observer1;

/**
 * This interface represents an integer storage observer. It provides a single
 * method, {@linkplain #valueChanged(IntegerStorage)} that is called by the
 * {@linkplain IntegerStorage} when its value is changed. Every time the
 * objects' state changes, the object will invoke all of the registered actions
 * by using methods of prescribed interface.
 *
 * @author Mario Bobic
 */
public interface IntegerStorageObserver {

	/**
	 * Notifies all the registered observers that a value has been changed.
	 * 
	 * @param istorage the object of which the value has been changed
	 */
	public void valueChanged(IntegerStorage istorage);
	
}
