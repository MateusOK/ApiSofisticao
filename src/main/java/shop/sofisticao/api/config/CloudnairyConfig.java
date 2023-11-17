package shop.sofisticao.api.config;

import com.cloudinary.Cloudinary;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
@RequiredArgsConstructor
public class CloudnairyConfig {

    @Bean
    public Cloudinary cloudinary(){
        return new Cloudinary(Map.of(
                "cloud_name", "dxggm7sk6",
                "api_key", "814598843971855",
                "api_secret", "ZNSWmWoh3aAZvg95gaRaLz3EZ50"
        ));
    }


}
