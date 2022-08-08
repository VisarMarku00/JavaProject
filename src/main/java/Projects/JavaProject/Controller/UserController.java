package Projects.JavaProject.Controller;

import Projects.JavaProject.Pojo.Entity.User;
import Projects.JavaProject.Pojo.Input.UserInput;
import Projects.JavaProject.Service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    /** get request to find every user**/
    @GetMapping("/user")
    public List<User> getAllUsers(){
        return  userService.findAll();
    }

    /** get request to find a user by id**/
    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable Integer id){
        return userService.findUserById(id);
    }

    /** post request to input a user in the database**/
    @PostMapping("/user")
    public User insertNewUser(@RequestBody UserInput userInput){
        return userService.save(userInput);
    }

    /** put request to update a user in the database**/
    @PutMapping("/user/{id}")
    public User updateUser(@PathVariable Integer id,
                           @RequestBody UserInput userInput){
        return userService.update(id, userInput);
    }

    /**delete request to delete a user from database**/
    @DeleteMapping("/user/{id}")
    public Boolean deleteUser(@PathVariable Integer id){
        userService.delete(id);
        return true;
    }

    /**get request to find a user by first name and last name**/
    @RequestMapping(path = "/user/firstLastName/{firstname}/{lastname}", method = RequestMethod.GET)
    public List<User> findUserByFirstNameAndLastName(@PathVariable String firstname,
                                                     @PathVariable String lastname){
        return userService.findUserByFirstNameAndLastName(firstname, lastname);
    }
}
