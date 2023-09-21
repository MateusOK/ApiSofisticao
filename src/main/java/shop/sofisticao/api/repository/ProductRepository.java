package shop.sofisticao.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import shop.sofisticao.api.entity.Product;

public interface ProductRepository extends MongoRepository<Product, String> {

    @Query("{name:'?0'}")
    Product findItemByName(String name);

}
