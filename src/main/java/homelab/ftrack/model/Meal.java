package homelab.ftrack.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "ft_meals")
public class Meal extends BaseModel {
  @Id
  private String id;
  private String mealCode;
  private String mealName;
  private Float calories;
  private String mealPhotoId;
}
