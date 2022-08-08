package Projects.JavaProject.Pojo.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
/** it is mapped to the table named book **/
@Table(name="user")
public class User {

    /** this annotation defines the id of the entity**/
    @Id
    /**this annotation defines the generation method for the id**/
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    /**this annotation shows that it is mapped to the id column**/
    @Column(name="id")
    /**id property represents the id of the user entity**/
    private Integer id;

    /**this annotation shows it is mapped to the firstName column**/
    @Column(name="firstname")
    /**firstName property represents the firstName column of the user entity**/
    private String firstName;

    /**this annotation shows it is mapped to the lastName column**/
    @Column(name="lastname")
    /**lastName property represents the lastName column of the user entity**/
    private String lastName;

    /**this annotation shows it is mapped to the dateOfBirth column**/
    @Column(name="dateofbirth")
    /**dateOfBirth property represents the dateOfBirth column of the user entity**/
    private Date dateOfBirth;

    /**this annotation shows it is mapped to the address column**/
    @Column(name="address")
    /**address property represents the address column of the user entity**/
    private String address;

    /**annotation to express the relationship between book and user**/
    @OneToMany(mappedBy = "user")
    /**annotation to avoid infinite recursion**/
    @JsonManagedReference
    /**list object to show the list of books for the user**/
    private List<Book> books;

    /**annotation to express the relationship between libraryCard and user**/
    @OneToMany(mappedBy = "user")
    /**annotation to avoid infinite recursion**/
    @JsonBackReference
    /**list object represents the list of libraryCards for the user**/
    private List<LibraryCard> libraryCard;

    /**default constructor for User class**/
    public User() {
    }

    /**
     *
     * constructor for User class creates a copy of the class
     *
     * @param id is the id of the entity
     * @param firstName is the name of entity
     * @param lastName is the last name of the entity
     * @param dateOfBirth is the date of birth of the entity
     * @param address is the address of the entity
     * **/
    public User(Integer id, String firstName, String lastName, Date dateOfBirth, String address) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.address=address;
    }


    //--------------------------------
    //CLass Methods
    //
    //-------------------------------
    /**getter for the id of the User class**/
    public Integer getId() {
        return id;
    }

    /**setter for the id of the User class**/
    public void setId(Integer id) {
        this.id = id;
    }

    /**getter for the firstName property of the User class**/
    public String getFirstName() {
        return firstName;
    }

    /**setter for the firstName property of the User class**/
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**getter for the lastName property of the User class**/
    public String getLastName() {
        return lastName;
    }

    /**setter for the lastName property of the User class**/
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**getter for the dateOfBirth property of the User class**/
    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    /**setter for the dateOfBirth property of the User class**/
    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    /**getter for the address property of the User class**/
    public String getAddress() {
        return address;
    }

    /**setter for the address property of the User class**/
    public void setAddress(String address) {
        this.address = address;
    }

    /**getter for the list of Books of the User class**/
    public List<Book> getBooks() {
        return books;
    }

    /**setter for the list of Books of the User class**/
    public void setBooks(List<Book> books) {
        this.books = books;
    }

    /**getter for the list of Library Cards of the User class**/
    public List<LibraryCard> getLibraryCard() {
        return libraryCard;
    }

    /**setter for the list of Library Cards of the User class**/
    public void setLibraryCard(List<LibraryCard> libraryCard) {
        this.libraryCard = libraryCard;
    }
}

