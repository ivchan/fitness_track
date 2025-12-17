package homelab.ftrack.service;

import java.util.List;

import homelab.ftrack.model.Meal;

public interface MealService {
  List<Meal> listMeals();

  Meal getMeal(String mealId);

  Meal addMeal(Meal meal);

  Meal updateMeal(Meal meal);

  void removeMeal(String mealId);

  boolean exists(String mealId);
}
