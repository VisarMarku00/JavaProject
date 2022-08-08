package Projects.JavaProject.Repository;

import Projects.JavaProject.Pojo.Entity.Book;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**the repository for the Book table**/
public interface BookRepository extends CrudRepository<Book, Integer> {

    /**this function finds all the books in the table by id**/
    List<Book> findAll();
    /**this function finds a book that has the id that was entered**/
    Book findBookById(Integer id);


    /**this annotation allows us to use SQL queries to search for the books by author
     *
     * @param author the name of the author whose books we are looking for
     *
     * @return the list of books from this author
     * **/
    @Query( "SELECT  b FROM Book b where b.author= :author")
    /**this function is used to find books in the table by author**/
    List<Book> findBookByAuthor(@Param("author") String author);


    /**this annotation allows us to use SQL queries to search for the books by genre
     *
     * @param genre the genre of books we are looking for
     *
     * @return the list of books from the same genre
     * **/
    @Query("SELECT b from Book b where b.genre= :genre")
    /**this function is used to find books in the table by genre**/
    List<Book> findBookByGenre(@Param("genre") String genre);


    /**this annotation allows us to use SQL queries to search for the books by year
     *
     * @param year the year the books were published
     *
     * @return a list of books that were published in that year
     * **/
    @Query("SELECT b from Book b where b.year= :year")
    /**this function is used to find books in the table by year**/
    List<Book> findBookByYear(@Param("year") int year);
}
