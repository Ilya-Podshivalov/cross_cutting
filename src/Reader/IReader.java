package Reader;

import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public interface IReader {
     ArrayList<String> ReadData(String nameFile) throws IOException, ParseException;
}
