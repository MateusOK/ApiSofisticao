package shop.sofisticao.api.dto.request;

public record UserRequestDto(
        String name,
        String email,
        String password
) {
}
