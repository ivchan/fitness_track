package homelab.ftrack.controller;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import homelab.ftrack.model.User;
import homelab.ftrack.service.UserService;
import tools.jackson.databind.ObjectMapper;

@WebMvcTest(UserController.class)
class UserControllerTest {
  @Autowired
  private MockMvc mockMvc;

  @MockitoBean
  private UserService userService;

  @Autowired
  private ObjectMapper objectMapper;

  @Test
  void list_ReturnListOfUsers() throws Exception {
    List<User> mockUsers = List.of(new User("T001", "test1", "TEST USER 1"), new User("T002", "test2", "TEST USER 2"),
        new User("T003", "test3", "TEST USER 3"));
    when(userService.listUsers()).thenReturn(mockUsers);

    mockMvc.perform(get("/user")).andExpect(status().isOk()).andExpect(jsonPath("$[0].id").value("T001"))
        .andExpect(jsonPath("$[1].id").value("T002")).andExpect(jsonPath("$[2].id").value("T003"));
  }

  @Test
  void get_WhenExist_ReturnUser() throws Exception {
    when(userService.getUser("123")).thenReturn(new User("T001", "test1", "TEST USER 1"));

    mockMvc.perform(get("/user/123")).andExpect(status().isOk());
  }

  @Test
  void get_WhenNotExist_ReturnNull() throws Exception {
    when(userService.getUser("123")).thenReturn(null);

    mockMvc.perform(get("/user/123")).andExpect(status().isNotFound());
  }

  @Test
  void delete_ReturnOK() throws Exception {
    userService.removeUser("123");
    verify(userService).removeUser("123");
    verify(userService, times(1)).removeUser("123");
    verifyNoMoreInteractions(userService);

    mockMvc.perform(delete("/user/123")).andExpect(status().isOk());
  }

  @Test
  void create_WhenExist_ReturnConflict() throws Exception {
    User existUser = new User("existid", "exist", "exist");

    when(userService.exists(existUser.getId())).thenReturn(true);
    String jsonReq = objectMapper.writeValueAsString(existUser);
    mockMvc
        .perform(
            post("/user").content(jsonReq).contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
        .andDo(print()).andExpect(status().isConflict());
  }

  @Test
  void create_WhenNotExist_ReturnCreated() throws Exception {
    User notExistUser = new User("notexistid", "notexist", "notexist");

    when(userService.exists(notExistUser.getId())).thenReturn(false);
    String jsonReq = objectMapper.writeValueAsString(notExistUser);
    mockMvc
        .perform(
            post("/user").content(jsonReq).contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
        .andDo(print()).andExpect(status().isCreated());
  }

  @Test
  void update_WhenNotExist_ReturnNotFound() throws Exception {
    User notExistUser = new User("notexistid", "notexist", "notexist");

    when(userService.exists(notExistUser.getId())).thenReturn(false);
    String jsonReq = objectMapper.writeValueAsString(notExistUser);
    mockMvc
        .perform(
            put("/user").content(jsonReq).contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
        .andDo(print()).andExpect(status().isNotFound());
  }

  @Test
  void update_WhenExist_ReturnOk() throws Exception {
    User existUser = new User("existid", "exist", "exist");

    when(userService.exists(existUser.getId())).thenReturn(true);
    String jsonReq = objectMapper.writeValueAsString(existUser);
    mockMvc
        .perform(
            put("/user").content(jsonReq).contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
        .andDo(print()).andExpect(status().isOk());
  }
}
