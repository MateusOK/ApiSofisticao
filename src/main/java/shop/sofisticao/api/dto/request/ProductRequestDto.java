package shop.sofisticao.api.dto.request;

import java.math.BigDecimal;

public record ProductRequestDto(
        String name,
        BigDecimal price
) {
}
