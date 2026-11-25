
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.*;
import java.util.HashMap;
import java.util.Map;
import javax.swing.*;

public class Edic2 extends JFrame {
    private final Map<String, String> dictionaryEntries = new HashMap<>();
    private JTextField textField;
    private JButton translateButton;
    private JButton clearButton;
    private JButton quitButton;
    private JLabel resultLabel;

    public Edic2(String[] args) throws HeadlessException {
        super("Edic2");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        if (args.length >= 1)
            loadDictionary(args[0]);
        else
            loadDictionary("dic.txt");

        setupGUI();
    }

    private void setupGUI() {
        // Elements:
        textField = new JTextField(20);
        
        translateButton = new JButton("Translate");
        translateButton.addActionListener((ActionEvent e) -> {
            String word = textField.getText().trim().toLowerCase();
            String translation = dictionaryEntries.get(word);
            
            if (translation == null)
                resultLabel.setText("Not found");
            else
                resultLabel.setText(translation);
        });

        clearButton = new JButton("Clear");
        clearButton.addActionListener((ActionEvent e) -> {
            textField.setText("");
            resultLabel.setText("");
        });
        
        
        quitButton = new JButton("Quit");
        quitButton.addActionListener((ActionEvent e) -> {
            System.exit(0);
        });

        resultLabel = new JLabel("");
        
        // Layout:
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new FlowLayout());
        topPanel.add(textField);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.add(translateButton);      
        buttonPanel.add(clearButton);      
        buttonPanel.add(quitButton);      

        JPanel bottomPanel = new JPanel();
        bottomPanel.add(resultLabel);

        setLayout(new GridLayout(3, 1));
        add(topPanel);
        add(buttonPanel);
        add(bottomPanel);

        // Geometry:
        setSize(300, 150);  
        setMinimumSize(new Dimension(300, 150));
    }

    private void loadDictionary(String filepath) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(filepath), "UTF-8"));
            String english;
            while ((english = reader.readLine()) != null) {
                String japanese = reader.readLine();
                if (japanese == null)
                    break;

                dictionaryEntries.put(english.trim().toLowerCase(), japanese.trim().toLowerCase());
            }

        } catch (IOException e) {
            System.err.println("Error: Failed to read '" + filepath + "'. " + e.getMessage());
            System.exit(1);
        }
    }
    
    public static void main(String[] args) {
        Edic2 edic = new Edic2(args);
        edic.setVisible(true);
    }
}