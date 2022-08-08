package Projects.JavaProject.Service;

import Projects.JavaProject.Pojo.Entity.User;
import Projects.JavaProject.Pojo.Input.UserInput;

import java.util.List;
/**this is the interface with all the necessary functions for the DefaultUserService**/
public interface UserService {
    /**method to find all the users in the table**/
    List<User> findAll();
    /**method to find a user by id**/
    User findUserById(Integer id);
    /**method to save a new user to the table**/
    User save(UserInput userInput);
    /**method to update a user in the table**/
    User update(Integer id, UserInput userInput);
    /**method to delete a user from the table**/
    void delete(Integer id);
    /**method to find the user by first name and last name**/
    List<User> findUserByFirstNameAndLastName(String firstName,String lastName);
}
