package shop.sofisticao.api.service.impl;

import shop.sofisticao.api.dto.request.UserRequestDto;
import shop.sofisticao.api.dto.response.UserResponseDto;
import shop.sofisticao.api.entity.User;
import shop.sofisticao.api.repository.UserRepository;
import shop.sofisticao.api.service.UserService;



public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    @Override
    public UserResponseDto findUserById(String id) {
        var response = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("user not found with id: " + id));
        return new UserResponseDto(response);
    }

    @Override
    public UserResponseDto saveUser(UserRequestDto request) {
        var response = userRepository.save(new User(request));
        return new UserResponseDto(response);
    }

    @Override
    public void deleteUserById(String id) {
        userRepository.deleteById(id);
    }
}
