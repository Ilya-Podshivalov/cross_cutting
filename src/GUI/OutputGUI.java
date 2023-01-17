package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.io.IOException;

import Reader.Reader;
import Reader.ReaderJSON;
import de.congrace.exp4j.UnknownFunctionException;
import de.congrace.exp4j.UnparsableExpressionException;
import org.json.simple.parser.ParseException;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;

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
    private ArrayList<String> EncArhList;

    public OutputGUI(JFrame frame, String nameFile) {
        EncArhList = new ArrayList<>();
        ButtonGroup radioGroup = new ButtonGroup();
        radioGroup.add(XMLRadioButton);
        radioGroup.add(TXTRadioButton);
        radioGroup.add(JSONRadioButton);
        INPUTButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame newFrame = new JFrame("Calculator");
                newFrame.setContentPane(new InputGUI(newFrame).panel);
                newFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                newFrame.pack();
                newFrame.setVisible(true);
                frame.dispose();
            }
        });
        completeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DataBase dataBase = DataBase.getInstance();
                MathExample mathExample = new MathExample();
                Reader reader = new Reader();
                try {
                    dataBase.AddData(reader.ReadData(nameFile));
                } catch (IOException | ParserConfigurationException | SAXException | ParseException ex) {
                    throw new RuntimeException(ex);
                }
                if(JSONRadioButton.isSelected()) {
                    ReaderJSON readerJSON = new ReaderJSON();
                    try {
                        readerJSON.WriteData("outputrr.json", mathExample.Calculate(DataBase.exampleList));
                    } catch (UnparsableExpressionException | UnknownFunctionException ex) {
                        throw new RuntimeException(ex);
                    }
                }

            }
        });
        encryptionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EncArhList.add("enc");
                encArh.setText(convertStringList(EncArhList));
            }
        });
        arhiveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EncArhList.add("arh");
                encArh.setText(convertStringList(EncArhList));
            }
        });
    }
    public String convertStringList(ArrayList<String> stringList){
        String string = new String();
        for(int i = 0; i < stringList.size(); i++){
            string +=   stringList.get(i) + " + ";
        }
        return string.substring(0, string.length() - 2);
    }
}
