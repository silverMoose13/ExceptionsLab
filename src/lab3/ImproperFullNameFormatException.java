package lab3;

/**
 *
 * @author Aaron
 */
public class ImproperFullNameFormatException extends Exception {

    private static final String MESSAGE = "Error! Your full name was not entered in properly. "
            + "It must contain"
            + " both a first and last name.";

    public ImproperFullNameFormatException() {
        super(MESSAGE);
    }

    public ImproperFullNameFormatException(String message) {
        super(MESSAGE);
    }

    public ImproperFullNameFormatException(String message, Throwable cause) {
        super(MESSAGE, cause);
    }

    public ImproperFullNameFormatException(Throwable cause) {
        super(cause);
    }

}
