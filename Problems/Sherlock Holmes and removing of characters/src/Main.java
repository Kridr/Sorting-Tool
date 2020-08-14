import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //character - occurrences in each word
        Map<Character, ArrayList<Integer>> occurrences = new HashMap<>();

        //first, we process word to find all unique symbols
        ArrayList<String> listOfWords = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String word = scanner.nextLine().toLowerCase();

            for (int i = 0; i < word.length(); i++) {
                occurrences.put(word.charAt(i), new ArrayList<>());
            }

            listOfWords.add(word);
        }

        //second, we find occurrences of symbols in each word
        for (var word : listOfWords) {
            Map<Character, Integer> innerOccurrences = new HashMap<>();
            occurrences.forEach((key, v) -> innerOccurrences.put(key, 0));

            for (int i = 0; i < word.length(); i++) {
                char letter = word.charAt(i);

                innerOccurrences.put(letter, innerOccurrences.get(letter) + 1);
            }

            occurrences.forEach((key, value) -> value.add(innerOccurrences.get(key)));
        }

        int incompleteCharacters = 0;

        //third, we find difference between occurrences of each word and "such word"
        for (var list : occurrences.values()) {
            int min = Collections.min(list);
            for (var elem : list) {
                incompleteCharacters += elem - min;
            }
        }

        System.out.println(incompleteCharacters);
    }
}