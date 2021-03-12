package entity;

public class ArrList<T> {
	
	private Object[] arr;
	private int length = 0;

	public ArrList() {
		this.arr = new Object[10];
	}

	public ArrList(int cap) {
		this.arr = new Object[cap];
	}

	public void add(T elem) {
		if(length >= arr.length) {
			var newCapacity = arr.length * 3 / 2;
			var newArr = new Object[newCapacity];

			for(int i = 0; i < arr.length; i++) {
				newArr[i] = arr[i];
			}
			
			this.arr = newArr;
		}

		this.arr[length++] = elem;
	}
	
	public T get(int index) {
		int lastElemIndx = length - 1;
		if (index < 0 || index > lastElemIndx) {
			throw new RuntimeException("Index must be more or equal 0 and less or equal  " + lastElemIndx);
		}
		
		@SuppressWarnings("unchecked")
		final T result = (T) this.arr[index];

		return result;	
	}	

	public void set(int index, T elem) {
		int lastElemIndx = length - 1;
		if (index < 0 || index > lastElemIndx) {
			throw new RuntimeException("Index must be more or equal 0 and less or equal  " + lastElemIndx);
		}
		
		arr[index] = elem;
	}

	public void delete(int index) {
		int lastElemIndx = length - 1;
		if (index < 0 || index > lastElemIndx) {
			throw new RuntimeException("Index must be more or equal 0 and less or equal  " + lastElemIndx);
		}
		
		this.arr[index] = null;
		this.length--;	
	}
	
	public int getLength() {
		return this.length;
	}

	@Override
        public String toString() {
                var sb = new StringBuilder("[");

                for(Object val : this.arr) {
                        sb.append(val + ", ");
                }
 
                sb.delete(sb.length() - 2, sb.length());
                sb.append("]");
 
                return sb.toString();
        }
}
