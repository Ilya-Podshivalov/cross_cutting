package Reader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Reader implements IReader{
    private String fileName;
    public Reader(){
        this.fileName = null;
    }
    //public Reader(String fileName){
  //     this.fileName = fileName;
  //  }
    public ArrayList<String> ReadData(String nameFile) throws IOException, ParseException {
        ArrayList<String> exampleList = new ArrayList<>();
        if(nameFile.endsWith("txt")){
            exampleList = ReadDataTXT(nameFile);
        }
        else if(nameFile.endsWith("json")) {
            exampleList = ReadDataJSon(nameFile);
        }
        return exampleList;
    }
    public ArrayList<String> ReadDataTXT(String nameFile) throws FileNotFoundException {
        File inputFile = new File(nameFile);
        Scanner scanner = new Scanner(inputFile);
        ArrayList<String> exampleList = new ArrayList<>();
        while (scanner.hasNextLine()) {
            exampleList.add(scanner.nextLine());
        }
        return exampleList;
    }
    public ArrayList<String> ReadDataJSon(String nameFile) throws IOException, ParseException {
        ArrayList<String> exampleList = new ArrayList<>();
        JSONParser parser = new JSONParser();
        try( FileReader reader = new FileReader(nameFile)) {
            JSONObject rootJSONObject = (JSONObject) parser.parse(reader);
            JSONArray exampleJSONArray = (JSONArray) rootJSONObject.get("MathExample");
            for (Object it : exampleJSONArray) {
                JSONObject exampleJSONObject = (JSONObject) it;
                exampleList.add((String) exampleJSONObject.get("example"));
            }
        }catch(Exception e) {
            e.printStackTrace();
        }
        return exampleList;
    }

}
