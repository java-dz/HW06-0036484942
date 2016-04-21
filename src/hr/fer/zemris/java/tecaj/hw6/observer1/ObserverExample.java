package hr.fer.zemris.java.tecaj.hw6.observer1;

/**
 * An example class which shows the use of class {@linkplain IntegerStorage} and
 * the implementing classes of interface {@linkplain IntegerStorageObserver};
 * {@linkplain SquareValue}, {@linkplain ChangeCounter} and
 * {@linkplain DoubleValue}.
 *
 * @author Mario Bobic
 */
public class ObserverExample {

	/**
	 * Program entry point.
	 * 
	 * @param args not used in this example
	 */
	public static void main(String[] args) {
		IntegerStorage istorage = new IntegerStorage(20);
		
		IntegerStorageObserver observer = new SquareValue();
		
		istorage.addObserver(observer);
		istorage.setValue(5);
		istorage.setValue(2);
		istorage.setValue(25);
		
		istorage.removeObserver(observer);
		
		istorage.addObserver(new ChangeCounter());
		istorage.addObserver(new DoubleValue(2));
		istorage.addObserver(new DoubleValue(1));
		istorage.addObserver(new DoubleValue(2));
		istorage.setValue(13);
		istorage.setValue(22);
		istorage.setValue(15);
	}

}
