package Projects.JavaProject.Pojo.Entity;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
/**it is mapped to the table named book**/
@Table(name="book")
public class Book {

    /** this annotation defines the id of the entity**/
    @Id
    /**this annotation defines the generation method for the id**/
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    /**this annotation shows that it is mapped to the id column**/
    @Column(name="id")
    /**id property represents the id of the book entity**/
    private Integer id;

    /**this annotation shows it is mapped to the title column**/
    @Column(name="title")
    /**title property represents the title of the book entity**/
    private String title;

    /**this annotation shows it is mapped to the author column**/
    @Column(name="author")
    /**author property represents the author of the book entity**/
    private String author;

    /**this annotation shows it is mapped to the genre column**/
    @Column(name="genre")
    /**genre property represents the genre of the book entity**/
    private String genre;

    /**this annotation shows it is mapped to the year column**/
    @Column(name="year")
    /**year property represents the year of the book entity**/
    private int year;

    /**annotation to express the relationship between book and user**/
    @ManyToOne
    /**annotation to express the column in which the tables will be joined**/
    @JoinColumn(name="userid")
    /**annotation to avoid infinite recursion**/
    @JsonBackReference
    /**user object represents the user entity**/
    private User user;

    /**default constructor for Book class**/
    public Book() {
    }

    /**
     *
     * constructor for Book class creates a copy of the class
     *
     * @param id is the id of the entity
     * @param author is the author of entity
     * @param title is the title of the entity
     * @param genre is the genre of the entity
     * @param year is the year of the entity
     * **/
    public Book(Integer id, String title, String author, String genre, int year) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.year = year;
    }

    //--------------------------------
    //CLass Methods
    //
    //-------------------------------
    /**getter for the id of the Book class**/
    public Integer getId() {
        return id;
    }

    /**setter for the id of the Book class**/
    public void setId(Integer id) {
        this.id = id;
    }

    /**getter for the title of the Book class**/
    public String getTitle() {
        return title;
    }

    /**setter for the title of the Book class**/
    public void setTitle(String title) {
        this.title = title;
    }

    /**getter for the author of the Book class**/
    public String getAuthor() {
        return author;
    }

    /**setter for the author of the Book class**/
    public void setAuthor(String author) {
        this.author = author;
    }

    /**getter for the genre of the Book class**/
    public String getGenre() {
        return genre;
    }

    /**setter for the genre of the Book class**/
    public void setGenre(String genre) {
        this.genre = genre;
    }

    /**getter for the year of the Book class**/
    public int getYear() {
        return year;
    }

    /**setter for the year of the Book class**/
    public void setYear(int year) {
        this.year = year;
    }

    /**getter for the user of the Book class**/
    public User getUser() {
        return user;
    }

    /**setter for the user of the Book class**/
    public void setUser(User user) {
        this.user = user;
    }
}
