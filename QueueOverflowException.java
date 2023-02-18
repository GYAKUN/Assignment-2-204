package application;

/**
 * QueueOverflowException class
 * @author Gleb Yakunin
 *
 */
public class QueueOverflowException extends Exception{
	/**
	 *  Default constructor of QueueOverflowException
	 * Assigns appropriate message to print in case exception happens
	 */
	QueueOverflowException(){
		super("Queue is full");
	}
}