package Projects.JavaProject.Controller;

import Projects.JavaProject.Pojo.Entity.LibraryCard;
import Projects.JavaProject.Pojo.Input.LibraryCardInput;
import Projects.JavaProject.Service.LibraryCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class LibraryCardController {


    private final LibraryCardService libraryCardService;

    public LibraryCardController(LibraryCardService libraryCardService) {
        this.libraryCardService = libraryCardService;
    }

    /** get request to find every library card**/
    @GetMapping("/librarycard")
    public List<LibraryCard> getAllLibraryCards(){
        return libraryCardService.findAll();
    }

    /** get request to find a library card by id**/
    @GetMapping("/librarycard/{id}")
    public LibraryCard getLibraryCardById(@PathVariable Integer id){
        return libraryCardService.findCardById(id);
    }

    /** post request to input a library card in the database**/
    @PostMapping("/librarycard")
    public LibraryCard insertNewLibraryCard(@RequestBody LibraryCardInput libraryCardInput){
        return libraryCardService.save(libraryCardInput);
    }

    /** delete request to delete a library card from the database**/
    @DeleteMapping("/librarycard/{id}")
    public Boolean deleteLibraryCard(@PathVariable Integer id){
        libraryCardService.delete(id);
        return true;
    }
}
