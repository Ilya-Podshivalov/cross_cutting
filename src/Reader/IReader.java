package Reader;

import org.json.simple.parser.ParseException;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public interface IReader {
     ArrayList<String> ReadData(String nameFile) throws IOException, ParseException, ParserConfigurationException, SAXException;
     void WriteData(String nameFile, ArrayList<Double> resultList);
}
