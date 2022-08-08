package Projects.JavaProject.Repository;

import Projects.JavaProject.Pojo.Entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**the repository for User table**/
public interface UserRepository extends CrudRepository<User, Integer> {

    /**this function finds all the users in the table by id**/
    List<User> findAll();
    /**this function finds a user that has the id that was entered**/
    User findUserById(Integer id);
    /**this annotation allows us to use SQL queries to search for the users by firstName and lastName
     * @param firstName is the first name of the user we are looking for
     * @param lastName is the lasr name of the user we are looking for
     *
     * @return the user with the first and last name we are looking for
     * **/
    @Query("SELECT u from User u where u.firstName= :firstname and u.lastName= :lastname")
    /**this function is used to find users in the table by firstName and lastName**/
    List<User> findUserByFirstNameAndLastName(@Param("firstname") String firstName,
                                              @Param("lastname") String lastName);

}
