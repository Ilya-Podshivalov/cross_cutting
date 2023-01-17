import java.io.FileNotFoundException;
import java.io.IOException;
import Reader.ZIPArchiving;
import Reader.Reader;
import Reader.Encryption;
import Reader.ReaderJSON;
import de.congrace.exp4j.UnknownFunctionException;
import de.congrace.exp4j.UnparsableExpressionException;
import org.json.simple.parser.ParseException;
import org.xml.sax.SAXException;

import javax.swing.*;
import javax.xml.parsers.ParserConfigurationException;
import GUI.InputGUI;
import GUI.OutputGUI;
public class Main {
    public static void main(String[] argc) throws IOException, ParseException, ParserConfigurationException, SAXException, UnparsableExpressionException, UnknownFunctionException {
       /* DataBase dataBase = DataBase.getInstance();
        Reader reader = new Reader();
        dataBase.AddData(reader.ReadData("C:/Users/Lenovo/input.json.zip.zip.enc.enc.enc.zip.enc.enc.enc.zip"));
        MathExample mathExample = new MathExample();
        ReaderJSON readerJSON = new ReaderJSON();
        readerJSON.WriteData("output.json", mathExample.Calculate(DataBase.exampleList));*/
         JFrame frame = new JFrame("Calculator");
        frame.setContentPane(new InputGUI(frame).panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }
}
