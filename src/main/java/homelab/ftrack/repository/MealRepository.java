package homelab.ftrack.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import homelab.ftrack.model.Meal;

@Repository
public interface MealRepository extends MongoRepository<Meal, String> {

}