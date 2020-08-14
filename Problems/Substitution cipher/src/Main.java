import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String origAlphabet = scanner.nextLine();
        String encodedAlphabet = scanner.nextLine();

        String origMessage = scanner.nextLine();
        String encodedMessage = scanner.nextLine();

        Map<Character, Character> alphabet = new HashMap<>();
        Map<Character, Character> reverseAlphabet = new HashMap<>();
        for (int i = 0; i < origAlphabet.length(); i++) {
            alphabet.put(origAlphabet.charAt(i), encodedAlphabet.charAt(i));
            reverseAlphabet.put(encodedAlphabet.charAt(i), origAlphabet.charAt(i));
        }

        for (int i = 0; i < origMessage.length(); i++) {
            System.out.print(alphabet.get(origMessage.charAt(i)));
        }

        System.out.println();

        for (int i = 0; i < encodedMessage.length(); i++) {
            System.out.print(reverseAlphabet.get(encodedMessage.charAt(i)));
        }
    }
}