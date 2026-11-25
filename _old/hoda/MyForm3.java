import java.awt.*;
import javax.swing.*;

public class MyForm3 extends JFrame {

    JTextField tf1;
    JButton b1;
    JButton b2;

    MyForm3(){
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(360, 150);
    setTitle("MyForm3");

    Container c = getContentPane();
    c.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 15));
    
    tf1 = new JTextField("", 28);
    b1 = new JButton("Print");
    b2 = new JButton("Clear");

    c.add(tf1);
    c.add(b1);
    c.add(b2);

    b1.addActionListener(e -> {
        System.out.println(tf1.getText());
    });
    b2.addActionListener(e -> {
        tf1.setText("");
    });
    }

    public static void main(String[] args) {
        MyForm3 frame = new MyForm3();
        frame.setVisible(true);
    }
}