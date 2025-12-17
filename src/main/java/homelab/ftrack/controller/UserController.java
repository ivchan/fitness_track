package homelab.ftrack.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import homelab.ftrack.model.User;
import homelab.ftrack.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
  private final UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }

  @PostMapping
  public ResponseEntity<?> create(@RequestBody User user) {
    if (userService.exists(user.getId())) {
      return ResponseEntity.status(HttpStatus.CONFLICT).build();
    }
    User savedUser = this.userService.addUser(user);
    return new ResponseEntity<User>(savedUser, HttpStatus.CREATED);
  }

  @PutMapping
  public ResponseEntity<?> update(@RequestBody User user) {
    if (!userService.exists(user.getId())) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
    User savedUser = this.userService.updateUser(user);
    return ResponseEntity.ok(savedUser);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<?> delete(@PathVariable("id") String id) {
    this.userService.removeUser(id);
    return ResponseEntity.ok().build();
  }

  @GetMapping("/{id}")
  public ResponseEntity<?> get(@PathVariable("id") String id) {
    User user = this.userService.getUser(id);
    if (user == null) {
      return ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok(user);
  }

  @GetMapping()
  public ResponseEntity<?> list() {
    return ResponseEntity.ok(this.userService.listUsers());
  }
}
