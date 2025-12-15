package homelab.ftrack.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import homelab.ftrack.model.User;
import homelab.ftrack.service.UserService;

@WebMvcTest(UserController.class)
class UserControllerTest {
  @Autowired
  private MockMvc mockMvc;

  @MockitoBean
  private UserService userService;

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
}
