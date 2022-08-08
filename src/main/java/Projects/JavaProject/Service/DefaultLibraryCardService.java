package Projects.JavaProject.Service;

import Projects.JavaProject.Pojo.Entity.LibraryCard;
import Projects.JavaProject.Pojo.Input.LibraryCardInput;
import Projects.JavaProject.Repository.LibraryCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
/**in this class we do the implementation of the methods from the LibraryCardService interface**/
public class DefaultLibraryCardService implements  LibraryCardService{

    @Autowired
    /**this class contains the methods to find the LibraryCard by different criteria**/
    private LibraryCardRepository libraryCardRepository;

    @Override
    /**this function finds all the libraryCards in the table
     *
     * @return all the books in the database
     * **/
    public List<LibraryCard> findAll() {
        return libraryCardRepository.findAll();
    }

    @Override
    /**this function finds a LibraryCard that has the id that was entered
     *
     * @param id the id of the library card we are looking for
     *
     *
     * @return the library card that has the id we entered
     * **/
    public LibraryCard findCardById(Integer id) {
        if (id == null) {
            return null;
        }
        return libraryCardRepository.findCardById(id);
    }

    @Override
    /**method to delete a libraryCard from the table
     *
     * @param id the id of the library card we want to delete
     *
     *
     * @return the library card with the id is deleted
     * **/
    public void delete(Integer id) {
        libraryCardRepository.deleteById(id);
    }

    @Override
    /**method to save a new libraryCard to the table
     *
     * @param librarycardInput we input the library card to the database
     *
     *
     * @return the library card is saved to the database
     * **/
    public LibraryCard save(LibraryCardInput libraryCardInput) {
        Date dateRegistered= libraryCardInput.getDateRegistered();
        Date expiryDate= libraryCardInput.getExpiryDate();

        LibraryCard libraryCard= new LibraryCard();

        libraryCard.setDateRegistered(dateRegistered);
        libraryCard.setExpiryDate(expiryDate);
        return libraryCardRepository.save(libraryCard);
    }

}
