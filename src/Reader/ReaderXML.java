package Reader;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ReaderXML implements IReader{
    public ArrayList<String> ReadData(String nameFile) throws IOException, SAXException, ParserConfigurationException, ParserConfigurationException, IOException, SAXException {
        ArrayList<String> exampleList = new ArrayList<>();
        DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document document = documentBuilder.parse(nameFile);
        Node root = document.getDocumentElement();
        NodeList examples = root.getChildNodes();
        for (int i = 0; i < examples.getLength(); i++) {
            Node example = examples.item(i);
            if (example.getNodeType() != Node.TEXT_NODE) {
                exampleList.add(example.getChildNodes().item(0).getTextContent());
            }
        }
        return exampleList;
    }
    public String WriteData(String nameFile, ArrayList<Double> resultList) throws XMLStreamException, IOException {
        XMLOutputFactory output = XMLOutputFactory.newInstance();
        XMLStreamWriter writer = output.createXMLStreamWriter(new FileWriter(nameFile + ".xml"));
        writer.writeStartDocument("UTF-8", "1.0");
        for (int i = 0; i < resultList.size(); i++) {
            writer.writeStartElement("result");
            writer.writeCharacters(Double.toString(resultList.get(i)));
            writer.writeEndElement();
        }
        writer.writeEndDocument();
        writer.flush();
        return nameFile + ".xml";
    }
}
