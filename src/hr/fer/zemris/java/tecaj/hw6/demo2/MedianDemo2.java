package hr.fer.zemris.java.tecaj.hw6.demo2;

import java.util.Optional;

/**
 * Demonstrates the usage of {@linkplain LikeMedian} with String literals.
 *
 * @author Mario Bobic
 */
public class MedianDemo2 {

	/**
	 * Program entry point.
	 * 
	 * @param args not used in this example
	 */
	public static void main(String[] args) {
		LikeMedian<String> likeMedian = new LikeMedian<String>();
		likeMedian.add("Joe");
		likeMedian.add("Jane");
		likeMedian.add("Adam");
		likeMedian.add("Zed");
		
		Optional<String> result = likeMedian.get();
		System.out.println(result); // or: result.get()
		
		for (String elem : likeMedian) {
			System.out.println(elem);
		}
	}

}
