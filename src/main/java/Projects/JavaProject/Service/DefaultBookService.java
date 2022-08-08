package Projects.JavaProject.Service;

import Projects.JavaProject.Pojo.Entity.Book;
import Projects.JavaProject.Pojo.Input.BookInput;
import Projects.JavaProject.Repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
/**in this class we do the implementation of the methods from the BookService interface**/
public class DefaultBookService implements BookService {
    /**this class contains the methods to find the Books by different criteria**/
    private final BookRepository bookRepository;

    public DefaultBookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


    /** this annotation denotes that the child class method overrides the base class method**/
    @Override
    /**method to find all the books in the table
     *
     * @return a list of all the books
     * **/
    public List<Book> findAll() {
        return bookRepository.findAll();
    }
    @Override
    /**method to find a book by its id
     *
     * @param id is the id of the book we are looking for
     *
     * @return it returns the book with the id
     * **/
    public Book findBookById(Integer id) {
        if (id == null) {
            return null;
        }
        return bookRepository.findBookById(id);
    }
    @Override
    /**method to save a new book to the table
     *
     * @param bookInput the book we are trying to add to the database
     *
     * @return the book is added to the database
     * **/
    public Book save(BookInput bookInput) {
        String title=bookInput.getTitle();
        String author=bookInput.getAuthor();
        String genre=bookInput.getGenre();
        int year= bookInput.getYear();

        Book book=new Book();
        book.setTitle(title);
        book.setAuthor(author);
        book.setGenre(genre);
        book.setYear(year);
        return bookRepository.save(book);
    }
    @Override
    /**method to update a book in the table
     *
     * @param id is the book we are tryin to change
     * @param bookInput is the updates we added to the book
     *
     * @return the book has been updated
     * **/
    public Book update(Integer id, BookInput bookInput) {
        Book book=bookRepository.findBookById(id);
        if(book==null){
            return null;
        }
        String updatedTitle= bookInput.getTitle();
        String updatedAuthor=bookInput.getAuthor();
        String updatedGenre=bookInput.getGenre();
        int updatedYear = bookInput.getYear();

        book.setTitle(updatedTitle);
        book.setGenre(updatedGenre);
        book.setAuthor(updatedAuthor);
        book.setYear(updatedYear);

        return bookRepository.save(book);
    }
    @Override
    /**method to delete a book from the table
     *
     * @param id is the id of the book we are trying to delete
     *
     * @return the book has been deleted
     * **/
    public void delete(Integer id) {
        bookRepository.deleteById(id);
    }
    @Override
    /**this function is used to find books in the table by author
     *
     * @param author the name of the author whose books we are looking for
     *
     * @return the books by the same author
     * **/
    public List<Book> findBookByAuthor(String author) {
        return bookRepository.findBookByAuthor(author);
    }
    @Override
    /**this function is used to find books in the table by genre
     *
     * @param genre we are looking up the books in the database by their genre
     *
     * @return it returns the books of the same genre
     * **/
    public List<Book> findBookByGenre(String genre) {
        return bookRepository.findBookByGenre(genre);
    }
    @Override
    /**this function is used to find books in the table by year
     *
     * @param year we are looking up the books in the database by their year of release
     *
     *
     * @return it returns the books released in the same year
     * **/
    public List<Book> findBookByYear(int year) {
        return bookRepository.findBookByYear(year);
    }
}
