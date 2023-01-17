package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InputGUI {
    private String nameFile;
    public JPanel panel;
    private JButton INPUTButton;
    private JButton OUTPUTButton;
    private JTextField nameFileOrPathTextField;
    private JButton exitButton;
    private JButton chooseFileButton;
    private JButton resetButton;

    public InputGUI(JFrame frame) {
        OUTPUTButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame newFrame = new JFrame("Calculator");
                newFrame.setContentPane(new OutputGUI(newFrame, nameFileOrPathTextField.getText()).panel);
                newFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                newFrame.pack();
                newFrame.setVisible(true);
                frame.dispose();
            }
        });
    }
}
