package tests;

import Reader.ZIPArchiving;
import org.junit.Test;

import static org.junit.Assert.*;

public class ZIPArchivingTest {

    @Test
    public void unArchive() {
        ZIPArchiving archiving = new ZIPArchiving();
        String actualName = archiving.UnArchive("C:\\Users\\Lenovo\\IdeaProjects\\cross_cutting\\src\\tests\\files\\input.json.zip");
        String expectedName = "C:\\Users\\Lenovo\\IdeaProjects\\cross_cutting\\src\\tests\\files\\input.json";
        assertEquals(actualName, expectedName);
    }

    @Test
    public void archive() {
        ZIPArchiving archiving = new ZIPArchiving();
        String actualName = archiving.Archive("C:\\Users\\Lenovo\\IdeaProjects\\cross_cutting\\src\\tests\\files\\input.json");
        String expectedName = "C:\\Users\\Lenovo\\IdeaProjects\\cross_cutting\\src\\tests\\files\\input.json.zip";
        assertEquals(actualName, expectedName);
    }
}