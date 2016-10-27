package tests.GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by solbon on 17.12.2014.
 */
public class FirstGUI implements ActionListener{
    JButton button;

    public static void main(String[] args) {
        new FirstGUI().go();
    }
    public void go() {
        JFrame frame = new JFrame();
        button = new JButton("click me");
        button.addActionListener(this);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(button);
        frame.setSize(300, 300);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        button.setText("I've been pressed!");
    }
}
