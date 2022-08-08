package Projects.JavaProject.Controller;

import Projects.JavaProject.Pojo.Entity.Book;
import Projects.JavaProject.Pojo.Input.BookInput;
import Projects.JavaProject.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

   @Autowired
   private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    /** get request to find every book**/
    @GetMapping("/book")
    public List<Book> getAllBooks(){
        return bookService.findAll();
    }

    /** get request to find a book by id**/
    @GetMapping("/book/{id}")
    public Book getBookById(@PathVariable Integer id){
        return bookService.findBookById(id);
    }

    /** post request to input a book in the database**/
    @PostMapping("/book")
    public Book insertNewBook(@RequestBody BookInput bookInput){
        return bookService.save(bookInput);
    }

    /** put request to update a book in the database**/
    @PutMapping("/book/{id}")
    public Book updateBook(@PathVariable Integer id,
                           @RequestBody BookInput bookInput){
        return bookService.update(id, bookInput);
    }

    /**delete request to delete a book from database**/
    @DeleteMapping("/book/{id}")
    public boolean deleteBook(@PathVariable Integer id){
        bookService.delete(id);
        return true;
    }

    /**get request to find a book by the author**/
    @GetMapping("/book/author/{author}")
    public List<Book> findBookByAuthor(@PathVariable String author){
        return bookService.findBookByAuthor(author);
    }

    /**get request to find a book by the genre**/
    @GetMapping ("/book/genre/{genre}")
    public List<Book> findBookByGenre(@PathVariable String genre){
        return bookService.findBookByGenre(genre);
    }

    /**get request to find a book by the year**/
    @GetMapping("/book/year/{year}")
    public List<Book> findBookByYear(@PathVariable int year){
        return bookService.findBookByYear(year);
    }

}

