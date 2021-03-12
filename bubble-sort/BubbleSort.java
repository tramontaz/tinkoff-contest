import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class BubbleSort {

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
		
			bubbleSort(array);
			
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
	
	private static void bubbleSort(Integer[] array) {
	
		for(int i = 0; i < array.length; i++) {
			for(int j = 0; j < array.length - 1; j++) {
				if(array[j+1] < array[j]) {
					swap(array, j+1, j);
				}
			}	
			
		}
	}
}
