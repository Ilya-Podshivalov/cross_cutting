package GUI;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InputGUI {
    private String nameFile;
    public JPanel panel;
    private JButton INPUTButton;
    private JButton OUTPUTButton;
    private JTextField nameInputFile;
    private JButton exitButton;
    private JButton chooseFileButton;
    private JButton resetButton;

    public InputGUI(JFrame frame, String nameFile) {
        nameInputFile.setText(nameFile);
        OUTPUTButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(nameInputFile.getText().endsWith(".json") ||
                        nameInputFile.getText().endsWith(".xml")||
                        nameInputFile.getText().endsWith(".txt") ||
                        nameInputFile.getText().endsWith(".enc") ||
                        nameInputFile.getText().endsWith(".zip")) {
                    JFrame newFrame = new JFrame("Calculator");
                    newFrame.setContentPane(new OutputGUI(newFrame, nameInputFile.getText()).panel);
                    newFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    newFrame.pack();
                    newFrame.setVisible(true);
                    frame.dispose();
                } else
                    nameInputFile.setText("name file incorrect");
            }
        });
        chooseFileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser j = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
                int r = j.showOpenDialog(null);
                if (r == JFileChooser.APPROVE_OPTION)
                    nameInputFile.setText(j.getSelectedFile().getAbsolutePath());
            }
        });
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nameInputFile.setText("Name file or path");
            }
        });
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
            }
        });
    }
}
