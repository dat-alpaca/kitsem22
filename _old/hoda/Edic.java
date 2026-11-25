import java.awt.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import javax.swing.*;

public class Edic extends JFrame{
    JTextField tf1;
    JButton b1;
    JButton b2;
    JButton b3;
    JLabel label;

    Edic(){
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(360, 200);
    setTitle("Edic");

    Container c = getContentPane();
    c.setLayout(new BorderLayout());
    
    tf1 = new JTextField("", 28);
    b1 = new JButton("Translate");
    b2 = new JButton("Clear");
    b3 = new JButton("Quit");
    label = new JLabel("");

    JPanel panel = new JPanel();
    panel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

    panel.add(b1);
    panel.add(b2);
    panel.add(b3);

    c.add(tf1, BorderLayout.NORTH);
    c.add(panel, BorderLayout.CENTER);
    c.add(label, BorderLayout.SOUTH);

    label.setHorizontalAlignment(SwingConstants.CENTER);

    b1.addActionListener(e -> {
        try {
            List<String> lines = Files.readAllLines(Path.of("dic.txt"));
            int i;
            for (i = 0; i < lines.size() - 1; i += 2) {
                if (tf1.getText().equalsIgnoreCase(lines.get(i))) {
                    label.setText(lines.get(i + 1));
                    break;
                }
            }
            if (i >= lines.size()-1) {
                label.setText("This word doesn't exist!");
            }
        } catch (IOException ex) {
            System.out.println("Error reading file: " + ex.getMessage());
        }
    });
    b2.addActionListener(e -> {
        tf1.setText("");
        label.setText("");
    });
    b3.addActionListener(e -> {
        System.exit(0);
    });
    }
    public static void main(String[] args) {
        Edic frame = new Edic();
        frame.setVisible(true);
    }
}