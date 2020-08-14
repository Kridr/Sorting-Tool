import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int d = scanner.nextInt();
        Set<String> dictionary = new HashSet<>();
        for (int i = 0; i < d; i++) {
            dictionary.add(scanner.next());
        }

        int l = scanner.nextInt();
        scanner.nextLine();
        Set<String> words = new HashSet<>();
        for (int i = 0; i < l; i++) {
            words.addAll(Arrays.asList(scanner
                    .nextLine()
                    .split(" ")));
        }

        Set<String> erroneous = new HashSet<>(words);

        erroneous.removeIf(elem -> containsIgnoreCase(elem, dictionary));

        erroneous.forEach(System.out::println);
    }

    public static boolean containsIgnoreCase(String elem, Set<String> set) {
        Set<String> lowerCaseSet = new HashSet<>();
        set.forEach(e -> lowerCaseSet.add(e.toLowerCase()));

        String lowerCaseElem = elem.toLowerCase();

        return lowerCaseSet.contains(lowerCaseElem);
    }
}