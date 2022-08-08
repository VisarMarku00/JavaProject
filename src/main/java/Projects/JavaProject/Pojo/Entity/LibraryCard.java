package Projects.JavaProject.Pojo.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Date;

@Entity
/**it is mapped to the table named librarycard**/
@Table(name="librarycard")
public class LibraryCard {

    /** this annotation defines the id of the entity**/
    @Id
    /**this annotation defines the generation method for the id**/
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    /**this annotation shows that it is mapped to the id column**/
    @Column(name="id")
    /**id property represents the id of the librarycard entity**/
    private Integer id;

    /**this annotation shows that it is mapped to the dateRegistered column**/
    @Column(name="dateregistered")
    /**dateRegistered property represents the dateRegistered column of the librarycard entity**/
    private Date dateRegistered;

    /**this annotation shows that it is mapped to the expiryDate column**/
    @Column(name="expirydate")
    /**expiryDate property represents the expiryDate column of the librarycard entity**/
    private Date expiryDate;

    /**annotation to express the relationship between LibraryCard and User**/
    @ManyToOne
    /**annotation to express the column in which the tables will be joined**/
    @JoinColumn(name="userid")
    /**user object represents the user entity**/
    @JsonManagedReference
    private User user;

    /**default constructor for LibraryCard class**/
    public LibraryCard() {
    }

    /**
     *
     * constructor for LibraryCard class creates a copy of the class
     *
     * @param id is the id of the entity
     * @param dateRegistered is the registration date of entity
     * @param expiryDate is the expiration date of the entity
     * **/
    public LibraryCard(Integer id, Date dateRegistered, Date expiryDate) {
        this.id = id;
        this.dateRegistered = dateRegistered;
        this.expiryDate = expiryDate;
    }

    //--------------------------------
    //CLass Methods
    //
    //-------------------------------

    /**getter for the id of the LibraryCard class**/
    public Integer getId() {
        return id;
    }

    /**setter for the id of the LibraryCard class**/
    public void setId(Integer id) {
        this.id = id;
    }

    /**getter for the DateRegistered property of the LibraryCard class**/
    public Date getDateRegistered() {
        return dateRegistered;
    }

    /**setter for the DateRegistered property of the LibraryCard class**/
    public void setDateRegistered(Date dateRegistered) {
        this.dateRegistered = dateRegistered;
    }

    /**getter for the ExpiryDate property of the LibraryCard class**/
    public Date getExpiryDate() {
        return expiryDate;
    }

    /**setter for the ExpiryDate property of the LibraryCard class**/
    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

}
