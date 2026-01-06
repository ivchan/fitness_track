package homelab.ftrack.controller.test;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import homelab.ftrack.util.KeyValueUtility;

@RestController
@RequestMapping("/test")
public class TestController {
  private final KeyValueUtility kvUtil;

  public TestController(KeyValueUtility kvUtil) {
    this.kvUtil = kvUtil;
  }

  @GetMapping("/putkv/{msg}")
  public ResponseEntity<?> putkv(@PathVariable("msg") String msg) {
    try {
      kvUtil.setValue("test01", msg.toUpperCase());
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
      return ResponseEntity.ok(retValue.toLowerCase());
    } catch (Exception e) {
      e.printStackTrace();
      return ResponseEntity.ok("fail");
    }
  }

  @GetMapping("/removekv")
  public ResponseEntity<?> clearkv() {
    try {
      kvUtil.removeValue("test01");
      return ResponseEntity.ok("removed");
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
