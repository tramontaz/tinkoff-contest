import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        try(var reader = new BufferedReader(new InputStreamReader(System.in))) {

            int l = Integer.parseInt(reader.readLine());

            if(l < 2) {
                System.out.println("Poor Alex");
                return;
            }

            var laptops = new Laptop[l];
            for(int i = 0; i < l; i++) {
                var arr = reader.readLine().split(" ");
                int price = Integer.parseInt(arr[0]);
                int quality = Integer.parseInt(arr[1]);

                laptops[i] = new Laptop(price, quality);
            }

            isAlexHappy(laptops);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void isAlexHappy(Laptop[] laptops) {

        sortByPrice(laptops);

        int l = laptops.length;
        int maxQuality = laptops[0].getQuality();

        for(int i = 1; i < l; i++) {
            var laptop = laptops[i];
            int curQuality = laptop.getQuality();

            if(curQuality < maxQuality) {
                System.out.println("Happy Alex");
                return;
            } else {
                maxQuality = curQuality;
            }
        }

        System.out.println("Poor Alex");
    }

    private static void sortByPrice(Laptop[] laptops) {
        sort(laptops, 0, laptops.length);
    }
    private static void sort(Laptop[] arr, int l, int r) {


        if(arr.length < 2) {
            return;
        }

        int m = l + (r - l) / 2;

        Laptop[] left = new Laptop[l + m];
        Laptop[] right = new Laptop[r - m];

        for(int i = 0; i < left.length; i++) {
            left[i] = arr[l + i];
        }

        for(int i = 0; i < right.length; i++) {
            right[i] = arr[m + i];
        }

        sort(left, 0, left.length);
        sort(right, 0, right.length);

        merge(arr, left, right);
    }

    private static void merge(Laptop[] arr, Laptop[] left, Laptop[] right) {

        int p = 0;
        int i = 0;
        int j = 0;

        while(i < left.length && j < right.length) {

            if(left[i].getPrice() < right[j].getPrice()) {
                arr[p++] = left[i++];
            } else {
                arr[p++] = right[j++];
            }
        }

        while(i < left.length) {
            arr[p++] = left[i++];
        }

        while(j < right.length) {
            arr[p++] = right[j++];
        }
    }

    public static class Laptop {

        private final Integer price;
        private final Integer quality;

        public Laptop(Integer price, Integer quality) {
            this.price = price;
            this.quality = quality;
        }

        public Integer getPrice() {
            return this.price;
        }


        public Integer getQuality() {
            return this.quality;
        }

        public String toString() {
            return String.format("{%d %d}", this.price, this.quality);
        }
    }
}