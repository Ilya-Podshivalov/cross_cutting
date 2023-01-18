package tests;

import Reader.Reader;
import org.json.simple.parser.ParseException;
import org.junit.Test;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class ReaderTest {

    @Test
    public void readData() throws IOException, ParseException, ParserConfigurationException, SAXException {
        ArrayList<String> expectedList = new ArrayList<>();
        ArrayList<String> actualList = new ArrayList<>();
        expectedList.add("231 + 2 + 3 * 5 + (3 * 2) + 2");
        expectedList.add("8 + 3*(5 + 8) + 3 * 3");
        expectedList.add("3 + 2 + 5");
        Reader reader = new Reader();
        actualList = reader.ReadData("C:\\Users\\Lenovo\\IdeaProjects\\cross_cutting\\src\\tests\\files\\readerTest.json.zip.zip.enc");
        assertEquals(actualList, expectedList);
    }
}