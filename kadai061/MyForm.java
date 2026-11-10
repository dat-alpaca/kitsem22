import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class MyForm extends JFrame {
    private JTextField textField;
    private JButton printButton;
    private JButton clearButton;
    
    public MyForm() {
        super("MyForm");
        setupGUI();
    }

    private void setupGUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        textField = new JTextField(20);
        add(textField);

        printButton = new JButton("Print");
        printButton.addActionListener((ActionEvent e) -> {
            System.err.println(textField.getText());
        });
        add(printButton);

        clearButton = new JButton("Clear");
        clearButton.addActionListener((ActionEvent e) -> {
            textField.setText("");
        });
        add(clearButton);

        setSize(300, 150);
    }
    
    public static void main(String[] args) {
        var form = new MyForm();
        form.setVisible(true);
    }
}