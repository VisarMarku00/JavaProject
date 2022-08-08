package Projects.JavaProject.Controller;


import Projects.JavaProject.Pojo.Entity.Book;
import Projects.JavaProject.Pojo.Input.BookInput;
import Projects.JavaProject.Repository.BookRepository;
import Projects.JavaProject.Service.BookService;
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
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.*;

@WebMvcTest(BookController.class)
public class BookControllerTest {
    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper mapper;

    @MockBean
    BookService bookService;

    @MockBean
    BookRepository bookRepository;

    Book book1= new Book(1,"1984", "George Orwell", "Dystopian", 1949);
    Book book2= new Book(2,"Dune", "Frank Herbert", "Sci-Fi", 1959);
    Book book3= new Book(3,"A Song Of Ice And Fire", "George R.R. Martin", "Fantasy", 1992);

    BookInput bookInput=new BookInput("1984","George Orwell","Dystopian",1949);

    @Test
    public void getAllBooks_success() throws Exception {
        List<Book> books=new ArrayList<>(Arrays.asList(book1,book2,book3));

        Mockito.when(bookService.findAll()).thenReturn(books);

        mockMvc.perform(MockMvcRequestBuilders
                .get("/book")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$",hasSize(3)))
                .andExpect(jsonPath("$[2].title", is("A Song Of Ice And Fire")));
    }

    @Test
    public void getBookById_success() throws Exception {
        Mockito.when(bookService.findBookById(book1.getId())).thenReturn(book1);

        mockMvc.perform(MockMvcRequestBuilders
                .get("/book/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$",notNullValue()))
                .andExpect(jsonPath("$.title", is("1984")));
    }

    @Test
    public void insertNewBook_success() throws Exception {

        Mockito.when(bookService.save(bookInput)).thenReturn(book1);

        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post("/book")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(this.mapper.writeValueAsString(book1));

        mockMvc.perform(mockRequest)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", notNullValue()))
                .andExpect(jsonPath("$.title", is("1984")));
    }

    @Test
    public void updateBook_success() throws Exception {


        Mockito.when(bookService.findBookById(book1.getId())).thenReturn(book1);
        Mockito.when(bookService.update(1,bookInput)).thenReturn(book2);

        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.put("/book/1")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(this.mapper.writeValueAsString(book2));

        mockMvc.perform(mockRequest)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", notNullValue()))
                .andExpect(jsonPath("$.id", is(2)));
    }

    @Test
    public void deleteBookById_success() throws Exception {
        Mockito.when(bookService.findBookById(book1.getId())).thenReturn(book1);

        mockMvc.perform(MockMvcRequestBuilders
                        .delete("/book/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }


}


