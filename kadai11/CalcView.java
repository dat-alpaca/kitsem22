package kadai11;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CalcView extends JFrame implements ActionListener {
    private final CalcCtrl calcControl;

    private Container container;
    private JLabel labelEqual, labelResult;
    private JTextField textField0, textFieldOperation, textField1;
    private JButton buttonCalc, buttonClear;

    public CalcView() {
        super("Calculator");
        this.calcControl = new CalcCtrl();

        initializeGUI();
    }

    private void initializeGUI() {
        container = getContentPane();
        container.setLayout(new BorderLayout());

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JPanel inputPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));

        textField0 = new JTextField(4);
        textFieldOperation = new JTextField(2);
        textField1 = new JTextField(4);
        labelEqual = new JLabel(" = ");
        labelResult = new JLabel("");

        buttonCalc = new JButton("Calc");
        buttonClear = new JButton("Clear");

        buttonCalc.addActionListener(this);
        buttonClear.addActionListener(this);

        buttonPanel.add(buttonCalc);
        buttonPanel.add(buttonClear);

        inputPanel.add(textField0);
        inputPanel.add(textFieldOperation);
        inputPanel.add(textField1);
        inputPanel.add(labelEqual);
        inputPanel.add(labelResult);

        container.add(buttonPanel, BorderLayout.SOUTH);
        container.add(inputPanel, BorderLayout.NORTH);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(250, 120);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if (source == buttonCalc) {
            try {
                int numberLeft = Integer.parseInt(textField0.getText().trim());
                String operation = textFieldOperation.getText().trim();
                int numberRight = Integer.parseInt(textField1.getText().trim());

                int result = calcControl.calc(numberLeft, operation, numberRight);
                labelResult.setText(Integer.toString(result));
                
            } catch (NumberFormatException ex) {
                labelResult.setText("Invalid number");
            } catch (ArithmeticException ex) {
                labelResult.setText("Div by 0");
            } catch (IllegalArgumentException ex) {
                labelResult.setText("Invalid op");
            }
            
        } else if (source == buttonClear) {
            clearFields();
        }
    }

    private void clearFields() {
        textField0.setText("");
        textFieldOperation.setText("");
        textField1.setText("");
        labelResult.setText("");
    }

    public static void main(String[] args) {
        CalcView v = new CalcView();
        v.setVisible(true);
    }
}