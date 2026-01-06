package homelab.ftrack.model;

import java.time.LocalDate;

//@Document(collection = "ft_daily_summary")
public class DailySummary extends BaseModel {
  private String id;
  private LocalDate recordDate;
  private int mealCount;
  private int totalCaloriesConsumed;
  private int exerciseCount;
  private int totalCaloriesBurned;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public LocalDate getRecordDate() {
    return recordDate;
  }

  public void setRecordDate(LocalDate recordDate) {
    this.recordDate = recordDate;
  }

  public int getMealCount() {
    return mealCount;
  }

  public void setMealCount(int mealCount) {
    this.mealCount = mealCount;
  }

  public int getTotalCaloriesConsumed() {
    return totalCaloriesConsumed;
  }

  public void setTotalCaloriesConsumed(int totalCaloriesConsumed) {
    this.totalCaloriesConsumed = totalCaloriesConsumed;
  }

  public int getExerciseCount() {
    return exerciseCount;
  }

  public void setExerciseCount(int exerciseCount) {
    this.exerciseCount = exerciseCount;
  }

  public int getTotalCaloriesBurned() {
    return totalCaloriesBurned;
  }

  public void setTotalCaloriesBurned(int totalCaloriesBurned) {
    this.totalCaloriesBurned = totalCaloriesBurned;
  }
}
