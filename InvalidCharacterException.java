package application;

/** Exception class that is thrown when invalid character is used in
 *  an infix or a postfix expression!
 *  
 * @author Gleb Yakunin
 */
public class InvalidCharacterException extends Exception {
	
	/** Default constructor that shows a default message when this exception is thrown */
	public InvalidCharacterException() {
		this("An invalid character was used! You need to use numbers or + - * /");
	}
	
	/** Constructor that allows for a custom message if this exception is thrown
	 * 
	 * @param msg The custom message to show
	 */
	public InvalidCharacterException(String msg) {
		super(msg);
	}
}
