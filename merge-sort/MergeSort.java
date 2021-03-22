import java.lang.StringBuilder;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class MergeSort {

	public static void main(String[] args) {

		try(var reader = new BufferedReader(new InputStreamReader(System.in))) {
			
			reader.readLine();

			var arrStr = reader.readLine().split(" ");

			var arr = new Integer[arrStr.length];
			for(int i = 0; i < arr.length; i++) {
				arr[i] = Integer.parseInt(arrStr[i]);
			}

			var result = sort(arr, 0, arr.length);

			say(toStr(result));


		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static Integer[] sort(Integer[] array, int l, int r) {
		
		if(array.length < 2) {
			return array;
		}

		int m = l + (r - l) / 2;

		Integer[] leftHalf = new Integer[l + m];
		Integer[] rightHalf = new Integer[r - m];
	
		for(int i = 0; i < leftHalf.length; i++){ 
			leftHalf[i] = array[l + i];
		}
		
		for(int i = 0; i < rightHalf.length; i++) {
			rightHalf[i] = array[m + i];
		}
			
		return merge(array, sort(leftHalf, 0, leftHalf.length), sort(rightHalf, 0, rightHalf.length), l);
	}



	private static Integer[] merge(Integer[] array, Integer[] left, Integer[] right, int l) {

		int p = l;

		int i = 0;
		int j = 0;

		while(i < left.length && j < right.length) {
			
			if(left[i] < right[j]) {
				array[p++] = left[i++];
			} else {
				array[p++] = right[j++];
			}
		}

		while(i < left.length) {
			array[p++] = left[i++];
		}

		while(j < right.length) {
			array[p++] = right[j++];
		}

		return array;
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
