package Reader;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.util.ArrayList;

public class ReaderJSON implements IReader{
    public ArrayList<String> ReadData(String nameFile){
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
