package homelab.ftrack.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import homelab.ftrack.model.Meal;
import homelab.ftrack.service.MealService;

@RestController
@RequestMapping("/meal")
public class MealController {
  private final MealService mealService;

  public MealController(MealService mealService) {
    this.mealService = mealService;
  }

  @PostMapping
  public ResponseEntity<?> create(@RequestBody Meal meal) {
    if (mealService.exists(meal.getId())) {
      return ResponseEntity.status(HttpStatus.CONFLICT).build();
    }
    Meal savedMeal = this.mealService.addMeal(meal);
    return new ResponseEntity<Meal>(savedMeal, HttpStatus.CREATED);
  }

  @PutMapping
  public ResponseEntity<?> update(@RequestBody Meal meal) {
    if (!mealService.exists(meal.getId())) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
    Meal savedMeal = this.mealService.updateMeal(meal);
    return ResponseEntity.ok(savedMeal);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<?> delete(@PathVariable("id") String id) {
    this.mealService.removeMeal(id);
    return ResponseEntity.ok().build();
  }

  @GetMapping("/{id}")
  public ResponseEntity<?> get(@PathVariable("id") String id) {
    Meal meal = this.mealService.getMeal(id);
    if (meal == null) {
      return ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok(meal);
  }

  @GetMapping()
  public ResponseEntity<?> list() {
    return ResponseEntity.ok(this.mealService.listMeals());
  }
}
