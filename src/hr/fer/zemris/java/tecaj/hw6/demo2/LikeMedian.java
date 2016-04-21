package hr.fer.zemris.java.tecaj.hw6.demo2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * This class works with any type which has defined natural ordering and is used
 * for extracting the median from the added elements.
 *
 * @author Mario Bobic
 * @param <E> element of type implementing {@linkplain Comparable}
 */
public class LikeMedian<E extends Comparable<E>> implements Iterable<E> {

	/** List of elements. */
	private List<E> list = new ArrayList<>();
	
	/**
	 * Adds the specified element to the list of elements for further median
	 * calculation.
	 * 
	 * @param element element to be added
	 */
	public void add(E element) {
		Objects.requireNonNull(element);
		list.add(element);
	}
	
	/**
	 * Returns an {@linkplain Optional} median. The median may or may not exist,
	 * depending if there are any elements contained in the list, that is if the
	 * {@linkplain #add} method has been called at least once.
	 * <p>
	 * If the list is empty, {@linkplain Optional#empty()} is returned.
	 * Otherwise, the median is calculated and then returned in the form of
	 * {@linkplain Optional#of(Object)}.
	 * 
	 * @return an optional that may contain the median value of elements
	 */
	public Optional<E> get() {
		if (list.isEmpty()) {
			return Optional.empty();
		}
		
		List<E> list = new ArrayList<>(this.list);
		Collections.sort(list);
		int index = (int) Math.ceil(list.size() / 2.0) - 1;
		return Optional.of(list.get(index));
	}

	@Override
	public Iterator<E> iterator() {
		return list.iterator();
	}

}
