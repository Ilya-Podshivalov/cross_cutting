import java.io.FileNotFoundException;
import java.io.IOException;

import Reader.Reader;
import Reader.Encryption;
import org.json.simple.parser.ParseException;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;

public class Main {
    public static void main(String[] argc) throws IOException, ParseException, ParserConfigurationException, SAXException {
        DataBase dataBase = DataBase.getInstance();
        Reader reader = new Reader();
        dataBase.AddData(reader.ReadData("input.xml"));
        DataBase.Print();
        /*Encryption enc = new Encryption();
        enc.Encode("input.txt");
        enc.Decode("input.txt.enc");*/

    }
}
