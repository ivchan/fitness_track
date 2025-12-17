package homelab.ftrack.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MealModelTest {
  private Meal mealTest;

  @BeforeEach
  void setUp() {
    String uid = UUID.randomUUID().toString();
    String photoId = UUID.randomUUID().toString();

    mealTest = new Meal(uid, "egg", "Egg");
    mealTest.setCalories(50f);
    mealTest.setMealPhotoId(photoId);
  }

  @Test
  void constructor_NoParam() throws Exception {
    Meal m = new Meal();
    m.setId(mealTest.getId());
    m.setMealCode(mealTest.getMealCode());
    m.setMealName(mealTest.getMealName());
    m.setCalories(mealTest.getCalories());
    m.setMealPhotoId(mealTest.getMealPhotoId());
    assertNotNull(m);
    assertEquals(m.getId(), mealTest.getId());
    assertEquals(m.getMealCode(), mealTest.getMealCode());
    assertEquals(m.getMealName(), mealTest.getMealName());
    assertEquals(m.getCalories(), mealTest.getCalories());
    assertEquals(m.getMealPhotoId(), mealTest.getMealPhotoId());
  }
}
