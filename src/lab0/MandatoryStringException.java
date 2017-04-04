package lab0;

/**
 *
 * @author agnas
 */

//this is extending a superclass of this custom exception
//next decide how serious
public class MandatoryStringException extends IllegalArgumentException {
    
    private static String msg = "Method argument is mandatory";

    public MandatoryStringException() {
        super(msg);
    }

    public MandatoryStringException(String s) {
        super(msg);
    }

    public MandatoryStringException(String message, Throwable cause) {
        super(msg, cause);
    }

    public MandatoryStringException(Throwable cause) {
        super(cause);
    }
    
    
    
}
