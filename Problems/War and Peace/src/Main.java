import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine()
                .toLowerCase()
                .split(" ");

        Map<String, Integer> map = new HashMap<>();

        for (var word : input) {
            if (map.containsKey(word)) {
                map.put(word, map.get(word) + 1);
            } else {
                map.put(word, 1);
            }
        }

        map.forEach((key, value) -> System.out.println(key + " " + value));
    }
}