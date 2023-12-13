
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.EmptyBorder;

public class FuncCalc extends JFrame {
    private JTextField textField;
    private JButton[] numberButtons = new JButton[10];
    private JButton addButton, subtractButton, multiplyButton, divideButton, equalsButton, clearButton, swapButton,dotButton;

    // Variables for calculator logic
    private double OP1 = 0;
    private char operator = ' ';
    private boolean newOperand = true;

    public FuncCalc() {
        this.setTitle("Functional Calculator");
        this.setLayout(new BorderLayout());
        this.setSize(400, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        textField = new JTextField();
        textField.setHorizontalAlignment(JTextField.RIGHT);
        textField.setFont(new Font("Arial", Font.PLAIN, 40));
        textField.setEditable(false);
        textField.setBorder(new EmptyBorder(10,10,10,10));

        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
            int finalI = i;
            // Add ActionListener for number buttons
            numberButtons[i].addActionListener(e -> doNum(finalI));
        }

        addButton = new JButton("+");
        subtractButton = new JButton("-");
        multiplyButton = new JButton("*");
        divideButton = new JButton("/");
        equalsButton = new JButton("=");
        clearButton = new JButton("C");
        swapButton = new JButton("+/-");
        dotButton = new JButton(".");

        // Add ActionListener for operator buttons
        addButton.addActionListener(e -> doOP('+'));
        subtractButton.addActionListener(e -> doOP('-'));
        multiplyButton.addActionListener(e -> doOP('*'));
        divideButton.addActionListener(e -> doOP('/'));
        addButton.addActionListener(e -> doSwap());
        // addButton.addActionListener(e -> doOP('.'));

        // Add ActionListener for clear button
        clearButton.addActionListener(e -> doClear());

        // Add ActionListener for equals button
        equalsButton.addActionListener(e -> doEqual());

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 4, 10, 10));

        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(numberButtons[4]);
        
      
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        

        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(numberButtons[0]);
        panel.add(addButton);
        panel.add(subtractButton);
        
        panel.add(divideButton);
        panel.add(multiplyButton);
        panel.add(swapButton);
        panel.add(clearButton);
        
        panel.add(equalsButton);
        
        this.add(textField, BorderLayout.NORTH);
        this.add(panel);
    }

    // Method to handle number button 
    private void doNum(int digit) {
        if (newOperand) {
            textField.setText(String.valueOf(digit));
            newOperand = false;
        } else {
            textField.setText(textField.getText() + digit);
        }
    }

    // Method to handle operator button 
    private void doOP(char op) {
        if (!newOperand) {
            doEqual(); // Perform previous calculation if any
        }
        OP1 = Double.parseDouble(textField.getText());
        operator = op;
        newOperand = true;
    }
    // Method for +/- button
    private void doSwap() {
    	double swap = -1*Double.parseDouble(textField.getText());
    	textField.setText(String.valueOf(swap));
    	
    }

    // Method to handle clear button click
    private void doClear() {
        textField.setText("");
        OP1 = 0;
        operator = ' ';
        newOperand = true;
    }

    // Method to handle equals button click
    private void doEqual() {
        double OP2 = Double.parseDouble(textField.getText());
        double result = 0;

        // Perform calculation based on the operator
        switch (operator) {
            case '+':
                result = OP1 + OP2;
                break;
            case '-':
                result = OP1 - OP2;
                break;
            case '*':
                result = OP1 * OP2;
                break;
            case '/':
                if (OP2 != 0) {
                    result = OP1 / OP2;
                                 
                } else {
                    // Handle division by zero
                    textField.setText("Error");
                    return;
                }     
            	
                break;
        }

        // Display the result
        textField.setText(String.valueOf(result));
        OP1 = result;
        newOperand = true;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            FuncCalc calculator = new FuncCalc();
            calculator.setVisible(true);
        });
    }
}
