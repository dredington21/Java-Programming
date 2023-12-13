import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator {
    private JFrame frame;
    private JPanel panel;
    private JTextField num1Field;
    private JTextField num2Field;
    private JTextField resultField;
    private JButton calculateButton;
    private JRadioButton addRadio;
    private JRadioButton subtractRadio;
    private JRadioButton multiplyRadio;
    private JRadioButton divideRadio;

    public Calculator() {
        frame = new JFrame("Calculator");
        panel = new JPanel();
        num1Field = new JTextField(10);
        num2Field = new JTextField(10);
        resultField = new JTextField(10);
        calculateButton = new JButton("Calculate");
        addRadio = new JRadioButton("Add");
        subtractRadio = new JRadioButton("Subtract");
        multiplyRadio = new JRadioButton("Multiply");
        divideRadio = new JRadioButton("Divide");

        ButtonGroup operatorGroup = new ButtonGroup();
        operatorGroup.add(addRadio);
        operatorGroup.add(subtractRadio);
        operatorGroup.add(multiplyRadio);
        operatorGroup.add(divideRadio);

        calculateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Calculate();
            }
        });

        panel.add(new JLabel("Number 1:"));
        panel.add(num1Field);
        panel.add(new JLabel("Number 2:"));
        panel.add(num2Field);
        panel.add(addRadio);
        panel.add(subtractRadio);
        panel.add(multiplyRadio);
        panel.add(divideRadio);
        panel.add(calculateButton);
        panel.add(new JLabel("Result:"));
        panel.add(resultField);

        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private void Calculate() {
        try {
            int num1 = Integer.parseInt(num1Field.getText());
            int num2 = Integer.parseInt(num2Field.getText());

            int result = 0;

            if (addRadio.isSelected()) {
                result = num1 + num2;
            } 
            if (subtractRadio.isSelected()) {
                result = num1 - num2;
            } 
            if (multiplyRadio.isSelected()) {
                result = num1 * num2;
            } 
            if (divideRadio.isSelected()) {
                result = num1 / num2;
            }

            resultField.setText(String.valueOf(result));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(frame, "Please input numbers.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Calculator();
            }
        });
    }
}
