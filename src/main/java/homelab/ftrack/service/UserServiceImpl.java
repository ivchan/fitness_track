package homelab.ftrack.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import homelab.ftrack.model.User;
import homelab.ftrack.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
  private final UserRepository userRepository;
  private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

  public UserServiceImpl(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public List<User> listUsers() {
    List<User> users = this.userRepository.findAll();
    return users;
  }

  @Override
  public User addUser(User user) {
    if (user.getId().isEmpty()) {
      user.setId(UUID.randomUUID().toString());
    }
    User saved = this.userRepository.insert(user);
    logger.info("Saved new user {}", user);
    return saved;
  }

  @Override
  public boolean exists(String userId) {
    return this.userRepository.existsById(userId);
  }

  @Override
  public User getUser(String userId) {
    return this.userRepository.findById(userId).orElse(null);
  }

  @Override
  public User updateUser(User user) {
    User existUser = this.userRepository.findById(user.getId()).orElse(null);
    if (existUser == null) {
      logger.info("User not found for updating, {}", user);
      return null;
    }
    existUser.setUserCode(user.getUserCode());
    existUser.setUserName(user.getUserName());
    existUser.setEmailAddress(user.getEmailAddress());
    existUser.setUpdatedAt(LocalDateTime.now());
    existUser = this.userRepository.save(existUser);
    logger.info("Updated user {}", existUser);
    return existUser;
  }

  @Override
  public void removeUser(String userId) {
    this.userRepository.deleteById(userId);
    logger.info("Deleted user {}", userId);
  }
}
