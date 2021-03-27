import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        try(var reader = new BufferedReader(new InputStreamReader(System.in))) {

            var sizes = reader.readLine().split(" ");
            int firstArraySize = Integer.parseInt(sizes[0]);
            int secondArraySize = Integer.parseInt(sizes[1]);

            if (firstArraySize < 2 || secondArraySize < 2) {
                System.out.println("NO");
                return;
            }

            var sortedArrayStr = reader.readLine().split(" ");
            var elemsStr = reader.readLine().split(" ");

            var sorterArray = new Integer[sortedArrayStr.length];
            for (int i = 0; i < sortedArrayStr.length; i++) {
                sorterArray[i] = Integer.parseInt(sortedArrayStr[i]);
            }

            for (String elemStr : elemsStr) {
                Integer elem = Integer.parseInt(elemStr);
                int elemIndx = search(sorterArray, elem);
                if (elemIndx != -1) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int search(Integer[] array, Integer elem) {

        int l = 0;
        int r = array.length - 1;
        int m;

        while(l <= r) {

            m = l + (r - l) / 2;

            Integer middleElem = array[m];

            if (middleElem.equals(elem)) {
                return m;
            } else if (elem < middleElem) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }

        return -1;
    }
}
