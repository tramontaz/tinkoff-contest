package entity;

public class Queue<T> {
	
	private Stack<T> add;
	private Stack<T> del;

	public Queue() {
		add = new Stack<>();
		del = new Stack<>();
	}
	
	public void push(T elem) {
		add.push(elem);
	}

	public T pop() {
		if(del.size() == 0 && add.size() > 0) {
			var size = add.size();
			for(int i = 0; i < size; i++) {
				del.push(add.pop());
			}
		}
	
		if(del.size() == 0) {
			throw new RuntimeException("Queue is empty");
		}
	
		return del.pop();
	}

	public T front() {
		if(del.size() == 0 && add.size() > 0) {
			var size = add.size();
			for(int i = 0; i < size; i++) {
				del.push(add.pop());
			}
		}

		if(del.size() == 0) {
			throw new RuntimeException("Queue is empty");
		}
	
		return del.back();
	}
	
	public int size() {
		return add.size() + del.size();
	}

	public void clear() {
		add.clear();
		del.clear();
	}	
}		
