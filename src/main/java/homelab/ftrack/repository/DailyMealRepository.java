package homelab.ftrack.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import homelab.ftrack.model.DailyMeal;

public interface DailyMealRepository extends MongoRepository<DailyMeal, String> {

}
