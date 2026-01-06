package homelab.ftrack.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import homelab.ftrack.model.Meal;

public interface MealRepository extends MongoRepository<Meal, String> {

}