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
    public ArrayList<String> ReadData(String nameFile) throws IOException, ParseException, ParserConfigurationException, SAXException {
        ArrayList<String> exampleList = new ArrayList<>();
        while(nameFile.endsWith(".enc") || nameFile.endsWith(".zip")){
            if(nameFile.endsWith(".zip")) {
                ZIPArchiving archiving = new ZIPArchiving();
                 nameFile = archiving.UnArchive(nameFile);
                 System.out.println(nameFile);
            }
            if(nameFile.endsWith(".enc")){
                Encryption enc = new Encryption();
                nameFile = enc.Decode(nameFile);
            }
        }
        if(nameFile.endsWith("txt")){
            ReaderTXT reader = new ReaderTXT();
            exampleList = reader.ReadData(nameFile);
        }
        else if(nameFile.endsWith("json")) {
            ReaderJSON reader = new ReaderJSON();
            exampleList = reader.ReadData(nameFile);
        }
        else if(nameFile.endsWith("xml")) {
            ReaderXML reader = new ReaderXML();
            exampleList = reader.ReadData(nameFile);
        }
        return exampleList;
    }
}
