package tests;

import Reader.ReaderTXT;
import Reader.ReaderXML;
import org.junit.Test;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class ReaderXMLTest {

    @Test
    public void readData() throws IOException, ParserConfigurationException, SAXException {
        ArrayList<String> expectedList = new ArrayList<>();
        ArrayList<String> actualList = new ArrayList<>();
        expectedList.add("32 + 4 - 3 + 5 * 14");
        expectedList.add("84 + 2 * 32");
        expectedList.add("34848384");
        ReaderXML readerXML = new ReaderXML();
        actualList = readerXML.ReadData("C:\\Users\\Lenovo\\IdeaProjects\\cross_cutting\\src\\tests\\files\\input.xml");
        assertEquals(expectedList, actualList);
    }

    @Test
    public void writeData() {
    }
}