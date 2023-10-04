package shop.sofisticao.api.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import shop.sofisticao.api.dto.request.ProductRequestDto;

import java.math.BigDecimal;

@Document("products")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    private String id;
    private String name;
    private BigDecimal price;

    public Product(ProductRequestDto request) {
        this.name = request.name();
        this.price = request.price();
    }
}