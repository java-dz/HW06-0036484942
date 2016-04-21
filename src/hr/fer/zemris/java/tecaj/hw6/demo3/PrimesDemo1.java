package hr.fer.zemris.java.tecaj.hw6.demo3;

/**
 * Demonstrates the usage of {@linkplain PrimesCollection} by iterating through
 * the first 5 prime numbers.
 *
 * @author Mario Bobic
 */
public class PrimesDemo1 {

	/**
	 * Program entry point.
	 * 
	 * @param args not used in this example
	 */
	public static void main(String[] args) {
		PrimesCollection primesCollection = new PrimesCollection(5);
		
		for (Integer prime : primesCollection) {
			System.out.println("Got prime: " + prime);
		}
	}

}
