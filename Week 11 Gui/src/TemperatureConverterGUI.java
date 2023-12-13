import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TemperatureConverterGUI {
    private JFrame frame;
    private JPanel panel;
    private JTextField input;
    private JTextField output;
   private JButton clearButton; 
   private JButton calculateButton;
    

    public TemperatureConverterGUI() {
        frame = new JFrame("Celsius to Fahrenheit");
        panel = new JPanel();
        input = new JTextField(10);
        output = new JTextField(10);
        calculateButton = new JButton("Calculate");
        clearButton = new JButton("Clear");

        calculateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                convert();
            }
        });

        clearButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                clear();
            }
        });

        panel.add(input);
        panel.add(output);
        panel.add(clearButton);
        panel.add(calculateButton);
        

        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private void convert() {
        try {
            double celsius = Double.parseDouble(input.getText());
            double fahrenheit = (celsius * 9/5) + 32;
            output.setText(String.format("%.2f", fahrenheit));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(frame, "Please enter a number");
        }
    }

    private void clear() {
        input.setText("");
        output.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TemperatureConverterGUI();
            }
        });
    }
}