package shop.sofisticao.api.dto.response;

import shop.sofisticao.api.entity.Product;
import shop.sofisticao.api.enums.Cores;
import shop.sofisticao.api.enums.Porte;

import java.math.BigDecimal;
import java.util.List;

public record ProductResponseDto(
        String id,
        String name,
        BigDecimal price,
        BigDecimal priceDesc,
        List<Cores> colors,
        List<Porte> size,
        String image
) {
    public ProductResponseDto(Product response){
        this(
                response.getId(),
                response.getName(),
                response.getPrice(),
                response.getPriceDesc(),
                response.getColors(),
                response.getSize(),
                response.getImage()
        );
    }
}
