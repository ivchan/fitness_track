package homelab.ftrack.controller;

import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import homelab.ftrack.model.User;
import homelab.ftrack.service.UserService;

@RestController
@RequestMapping("/api/init")
public class InitController {
  private final UserService userService;

  public InitController(UserService userService) {
    this.userService = userService;
  }

  @PostMapping()
  public void Initial() {
    this.userService.emptyCollection();

    User admin = new User("115b24c6-e9c2-4d90-a3c9-cfa2be97accb", "sysadmin", "System Admin.");
    admin.setCreatedAt(LocalDateTime.now());
    admin.setCreatedBy(admin.getUserCode());
    this.userService.addUser(admin);

    User ihmchan = new User("a4a67704-ea8a-4948-991a-00bc068160b3", "ihmchan", "Ivan Chan");
    ihmchan.setCreatedAt(LocalDateTime.now());
    ihmchan.setCreatedBy(ihmchan.getUserCode());
    this.userService.addUser(ihmchan);
  }
}