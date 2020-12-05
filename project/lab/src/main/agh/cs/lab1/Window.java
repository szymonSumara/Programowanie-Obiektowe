package agh.cs.lab1;

import javax.swing.*;
import java.awt.*;

public class Window {

    private JFrame frame = new JFrame("HelloWorldSwing");
    private JTextArea textArea = new JTextArea(20, 30);

    public Window(JLabel label){
        textArea.setEditable(false);
        Font f1  = new Font(Font.DIALOG_INPUT, Font.PLAIN,  25);
        textArea.setFont(f1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(textArea);
        frame.pack();
        frame.setVisible(true);
    }

    public void updateContent(String content){
        textArea.setText(content);;
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
