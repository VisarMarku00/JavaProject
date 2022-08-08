package Projects.JavaProject.Pojo.Input;


import java.util.Date;
/**class for entering the data for the LibraryCard table**/
public class LibraryCardInput {

    /**id property represents the id column of the librarycard entity**/
    private Integer id;
    /**dateRegistered property represents the dateRegistered column of the librarycard entity**/
    private Date dateRegistered;
    /**expiryDate property represents the expiryDate column of the librarycard entity**/
    private Date expiryDate;

    /**default constructor for LibraryCardInput class**/
    public LibraryCardInput() {
    }

    /**constructor for LibraryCardInput class**/
    public LibraryCardInput(Integer id, Date dateRegistered, Date expiryDate) {
        this.id = id;
        this.dateRegistered = dateRegistered;
        this.expiryDate = expiryDate;
    }

    /**getter for the id property of the LibraryCardInput class**/
    public Integer getId() {
        return id;
    }

    /**setter for the id property of the LibraryCardInput class**/
    public void setId(Integer id) {
        this.id = id;
    }

    /**getter for the DateRegistered property of the LibraryCardInput class**/
    public Date getDateRegistered() {
        return dateRegistered;
    }

    /**setter for the DateRegistered property of the LibraryCardInput class**/
    public void setDateRegistered(Date dateRegistered) {
        this.dateRegistered = dateRegistered;
    }

    /**getter for the DateRegistered property of the LibraryCardInput class**/
    public Date getExpiryDate() {
        return expiryDate;
    }

    /**setter for the DateRegistered property of the LibraryCardInput class**/
    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }
}
