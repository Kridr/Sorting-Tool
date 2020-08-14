import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Integer> inputList = readArrayList(scanner);

        int n = scanner.nextInt();

        int minDist = Math.abs(n - inputList.get(0));

        ArrayList<Integer> minDistElems = new ArrayList<>();

        for (var elem : inputList) {
            int dist = Math.abs(n - elem);

            if (dist == minDist) {
                minDistElems.add(elem);
            } else if (dist < minDist) {
                minDist = dist;
                minDistElems.clear();
                minDistElems.add(elem);
            }
        }

        Collections.sort(minDistElems);

        for (var elem : minDistElems) {
            System.out.print(elem + " ");
        }
    }

    private static ArrayList<Integer> readArrayList(Scanner scanner) {
        return Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayList::new));
    }
}