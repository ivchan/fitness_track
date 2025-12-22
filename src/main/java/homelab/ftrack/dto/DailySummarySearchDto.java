package homelab.ftrack.dto;

public class DailySummarySearchDto {
  private String id;
  private String userId;
  private String recordDateFrom;
  private String recordDateTo;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public String getRecordDateFrom() {
    return recordDateFrom;
  }

  public void setRecordDateFrom(String recordDateFrom) {
    this.recordDateFrom = recordDateFrom;
  }

  public String getRecordDateTo() {
    return recordDateTo;
  }

  public void setRecordDateTo(String recordDateTo) {
    this.recordDateTo = recordDateTo;
  }

}
