package homelab.ftrack.dto;

public class DailySummaryAddExerciseDto {
  private String id;
  private String summaryId;
  private String exerciseId;
  private int durationMins;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getSummaryId() {
    return summaryId;
  }

  public void setSummaryId(String summaryId) {
    this.summaryId = summaryId;
  }

  public String getExerciseId() {
    return exerciseId;
  }

  public void setExerciseId(String exerciseId) {
    this.exerciseId = exerciseId;
  }

  public int getDurationMins() {
    return durationMins;
  }

  public void setDurationMins(int durationMins) {
    this.durationMins = durationMins;
  }

}
