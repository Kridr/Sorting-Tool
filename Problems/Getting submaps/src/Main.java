import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int left = scanner.nextInt();
        int right = scanner.nextInt();

        int size = scanner.nextInt();

        Map<Integer, String> map = new TreeMap<>();

        for (int i = 0; i < size; i++) {
            int key = scanner.nextInt();
            String value = scanner.next();

            if (left <= key && key <= right) {
                map.put(key, value);
            }
        }

        map.forEach((k, v) -> System.out.println(k + " " + v));
    }
}