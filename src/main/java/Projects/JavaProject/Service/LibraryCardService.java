package Projects.JavaProject.Service;

import Projects.JavaProject.Pojo.Entity.LibraryCard;
import Projects.JavaProject.Pojo.Input.LibraryCardInput;

import java.util.List;

/**this is the interface with all the necessary functions for the DefaultLibraryCardService**/
public interface LibraryCardService {

    /**method to find all the libraryCards in the table**/
    List<LibraryCard> findAll();

    /**method to find a libraryCard by id**/
    LibraryCard findCardById(Integer id);

    /**method to delete a libraryCard from the table**/
    void delete(Integer id);

    /**method to save a new libraryCard to the table**/
    LibraryCard save(LibraryCardInput libraryCardInput);
}
