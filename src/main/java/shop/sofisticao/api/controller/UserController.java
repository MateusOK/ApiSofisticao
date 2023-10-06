package shop.sofisticao.api.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import shop.sofisticao.api.dto.request.ProductRequestDto;
import shop.sofisticao.api.dto.request.UserRequestDto;
import shop.sofisticao.api.dto.response.ProductResponseDto;
import shop.sofisticao.api.dto.response.UserResponseDto;
import shop.sofisticao.api.service.UserService;

import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/users")
public class UserController {

    private UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDto> getUserById(@PathVariable String id){
        return ResponseEntity.ok(userService.findUserById(id));
    }

    @PostMapping
    public ResponseEntity<UserResponseDto> saveProduct(@RequestBody UserRequestDto request, UriComponentsBuilder builder) {
        var response = userService.saveUser(request);
        return ResponseEntity.created(
                builder.path("/api/products/{id}").buildAndExpand(response.id()).toUri()
        ).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResponseDto> updateUserById(@PathVariable String id, @RequestBody UserRequestDto request){
        Optional<UserResponseDto> existingUserOptional = Optional.ofNullable(userService.findUserById(id));
        return existingUserOptional
                .map(existingProduct -> {
                    var response = userService.saveUser(request);
                    return ResponseEntity.ok(response);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUserById(@PathVariable String id){
        userService.deleteUserById(id);
        return ResponseEntity.noContent().build();
    }
}
