package homelab.ftrack.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import homelab.ftrack.model.DailySummary;

public interface DailySummaryRepository extends MongoRepository<DailySummary, String> {

}
