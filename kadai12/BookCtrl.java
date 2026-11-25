package kadai12;
import java.util.List;

public class BookCtrl {
    private final BookModel model;

    public BookCtrl() {
        this.model = new BookModel();
    }

    public void registerBook(String title, String author, String publisher, String ISBN) {
        model.addBook(title.trim(), author.trim(), publisher.trim(), ISBN.trim());
    }

    public List<String[]> listBooks() {
        return model.getBookList();
    }

    public List<String[]> search(String keyword) {
        return model.getAllBookMatchesWith(keyword.trim().toLowerCase());
    }
}