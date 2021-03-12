package entity;

import java.lang.StringBuilder;

public class Stack<T> {
	
	private ArrList<T> list;
	private int length = 0;	

	public Stack() {
		list = new ArrList<T>();
	}
	
	public Stack(int capacity) {
		list = new ArrList<T>(capacity);
	}

	public int size() {
		return this.length;
	}

	public void push(T elem) {
		list.add(elem);
		length++;
	}
	
	public T pop() {

		if(length == 0) {
			throw new RuntimeException("The stack is empty");
		}

		T elem = list.get(--length);
		list.delete(length);
		
		return elem;
	}
	
	public T back() {
		if(length == 0) {
			throw new RuntimeException("The stack is empty");
		}

		int position = length - 1;
		return this.list.get(position);
	}

	public void clear() {
		this.list = new ArrList<T>();
		this.length = 0;
	}
	
	@Override
	public String toString() {
		return list.toString();
	}
}
