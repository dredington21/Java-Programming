import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.EmptyBorder;

public class AdvancedCalculator extends JFrame {
    private JTextField textField;
    private JButton[] numberButtons = new JButton[10];
    private JButton addButton, subtractButton, multiplyButton, divideButton, equalsButton, clearButton, swapButton, decimalButton;

    private double firstOperand = 0;
    private char operator = ' ';
    private boolean newOperand = true;

    public AdvancedCalculator() {
        this.setTitle("Advanced Calculator");
        this.setLayout(new BorderLayout());
        this.setSize(300, 450);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        JPanel textPanel = new JPanel();
       textPanel.setLayout(new BorderLayout());

        textField = new JTextField();
        textField.setHorizontalAlignment(JTextField.RIGHT);
        textField.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        textField.setEditable(false);
        textField.setBorder(new EmptyBorder(10, 0, 0, 0)); 

        textPanel.add(textField, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(5, 4, 10, 10));


        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
            int I = i;
            numberButtons[i].addActionListener(e -> doNum(I));
            buttonPanel.add(numberButtons[i]);
        }

        addButton = new JButton("+");
        subtractButton = new JButton("-");
        multiplyButton = new JButton("*");
        divideButton = new JButton("/");
        equalsButton = new JButton("=");
        clearButton = new JButton("C");
        swapButton = new JButton("+/-");
        decimalButton = new JButton(".");

        addButton.addActionListener(e -> doOP('+'));
        subtractButton.addActionListener(e -> doOP('-'));
        divideButton.addActionListener(e -> doOP('/'));
        multiplyButton.addActionListener(e -> doOP('*'));
        swapButton.addActionListener(e -> doSwap());
        decimalButton.addActionListener(e -> doDec());
        clearButton.addActionListener(e -> doClear());
        equalsButton.addActionListener(e -> doEQ());
        
        buttonPanel.add(numberButtons[1]);
        buttonPanel.add(numberButtons[2]);
        buttonPanel.add(numberButtons[3]);
        buttonPanel.add(numberButtons[4]);
        buttonPanel.add(numberButtons[5]);
        buttonPanel.add(numberButtons[6]);
        buttonPanel.add(numberButtons[7]);
        buttonPanel.add(numberButtons[8]);
        buttonPanel.add(numberButtons[9]);
        buttonPanel.add(numberButtons[0]);
        buttonPanel.add(addButton);
        buttonPanel.add(subtractButton);
        buttonPanel.add(divideButton);
        buttonPanel.add(multiplyButton);
        buttonPanel.add(swapButton);
        buttonPanel.add(decimalButton);
        
        
        buttonPanel.add(clearButton);
        buttonPanel.add(equalsButton);
        
        this.add(textPanel, BorderLayout.NORTH);
        this.add(buttonPanel, BorderLayout.CENTER);
        
    }

    private void doNum(int digit) {
        if (newOperand) {
            textField.setText(String.valueOf(digit));
           newOperand = false;
        } 
 
        else {
            textField.setText(textField.getText() + digit);
        }
    }

    private void doOP(char op) {
    	firstOperand=Double.parseDouble(textField.getText());
        if (!newOperand) {
        	double save = firstOperand;
            doEQ(); 
            firstOperand = save;
            textField.setText(String.valueOf(save));
        } else {
            firstOperand = Double.parseDouble(textField.getText());
            newOperand = false;
      }

        operator = op;
    }

    private void doClear() {
        textField.setText("");
        firstOperand = 0;
        operator = ' ';
        newOperand = true;
    }

    private void doEQ() {
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
                        textField.setText("Error");
                        newOperand = true; 
                        return;
                    }
                    break;
            }
            textField.setText(String.valueOf(result));
            firstOperand = result;
        }

        newOperand = true; 
        // System.out.println("Result: " + textField.getText() + ", newOperand: " + newOperand); (used for debugging)
    }

    private void doSwap() {
        if (!textField.getText().equals("0")) {
            double currentValue = Double.parseDouble(textField.getText());
            double newValue = -currentValue;
            textField.setText(String.valueOf(newValue));
        }
    }

    private void doDec() {
        if (!textField.getText().contains(".")) {
            textField.setText(textField.getText() + ".");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            AdvancedCalculator calculator = new AdvancedCalculator();
            calculator.setVisible(true);
        });
    }
}
