package shop.sofisticao.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import shop.sofisticao.api.entity.Product;
import java.util.List;
public interface ProductRepository extends MongoRepository<Product, String> {

    List<Product> findByNameContaining(String name);
}
