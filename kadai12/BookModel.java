package kadai12;

import java.io.*;
import java.util.*;

public class BookModel {
    private static final String FILENAME = "book.txt";
    private final List<String[]> bookList = new ArrayList<>();

    public BookModel() {
        deserialzie();
    }

    public void addBook(String title, String author, String publisher, String ISBN) {
        bookList.add(new String[]{ title, author, publisher, ISBN });
        serialize();
    }

    public List<String[]> getBookList() {
        return new ArrayList<>(bookList);
    }

    public List<String[]> getAllBookMatchesWith(String keyword) {
        List<String[]> matches = new ArrayList<>();
        for (String[] book : bookList) {
            for (String field : book) {
                if (!field.toLowerCase().contains(keyword))
                    continue;

                matches.add(book);
                break;
            }
        }
        return matches;
    }

    // Serialization
    private void deserialzie() {
        File file = new File(FILENAME);
        if (!file.exists())
            return;
        
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|", -1);
                
                if (parts.length == 4)
                    bookList.add(parts);
            }

        } 
        catch (IOException _) {}
    }

    private void serialize() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILENAME))) {
            for (String[] book : bookList) {
                writer.println(String.join("|", book));
            }
        } catch (IOException _) {}
    }
}