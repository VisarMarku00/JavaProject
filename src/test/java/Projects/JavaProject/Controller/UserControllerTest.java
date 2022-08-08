package Projects.JavaProject.Controller;

import Projects.JavaProject.Pojo.Entity.User;
import Projects.JavaProject.Pojo.Input.UserInput;
import Projects.JavaProject.Repository.UserRepository;
import Projects.JavaProject.Service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UserController.class)
public class UserControllerTest {

    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper mapper;

    @MockBean
    UserService userService;

    @MockBean
    UserRepository userRepository;

    Date date=new Date(2000,10,10);
    User user1=new User(1,"Visar","Marku",date,"Xhon Kenedi");

    User user2=new User(2,"Misar","Varku",date,"Woodrow Wilson");

    User user3=new User(3,"Wisar","Warku",date,"Abraham Lincoln");

    UserInput userInput=new UserInput("Visar","Marku",date,"Xhon Kenedi");


    @Test
    public void getAllUsers_success() throws Exception {
        List<User> users=new ArrayList<>(Arrays.asList(user1,user2,user3));

        Mockito.when(userService.findAll()).thenReturn(users);

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/user")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$",hasSize(3)))
                .andExpect(jsonPath("$[2].firstName", is("Wisar")));
    }

    @Test
    public void getUserById_success() throws Exception {
        Mockito.when(userService.findUserById(user1.getId())).thenReturn(user1);

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/user/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$",notNullValue()))
                .andExpect(jsonPath("$.firstName", is("Visar")));
    }

    @Test
    public void insertNewUser_success() throws Exception {

        Mockito.when(userService.save(userInput)).thenReturn(user1);

        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post("/user")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(this.mapper.writeValueAsString(user1));

        mockMvc.perform(mockRequest)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", notNullValue()))
                .andExpect(jsonPath("$.firstName", is("Visar")));
    }

    @Test
    public void updateUser_success() throws Exception {
        User updatedUser =new User(3,"Wisar","Warku",date,"Abraham Lincoln");

        Mockito.when(userService.findUserById(user1.getId())).thenReturn(user1);
        Mockito.when(userService.update(1,userInput)).thenReturn(updatedUser);

        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.put("/user/1")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(this.mapper.writeValueAsString(updatedUser));

        mockMvc.perform(mockRequest)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", notNullValue()))
                .andExpect(jsonPath("$.firstName", is("Wisar")));
    }

    @Test
    public void deleteUserById_success() throws Exception {
        Mockito.when(userService.findUserById(user1.getId())).thenReturn(user1);

        mockMvc.perform(MockMvcRequestBuilders
                        .delete("/user/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}
