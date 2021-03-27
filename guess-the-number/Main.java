import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        try(var reader = new BufferedReader(new InputStreamReader(System.in))) {
            int count = 0;
            int m;
            int l = 0;
            int r = 1_000_001;
            while (r - l > 1 && count < 25) {

                m = (r + l) / 2;
                System.out.println(m);
                System.out.flush();

                String command = reader.readLine();

                switch (command) {
                    case "<":
                        r = m;
                        count++;
                        continue;
                    case ">=":
                        l = m;
                        count++;
                        continue;
                    default:
                        throw new UnsupportedOperationException("bad response. it can be '<' or '>='");
                }

            }
            l = Math.max(l, 0);
            System.out.println("! " + l);

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