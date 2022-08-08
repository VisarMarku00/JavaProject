package Projects.JavaProject.Repository;

import Projects.JavaProject.Pojo.Entity.LibraryCard;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**the repository for the LibraryCard table**/
public interface LibraryCardRepository extends CrudRepository<LibraryCard, Integer> {

    /**this function finds all the libraryCards in the table**/
    List<LibraryCard> findAll();
    /**this function finds a LibraryCard that has the id that was entered**/
    LibraryCard findCardById(Integer id);
}
