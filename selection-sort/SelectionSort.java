import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class SelectionSort {

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
		
			selectionSort(array);
			
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
	
	private static void selectionSort(Integer[] array) {
	
		for(int i = 0; i < array.length - 1; i++) {
			var min = array[i];
			
			for(int j = i + 1; j < array.length; j++) {
				if(array[j] < min) {
					swap(array, j, i);
					min = array[i];
				}
			}
		}
	}
}
