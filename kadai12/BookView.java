package kadai12;

import java.awt.*;
import java.util.List;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class BookView extends JFrame {
    private final BookCtrl bookControl = new BookCtrl();

    private final JTextField textFieldTitle      = new JTextField(12);
    private final JTextField textFieldAuthor     = new JTextField(12);
    private final JTextField textFieldPublisher  = new JTextField(12);
    private final JTextField textFieldISBN       = new JTextField(12);
    private final JTextField textFieldSearch     = new JTextField(12);
    private final JTextArea textArea             = new JTextArea(10, 40);

    public BookView() {
        super("Book Management System");
        initializeGUI();
    }

    private void initializeGUI() {
        setLayout(new BorderLayout(5, 5));
        setMinimumSize(new Dimension(350, 300));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        textArea.setEditable(false);

        // Top book form:
        JPanel bookForm = new JPanel(new GridLayout(5, 2, 4, 4));
        bookForm.setBorder(new EmptyBorder(4, 4, 4, 4));
        bookForm.add(new JLabel("Title:"));     bookForm.add(textFieldTitle);
        bookForm.add(new JLabel("Author:"));    bookForm.add(textFieldAuthor);
        bookForm.add(new JLabel("Publisher:")); bookForm.add(textFieldPublisher);
        bookForm.add(new JLabel("ISBN:"));      bookForm.add(textFieldISBN);

        // Buttons:
        JButton btnAdd = new JButton("Register");
        JButton btnList = new JButton("Show All");
        bookForm.add(btnAdd);
        bookForm.add(btnList);

        // Bottom search panel:
        JPanel searchPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JButton btnSearch = new JButton("Search");
        searchPanel.add(new JLabel("Keyword:"));
        searchPanel.add(textFieldSearch);
        searchPanel.add(btnSearch);

        btnAdd.addActionListener(_ -> {
            bookControl.registerBook(
                textFieldTitle.getText(), 
                textFieldAuthor.getText(), 
                textFieldPublisher.getText(), 
                textFieldISBN.getText()
            );

            textFieldTitle.setText(""); 
            textFieldAuthor.setText("");
            textFieldPublisher.setText("");
            textFieldISBN.setText("");

            display(bookControl.listBooks());
        });
        btnList.addActionListener(_ -> display(bookControl.listBooks()));
        btnSearch.addActionListener(_ -> display(bookControl.search(textFieldSearch.getText())));

        add(bookForm, BorderLayout.NORTH);
        add(new JScrollPane(textArea), BorderLayout.CENTER);
        add(searchPanel, BorderLayout.SOUTH);
        
        pack();
    }

    private void display(List<String[]> list) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String[] parameter : list) {
            stringBuilder.append(String.format("Title: %s | Author: %s | Publisher: %s | ISBN: %s%n",
                parameter[0], 
                parameter[1], 
                parameter[2], 
                parameter[3]
            ));
        }
        textArea.setText(stringBuilder.toString());
    }

    public static void main(String[] args) {
        new BookView().setVisible(true);
    }
}