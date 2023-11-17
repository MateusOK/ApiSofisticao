package shop.sofisticao.api.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import shop.sofisticao.api.dto.request.ProductRequestDto;
import shop.sofisticao.api.enums.Cores;
import shop.sofisticao.api.enums.Porte;

import java.math.BigDecimal;
import java.util.List;

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
    private BigDecimal priceDesc;
    private List<Cores> colors;
    private List<Porte> size;
    private String image;

    public Product(ProductRequestDto request) {
        this.name = request.name();
        this.price = request.price();
        this.priceDesc = request.priceDesc();
        this.colors = request.colors();
        this.size = request.size();
        this.image = request.image();
    }
}