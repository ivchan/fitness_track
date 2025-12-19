package homelab.ftrack.dto;

public class MealPhotoRequsetDto {
  private String requestId;
  private String image64;

  public MealPhotoRequsetDto() {
  }

  public MealPhotoRequsetDto(String requestId, String image64) {
    super();
    this.requestId = requestId;
    this.image64 = image64;
  }

  public String getRequestId() {
    return requestId;
  }

  public void setRequestId(String requestId) {
    this.requestId = requestId;
  }

  public String getImage64() {
    return image64;
  }

  public void setImage64(String image64) {
    this.image64 = image64;
  }

}
