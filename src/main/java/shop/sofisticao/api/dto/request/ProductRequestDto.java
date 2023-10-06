package shop.sofisticao.api.dto.request;

import shop.sofisticao.api.enums.Cores;
import shop.sofisticao.api.enums.Porte;

import java.math.BigDecimal;
import java.util.List;

public record ProductRequestDto(
        String name,
        BigDecimal price,
        BigDecimal priceDesc,
        List<Cores> cores,
        List<Porte> porte
) {
}
