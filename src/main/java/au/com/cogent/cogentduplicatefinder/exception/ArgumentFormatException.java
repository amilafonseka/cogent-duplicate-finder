package au.com.cogent.cogentduplicatefinder.exception;

/**
 * Exception denoting malformed argument input
 * 
 * @author amilasembunaidelage
 *
 */
public class ArgumentFormatException extends Exception{

	private static final long serialVersionUID = 1L;
	
	public ArgumentFormatException(String errorMessage) {
		super(errorMessage);
	}

}
