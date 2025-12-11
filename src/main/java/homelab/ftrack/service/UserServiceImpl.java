package homelab.ftrack.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import homelab.ftrack.model.User;
import homelab.ftrack.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
  private final UserRepository userRepository;

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
    User saved = this.userRepository.insert(user);
    return saved;
  }

  @Override
  public boolean exists(String userId) {
    return this.userRepository.existsById(userId);
  }

  @Override
  public void emptyCollection() {
    this.userRepository.deleteAll();
  }

  @Override
  public User getUser(String userId) {
    return this.userRepository.findById(userId).orElse(null);
  }

  @Override
  public User updateUser(User user) {
    User existUser = this.userRepository.findById(user.getId()).orElse(null);
    if (existUser == null) {
      return null;
    }
    existUser.setUserCode(user.getUserCode());
    existUser.setUserName(user.getUserName());
    existUser.setEmailAddress(user.getEmailAddress());
    existUser.setUpdatedAt(LocalDateTime.now());
    return this.userRepository.save(existUser);
  }

  @Override
  public void removeUser(String userId) {
    this.userRepository.deleteById(userId);
  }
}
