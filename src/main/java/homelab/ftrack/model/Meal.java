package homelab.ftrack.model;

import org.springframework.data.annotation.Id;

//@Document(collection = "ft_meals")
public class Meal extends BaseModel {
  @Id
  private String id;
  private String mealCode;
  private String mealName;
  private Float calories;
  private String mealPhotoId;

  public Meal() {

  }

  public Meal(String id, String mealCode, String mealName) {
    super();
    this.id = id;
    this.mealCode = mealCode;
    this.mealName = mealName;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getMealCode() {
    return mealCode;
  }

  public void setMealCode(String mealCode) {
    this.mealCode = mealCode;
  }

  public String getMealName() {
    return mealName;
  }

  public void setMealName(String mealName) {
    this.mealName = mealName;
  }

  public Float getCalories() {
    return calories;
  }

  public void setCalories(Float calories) {
    this.calories = calories;
  }

  public String getMealPhotoId() {
    return mealPhotoId;
  }

  public void setMealPhotoId(String mealPhotoId) {
    this.mealPhotoId = mealPhotoId;
  }

}
