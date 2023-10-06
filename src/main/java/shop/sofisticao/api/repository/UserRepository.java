package shop.sofisticao.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import shop.sofisticao.api.entity.User;

public interface UserRepository extends MongoRepository<User, String> {
}
