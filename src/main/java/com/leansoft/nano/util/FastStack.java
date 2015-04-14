package com.leansoft.nano.util;

import java.util.ArrayList;
import java.util.EmptyStackException;

/**
 * A lightweight stack implementation, this stack is not synchronized and
 * keeps track of elements using an array list.
 * 
 * @author bulldog
 *
 */
@SuppressWarnings("serial")
public class FastStack<T> extends ArrayList<T> {

	/**
	 * Constructor for the FastStack
	 * 
	 * @param size initial size of the stack to use
	 */
	public FastStack(int size) {
		super(size);
	}
	
	/**
	 * Add an object to the top of the stack
	 * 
	 * @param o object to be added to the stack
	 */
	public void push(T o) {
		add(o);
	}
	
	/**
	 * Remove an object from the top of the stack,
	 * if the stack is empty, @see java.util.EmptyStackException will be thrown.
	 * 
	 * @return the object on the top of the stack
	 */
	public T pop() {
		if (empty()) throw new EmptyStackException();
		return remove(size() - 1);
	}
	
	/**
	 * Check if the stack is empty
	 * 
	 * @return true or false
	 */
	public boolean empty() {
		return size() == 0;
	}
	
	/**
	 * Peek the object at the top of the stack,
	 * if the stack is empty, @see java.util.EmptyStackException will be thrown.
	 * 
	 * @return the object at the top of the stack
	 */
	public T peek() {
		if (empty()) throw new EmptyStackException();
		return get(size() - 1);
	}	
}
