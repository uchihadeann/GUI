import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FoodOrderingSystem extends JFrame {
    private JButton btnOrder;

    private JCheckBox cPizza;
    private JCheckBox cBurger;
    private JCheckBox cFries;
    private JCheckBox cSoftDrinks;
    private JCheckBox cTea;
    private JCheckBox cSundae;

    private JRadioButton rbNone;
    private JRadioButton rb5;
    private JRadioButton rb10;
    private JRadioButton rb15;

    private JPanel mainPanel;

    public FoodOrderingSystem() {
        setTitle("Food Ordering System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(mainPanel);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);

        // You must group the radio buttons
        ButtonGroup bg = new ButtonGroup();
        bg.add(rbNone);
        bg.add(rb5);
        bg.add(rb10);
        bg.add(rb15);

        btnOrder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double totalPrice = 0;

                if (cPizza.isSelected()) totalPrice += 100;
                if (cBurger.isSelected()) totalPrice += 80;
                if (cFries.isSelected()) totalPrice += 65;
                if (cSoftDrinks.isSelected()) totalPrice += 55;
                if (cTea.isSelected()) totalPrice += 50;
                if (cSundae.isSelected()) totalPrice += 40;

                if (rb5.isSelected()) totalPrice *= 0.95;
                if (rb10.isSelected()) totalPrice *= 0.90;
                if (rb15.isSelected()) totalPrice *= 0.85;

                String msg = "The total price is Php " + String.format("%.2f", totalPrice);
                JOptionPane.showMessageDialog(null, msg);
            }
        });
    }

    public static void main(String[] args) {
        new FoodOrderingSystem();
    }
}
