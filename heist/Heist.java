import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.lang.StringBuilder;

public class Heist {

	private static final String SPACE = " ";

	public static void main(String[] args) {
		
		try(var reader = new BufferedReader(new InputStreamReader(System.in))) {
			
			var remain = Integer.parseInt(reader.readLine());
			String[] keyboardsStr = reader.readLine().split(SPACE);
			
			int length = keyboardsStr.length;
			var keyboards = new Integer[length];

			for(int i = 0; i < length; i++) {
				keyboards[i] = Integer.parseInt(keyboardsStr[i]);
			}

			sort(keyboards);

			var size = keyboards[length - 1] - keyboards[0] + 1;

			System.out.println(size - remain);	

		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	private static void swap(Integer[] arr, int from, int to) {
		var temp = arr[from];
		arr[from] = arr[to];
		arr[to] = temp;
	}

	private static void sort(Integer[] arr) {

		for(int i = 1; i < arr.length; i++) {
			for(int j = i; j >= 0; j--) {
				if(j > 0 && arr[j] < arr[j - 1]) {
					swap(arr, j, j - 1);
				}
			}
		}
	}
}
