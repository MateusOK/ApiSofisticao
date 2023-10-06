package shop.sofisticao.api.service;

import shop.sofisticao.api.dto.request.UserRequestDto;
import shop.sofisticao.api.dto.response.UserResponseDto;

public interface UserService {
    UserResponseDto findUserById(String id);
    UserResponseDto saveUser(UserRequestDto request);
    void deleteUserById(String id);
}
