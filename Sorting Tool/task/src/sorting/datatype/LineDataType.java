package sorting.datatype;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class LineDataType extends DataType {
    List<String> data;

    public LineDataType(String inpFile) throws FileNotFoundException {
        data = new ArrayList<>();
        if (Objects.equals(inpFile, "")) {
            scanner = new Scanner(System.in);
        } else {
            scanner = new Scanner(new File(inpFile));
        }
    }

    @Override
    public String sortByCount() {
        Map<String, Integer> dataToCount = new HashMap<>();

        data.forEach(elem -> dataToCount.put(elem, dataToCount.getOrDefault(elem, 0) + 1));

        Map<Integer, List<String>> countToData = new TreeMap<>();

        dataToCount.forEach((key, value) -> {
            if (!countToData.containsKey(value)) {
                countToData.put(value, new ArrayList<>());
            }
            countToData.get(value).add(key);
        });

        StringBuilder out = new StringBuilder();
        out.append("Total numbers: ").append(data.size());
        out.append("\n");
        countToData.forEach((key, value) -> {
            Collections.sort(value);

            int percents = key * 100 / data.size();

            for (var elem : value) {
                out.append(elem).append(": ").append(key).append("time(s), ").append(percents).append("%\n");
            }
        });

        scanner.close();
        return out.toString();
    }

    @Override
    public String sortNaturally() {
        Collections.sort(data);

        StringBuilder out = new StringBuilder();
        out.append("Total lines ").append(data.size()).append(".\n");
        out.append("Sorted data: \n");
        data.forEach(elem -> out.append(elem).append("\n"));

        scanner.close();
        return out.toString();
    }

    @Override
    public void input() {
        while(scanner.hasNextLine()) {
            data.add(scanner.nextLine());
        }
    }
}
