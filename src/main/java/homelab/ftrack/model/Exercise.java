package homelab.ftrack.model;

import org.springframework.data.annotation.Id;

//@Document(collection = "ft_exercise")
public class Exercise extends BaseModel {
  @Id
  private String id;
  private String exerciseCode;
  private String exerciseName;
  private Float calories;

  public Exercise() {

  }

  public Exercise(String id, String exerciseCode, String exerciseName) {
    super();
    this.id = id;
    this.exerciseCode = exerciseCode;
    this.exerciseName = exerciseName;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getExerciseCode() {
    return exerciseCode;
  }

  public void setExerciseCode(String exerciseCode) {
    this.exerciseCode = exerciseCode;
  }

  public String getExerciseName() {
    return exerciseName;
  }

  public void setExerciseName(String exerciseName) {
    this.exerciseName = exerciseName;
  }

  public Float getCalories() {
    return calories;
  }

  public void setCalories(Float calories) {
    this.calories = calories;
  }

}
