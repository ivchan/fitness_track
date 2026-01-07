package homelab.ftrack.controller;

import java.util.Base64;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import homelab.ftrack.service.DailySummaryService;
import homelab.ftrack.util.KeyValueUtility;

@RestController
@RequestMapping("/activity")
public class ActivityController {
  private final DailySummaryService dailySummaryService;
  private final KeyValueUtility keyValueUtility;

  public ActivityController(DailySummaryService dailySummaryService, KeyValueUtility keyValUtil) {
    this.dailySummaryService = dailySummaryService;
    this.keyValueUtility = keyValUtil;
  }

  @PostMapping("/image")
  public ResponseEntity<?> uploadMealImageKv(@RequestParam("file") MultipartFile file,
      @RequestParam("summaryKey") String summaryKey) throws Exception {

    byte[] imageBytes = file.getBytes();
    String imageBase64 = Base64.getEncoder().encodeToString(imageBytes);
    String imgKey = "MEALIMAGE_d51b46b5-5693-4f4b-b92c-45da7887173a";
    keyValueUtility.setValue(imgKey, imageBase64);

    return ResponseEntity.ok("succes");
  }

}
