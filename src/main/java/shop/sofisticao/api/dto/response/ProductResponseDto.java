package shop.sofisticao.api.dto.response;

import shop.sofisticao.api.entity.Product;

import java.math.BigDecimal;

public record ProductResponseDto(

        String id,
        String name,
        BigDecimal price
) {

    public ProductResponseDto(Product response){
        this(response.getId(), response.getName(), response.getPrice());
    }

}
