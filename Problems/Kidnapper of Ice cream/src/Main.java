import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> newspaper = toMap(scanner.nextLine());
        Map<String, Integer> message = toMap(scanner.nextLine());

        boolean[] okWithWords = {true};
        message.forEach((key, value) -> {
            if (newspaper.getOrDefault(key, 0) < value) {
                okWithWords[0] = false;
            }
        });

        System.out.println(
                okWithWords[0] ?
                "You get money" :
                "You are busted"
        );
    }

    public static Map<String, Integer> toMap(String line) {
        Map<String, Integer> map = new HashMap<>();
        for (var word : line.split("\\s")) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        return map;
    }
}