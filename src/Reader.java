import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Reader {
    private String fileName;
    public Reader(){
        this.fileName = null;
    }
    public Reader(String fileName){
        this.fileName = fileName;
    }
    public ArrayList<String> ReadData() throws FileNotFoundException {
        File inputFile = new File(fileName);
        Scanner scanner = new Scanner(inputFile);
        ArrayList<String> exampleList = new ArrayList<String>();
        while (scanner.hasNextLine()) {
            exampleList.add(scanner.nextLine());
        }
        return exampleList;
    }
}
