import javax.swing.*;
import GUI.InputGUI;
public class Main {
    public static void main(String[] argc){
        JFrame frame = new JFrame("Calculator");
        frame.setContentPane(new InputGUI(frame, "Name file or path").panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }
}
