package tests;

import Reader.ReaderJSON;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class ReaderJSONTest {

    @Test
    public void readData() {
        ArrayList<String> expectedList = new ArrayList<>();
        ArrayList<String> actualList = new ArrayList<>();
        expectedList.add("231 + 2 + 3 * 5 + (3 * 2) + 2");
        expectedList.add("8 + 3*(5 + 8) + 3 * 3");
        expectedList.add("3 + 2 + 5");
        ReaderJSON readerJSON = new ReaderJSON();
        actualList = readerJSON.ReadData("C:\\Users\\Lenovo\\IdeaProjects\\cross_cutting\\src\\tests\\files\\input.json");
        assertEquals(expectedList, actualList);
    }

    @Test
    public void writeData() {
    }
}