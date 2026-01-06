package homelab.ftrack.controller.test;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import homelab.ftrack.util.KeyValUtil;

@RestController
@RequestMapping("/test")
public class TestController {
  private final KeyValUtil kvUtil;

  public TestController(KeyValUtil kvUtil) {
    this.kvUtil = kvUtil;
  }

  @GetMapping("/putkv")
  public ResponseEntity<?> putkv() {
    try {
      kvUtil.setValue("test01", "this is a success case");
      return ResponseEntity.ok("success");
    } catch (Exception e) {
      e.printStackTrace();
      return ResponseEntity.ok("fail");
    }
  }

  @GetMapping("/getkv")
  public ResponseEntity<?> getkv() {
    try {
      String retValue = kvUtil.getValue("test01");
      return ResponseEntity.ok(retValue);
    } catch (Exception e) {
      e.printStackTrace();
      return ResponseEntity.ok("fail");
    }
  }

  @GetMapping("/submitimage")
  public ResponseEntity<?> get() {
    return ResponseEntity.ok("success");
  }
}
