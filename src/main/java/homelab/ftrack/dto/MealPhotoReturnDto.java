package homelab.ftrack.dto;

public class MealPhotoReturnDto {
  private String requestId;

  public MealPhotoReturnDto() {
    super();
  }

  public MealPhotoReturnDto(String requestId, String resultJson) {
    super();
    this.requestId = requestId;
  }

  public String getRequestId() {
    return requestId;
  }

  public void setRequestId(String requestId) {
    this.requestId = requestId;
  }

}
