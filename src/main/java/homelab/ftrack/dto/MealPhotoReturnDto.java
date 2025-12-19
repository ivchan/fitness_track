package homelab.ftrack.dto;

public class MealPhotoReturnDto {
  private String requestId;
  private String resultJson;

  public MealPhotoReturnDto() {
    super();
  }

  public MealPhotoReturnDto(String requestId, String resultJson) {
    super();
    this.requestId = requestId;
    this.resultJson = resultJson;
  }

  public String getRequestId() {
    return requestId;
  }

  public void setRequestId(String requestId) {
    this.requestId = requestId;
  }

  public String getResultJson() {
    return resultJson;
  }

  public void setResultJson(String resultJson) {
    this.resultJson = resultJson;
  }

}
