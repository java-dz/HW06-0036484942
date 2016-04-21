package hr.fer.zemris.java.tecaj.hw6.demo5;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * A loader class for students. This class offers one public method for loading
 * student records from the students text file.
 *
 * @author Mario Bobic
 */
public class StudentLoader {
	
	/** Name of the file from which all lines are read. */
	private static final String FILENAME = "./studenti.txt";
	
	/** A splitter used for splitting student record attributes. */
	private static final String SPLITTER = "\\t";
	
	/**
	 * Assure non-instantiability.
	 */
	private StudentLoader() {
	}

	/**
	 * Loads all lines from the file and returns a list of {@link StudentRecord
	 * student records}. If the file is not found, has a malformed line or can
	 * not be read in any way, an error message is printed out onto the standard
	 * error and the program is terminated as it does not make sense to continue.
	 * 
	 * @return a list of student records
	 */
	public static List<StudentRecord> loadStudents() {
		try {
			List<String> lines = Files.readAllLines(
				Paths.get(FILENAME),
				StandardCharsets.UTF_8
			);
			return convert(lines);
		} catch (NoSuchFileException exc) {
			System.err.println("File " + FILENAME + " not found");
			System.exit(1);
		} catch (MalformedLineError err) {
			System.err.println("In file " + FILENAME + ", " + err.getMessage());
			System.exit(2);
		} catch (IOException exc) {
			System.err.println("Error reading " + FILENAME + ": " + exc.getMessage());
			System.exit(3);
		}
		return null; // just for the compiler to be happy
	}
	
	/**
	 * Converts all lines from the specified list to a list of
	 * {@linkplain StudentRecord student records}. This is done by parsing the
	 * lines from the list as student data.
	 * 
	 * @param lines list of lines that represent student data
	 * @return a List filled with student data
	 * @throws MalformedLineError if a malformed line is present
	 */
	private static List<StudentRecord> convert(List<String> lines) {
		List<StudentRecord> records = new ArrayList<>();
		
		int lineCount = 0;
		for (String line : lines) {
			lineCount++;
			if (line.isEmpty()) continue;
			try {
				String[] attrs = line.split(SPLITTER);
				String jmbag = attrs[0];
				String lastName = attrs[1];
				String firstName = attrs[2];
				Double scoreMI = Double.parseDouble(attrs[3]);
				Double scoreZI = Double.parseDouble(attrs[4]);
				Double scoreLab = Double.parseDouble(attrs[5]);
				Integer finalGrade = Integer.parseInt(attrs[6]);
				records.add(new StudentRecord(jmbag, lastName, firstName,
								scoreMI, scoreZI, scoreLab, finalGrade));
			} catch (Exception e) {
				throw new MalformedLineError(
						"Malformed line " + lineCount + ": " + line);
			}
		}
		
		return records;
	}
	
}
