package Reader;

import org.json.simple.parser.ParseException;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLStreamException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public interface IReader {
     ArrayList<String> ReadData(String nameFile) throws IOException, ParseException, ParserConfigurationException, SAXException;
     String WriteData(String nameFile, ArrayList<Double> resultList) throws XMLStreamException, IOException;
}
