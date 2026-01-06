package homelab.ftrack.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import homelab.ftrack.service.DailySummaryService;
import homelab.ftrack.util.KeyValueUtility;

@RestController
public class ActivityController {
  private final DailySummaryService dailySummaryService;
  private final KeyValueUtility keyValueUtility;

  public ActivityController(DailySummaryService dailySummaryService, KeyValueUtility keyValUtil) {
    this.dailySummaryService = dailySummaryService;
    this.keyValueUtility = keyValUtil;
  }

  public ResponseEntity<?> uploadMealImageKv(@RequestParam("file") MultipartFile file,
      @RequestParam("summaryKey") String summaryKey) throws Exception {

    byte[] imageBytes = file.getBytes();
    keyValueUtility.setImage(summaryKey, imageBytes);

    return ResponseEntity.ok("succes");
  }

  public ResponseEntity<?> getMealImageKv(String key) throws Exception {
    byte[] imageBytes = keyValueUtility.getImage(key);

    if (imageBytes == null) {
      return ResponseEntity.notFound().build();
    }

    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.IMAGE_JPEG);
    headers.setContentLength(imageBytes.length);

    return new ResponseEntity<>(imageBytes, headers, HttpStatus.OK);
  }

}
