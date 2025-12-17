package homelab.ftrack.service;

import java.util.List;

import homelab.ftrack.model.User;

public interface UserService {
  List<User> listUsers();

  User getUser(String userId);

  User addUser(User user);

  User updateUser(User user);

  void removeUser(String userId);

  boolean exists(String userId);
}
