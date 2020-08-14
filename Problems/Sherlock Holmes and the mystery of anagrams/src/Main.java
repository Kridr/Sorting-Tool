import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean answer = Objects.equals(toMap(scanner.nextLine().toLowerCase()),
                toMap(scanner.nextLine().toLowerCase()));

        System.out.println(answer ? "yes" : "no");
    }

    public static Map<Character, Integer> toMap(String word) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < word.length(); i++) {
            char letter = word.charAt(i);
            map.put(letter, map.getOrDefault(letter, 0) + 1);
        }
        return map;
    }
}