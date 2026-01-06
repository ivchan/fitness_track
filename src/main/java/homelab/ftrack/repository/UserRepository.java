package homelab.ftrack.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import homelab.ftrack.model.User;

public interface UserRepository extends MongoRepository<User, String> {

}
