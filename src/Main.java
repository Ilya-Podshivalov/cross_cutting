import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] argc) throws FileNotFoundException {
        DataBase dataBase = DataBase.getInstance();
        Reader reader = new Reader("input.txt");
        dataBase.AddData(reader.ReadData());
        DataBase.Print();
    }
}
