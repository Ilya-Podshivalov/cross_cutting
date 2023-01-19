package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.io.IOException;

import Reader.Reader;
import Reader.ReaderJSON;
import Reader.*;
import de.congrace.exp4j.UnknownFunctionException;
import de.congrace.exp4j.UnparsableExpressionException;
import org.json.simple.parser.ParseException;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLStreamException;

import DataBase.DataBase;
import MathExample.MathExample;
public class OutputGUI {
    public JPanel panel;
    private JButton INPUTButton;
    private JButton OUTPUTButton;
    private JButton exitButton;
    private JButton resetButton;
    private JButton encryptionButton;
    private JButton arhiveButton;
    private JTextField encArh;
    private JRadioButton XMLRadioButton;
    private JRadioButton TXTRadioButton;
    private JRadioButton JSONRadioButton;
    private JButton completeButton;
    private JTextField nameOutputFile;
    private ArrayList<String> encArhList;

    public OutputGUI(JFrame frame, String nameInputFile) {
        encArhList = new ArrayList<>();
        ButtonGroup radioGroup = new ButtonGroup();
        radioGroup.add(XMLRadioButton);
        radioGroup.add(TXTRadioButton);
        radioGroup.add(JSONRadioButton);
        INPUTButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame newFrame = new JFrame("Calculator");
                newFrame.setContentPane(new InputGUI(newFrame, nameInputFile).panel);
                newFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                newFrame.pack();
                newFrame.setVisible(true);
                frame.dispose();
            }
        });
        completeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String outputFile = nameOutputFile.getText();
                DataBase dataBase = DataBase.getInstance();
                MathExample mathExample = new MathExample();
                Reader reader = new Reader();
                try {
                    dataBase.AddData(reader.ReadData(nameInputFile));
                } catch (IOException | ParserConfigurationException | SAXException | ParseException ex) {
                    throw new RuntimeException(ex);
                }
                if(JSONRadioButton.isSelected()) {
                    ReaderJSON readerJSON = new ReaderJSON();
                    try {
                        readerJSON.WriteData(outputFile, mathExample.Calculate(DataBase.exampleList));
                        outputFile = readerJSON.WriteData(outputFile, mathExample.Calculate(DataBase.exampleList));
                    } catch (UnparsableExpressionException | UnknownFunctionException ex) {
                        throw new RuntimeException(ex);
                    }
                }
                else if(XMLRadioButton.isSelected()){
                    ReaderXML readerXML = new ReaderXML();
                    try {
                        outputFile = readerXML.WriteData(outputFile, mathExample.Calculate(DataBase.exampleList));
                    } catch (UnparsableExpressionException | UnknownFunctionException | XMLStreamException |
                             IOException ex) {
                        throw new RuntimeException(ex);
                    }
                }
                else if(TXTRadioButton.isSelected()){
                    ReaderTXT readerTXT = new ReaderTXT();
                    try {
                        outputFile = readerTXT.WriteData(outputFile, mathExample.Calculate(DataBase.exampleList));
                    } catch (UnparsableExpressionException | UnknownFunctionException | IOException ex) {
                        throw new RuntimeException(ex);
                    }
                }
                Encryption encryption = new Encryption();
                ZIPArchiving archiving = new ZIPArchiving();
                for (String s : encArhList) {
                    if (s.equals("enc")) {
                        outputFile = encryption.Encode(outputFile);
                    } else if (s.equals("arh")) {
                        outputFile = archiving.Archive(outputFile);
                    }
                }

            }
        });
        encryptionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                encArhList.add("enc");
                encArh.setText(convertStringList(encArhList));
            }
        });
        arhiveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                encArhList.add("arh");
                encArh.setText(convertStringList(encArhList));
            }
        });
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                encArh.setText("");
                encArhList.clear();
            }
        });
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
            }
        });
    }
    public String convertStringList(ArrayList<String> stringList){
        String string = new String();
        for (String s : stringList) {
            string += s + " + ";
        }
        return string.substring(0, string.length() - 2);
    }
}
