package homelab.ftrack.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import homelab.ftrack.model.Meal;
import homelab.ftrack.repository.MealRepository;

@Service
public class MealServiceImpl implements MealService {
  private final MealRepository mealRepository;
  private static final Logger logger = LoggerFactory.getLogger(MealServiceImpl.class);

  public MealServiceImpl(MealRepository mealRepository) {
    this.mealRepository = mealRepository;
  }

  @Override
  public List<Meal> listMeals() {
    List<Meal> meals = this.mealRepository.findAll();
    return meals;
  }

  @Override
  public Meal getMeal(String mealId) {
    return this.mealRepository.findById(mealId).orElse(null);
  }

  @Override
  public Meal addMeal(Meal meal) {
    if (meal.getId().isEmpty()) {
      meal.setId(UUID.randomUUID().toString());
    }
    Meal saved = this.mealRepository.insert(meal);
    return saved;
  }

  @Override
  public Meal updateMeal(Meal meal) {
    Meal existMeal = this.mealRepository.findById(meal.getId()).orElse(null);
    if (existMeal == null) {
      logger.info("Meal not found for updating, {}", meal);
      return null;
    }
    existMeal.setMealCode(meal.getMealCode());
    existMeal.setMealName(meal.getMealName());
    existMeal.setMealPhotoId(meal.getMealPhotoId());
    existMeal.setUpdatedAt(LocalDateTime.now());
    existMeal = this.mealRepository.save(existMeal);
    logger.info("Updated meal {}", existMeal);
    return existMeal;
  }

  @Override
  public void removeMeal(String mealId) {
    this.mealRepository.deleteById(mealId);
    logger.info("Deleted meal {}", mealId);
  }

  @Override
  public boolean exists(String mealId) {
    return this.mealRepository.existsById(mealId);
  }

}
