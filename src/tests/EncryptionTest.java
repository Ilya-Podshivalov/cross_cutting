package tests;
import Reader.Encryption;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class EncryptionTest {

    @Test
    public void encode() {
        Encryption encryption = new Encryption();
        String newFile;
        newFile = encryption.Encode("C:\\Users\\Lenovo\\IdeaProjects\\cross_cutting\\src\\tests\\files\\encodeTest.json");
        assertEquals("C:\\Users\\Lenovo\\IdeaProjects\\cross_cutting\\src\\tests\\files\\encodeTest.json.enc",newFile);
    }

    @Test
    public void decode() throws IOException {
        Encryption encryption = new Encryption();
        String newFile;
        newFile = encryption.Decode("C:\\Users\\Lenovo\\IdeaProjects\\cross_cutting\\src\\tests\\files\\encodeTest.json.enc");
        assertEquals("C:\\Users\\Lenovo\\IdeaProjects\\cross_cutting\\src\\tests\\files\\encodeTest.json",newFile);
    }
}