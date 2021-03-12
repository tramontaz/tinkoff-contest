import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class InsertionSort {

	private static final String SPACE = " ";

	public static void main(String[] args) {
		
		try(var reader = new BufferedReader(new InputStreamReader(System.in))) {
		
			Integer.parseInt(reader.readLine());
			
			String elements = reader.readLine();
						
			if(elements == null || elements.isEmpty()) {
				throw new RuntimeException("String with elements must be not empty");
			}

			var elementsString = elements.split(" ");
				
			
			var array = new Integer[elementsString.length];

			for(int i = 0; i < elementsString.length; i++) {
				array[i] = Integer.parseInt(elementsString[i]);
			}		
		
			insertionSort(array);
			
			var result = new StringBuilder();

			for(var elem : array) {
				result.append(elem).append(SPACE);
			}
			
			System.out.println((result.deleteCharAt(result.length() - 1).toString()));

		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	private static <T> void swap(T[] arr, int from, int to) {
		var temp = arr[to];
		arr[to] = arr[from];
		arr[from] = temp;
	}
	
	private static void insertionSort(Integer[] array) {
	
		//start from second elem, concider the left side is sorted
		for(int i = 1; i < array.length; i++) {

			// start from first unsorted elem afret sorted part
			for(int j = i; j >=0; j--) {

				if(j > 0 && array[j] < array[j - 1]) {
					swap(array, j, j - 1);
				}
			}
		}
	}
}
