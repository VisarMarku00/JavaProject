package Projects.JavaProject.Service;

import Projects.JavaProject.Pojo.Entity.User;
import Projects.JavaProject.Pojo.Input.UserInput;
import Projects.JavaProject.Repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
/**in this class we do the implementation of the methods from the UserService interface**/
public class DefaultUserService implements UserService{
    /**this class contains the methods to find the User by different criteria**/
    private final UserRepository userRepository;

    public DefaultUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    /**method to find all the users in the table
     *
     *
     * @return all the users in the database
     * **/
    public List<User> findAll() {
        return userRepository.findAll();
    }
    @Override
    /**method to find a user by id
     *
     * @param id the id of the user we are looking for
     *
     *
     * @return the user with the id we were looking for
     * **/
    public User findUserById(Integer id) {
        if(id==null){
            return null;
        }
        return userRepository.findUserById(id);
    }
    @Override
    /**method to save a new user to the table
     *
     * @param userInput a new user we want to add to the database
     *
     * @return the user is added to the database
     * **/
    public User save(UserInput userInput) {
        String firstName=userInput.getFirstName();
        String lastName=userInput.getLastName();
        Date dateOfBirth=userInput.getDateOfBirth();
        String address=userInput.getAddress();

        User user=new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setDateOfBirth(dateOfBirth);
        user.setAddress(address);
        return userRepository.save(user);
    }
    @Override
    /**method to update a user in the table
     *
     * @param id the id of the user we want to update
     * @param userInput the updated body of the user
     *
     * @return the user has been updated in the database
     * **/
    public User update(Integer id, UserInput userInput) {
        User user=userRepository.findUserById(id);
        if(user==null){
            return null;
        }
        String updatedFirstName=userInput.getFirstName();
        String updatedLastName=userInput.getLastName();
        Date updatedDate=userInput.getDateOfBirth();
        String address=userInput.getAddress();

        user.setLastName(updatedLastName);
        user.setFirstName(updatedFirstName);
        user.setDateOfBirth(updatedDate);
        user.setAddress(address);
        return userRepository.save(user);

    }
    @Override
    /**method to delete a user from the table
     *
     * @param id the id of the user we want to remove from the database
     *
     * @return the user has been removed from the database
     * **/
    public void delete(Integer id) {
        userRepository.deleteById(id);
    }
    @Override
    /**method to find the user by first name and last name
     *
     * @param firstName the first name of the user we are looking for
     * @param lastName the last name of the user we are looking for
     *
     *
     * @return the user with the first and last name that we were looking for
     * **/
    public List<User> findUserByFirstNameAndLastName(String firstName, String lastName) {
        return userRepository.findUserByFirstNameAndLastName(firstName,lastName);
    }
}