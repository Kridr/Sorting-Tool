import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        scanner.nextLine();

        Set<String> set = new TreeSet<>();

        for (int i = 0; i < n; i++) {
            set.add(scanner.nextLine());
        }

        set.forEach(System.out::println);
    }
}