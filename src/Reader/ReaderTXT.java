package Reader;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ReaderTXT implements IReader{
    public ArrayList<String> ReadData(String nameFile) throws FileNotFoundException {
        File inputFile = new File(nameFile);
        Scanner scanner = new Scanner(inputFile);
        ArrayList<String> exampleList = new ArrayList<>();
        while (scanner.hasNextLine()) {
            exampleList.add(scanner.nextLine());
        }
        return exampleList;
    }
}
