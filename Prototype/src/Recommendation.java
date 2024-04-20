import java.util.ArrayList;
import java.util.List;

public class Recommendation implements Cloneable{
    private String targetAudience;
    private static int idCounter = 0;
    private int id;
    private List<Book> bookList;

    public Recommendation(String targetAudience){
        this.id = ++idCounter;
        this.targetAudience = targetAudience;
        this.bookList = new ArrayList<>();
    }

    @Override
    protected Recommendation clone() throws CloneNotSupportedException {
        Recommendation cloned = (Recommendation) super.clone();
        cloned.id = ++idCounter;
        return cloned;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public String getTargetAudience() {
        return targetAudience;
    }

    public int getId() {
        return id;
    }

    public void setTargetAudience(String targetAudience) {
        this.targetAudience = targetAudience;
    }

    public void addBookToList(Book book){
        this.bookList.add(book);
    }

    public Book removeBookFromList(String author, String title){
        for(Book book:bookList){
            if (book.getAuthor().equalsIgnoreCase(author) && book.getTitle().equalsIgnoreCase(title)){
                return book;
            }
        }

        return null;
    }

    public String toString(){
        return targetAudience + ", ID: " +id;
    }

}
