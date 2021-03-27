import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        try(var reader = new BufferedReader(new InputStreamReader(System.in))) {

            var sizes = reader.readLine().split(" ");
            int firstArraySize = Integer.parseInt(sizes[0]);
            int secondArraySize = Integer.parseInt(sizes[1]);

            if (firstArraySize < 2 || secondArraySize < 1) {
                return;
            }

            var sortedArrayStr = reader.readLine().split(" ");
            var elemsStr = reader.readLine().split(" ");

            var sortedArray = new Integer[sortedArrayStr.length];
            for (int i = 0; i < sortedArrayStr.length; i++) {
                sortedArray[i] = Integer.parseInt(sortedArrayStr[i]);
            }

            for (String elemStr : elemsStr) {
                Integer elem = Integer.parseInt(elemStr);
                int elemIndx = search(sortedArray, elem);
                System.out.println(sortedArray[elemIndx]);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int search(Integer[] array, Integer elem) {

        int l = -1;
        int r = array.length;
        int m;

        while(r - l > 1) {

            m = (l + r) / 2;

            Integer middleElem = array[m];

            if (middleElem.equals(elem)) {
                return m;
            } else if (elem > middleElem) {
                l = m;
            } else {
                r = m;
            }
        }

        System.out.flush();

        if (l >= 0 && r < array.length && elem - array[l] <= array[r] - elem) {
            return l;
        }

        return Math.min(r, array.length - 1);
    }
}
