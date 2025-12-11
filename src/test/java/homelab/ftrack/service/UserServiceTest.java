package homelab.ftrack.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import homelab.ftrack.model.User;
import homelab.ftrack.repository.UserRepository;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
  @Mock
  private UserRepository userRepository;

  @InjectMocks
  private UserServiceImpl userService;

  private User testUser;

  @BeforeEach
  void setUp() {
    testUser = new User();
    testUser.setId("7fcc6501-e116-4118-a92e-559e5bfc32da");
    testUser.setUserName("Tester Account");
    testUser.setUserCode("tester");
    testUser.setEmailAddress("testac@email.com");
  }

  @Test
  void findUserById_WhenExist_ShouldReturnUser() {
    String uid = "7fcc6501-e116-4118-a92e-559e5bfc32da";
    when(userRepository.findById(uid)).thenReturn(Optional.of(testUser));
    User result = userService.getUser(uid);

    // Assert
    assertNotNull(result);
    assertEquals("Tester Account", result.getUserName());
    assertEquals("tester", result.getUserCode());
    assertEquals("testac@email.com", result.getEmailAddress());
  }
}