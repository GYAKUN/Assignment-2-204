package application;

import java.util.ArrayList;
import java.util.Collections;
/**
 * class implementing StackInterface
 * @author Gleb Yakunin
 *
 * @param <T> data type
 */
public class NotationStack<T> implements StackInterface<T> {
	
	private int sizeOfStack;
	private ArrayList<T>stack;
	int items=0;
	
	public NotationStack(){
		sizeOfStack=100;
		stack=new ArrayList<T> (sizeOfStack);
	}
	
	public NotationStack(int size) {
		sizeOfStack=size;
		stack=new ArrayList<T> (sizeOfStack);
	}

	/**
	 * Determines if Stack is empty
	 * @return true if Stack is empty, false if not
	 */
	@Override
	public boolean isEmpty() {
		if (items==0)
			return true;
		else 
			return false;
	}

	/**
	 * Determines if Stack is full
	 * @return true if Stack is full, false if not
	 */
	@Override
	public boolean isFull() {
		if (items==sizeOfStack)
			return true;
		else 
			return false;
	}

	/**
	 * Deletes and returns the element at the top of the Stack
	 * @return the element at the top of the Stack
	 */
	@Override
	public T pop() throws StackUnderflowException {
		T poppedElement=null;
		if(items==0) {
			throw new StackUnderflowException();
		}
		else {
			poppedElement=stack.get(items-1);
			stack.remove(items-1);
			items--;
			return poppedElement;
		}
	}

	/**
	 * Returns the element at the top of the Stack, does not pop it off the Stack
	 * @return the element at the top of the Stack
	 */
	@Override
	public T top() throws StackUnderflowException {
		if(items==0) {
			throw new StackUnderflowException();
		}
		else {
			return stack.get(items-1);
		}
	}

	/**
	 * Number of elements in the Stack
	 * @return the number of elements in the Stack
	 */
	@Override
	public int size() {
		return items;
	}

	/**
	 * Adds an element to the top of the Stack
	 * @param e the element to add to the top of the Stack
	 * @return true if the add was successful, false if not
	 */
	@Override
	public boolean push(T e) throws StackOverflowException {
		if(items>=sizeOfStack) {
			throw new StackOverflowException();
			}
		else {
			stack.add(e);
			items++;
			return true;
		}

	}
	
	/**
	 * Returns the elements of the Stack in a string from bottom to top, the beginning 
	 * of the String is the bottom of the stack
	 * @return an string which represent the Objects in the Stack from bottom to top
	 */
	@Override
	public String toString() {
		String stackString="";
		for(T i:stack ) {
			stackString+=i;
		}
		return stackString;
	}
	
	/**
	 * Returns the string representation of the elements in the Stack, the beginning of the 
	 * string is the bottom of the stack
	 * Place the delimiter between all elements of the Stack
	 * @return string representation of the Stack from bottom to top with elements 
	 * separated with the delimiter
	 */
	@Override
	public String toString(String delimiter) {
		String stackString="";
		for(int i=0;i<stack.size();i++ ) {
			if(i!=stack.size()-1) {
				stackString+=stack.get(i)+delimiter;
			}
			else {
				stackString+=stack.get(i);
			}
		}
		return stackString;
	}
	
	/**
	  * Fills the Stack with the elements of the ArrayList, First element in the ArrayList
	  * is the first bottom element of the Stack
	  * @param list elements to be added to the Stack from bottom to top
	  */
	@Override
	public void fill(ArrayList<T> list) {
		ArrayList<T> listCopy=new ArrayList<T>(list);
		stack.addAll(listCopy);
		items=stack.size();
		
	}

}
