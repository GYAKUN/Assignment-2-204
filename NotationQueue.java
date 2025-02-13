package application;

import java.util.ArrayList;
import java.util.Collections;

/**
 * class implementing QueueInterface
 * @author Gleb Yakunin
 *
 * @param <T> data type
 */
public class NotationQueue<T> implements QueueInterface<T> {

	private int sizeOfQueue;
	private ArrayList<T>queue;
	int front, end,items=0;
	
	public NotationQueue(){
		sizeOfQueue=100;
		queue=new ArrayList<T> (sizeOfQueue);
	}
	
	public NotationQueue(int size) {
		sizeOfQueue=size;
		queue=new ArrayList<T> (sizeOfQueue);
	}
	
	/**
	 * Determines if Queue is empty
	 * @return true if Queue is empty, false if not
	 */
	@Override
	public boolean isEmpty() {
		if (items!=0)
			return false;
		else 
			return true;
	}

	/**
	 * Determines of the Queue is full
	 * @return true if Queue is full, false is not
	 */
	@Override
	public boolean isFull() {
		if (items==sizeOfQueue)
			return true;
		else 
			return false;
	}

	/**
	 * Deletes and returns the element at the front of the Queue
	 * @return the element at the front of the Queue
	 */
	@Override
	public T dequeue() throws QueueUnderflowException {
		T dequeueElement;
		if(items==0) {
			throw new QueueUnderflowException();
		}
		else {
			dequeueElement=queue.get(front);
			front++;
			items--;
		}
		return dequeueElement;
	}

	/**
	 * Number of elements in the Queue
	 * @return the number of elements in the Queue
	 */
	@Override
	public int size() {
		return items;
	}

	/**
	 * Adds an element to the end of the Queue
	 * @param e the element to add to the end of the Queue
	 * @return true if the add was successful, false if not
	 */
	@Override
	public boolean enqueue(T e) throws QueueOverflowException {
		if(items==sizeOfQueue) {
			throw new QueueOverflowException();
		}
		else {
			queue.add(end,e);
			end++;
			items++;
			return true;
		}
	}
	
	/**
	 * Returns the string representation of the elements in the Queue, 
	 * the beginning of the string is the front of the queue
	 * @return string representation of the Queue with elements
	 */
	@Override
	public String toString() {
		String queueString="";
		for(T i:queue ) {
			queueString+=i;
		}
		return queueString;
	}
	
	/**
	 * Returns the string representation of the elements in the Queue, the beginning of the string is the front of the queue
	 * Place the delimiter between all elements of the Queue
	 * @return string representation of the Queue with elements separated with the delimiter
	 */
	@Override
	public String toString(String delimiter) {
		String queueString="";
		for(int i=0;i<queue.size();i++ ){
			if(i!=queue.size()-1) {
				queueString+=queue.get(i)+delimiter;
			}
			else {
				queueString+=queue.get(i);
			}
		}
		return queueString;
	}

	 /**
	  * Fills the Queue with the elements of the ArrayList, First element in the ArrayList
	  * is the first element in the Queue
	  * @param list elements to be added to the Queue
	  */
	@Override
	public void fill(ArrayList<T> list) {
		ArrayList<T> queueCopy=new ArrayList<T>(list);
		queue.addAll(queueCopy);
		items=queue.size();
		
	}

}