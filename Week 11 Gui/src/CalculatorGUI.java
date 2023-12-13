import javax.swing.*;
import java.awt.*;
    
public class CalculatorGUI extends JFrame {
    private JTextField textField;
    private JButton[] numberButtons = new JButton[10];
    private JButton addButton, subtractButton, multiplyButton, divideButton, equalsButton, clearButton;
    


    public CalculatorGUI() {
        this.setTitle("Calculator");
        this.setLayout(new BorderLayout());
        this.setSize(400, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        textField = new JTextField();
        textField.setHorizontalAlignment(JTextField.RIGHT);
        textField.setFont(new Font("Arial", Font.PLAIN, 20));
        textField.setEditable(false);

        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        }

        addButton = new JButton("+");
        subtractButton = new JButton("-");
        multiplyButton = new JButton("*");
        divideButton = new JButton("/");
        equalsButton = new JButton("=");
        clearButton = new JButton("C");

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 4, 10, 10));

        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addButton);

        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subtractButton);

        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(multiplyButton);

        panel.add(clearButton);
        panel.add(numberButtons[0]);
        panel.add(equalsButton);
        panel.add(divideButton);

        this.add(textField, BorderLayout.NORTH);
        this.add(panel);
        
    

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CalculatorGUI calculator = new CalculatorGUI();
            calculator.setVisible(true);
        });
    }
}