package homelab.ftrack.model;

import org.springframework.data.annotation.Id;

//@Document(collection = "ft_users")
public class User extends BaseModel {
  @Id
  private String id;
  private String userCode;
  private String userName;
  private String emailAddress;
  private String passwordHash;

  public User() {
  }

  public User(String id, String userCode, String userName) {
    super();
    this.id = id;
    this.userCode = userCode;
    this.userName = userName;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getUserCode() {
    return userCode;
  }

  public void setUserCode(String userCode) {
    this.userCode = userCode;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getEmailAddress() {
    return emailAddress;
  }

  public void setEmailAddress(String emailAddress) {
    this.emailAddress = emailAddress;
  }

  public String getPasswordHash() {
    return passwordHash;
  }

  public void setPasswordHash(String passwordHash) {
    this.passwordHash = passwordHash;
  }

}
