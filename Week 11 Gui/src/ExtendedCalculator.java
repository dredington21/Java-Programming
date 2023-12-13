import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.border.EmptyBorder;


public class ExtendedCalculator extends JFrame {
    private JTextField textField;
    private JButton[] numberButtons = new JButton[10];
    private JButton addButton, subtractButton, multiplyButton, divideButton, equalsButton, clearButton, signButton, decimalButton;

    // Variables for calculator logic
    private double firstOperand = 0;
    private char operator = ' ';
    private boolean newOperand = true;

    // Variables for decimal input
    private boolean decimalClicked = false;
    private int decimalCount = 0;

    public ExtendedCalculator() {
        // Frame setup
        this.setTitle("Extended Calculator");
        this.setLayout(new BorderLayout());
        this.setSize(400, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        // Text field setup
        textField = new JTextField();
        textField.setHorizontalAlignment(JTextField.RIGHT);
        textField.setFont(new Font("Arial", Font.PLAIN, 20));
        textField.setEditable(false);
        textField.setBorder(new EmptyBorder(10, 0, 0, 0));

        // Buttons setup
        addButton = new JButton("+");
        subtractButton = new JButton("-");
        multiplyButton = new JButton("*");
        divideButton = new JButton("/");
        equalsButton = new JButton("=");
        clearButton = new JButton("C");
        signButton = new JButton("+/-");
        decimalButton = new JButton(".");

        // Add action listeners
        addButton.addActionListener(e -> handleOperatorButtonClick('+'));
        subtractButton.addActionListener(e -> handleOperatorButtonClick('-'));
        multiplyButton.addActionListener(e -> handleOperatorButtonClick('*'));
        divideButton.addActionListener(e -> handleOperatorButtonClick('/'));
        equalsButton.addActionListener(e -> handleEqualsButtonClick());
        clearButton.addActionListener(e -> handleClearButtonClick());
        signButton.addActionListener(e -> handleSignButtonClick());
        decimalButton.addActionListener(e -> handleDecimalButtonClick());

        // Panel setup
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 4, 10, 10));

        panel.add(new JButton("1"));
        panel.add(new JButton("2"));
        panel.add(new JButton("3"));
        panel.add(addButton);

        panel.add(new JButton("4"));
        panel.add(new JButton("5"));
        panel.add(new JButton("6"));
        panel.add(subtractButton);

        panel.add(new JButton("7"));
        panel.add(new JButton("8"));
        panel.add(new JButton("9"));
        panel.add(multiplyButton);

        panel.add(clearButton);
        panel.add(new JButton("0"));
        panel.add(equalsButton);
        panel.add(divideButton);

        panel.add(signButton);
        panel.add(decimalButton);

        // Add components to the frame
        this.add(textField, BorderLayout.NORTH);
        this.add(panel);
    }

    private void handleOperatorButtonClick(char op) {
        if (!newOperand) {
            handleEqualsButtonClick();
        } else {
            firstOperand = Double.parseDouble(textField.getText());
            newOperand = false;
        }

        operator = op;
        decimalClicked = false;  // Reset decimal input state
        decimalCount = 0;
    }

    private void handleEqualsButtonClick() {
        if (!newOperand) {
            double secondOperand = Double.parseDouble(textField.getText());
            double result = 0;

            switch (operator) {
                case '+':
                    result = firstOperand + secondOperand;
                    break;
                case '-':
                    result = firstOperand - secondOperand;
                    break;
                case '*':
                    result = firstOperand * secondOperand;
                    break;
                case '/':
                    if (secondOperand != 0) {
                        result = firstOperand / secondOperand;
                    } else {
                        // Handle division by zero
                        textField.setText("Error");
                        return;
                    }
                    break;
            }

            textField.setText(String.format("%.4f", result));
            firstOperand = result;
            newOperand = true;
            decimalClicked = false;  // Reset decimal input state
            decimalCount = 0;
        }
    }

    private void handleClearButtonClick() {
        textField.setText("");
        firstOperand = 0;
        operator = ' ';
        newOperand = true;
        decimalClicked = false;  // Reset decimal input state
        decimalCount = 0;
    }

    private void handleSignButtonClick() {
        if (!textField.getText().equals("0")) {
            double currentValue = Double.parseDouble(textField.getText());
            double newValue = -currentValue;
            textField.setText(String.valueOf(newValue));
        }
    }

    private void handleDecimalButtonClick() {
        if (!decimalClicked) {
            String currentText = textField.getText();
            textField.setText(currentText + ".");
            decimalClicked = true;
            decimalCount = 1;
        } else if (decimalCount < 4) {
            // Allowing up to 4 decimal places
            String currentText = textField.getText();
            textField.setText(currentText + "0");
            decimalCount++;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ExtendedCalculator calculator = new ExtendedCalculator();
            calculator.setVisible(true);
        });
    }
}
