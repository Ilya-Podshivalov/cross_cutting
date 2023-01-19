package Reader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
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
    public String WriteData(String nameFile, ArrayList<Double> resultList) throws IOException {
        FileWriter output = new FileWriter(nameFile + ".txt");
        for (Double aDouble : resultList) {
            output.write(String.valueOf(aDouble));
        }
        return nameFile + ".txt";
    }
}
