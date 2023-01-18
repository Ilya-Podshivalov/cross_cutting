package tests;

import Reader.ReaderJSON;
import Reader.ReaderTXT;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class ReaderTXTTest {

    @Test
    public void readData() throws FileNotFoundException {
        ArrayList<String> expectedList = new ArrayList<>();
        ArrayList<String> actualList = new ArrayList<>();
        expectedList.add("4 + 2 * (2 - 5) + 239393");
        expectedList.add("823 - 2 / 5 + 23 * 7 / 2");
        ReaderTXT readerTXT = new ReaderTXT();
        actualList = readerTXT.ReadData("C:\\Users\\Lenovo\\IdeaProjects\\cross_cutting\\src\\tests\\files\\input.txt");
        assertEquals(expectedList, actualList);
    }

    @Test
    public void writeData() {
    }
}