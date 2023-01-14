import java.io.FileNotFoundException;
import java.io.IOException;
import Reader.ZIPArchiving;
import Reader.Reader;
import Reader.Encryption;
import de.congrace.exp4j.UnknownFunctionException;
import de.congrace.exp4j.UnparsableExpressionException;
import org.json.simple.parser.ParseException;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;

public class Main {
    public static void main(String[] argc) throws IOException, ParseException, ParserConfigurationException, SAXException, UnparsableExpressionException, UnknownFunctionException {
        DataBase dataBase = DataBase.getInstance();
        Reader reader = new Reader();
        dataBase.AddData(reader.ReadData("input.json.zip.zip.enc.enc.enc.zip.enc.enc.enc"));
        MathExample mathExample = new MathExample();
        mathExample.Calculate(DataBase.exampleList);
    }
}
