package shop.sofisticao.api.entity;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;
import shop.sofisticao.api.dto.request.ProductRequestDto;
import shop.sofisticao.api.dto.request.UserRequestDto;

@Document("users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private String id;
    private String name;
    private String email;
    private String password;

    public User(UserRequestDto request) {
        this.name = request.name();
        this.email = request.email();
        this.password = request.password();
    }

}
