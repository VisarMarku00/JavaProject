package Projects.JavaProject.Pojo.Input;

/**class for entering the data for the Book table**/
public class BookInput {

    /**title property represents the title of the book entity**/
    private String title;
    /**author property represents the author of the book entity**/
    private String author;
    /**genre property represents the genre of the book entity**/
    private String genre;
    /**year property represents the year of the book entity**/
    private int year;

    /**default constructor for BookInput class**/
    public BookInput() {
    }

    /**constructor for BookInput class**/
    public BookInput(String title, String author, String genre, int year) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.year = year;
    }

    /**getter for the title of the BookInput class**/
    public String getTitle() {
        return title;
    }

    /**setter for the title of the BookInput class**/
    public void setTitle(String title) {
        this.title = title;
    }

    /**getter for the author of the BookInput class**/
    public String getAuthor() {
        return author;
    }

    /**setter for the author of the BookInput class**/
    public void setAuthor(String author) {
        this.author = author;
    }

    /**getter for the genre of the BookInput class**/
    public String getGenre() {
        return genre;
    }

    /**setter for the genre of the BookInput class**/
    public void setGenre(String genre) {
        this.genre = genre;
    }

    /**getter for the year of the BookInput class**/
    public int getYear() {
        return year;
    }

    /**setter for the year of the BookInput class**/
    public void setYear(int year) {
        this.year = year;
    }
}
