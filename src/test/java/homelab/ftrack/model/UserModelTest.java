package homelab.ftrack.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class UserModelTest {
  private User userTest;

  @BeforeEach
  void setUp() {
    String uid = UUID.randomUUID().toString();

    userTest = new User(uid, "u1", "User01");
  }

  @Test
  void constructor_NoParam() throws Exception {
    User u = new User();
    u.setId(userTest.getId());
    u.setUserCode(userTest.getUserCode());
    u.setUserName(userTest.getUserName());
    u.setPasswordHash(userTest.getPasswordHash());
    u.setEmailAddress(userTest.getEmailAddress());
    assertNotNull(u);
    assertEquals(u.getId(), userTest.getId());
    assertEquals(u.getUserCode(), userTest.getUserCode());
    assertEquals(u.getUserName(), userTest.getUserName());
    assertEquals(u.getEmailAddress(), userTest.getEmailAddress());
    assertEquals(u.getPasswordHash(), userTest.getPasswordHash());
  }

  @Test
  void constructor_3Param() throws Exception {
    String uid = UUID.randomUUID().toString();

    User u = new User(userTest.getId(), userTest.getUserCode(), userTest.getUserName());
    assertNotNull(u);
    assertEquals(u.getId(), userTest.getId());
    assertEquals(u.getUserCode(), userTest.getUserCode());
    assertEquals(u.getUserName(), userTest.getUserName());
  }

}
