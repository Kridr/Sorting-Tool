import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        System.out.println(mergeSort(0, n));
    }

    public static int mergeSort(int left, int right) {
        if (right <= left + 1) {
            return 0;
        }

        int middle = left + (right - left) / 2;

        return 1 +
        mergeSort(left, middle) +
        mergeSort(middle, right);
    }
}