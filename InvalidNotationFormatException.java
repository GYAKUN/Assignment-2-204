package application;

/** This Exception is thrown when Notation format
 *  is incorrect.
 * 
 *  @author Gleb Yakunin
 *
 */
public class InvalidNotationFormatException extends Exception {

	/** Default constructor that is shown when
	 *  user passes a notation with an invalid format */
	public InvalidNotationFormatException() {
		this("");
	}
	
	/** Constructor that allows for a custom message to be 
	 *  shown if a notation of invalid format is sent to be 
	 *  worked with
	 * 
	 * @param msg The custom message to be shown when invalid notation format is found
	 */
	public InvalidNotationFormatException(String msg) {
		super(msg);
	}
}
