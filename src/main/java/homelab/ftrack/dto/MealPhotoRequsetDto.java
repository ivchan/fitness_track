package homelab.ftrack.dto;

public class MealPhotoRequsetDto {
  private String requestId;

  public MealPhotoRequsetDto() {
  }

  public MealPhotoRequsetDto(String requestId, String image64) {
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
