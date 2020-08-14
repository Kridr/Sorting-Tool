package sorting;

import java.io.FileNotFoundException;

public class Main {
    public static void main(final String[] args) throws FileNotFoundException {
        Facade facade = new Facade();

        facade.processTask(args);
    }

}
