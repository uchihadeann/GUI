import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;


public class PasswordValidator extends JFrame {
    private JPasswordField passwordTextField;
    private JLabel statusLabel;

    private JPanel JPanel;

    public PasswordValidator() {
        setTitle("Password Validator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(JPanel);
        pack();
        setLocationRelativeTo(null);
        statusLabel.setForeground(Color.RED);
        setVisible(true);

        passwordTextField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                String currentText = passwordTextField.getText();

                if (currentText.length() < 8) {
                    statusLabel.setForeground(Color.RED);
                    statusLabel.setText("Password must be 8 characters long");
                    return;
                }

                if (!currentText.matches(".*\\d.*")) {
                    statusLabel.setForeground(Color.RED);
                    statusLabel.setText("Password must contain at least one digit");
                    return;
                }

                if (!currentText.matches(".*[^a-zA-Z0-9\\s].*")) {
                    statusLabel.setForeground(Color.RED);
                    statusLabel.setText("Password must contain at least one special character");
                    return;
                }

                statusLabel.setForeground(Color.GREEN);
                statusLabel.setText("Password is valid");
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                String currentText = passwordTextField.getText();

                if (currentText.length() < 8) {
                    statusLabel.setForeground(Color.RED);
                    statusLabel.setText("Password must be 8 characters long");
                    return;
                }

                if (!currentText.matches(".*\\d.*")) {
                    statusLabel.setForeground(Color.RED);
                    statusLabel.setText("Password must contain at least one digit");
                    return;
                }

                if (!currentText.matches(".*[^a-zA-Z0-9\\s].*")) {
                    statusLabel.setForeground(Color.RED);
                    statusLabel.setText("Password must contain at least one special character");
                    return;
                }

                statusLabel.setForeground(Color.GREEN);
                statusLabel.setText("Password is valid");
            }

            @Override
            public void changedUpdate(DocumentEvent e) { }
        });
    }

    public static void main(String[] args) {
        new PasswordValidator();
    }

}
