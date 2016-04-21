package hr.fer.zemris.java.tecaj.hw6.demo2;

import java.util.Optional;

/**
 * Demonstrates the usage of {@linkplain LikeMedian} with Integer values.
 *
 * @author Mario Bobic
 */
public class MedianDemo1 {

	/**
	 * Program entry point.
	 * 
	 * @param args not used in this example
	 */
	public static void main(String[] args) {
		LikeMedian<Integer> likeMedian = new LikeMedian<Integer>();
		likeMedian.add(new Integer(10));
		likeMedian.add(new Integer(5));
		likeMedian.add(new Integer(3));
//		likeMedian.add(new Integer(1));
//		likeMedian.add(new Integer(1));
//		likeMedian.add(new Integer(1));
//		likeMedian.add(new Integer(2));
//		likeMedian.add(new Integer(3));
//		likeMedian.add(new Integer(4));

		Optional<Integer> result = likeMedian.get();
		System.out.println(result); // or: result.get()

		for (Integer elem : likeMedian) {
			System.out.println(elem);
		}
	}

}
