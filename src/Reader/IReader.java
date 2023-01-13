package Reader;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public interface IReader {
     ArrayList<String> ReadData(String nameFile) throws FileNotFoundException;
}
