package hr.fer.zemris.java.tecaj.hw6.demo3;

/**
 * Demonstrates the usage of {@linkplain PrimesCollection} by making a Cartesian
 * iteration through the first 2 prime numbers.
 *
 * @author Mario Bobic
 */
public class PrimesDemo2 {

	/**
	 * Program entry point.
	 * 
	 * @param args not used in this example
	 */
	public static void main(String[] args) {
		PrimesCollection primesCollection = new PrimesCollection(2);
		
		for (Integer prime : primesCollection) {
			for (Integer prime2 : primesCollection) {
				System.out.println("Got prime pair: " + prime + ", " + prime2);
			}
		}
	}

}
