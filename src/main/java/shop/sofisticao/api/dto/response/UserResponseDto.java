package shop.sofisticao.api.dto.response;

import shop.sofisticao.api.entity.User;

public record UserResponseDto(
        String id,
        String name,
        String email,
        String password
) {
    public UserResponseDto(User response){
        this(response.getId(), response.getName(), response.getEmail(), response.getPassword());
    }

}
