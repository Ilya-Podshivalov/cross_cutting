package Reader;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Reader implements IReader{
    private String fileName;
    public Reader(){
        this.fileName = null;
    }
    //public Reader(String fileName){
  //     this.fileName = fileName;
  //  }
    public ArrayList<String> ReadData(String nameFile) throws FileNotFoundException {
        File inputFile = new File(nameFile);
        Scanner scanner = new Scanner(inputFile);
        ArrayList<String> exampleList = new ArrayList<String>();
        while (scanner.hasNextLine()) {
            exampleList.add(scanner.nextLine());
        }
        return exampleList;
    }

}
