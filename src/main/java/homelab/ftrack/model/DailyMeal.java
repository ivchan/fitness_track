package homelab.ftrack.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "ft_daily_meal")
public class DailyMeal extends BaseModel {
  private String mealId;
  private String mealRemarks;
  private int mealCalories;

  public String getMealId() {
    return mealId;
  }

  public void setMealId(String mealId) {
    this.mealId = mealId;
  }

  public String getMealRemarks() {
    return mealRemarks;
  }

  public void setMealRemarks(String mealRemarks) {
    this.mealRemarks = mealRemarks;
  }

  public int getMealCalories() {
    return mealCalories;
  }

  public void setMealCalories(int mealCalories) {
    this.mealCalories = mealCalories;
  }

}
