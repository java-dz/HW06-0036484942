package hr.fer.zemris.java.tecaj.hw6.demo5;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Demonstrates the usage of a student database by using the Java
 * {@linkplain Stream stream API} for filtering and collecting students.
 *
 * @author Mario Bobic
 */
public class StudentDemo {
	
	/** List of students loaded from the {@linkplain StudentLoader}. */
	private static List<StudentRecord> records = StudentLoader.loadStudents();
	
	/**
	 * Program entry point.
	 * 
	 * @param args not used in this example
	 */
	public static void main(String[] args) {
		/* Task 1 */
		long broj = records.stream()
				.filter(s -> s.getTotalScore() > 25)
				.count();
		System.out.println(broj);

		/* Task 2 */
		long broj5 = records.stream()
				.filter(s -> s.getFinalGrade() == 5)
				.count();
		System.out.println(broj5);

		/* Task 3 */
		List<StudentRecord> odlikasi = records.stream()
				.filter(s -> s.getFinalGrade() == 5)
				.collect(Collectors.toList());
		print(odlikasi);

		/* Task 4 */
		List<StudentRecord> odlikasiSortirano = records.stream()
				.filter(s -> s.getFinalGrade() == 5)
				.sorted((s1, s2) -> s1.getTotalScore().compareTo(s2.getTotalScore()))
				.collect(Collectors.toList());
		print(odlikasiSortirano);

		/* Task 5 */
		List<String> nepolozeniJMBAGovi = records.stream()
				.filter(s -> s.getFinalGrade() == 1)
				.map(s -> s.getJmbag())
				.sorted((jmbag1, jmbag2) -> jmbag1.compareTo(jmbag2))
				.collect(Collectors.toList());
		print(nepolozeniJMBAGovi);

		/* Task 6 */
		Map<Integer, List<StudentRecord>> mapaPoOcjenama = records.stream()
				.collect(Collectors.groupingBy(StudentRecord::getFinalGrade));
		print(mapaPoOcjenama);

		/* Task 7 */
		Map<Integer, Integer> mapaPoOcjenama2 = records.stream()
				.collect(Collectors.toMap(
						StudentRecord::getFinalGrade,
						s -> 1,
						Integer::sum) // (old, new) -> old+new
		);
		print(mapaPoOcjenama2);

		/* Task 8 */
		Map<Boolean, List<StudentRecord>> prolazNeprolaz = records.stream()
				.collect(Collectors.partitioningBy(s -> s.getFinalGrade() > 1));
		print(prolazNeprolaz);
	}
	
	/**
	 * Prints out the specified <tt>list</tt>, where each element of the list is
	 * in a new line.
	 * 
	 * @param list list whose elements are to be printed out
	 */
	private static void print(List<? extends Object> list) {
		list.forEach(System.out::println);
		System.out.println("Selected: " + list.size());
		System.out.println("********************");
	}
	
	/**
	 * Prints out the specified <tt>map</tt>, where each element of the map is
	 * in a new line.
	 * 
	 * @param map map whose elements are to be printed out
	 */
	private static void print(Map<? extends Object, ? extends Object> map) {
		map.forEach((k,v) -> System.out.println(k + " => " + v));
		System.out.println("Selected: " + map.size());
		System.out.println("********************");
	}

}
