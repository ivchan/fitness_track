package homelab.ftrack.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "ft_daily_exercise")
public class DailyExercise extends BaseModel {
  private String exerciseId;
  private String exerciseRemarks;
  private int burnCalories;

  public String getExerciseId() {
    return exerciseId;
  }

  public void setExerciseId(String exerciseId) {
    this.exerciseId = exerciseId;
  }

  public String getExerciseRemarks() {
    return exerciseRemarks;
  }

  public void setExerciseRemarks(String exerciseRemarks) {
    this.exerciseRemarks = exerciseRemarks;
  }

  public int getBurnCalories() {
    return burnCalories;
  }

  public void setBurnCalories(int burnCalories) {
    this.burnCalories = burnCalories;
  }

}
