import java.io.FileNotFoundException;
import java.io.IOException;

import Reader.Reader;
import Reader.Encryption;
import org.json.simple.parser.ParseException;

public class Main {
    public static void main(String[] argc) throws IOException, ParseException {
        DataBase dataBase = DataBase.getInstance();
        Reader reader = new Reader();
        dataBase.AddData(reader.ReadData("input.json"));
        DataBase.Print();
        /*Encryption enc = new Encryption();
        enc.Encode("input.txt");
        enc.Decode("input.txt.enc");*/

    }
}
