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
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class Reader implements IReader{
    private String fileName;
    public Reader(){
        this.fileName = null;
    }
    //public Reader(String fileName){
  //     this.fileName = fileName;
  //  }
    public ArrayList<String> ReadData(String nameFile) throws IOException, ParseException, ParserConfigurationException, SAXException {
        ArrayList<String> exampleList = new ArrayList<>();
        if(nameFile.endsWith("txt")){
            exampleList = ReadDataTXT(nameFile);
        }
        else if(nameFile.endsWith("json")) {
            exampleList = ReadDataJSon(nameFile);
        }
        else if(nameFile.endsWith("xml")) {
            exampleList = ReadDataXML(nameFile);
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
    public ArrayList<String> ReadDataXML(String nameFile) throws IOException, SAXException, ParserConfigurationException {
        ArrayList<String> exampleList = new ArrayList<>();
        DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document document = documentBuilder.parse(nameFile);
        Node root = document.getDocumentElement();
        NodeList examples = root.getChildNodes();
        for (int i = 0; i < examples.getLength(); i++) {
            Node example = examples.item(i);
            if (example.getNodeType() != Node.TEXT_NODE) {
                exampleList.add(example.getChildNodes().item(0).getTextContent());
            }
        }


        return exampleList;
    }
}
