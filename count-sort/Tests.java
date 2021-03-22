import java.lang.StringBuilder;

public class Tests {

	public static void main(String[] args) {
		
		Integer[] pair = {3, 0};
		test(pair);

		Integer[] triple = {3, 0, 2};
		test(triple);
		
		Integer[] four = {3, 0, 2, 5};
		test(four);

		Integer[] five = {1, 4, 7, 5, 6};
		test(five);

		Integer[] six = {1, 6, 3, 2, 5, 4};
		test(six);

		Integer[] trick = {10000, 10000, 10000, 10000, 10000};
		test(trick);

	}

	public static void test(Integer[] array) {

		System.out.printf("Original: %s.%n", CountSort.toStr(array));
		CountSort.sort(array);
		System.out.printf("Sorted: %s.%n", CountSort.toStr(array));

	}
}
