package sorting;

import sorting.datatype.DataType;
import sorting.datatype.LineDataType;
import sorting.datatype.LongDataType;
import sorting.datatype.WordDataType;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;
import java.util.Set;

public class Facade {
    DataType dataType;

    void processTask(String[] args) throws FileNotFoundException {
        Set<String> availableArgs = Set.of("-sortingType", "-dataType", "-inputFile", "-outputFile");
        Set<String> availableSortingTypes = Set.of("natural", "byCount");
        Set<String> availableDataTypes = Set.of("long", "word", "line");

        //looking for invalid args
        for (var arg : args) {
            if (arg.startsWith("-")) {
                if (!availableArgs.contains(arg)) {
                    //error message
                    System.out.format("\"%s\" isn't a valid parameter. It's skipped.\n", arg);
                }
            }
        }

        int dataTypeIndex = search(args, "-dataType");
        int sortIndex = search(args, "-sortingType");


        String type = argsCheck(args, dataTypeIndex, "word", "data type", availableDataTypes);
        if (!Objects.equals(type, "")) {

            String sort = argsCheck(args, sortIndex, "natural", "sorting type", availableSortingTypes);
            if (!Objects.equals(sort, "")) {
                int inpFileIndex = search(args, "-inputFile");
                String inpFile = fileCheck(args, inpFileIndex);
                //check out DataType kids' constructors
                setType(type, inpFile);
                dataType.input();

                String outInfo;
                if (Objects.equals(sort, "natural")) {
                    outInfo = dataType.sortNaturally();
                } else {
                    outInfo = dataType.sortByCount();
                }

                int outFileIndex = search(args, "-outputFile");
                String outFile = fileCheck(args, outFileIndex);

                if (Objects.equals(outFile, "")) {
                    System.out.println(outInfo);
                } else {
                    try (PrintWriter printWriter = new PrintWriter(new File(outFile))) {
                        printWriter.println(outInfo);
                    } catch (IOException ignored) { }
                }
            }
        }
    }

    private String argsCheck(String[] args, int index, String defaultVal, String info, Set<String> available) {
        String arg = "";
        if (index < 0) {
            arg = defaultVal;
        } else if (index + 1 > args.length - 1 || args[index + 1].startsWith("-")) {
            System.out.println("No " + info + " type defined!");
        } else if (!available.contains(args[index + 1])) {
            System.out.println("Invalid " + info + " type!");
        } else {
            arg = args[index + 1];
        }

        return arg;
    }

    private String fileCheck(String[] args, int index) {
        String fileName = "";
        if (index + 1 <= args.length - 1 && !args[index + 1].startsWith("-") && index >= 0) {
            fileName = args[index + 1];
        }

        return fileName;
    }

    private int search(String[] args, String arg) {
        int index = -1;

        for (int i = 0; i < args.length; i++) {
            if (Objects.equals(arg, args[i])) {
                index = i;
                break;
            }
        }

        return index;
    }

    private void setType(String type, String inpFile) throws FileNotFoundException {
        switch (type) {
            case "long":
                dataType = new LongDataType(inpFile);
                break;
            case "word":
                dataType = new WordDataType(inpFile);
                break;
            case "line":
                dataType = new LineDataType(inpFile);
                break;
        }
    }

}
