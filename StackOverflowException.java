package application;

/**
 * StackOverflowException class
 * @author Gleb Yakunin
 *
 */
public class StackOverflowException extends Exception{
	/**
	 *  Default constructor of StackOverflowException
	 * Assigns appropriate message to print in case exception happens
	 */
	StackOverflowException(){
		super("Stack is full");
	}

}