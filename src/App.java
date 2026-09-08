import javax.swing.*;
import javax.swing.plaf.basic.BasicArrowButton;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App extends JFrame implements ActionListener {

    private JTextField screen;
    private double num1 = 0, num2 = 0, result = 0;
    private char operator = ' ';

    public App() {

        setTitle("Calculator");
        setSize(320, 420);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        screen = new JTextField();
        screen.setEditable(false);
        screen.setFont(new Font("Monospaced", Font.BOLD, 28));
        screen.setHorizontalAlignment(JTextField.RIGHT);
        screen.setBackground(new Color(230, 230, 230));

        add(screen, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4, 4, 8, 8));

        String[] buttons = {
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                "C", "0", "=", "+"
        };

        for (String button : buttons) {
            JButton b = new JButton(button);
            b.setFont(new Font("Arial", Font.BOLD, 20));
            b.setFocusPainted(false);
            b.addActionListener(this);
            buttonPanel.add(b);
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }

    public static void main(String[] args) throws Exception {
        new App();
    }
}
