import java.lang.StringBuilder;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class CountSort {

	public static void main(String[] args) {

		try(var reader = new BufferedReader(new InputStreamReader(System.in))) {
			
			reader.readLine();

			var arrStr = reader.readLine().split(" ");

			var arr = new Integer[arrStr.length];
			for(int i = 0; i < arr.length; i++) {
				arr[i] = Integer.parseInt(arrStr[i]);
			}

			sort(arr);

			say(toStr(arr));

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void sort(Integer[] array) {
		
		if(array.length < 2) {
			return;
		}
		
		int min = array[0];
		int max = array[0];
	
		for(int i = 1; i < array.length; i++){

			if(array[i] < min) {
				min = array[i];
			}

			if(array[i] > max) {
				max = array[i];
			}
		}
		
		Integer[] count = new Integer[max - min + 1];
		
		for(int i = 0; i < array.length; i++) {
			if(count[array[i] - min] ==  null)  {
				count[array[i] - min] = 1;
			} else {
				count[array[i] - min]++;
			}
		}

		for(int i = 0, j = 0; i < count.length; i++) {
			
			if(count[i] != null) {
				for(int k = 0; k < count[i]; k++) {
					array[j++] = i + min;
				}
			}
		}
	}

        public static <T> String toStr(T[] array) {
                var sb = new StringBuilder();

                for(var elem : array) {
                        sb.append(elem).append(" ");
                }

                return sb.deleteCharAt(sb.length() - 1).toString();
        }

	private static void say(String s) {
	       System.out.println(s);
	}
}
