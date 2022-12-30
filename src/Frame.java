import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frame extends JFrame implements ActionListener {

    JTextField textField = new JTextField();
    JPanel buttonPanel = new JPanel(new GridLayout(4, 4, 10, 10));
    JButton delButton = new JButton("Delete");
    JButton clrButton = new JButton("Clear");

    JButton[] numberButton = new JButton[10];
    JButton[] functionButton = new JButton[6];
    JButton addition, subtraction, multiplication, division, equal, decimal, negative;
    Font font = new Font("Ink free", Font.PLAIN, 38);
    double num1 = 0, num2 = 0, result = 0;
    char operator;

    Frame() {
        // initialization start
        addition = new JButton("+");
        subtraction = new JButton("-");
        multiplication = new JButton("*");
        division = new JButton("/");
        equal = new JButton("=");
        decimal = new JButton(".");
        negative = new JButton("(-)");
        // initialization end

        // adding buttons in function button start
        functionButton[0] = addition;
        functionButton[1] = subtraction;
        functionButton[2] = multiplication;
        functionButton[3] = division;
        functionButton[4] = equal;
        functionButton[5] = decimal;
        // adding buttons in function button end

        // function buttons start
        for (int i = 0; i < 6; i++) {
            functionButton[i].addActionListener(this);
            functionButton[i].setFocusable(false);
            functionButton[i].setFont(font);
        }
        // function buttons end

        // function buttons start
        for (int i = 0; i < 10; i++) {
            numberButton[i] = new JButton(String.valueOf(i));
            numberButton[i].addActionListener(this);
            numberButton[i].setFocusable(false);
            numberButton[i].setFont(font);
        }
        // function buttons end

        // textField start
        textField.setPreferredSize(new Dimension(350, 50));
        textField.setFont(font);
        textField.setEditable(false);
        // textField end

        // negative button start
        negative.addActionListener(this);
        negative.setFont(font);
        // negative button end

        // button panel start
        buttonPanel.setPreferredSize(new Dimension(450, 500));
        // button panel end

        // delete button start
        delButton.addActionListener(this);
        delButton.setFont(font);
        delButton.setPreferredSize(new Dimension(220, 70));
        // delete button end

        // Clear button start
        clrButton.addActionListener(this);
        clrButton.setFont(font);
        clrButton.setPreferredSize(new Dimension(220, 70));
        // Clear button end

        // adding components inside Panel start
        buttonPanel.add(numberButton[1]);
        buttonPanel.add(numberButton[2]);
        buttonPanel.add(numberButton[3]);
        buttonPanel.add(addition);
        buttonPanel.add(numberButton[4]);
        buttonPanel.add(numberButton[5]);
        buttonPanel.add(numberButton[6]);
        buttonPanel.add(subtraction);
        buttonPanel.add(numberButton[7]);
        buttonPanel.add(numberButton[8]);
        buttonPanel.add(numberButton[9]);
        buttonPanel.add(multiplication);
        buttonPanel.add(decimal);
        buttonPanel.add(numberButton[0]);
        buttonPanel.add(division);
        buttonPanel.add(equal);
        // adding components inside Panel end

        // adding components inside JFrame start
        this.add(textField);
        this.add(negative);
        this.add(buttonPanel);
        this.add(delButton);
        this.add(clrButton);
        // adding components inside JFrame end

        this.setTitle("Harsh Calculator");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        this.setSize(500, 700);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numberButton[i]) {
                textField.setText(textField.getText().concat(String.valueOf(i)));
            }
        }
        if (e.getSource() == decimal) {
            textField.setText(textField.getText().concat("."));
        }

        if (e.getSource() == addition) {
            num1 = Double.parseDouble(textField.getText());
            operator = '+';
            textField.setText("");
        }
        if (e.getSource() == subtraction) {
            num1 = Double.parseDouble(textField.getText());
            operator = '-';
            textField.setText("");

        }
        if (e.getSource() == multiplication) {
            num1 = Double.parseDouble(textField.getText());
            operator = '*';
            textField.setText("");
        }
        if (e.getSource() == division) {
            num1 = Double.parseDouble(textField.getText());
            operator = '/';
            textField.setText("");
        }
        if (e.getSource() == equal) {
            num2 = Double.parseDouble(textField.getText());
            switch (operator) {
                case '+' -> result = num1 + num2;
                case '-' -> result = num1 - num2;
                case '*' -> result = num1 * num2;
                case '/' -> result = num1 / num2;
            }
            String str = String.format("%f", result);
            textField.setText(str);
            num1 = result;
        }
        if (e.getSource() == clrButton) {
            textField.setText("");
        }
        if (e.getSource() == delButton) {
            String str = textField.getText();
            textField.setText("");
            for (int i = 0; i < str.length() - 1; i++) {
                textField.setText(textField.getText() + str.charAt(i));
            }
        }
        if (e.getSource() == negative) {
            double temp = Double.parseDouble(textField.getText());
            temp *= -1;
            textField.setText(String.valueOf(temp));
        }
    }
}
