import javax.swing.*;
import java.awt.event.*;

public class CharaacterRemoverGui extends JFrame {
    private JPanel contentPane;
    private JCheckBox vowelCheckBox;
    private JCheckBox consonantCheckBox;
    private JCheckBox numberCheckBox;
    private JButton removeButton;
    private JButton restoreButton;
    private JLabel textLabel;

    private final String DEFAULT = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    public CharaacterRemoverGui() {
        setTitle("Character Remover");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(contentPane);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);

        vowelCheckBox.setName("vowelCheckBox");
        consonantCheckBox.setName("consonantCheckBox");
        numberCheckBox.setName("numberCheckBox");

        removeButton.setName("removeButton");
        restoreButton.setName("restoreButton");
        textLabel.setName("textLabel");

        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String currentText = textLabel.getText();
                boolean removeVowel = vowelCheckBox.isSelected();
                boolean removeConsonant = consonantCheckBox.isSelected();
                boolean removeNumber = numberCheckBox.isSelected();

                StringBuilder newLabel = new StringBuilder();

                for (char c : currentText.toCharArray()) {
                    boolean keep = true;

                    if (Character.isLetter(c)) {
                        boolean isVowel = "AEIOUaeiou".indexOf(c) != -1;

                        if (isVowel && removeVowel) {
                            keep = false;
                        } else if (!isVowel && removeConsonant) {
                            keep = false;
                        }
                    } else if (Character.isDigit(c)) {
                        if (removeNumber) {
                            keep = false;
                        }
                    }

                    if (keep) {
                        newLabel.append(c);
                    }
                }

                // FIX: Update text ONCE, outside the loop
                textLabel.setText(newLabel.toString());
            }
        });

        restoreButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textLabel.setText(DEFAULT);
            }
        });
    }
    public static void main(String[] args) {
        new CharaacterRemoverGui();
    }


}
