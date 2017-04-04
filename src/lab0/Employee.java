package lab0;

/**
 * In this challenge you need to address the probability that at some point the
 * arguments to method parameters may not be valid.
 * <p>
 * For example, String arguments may be null or empty; other objects may be
 * null; or primitive numbers may be out of acceptable range.
 * <p>
 * You need to validate ALL method parameters to make sure any and all arguments
 * are valid. The only exception is when any argument is acceptable based on
 * requirements. Fix the code below using if logic to validate method arguments
 * and throw IllegalArgumentException if the validation fails.
 *
 * @author Jim Lombardo, jlombardo@wctc.edu
 * @version 1.00
 */
public class Employee {

    public static final int MAX_VACATION_DAYS = 28;
    private String firstName;
    private String lastName;
    private String ssn;
    private int daysVacation;

    public Employee() {
        // initialize a bunch of default values
        firstName = "Unknown";
        lastName = "Unknown";
        ssn = "Unknown";
        daysVacation = 0;
    }

    /**
     * Convenience constructor to set all properties.
     *
     * @param firstName - cannot be null or empty
     * @param lastName - cannot be null or empty
     * @param ssn
     * @param daysVacation
     * @throws IllegalArgumentException if parameters are not valid
     */
    public Employee(String firstName, String lastName, String ssn, int daysVacation) throws IllegalArgumentException {
        setFirstName(firstName);
        setLastName(lastName);
        setSsn(ssn);
        setDaysVacation(daysVacation);
    }

    public final int getDaysVacation() {
        return daysVacation;
    }

    //helps with documentation to have throws in header
    public final void setDaysVacation(int daysVacation) throws IllegalArgumentException {
        if (daysVacation < 0 || daysVacation > 28) {
            throw new IllegalArgumentException("Error vacation days must not");
        }

        this.daysVacation = daysVacation;
    }

    public final String getFirstName() {
        return firstName;
    }

    /**
     * Mutates the first name.
     *
     * @param firstName - cannot be null or empty
     * @throws IllegalArgumentException if firstName is null or empty
     */
    public final void setFirstName(String firstName) throws IllegalArgumentException {
        if (firstName == null || firstName.isEmpty()) {
            throw new IllegalArgumentException("Sorry, first name is mandatory. Please try again");
        }
        this.firstName = firstName;
    }

    public final String getLastName() {
        return lastName;
    }

    /**
     * Mutates the lastName.
     *
     * @param lastName - cannot be null or empty
     * @throws IllegalArgumentException if lastName is null or empty
     */
    public final void setLastName(String lastName) throws IllegalArgumentException {
        if (lastName == null || lastName.isEmpty()) {
            throw new IllegalArgumentException("Sorry, last name is mandatory. Please try again");
        }
        this.lastName = lastName;
    }

    public final String getSsn() {
        return ssn;
    }

    //do the validation for this for HW.
    public final void setSsn(String ssn) throws IllegalArgumentException, NumberFormatException {
        //if null or empty
        if (ssn == null || ssn.isEmpty()) {
            throw new IllegalArgumentException("Error! Social Security number must not be "
                    + "null or empty.");
        }
        //if incorrect length
        if (ssn.length() < 9 || ssn.length() > 11) {
            throw new IllegalArgumentException("Error! Social Security number must either have"
                    + "a length of 9 (digits no hyphens) or 11 (digits and 2 hyphens).");
        }
        //can't begin with 9
        if (ssn.charAt(1) == 9) {
            throw new IllegalArgumentException("Error! Social Security number must not begin"
                    + "with the number 9.");
        }
        //group 1 will be the charAt spots for each 9 or 11 length (can't begin with 3 zeroes or three sixs)
        if ((ssn.charAt(1) == 0 && ssn.charAt(2) == 0 && ssn.charAt(3) == 0)
                || (ssn.charAt(1) == 6 && ssn.charAt(2) == 6 && ssn.charAt(3) == 6)) {
            throw new IllegalArgumentException("Error! The first digit group must not contain "
                    + "3 zeroes or 3 sixs in a row.");
        }
        //can't be 987654320
        if (ssn.equalsIgnoreCase("987654320") || ssn.equalsIgnoreCase("987-65-4320")) {
            throw new IllegalArgumentException("Error! The SSN cannot be 987654320 || 987-65-4320.");
        }
        //if correct length
        if (ssn.length() == 9 || ssn.length() == 11) {
            //follow 9
            if (ssn.length() == 9) {
                //can't begin with 900999
                if (ssn.charAt(1) == 9 && ssn.charAt(2) == 0 && ssn.charAt(3) == 0
                        && ssn.charAt(4) == 9 && ssn.charAt(5) == 9 && ssn.charAt(6) == 9) {
                    throw new IllegalArgumentException("Error! The SSN must not begin with 900999.");
                }
                //group 2
                if (ssn.charAt(4) == 0 && ssn.charAt(5) == 0) {
                    throw new IllegalArgumentException("Error! The second digit group must not contain "
                            + "2 zeroes.");
                }
                //group 3
                if (ssn.charAt(6) == 0 && ssn.charAt(7) == 0 && ssn.charAt(8) == 0 && ssn.charAt(9) == 0) {
                    throw new IllegalArgumentException("Error! The third digit group must not contain "
                            + "4 zeroes.");
                }
                //parse to an int and check for non-digit values
                try {
                    Integer.parseInt(ssn);
                } catch (NumberFormatException nfe) {
                    throw new NumberFormatException("Error! Social Security in 9 digit format "
                            + "contains non-digit values).");
                }
            } //follow 11
            else {
                //can't begin with 900-999
                if (ssn.charAt(1) == 9 && ssn.charAt(2) == 0 && ssn.charAt(3) == 0
                        && ssn.charAt(5) == 9 && ssn.charAt(6) == 9 && ssn.charAt(7) == 9) {
                    throw new IllegalArgumentException("Error! The SSN must not begin with 900-999.");
                }
                //group 2
                if (ssn.charAt(5) == 0 && ssn.charAt(6) == 0) {
                    throw new IllegalArgumentException("Error! The second digit group must not contain "
                            + "2 zeroes.");
                }
                //group 3
                if (ssn.charAt(8) == 0 && ssn.charAt(9) == 0 && ssn.charAt(10) == 0 && ssn.charAt(11) == 0) {
                    throw new IllegalArgumentException("Error! The third digit group must not contain "
                            + "4 zeroes.");
                }
                ssn.split("-");
                if (ssn.length() == 3) {
                    //parse to an int and check for non digit values
                    try {
                        Integer.parseInt(ssn);
                    } catch (NumberFormatException nfe) {
                        throw new NumberFormatException("Error! Social Security in 11 digit format"
                                + "contains non-digit values).");
                    }
                }
            }
        }
        this.ssn = ssn;
    }

    public String toString() {
        return firstName + " " + lastName;
    }
}
