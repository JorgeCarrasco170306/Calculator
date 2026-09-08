import javax.swing.*;

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

        add(buttonPanel, BorderLayout.CENTER);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();

        // Si es un número
        if (comando.charAt(0) >= '0' && comando.charAt(0) <= '9') {
            screen.setText(screen.getText() + comando);
            return;
        }

        // Limpiar screen
        if (comando.equals("C")) {
            screen.setText("");
            num1 = num2 = result = 0;
            operator = ' ';
            return;
        }

        // Ejecutar cálculo
        if (comando.equals("=")) {
            if (!screen.getText().isEmpty() && operator != ' ') {
                num2 = Double.parseDouble(screen.getText());
                switch (operator) {
                    case '+':
                        result = num1 + num2;
                        break;
                    case '-':
                        result = num1 - num2;
                        break;
                    case '*':
                        result = num1 * num2;
                        break;
                    case '/':
                        if (num2 != 0) {
                            result = num1 / num2;
                        } else {
                            screen.setText("Error");
                            return;
                        }
                        break;
                }
                screen.setText(String.valueOf(result));
                operator = ' ';
            }
            return;
        }

        // Guardar operator y primer número
        if (!screen.getText().isEmpty()) {
            num1 = Double.parseDouble(screen.getText());
            operator = comando.charAt(0);
            screen.setText("");
        }
    }

    public static void main(String[] args) {
        // Asegura que la interfaz corra en el Event Dispatch Thread
        SwingUtilities.invokeLater(() -> {
            new App().setVisible(true);
        });
    }
}
