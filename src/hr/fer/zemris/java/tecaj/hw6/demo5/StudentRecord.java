package hr.fer.zemris.java.tecaj.hw6.demo5;

/**
 * This class represents records for individual students.
 *
 * @author Mario Bobic
 */
public class StudentRecord {

    /** Student's JMBAG. */
    private String jmbag;
    /** Student's last name. */
    private String lastName;
    /** Student's first name. */
    private String firstName;
    /** Student's score on mid-term exam. */
    private Double scoreMI;
    /** Student's score on final exam. */
    private Double scoreZI;
    /** Student's score on lab. */
    private Double scoreLab;
    /** Student's final grade. */
    private Integer finalGrade;

    /**
     * Constructs an instance of StudentRecord object with the specified
     * arguments.
     *
     * @param jmbag student's JMBAG
     * @param lastName student's last name
     * @param firstName student's first name
     * @param scoreMI student's score on mid-term exam
     * @param scoreZI student's score on final exam
     * @param scoreLab student's score on lab
     * @param finalGrade student's final grade
     */
    public StudentRecord(String jmbag, String lastName, String firstName,
            Double scoreMI, Double scoreZI, Double scoreLab, Integer finalGrade) {
        this.jmbag = processArgument(jmbag, "JMBAG");
        this.lastName = processArgument(lastName, "Last name");
        this.firstName = processArgument(firstName, "First name");
        this.scoreMI = processArgument(scoreMI, "Score on mid-term exam");
        this.scoreZI = processArgument(scoreZI, "Score on final exam");
        this.scoreLab = processArgument(scoreLab, "Score on lab");
        this.finalGrade = processArgument(finalGrade, "Final grade");
    }

    /**
     * Checks if the argument is <tt>null</tt>. If the test returns true this
     * method throws an {@linkplain IllegalArgumentException} with a detail
     * message where the message is in form:
     * <blockquote> <tt>desc</tt> must not be null.
     * </blockquote><p>
     * If checking is successful, the same object is returned.
     *
     * @param <T> the object type
     * @param arg argument to be checked if it is a <tt>null</tt> reference
     * @param desc description of the specified argument
     * @return the object given as argument, if not <tt>null</tt>
     * @throws IllegalArgumentException if the argument is <tt>null</tt>
     */
    private static <T> T processArgument(T arg, String desc) {
        if (arg == null) {
            throw new IllegalArgumentException(desc + " must not be null.");
        }
        return arg;
    }

    /**
     * Returns the student's JMBAG.
     *
     * @return the student's JMBAG
     */
    public String getJmbag() {
        return jmbag;
    }

    /**
     * Returns the student's last name.
     *
     * @return the student's last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Returns the student's first name.
     *
     * @return the student's first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Returns the student's score on mid-term exam.
     *
     * @return the student's score on mid-term exam
     */
    public Double getScoreMI() {
        return scoreMI;
    }

    /**
     * Returns the student's score on final exam.
     *
     * @return the student's score on final exam
     */
    public Double getScoreZI() {
        return scoreZI;
    }

    /**
     * Returns the student's score on lab.
     *
     * @return the student's score on lab
     */
    public Double getScoreLab() {
        return scoreLab;
    }

    /**
     * Returns the student's total score which is simply a sum of all three
     * components: <tt>scoreMI + scoreZI + scoreLab</tt>.
     *
     * @return the student's total score
     */
    public Double getTotalScore() {
        return scoreMI + scoreZI + scoreLab;
    }

    /**
     * Returns the student's final grade.
     *
     * @return the student's final grade
     */
    public Integer getFinalGrade() {
        return finalGrade;
    }

    @Override
    public String toString() {
        return String.format("(%s) %s %s, MI: %f, ZI: %f, LAB: %f, grade: %d",
                jmbag, lastName, firstName, scoreMI, scoreZI, scoreLab, finalGrade);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + jmbag.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof StudentRecord))
            return false;
        StudentRecord other = (StudentRecord) obj;
        if (!jmbag.equals(other.jmbag))
            return false;
        return true;
    }

}
