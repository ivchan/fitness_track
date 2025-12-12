package homelab.ftrack.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
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
  private List<User> listTestUser;

  @BeforeEach
  void setUp() {
    testUser = new User();
    testUser.setId("7fcc6501-e116-4118-a92e-559e5bfc32da");
    testUser.setUserName("Tester Account");
    testUser.setUserCode("tester");
    testUser.setEmailAddress("testac@email.com");

    listTestUser = new ArrayList<User>();
    User testUser1 = new User();
    testUser1.setId("009e25e4-7a43-4eed-b994-db7e1ed4cf25");
    testUser1.setUserName("Tester 1");
    testUser1.setUserCode("tester1");
    testUser1.setEmailAddress("testac1@email.com");

    User testUser2 = new User();
    testUser2.setId("a7fc5237-3378-4fb0-8996-5ba4e2590c64");
    testUser2.setUserName("Tester 2");
    testUser2.setUserCode("tester2");
    testUser2.setEmailAddress("testac2@email.com");

    User testUser3 = new User();
    testUser3.setId("ac6eb5ab-648b-48da-b0a1-881a04b15b1e");
    testUser3.setUserName("Tester 3");
    testUser3.setUserCode("tester3");
    testUser3.setEmailAddress("testac3@email.com");

    listTestUser.add(testUser1);
    listTestUser.add(testUser2);
    listTestUser.add(testUser3);
  }

  @Test
  void getUser_WhenExist_ShouldReturnUser() {
    String uid = "7fcc6501-e116-4118-a92e-559e5bfc32da";
    when(userRepository.findById(uid)).thenReturn(Optional.of(testUser));
    User result = userService.getUser(uid);

    // Assert
    assertNotNull(result);
    assertEquals("Tester Account", result.getUserName());
    assertEquals("tester", result.getUserCode());
    assertEquals("testac@email.com", result.getEmailAddress());
  }

  @Test
  void getUser_WhenNotExist_ShouldReturnNull() {
    String uid = "NA";
    when(userRepository.findById(uid)).thenReturn(Optional.empty());
    User result = userService.getUser(uid);

    assertNull(result);
  }

  @Test
  void emptyCollection_CallsRepositoryDeleteAll() {
    userService.emptyCollection();
    verify(userRepository).deleteAll();
  }

  @Test
  void removeUser_CallsRepositoryDelete() {
    String uid = "TEST-UID";
    userService.removeUser(uid);
    verify(userRepository).deleteById(uid);
  }

  @Test
  void exists_WhenExist_ShouldReturnTrue() {
    String existUid = "Exist";
    String notExistUid = "NotExist";
    when(userRepository.existsById(existUid)).thenReturn(true);
    when(userRepository.existsById(notExistUid)).thenReturn(false);
    assertEquals(true, userService.exists(existUid));
    assertEquals(false, userService.exists(notExistUid));
  }

  @Test
  void listUsers_ShouldReturnList() {
    when(userRepository.findAll()).thenReturn(listTestUser);
    List<User> result = userService.listUsers();
    assertNotNull(result);
    assertEquals(listTestUser.size(), result.size());
  }

  @Test
  void addUser_WhenWithId_ShouldReturnUser() {
    when(userRepository.insert(testUser)).thenReturn(testUser);
    User result = userService.addUser(testUser);
    verify(userRepository, times(1)).insert(any(User.class));
    assertNotNull(result);
  }

  @Test
  void addUser_WhenWithoutId_ShouldReturnUserWithId() {
    when(userRepository.insert(testUser)).thenReturn(testUser);
    testUser.setId("");
    User result = userService.addUser(testUser);
    verify(userRepository, times(1)).insert(testUser);
    assertNotNull(result);
    assertEquals(false, result.getId().isEmpty());
  }

  @Test
  void updateUser_WhenNotExist_ShouldReturnNull() {
    String existUid = "Exist";
    String notExistUid = "NotExist";

    when(userRepository.findById(notExistUid)).thenReturn(Optional.empty());
    testUser.setId(notExistUid);
    User result = userService.updateUser(testUser);
    assertNull(result);
    verify(userRepository, never()).save(testUser);
  }

  @Test
  void updateUser_WhenExist_ShouldReturnUser() {
    String existUid = "Exist";
    String notExistUid = "NotExist";

    when(userRepository.findById(existUid)).thenReturn(Optional.of(testUser));
    when(userRepository.save(any(User.class))).thenReturn(testUser);
    testUser.setId(existUid);
    User result = userService.updateUser(testUser);
    assertNotNull(result);
    verify(userRepository, times(1)).save(testUser);
  }

}