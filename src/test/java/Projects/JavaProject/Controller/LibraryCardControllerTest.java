package Projects.JavaProject.Controller;

import Projects.JavaProject.Pojo.Entity.LibraryCard;
import Projects.JavaProject.Pojo.Entity.User;
import Projects.JavaProject.Pojo.Input.LibraryCardInput;
import Projects.JavaProject.Repository.LibraryCardRepository;
import Projects.JavaProject.Service.LibraryCardService;
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

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(LibraryCardController.class)
public class LibraryCardControllerTest {


    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper mapper;

    @MockBean
    LibraryCardService libraryCardService;

    @MockBean
    LibraryCardRepository libraryCardRepository;

    Date date1=new Date(1000,10,1);
    Date date2=new Date(2000,11,11);


    LibraryCard libraryCard1=new LibraryCard(1,date1,date2);
    LibraryCard libraryCard2=new LibraryCard(2,date1,date2);
    LibraryCard libraryCard3=new LibraryCard(3,date1,date2);

    public LibraryCardControllerTest() throws ParseException {
    }

    @Test
    public void getAllLibraryCards_success() throws Exception {
        List<LibraryCard> libraryCards=new ArrayList<>(Arrays.asList(libraryCard1,libraryCard2,libraryCard3));

        Mockito.when(libraryCardService.findAll()).thenReturn(libraryCards);

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/librarycard")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$",hasSize(3)))
                .andExpect(jsonPath("$[2].id", is(3)));
    }

    @Test
    public void getLibraryCardById_success() throws Exception {
        Mockito.when(libraryCardService.findCardById(libraryCard1.getId())).thenReturn(libraryCard1);

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/librarycard/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$",notNullValue()))
                .andExpect(jsonPath("$.id", is(1)));
    }

    @Test
    public void insertNewLibraryCard_success() throws Exception {

        Mockito.when(libraryCardService.save(new LibraryCardInput())).thenReturn(libraryCard1);

        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post("/librarycard")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(this.mapper.writeValueAsString(libraryCard1));

        mockMvc.perform(mockRequest)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", notNullValue()))
                .andExpect(jsonPath("$.id", is("1")));
    }

    @Test
    public void deleteLibraryCardById_success() throws Exception {
        Mockito.when(libraryCardService.findCardById(libraryCard1.getId())).thenReturn(libraryCard1);

        mockMvc.perform(MockMvcRequestBuilders
                        .delete("/librarycard/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}
