package homelab.ftrack.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import homelab.ftrack.model.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

}
