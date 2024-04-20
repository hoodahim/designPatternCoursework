public class Book implements Cloneable{
    private String author;
    private String title;
    private String genre;
    private int publicationYear;

    public Book(String author, String title, String genre, int publicationYear){
        this.author = author;
        this.title = title;
        this.genre = genre;
        this.publicationYear = publicationYear;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    @Override
    protected Book clone() throws CloneNotSupportedException {
        try {
            return (Book)super.clone();
        }catch (CloneNotSupportedException e){
            throw new RuntimeException("This should not happen since we implement Cloneable", e);
        }

    }

    public String toString(){
        return "Author: " + author + "\nTitle: " + title + "\nGenre: " + genre + "\nPublication year: " + publicationYear;
    }
}
