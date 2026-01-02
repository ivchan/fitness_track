package homelab.ftrack.controller.test;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import homelab.ftrack.util.RedisUtil;

@RestController
@RequestMapping("/test")
public class TestController {
  private final RedisUtil redisUtil;

  public TestController(RedisUtil redisUtil) {
    this.redisUtil = redisUtil;
  }

  @GetMapping("/submitredis")
  public ResponseEntity<?> get() {
    redisUtil.setRedisValue("test01", "Hello World");
    return ResponseEntity.ok("success");
  }
}
