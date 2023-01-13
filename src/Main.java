import java.io.FileNotFoundException;
import java.io.IOException;

import Reader.Reader;
import Reader.Encryption;
public class Main {
    public static void main(String[] argc) throws IOException {
      /*  DataBase dataBase = DataBase.getInstance();
        Reader reader = new Reader();
        dataBase.AddData(reader.ReadData("input.txt"));
        DataBase.Print();*/
        Encryption enc = new Encryption();
        enc.Encode("input.txt");
        enc.Decode("input.txt.enc");

    }
}
