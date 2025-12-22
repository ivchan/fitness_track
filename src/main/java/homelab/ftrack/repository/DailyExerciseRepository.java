package homelab.ftrack.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import homelab.ftrack.model.DailyExercise;

public interface DailyExerciseRepository extends MongoRepository<DailyExercise, String> {

}
